package com.ktdsuniversity.edu.tmdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.vo.ActrVO;
import com.ktdsuniversity.edu.tmdb.vo.CastVO;
import com.ktdsuniversity.edu.tmdb.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.vo.MvVO;

public class OracleAccess {
		private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	    private static final String SCHEMA = "MV";
	    private static final String PASSWORD = "MV1234";

	    public Connection getConnection() {
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로딩
	            return DriverManager.getConnection(ORACLE_URL, SCHEMA, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.", e);
	        } catch (SQLException e) {
	            throw new RuntimeException("DB 연결에 실패했습니다. 계정 정보를 확인하세요.", e);
	        }
	    }
	    
	    
	
	
	public List<MvVO> selectMovies() {
		try {
			// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null; // DB와 연결되어 이쓴 세션(DriverManager가 열어줌)
		// 1. Oracle데이터 베이스에 접속한다.
		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE"; // -> 연결할 때 꼭 있어야함. 형식이 비슷함.
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		// 2. Select Query를 데이터베이스 전달한다.
		// StringBuffer vs StringBuilder thread-safe 이냐 아니냐 차이
		// 자바로 만들때는 싱글 thread로 돌아가기 때문에 상관 없이 써도 괜찮지만 코테할 때는 builder로 사용하는 것이 좋다.
		StringBuffer query = new StringBuffer();

		query.append(" SELECT MV_ID         ");
		query.append("      , MV_TTL         ");
		query.append("      , MV_ORGNL_TTL   ");
		query.append("      , MV_SUB_TTL      ");
		query.append("      , MV_LNG         ");
		query.append("      , MV_RNG_TM ");
		query.append("      , TO_CHAR(MV_OPN_DT, 'YYYY-MM-DD') AS MV_OPN_DT");
		query.append("      , MV_DESC      ");
		query.append("      , MV_PSTR      ");
		query.append("      , CASE MV_OPN_STTS WHEN 'Y' THEN '개봉됨' ELSE '개봉예정' END AS MV_OPN_STTS ");
		query.append("      , CASE MV_RTNG WHEN 'ALL' THEN '전체관람가' ELSE MV_RTNG || '세 이상 관람가' END AS MV_RTNG ");
		query.append("      , MV_CST         ");
		query.append("      , MV_PRFT      ");
		query.append("  FROM MV            ");

		PreparedStatement pstmt = null; // DB와 연결되어있는 세션(Connection)
		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3. Select Fetch Result를 받아와서

		ResultSet fetchResult = null; // DB와 연결되어 있는 세션(Prepared)
		try {
			fetchResult = pstmt.executeQuery(); // 데이터 베이스에 SELECT 쿼리 실행을 요청한다.
			// ResultSet을 반환시키기 때문에 ResultSet으로 받는다.
		} catch (SQLException e) {
			// 여기서 열려있는 session:
			// Connection
			// PreparedStatment
			// ResultSet은 close
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// finally를 사용하면 3가지 연결이 다 끊어지기 때문에 쓰면 안된다.
			// 연결이 죽기 직전에 끊어줘야한다.
			throw new RuntimeException("SQL에 문제가 있습니다.");

		}

		// 3-1 List<MvVo>에 하나씩 add한다.
		List<MvVO> mvList = new ArrayList<>();
		MvVO movie = null;
		// Fetch Row 를 하나씩 순환사면서 MvVO 인스턴스를 생성하고
		// MvVO 인스턴스를 movieList에 add 한다.

		try {
			while (fetchResult.next()) {
				movie = new MvVO();
				movie.setMvId(fetchResult.getString("MV_ID"));
				movie.setMvTtl(fetchResult.getString("MV_TTL"));
				movie.setMvOrgnlTtl(fetchResult.getString("MV_ORGNL_TTL"));
				movie.setMvSubTtl(fetchResult.getString("MV_SUB_TTL"));
				movie.setMvLng(fetchResult.getString("MV_LNG"));
				movie.setMvRngTm(fetchResult.getLong("MV_RNG_TM"));
				movie.setMvOpnDt(fetchResult.getString("MV_OPN_DT"));
				movie.setMvDesc(fetchResult.getString("MV_DESC"));
				movie.setMvPstr(fetchResult.getString("MV_PSTR"));
				movie.setMvOpnStts(fetchResult.getString("MV_OPN_STTS"));
				movie.setMvRtng(fetchResult.getString("MV_RTNG"));
				movie.setMvCst(fetchResult.getLong("MV_CST"));
				movie.setMvPrft(fetchResult.getLong("MV_PRFT"));

				// 이 영화의 장르 아이디를 모두 조회해 온다.
				List<String> genreIdList = this.selectGenreIdByMovieId(fetchResult.getString("MV_ID")); // MV-20250305-000001
				// 장르 아이디 목록을 반복하면서 해당 장르 정보를 하나씩 조회해온다.
				List<GnrVO> gnrList = new ArrayList<>();
				for (String genreId : genreIdList) {
					GnrVO gnrVO = this.selectGenre(genreId);
					gnrList.add(gnrVO);
				}
				// 장르 목록을 movie 인스턴스에 할당해준다.

				movie.setGnrList(gnrList);

				mvList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			// 여기선 다 끊어야해서 finally 사용
			// 이 시점에 열여있는 세션
			// ResultSet
			// Prepared
			// Connection
			// DB연결을 끊을 때에는 역순으로 끊어야한다.

			try {
				fetchResult.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 4. 영화목록을 반환시킨다.
		// 반환직전에 데이터 베이스에 연결된 모든 Session을 닫는다.(메모리 누수 방지)

		return mvList;
	}

	
	
	
	
	public List<GnrVO> selectGenres() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT GNR_ID         ");
		query.append("      , GNR_NM         ");
		query.append("   FROM GNR            ");

		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}

		List<GnrVO> gnrList = new ArrayList<>();
		GnrVO gnr = null;

		try {
			while (resultSet.next()) {
				gnr = new GnrVO();
				gnr.setGnrId(resultSet.getString("GNR_ID"));
				gnr.setGnrNm(resultSet.getString("GNR_NM"));

				List<String> mvIdList = this.selectMovieIdByGenreId(resultSet.getString("GNR_ID"));
				List<MvVO> mvList = new ArrayList<>();
				for (String mvId : mvIdList) {
					MvVO mvVO = this.selectMovie(mvId);
					mvList.add(mvVO);
				}

				gnr.setMvList(mvList);

				gnrList.add(gnr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return gnrList;

	}

	
	
	
	// 파라미터로 전달한 영화의 정보만 조회한다.
	public MvVO selectMovie(String movieId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet fetchResult = null;

		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT MV_ID         ");
		query.append("      , MV_TTL         ");
		query.append("      , MV_ORGNL_TTL   ");
		query.append("      , MV_SUB_TTL      ");
		query.append("      , MV_LNG         ");
		query.append("      , MV_RNG_TM ");
		query.append("      , TO_CHAR(MV_OPN_DT, 'YYYY-MM-DD') AS MV_OPN_DT");
		query.append("      , MV_DESC      ");
		query.append("      , MV_PSTR      ");
		query.append("      , CASE MV_OPN_STTS WHEN 'Y' THEN '개봉됨' ELSE '개봉예정' END AS MV_OPN_STTS ");
		query.append("      , CASE MV_RTNG WHEN 'ALL' THEN '전체관람가' ELSE MV_RTNG || '세 이상 관람가' END AS MV_RTNG ");
		query.append("      , MV_CST         ");
		query.append("      , MV_PRFT      ");
		query.append("   FROM MV            ");
//	      query.append(" WHERE MV_ID = " + movieId + " "); //BLACK HACKER 들의 먹잇감. -개인정보유출 위험 ''--' 이런느낌으로
		query.append(" WHERE MV_ID = ? "); // ? 자리에 파라미터 값(movieId)가 할당된다.

		try {
			pstmt = session.prepareStatement(query.toString());
			// ?(movieId) 의 값을 여기서 채워준다
			pstmt.setString(1, movieId); // 첫 번째 물음표에 값을 채운다.
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");

		}

		MvVO movie = null;

		try {
			while (fetchResult.next()) {
				movie = new MvVO();
				movie.setMvId(fetchResult.getString("MV_ID"));
				movie.setMvTtl(fetchResult.getString("MV_TTL"));
				movie.setMvOrgnlTtl(fetchResult.getString("MV_ORGNL_TTL"));
				movie.setMvSubTtl(fetchResult.getString("MV_SUB_TTL"));
				movie.setMvLng(fetchResult.getString("MV_LNG"));
				movie.setMvRngTm(fetchResult.getLong("MV_RNG_TM"));
				movie.setMvOpnDt(fetchResult.getString("MV_OPN_DT"));
				movie.setMvDesc(fetchResult.getString("MV_DESC"));
				movie.setMvPstr(fetchResult.getString("MV_PSTR"));
				movie.setMvOpnStts(fetchResult.getString("MV_OPN_STTS"));
				movie.setMvRtng(fetchResult.getString("MV_RTNG"));
				movie.setMvCst(fetchResult.getLong("MV_CST"));
				movie.setMvPrft(fetchResult.getLong("MV_PRFT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {

			try {
				fetchResult.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return movie;
	}

	
	
	
	
	public GnrVO selectGenre(String genreId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT GNR_ID         ");
		query.append("      , GNR_NM         ");
		query.append("   FROM GNR            ");
		query.append("  WHERE GNR_ID = ? ");

		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}

		GnrVO gnr = null;

		try {
			while (resultSet.next()) {
				gnr = new GnrVO();
				gnr.setGnrId(resultSet.getString("GNR_ID"));
				gnr.setGnrNm(resultSet.getString("GNR_NM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return gnr;

	}

	
	
	
	
	// 장르의 아이디로 영화의 아이디 조회하기
	public List<String> selectGenreIdByMovieId(String movieId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT GNR_ID         ");
		query.append("   FROM MV_GNR         ");
		query.append("  WHERE MV_ID = ? "); // MV-20250305-000001

		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}

		List<String> movieIdList = new ArrayList<>();

		try {
			while (resultSet.next()) {
				movieIdList.add(resultSet.getString("GNR_ID"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return movieIdList;

	}

	
	
	
	
	// 영화의 아이디로 장르의 아이디 조회하기
	public List<String> selectMovieIdByGenreId(String genreId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT MV_ID         ");
		query.append("   FROM MV_GNR         ");
		query.append("  WHERE GNR_ID = ? ");

		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}

		List<String> genreIdList = new ArrayList<>();

		try {
			while (resultSet.next()) {
				genreIdList.add(resultSet.getString("MV_ID"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return genreIdList;

	}

	
	
	
	
	// 새로운 장르를 등록한다. [액션, 코미디, 모험, 호러, *스릴러]
	public int insertNewGenre(String newGenre) {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}

		Connection session = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결
		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" INSERT INTO GNR         ");
		query.append(" ( GNR_ID         ");
		query.append(" , GNR_NM )         ");
		query.append("  VALUES ( ");
		query.append("  'GR-'|| TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD( GNR_PK_SEQ.NEXTVAL, 6, '0' ) ");
		query.append(", ? )");

		try {
			pstmt = session.prepareStatement(query.toString()); // 쿼리실행
			pstmt.setString(1, newGenre);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {
			}

			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}

		try {
			int resultSet = pstmt.executeUpdate(); // 실행된 쿼리의 결과 반환
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
			try {
				session.close();
			} catch (Exception e2) {
			}

		}

	}


	
	
	
	public int insertMovieGenre(String movieId, String genreId) {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}

		Connection session = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결
		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO MV_GNR ");
		query.append(" (GNR_ID, MV_ID) ");
		query.append(" VALUES ");
		query.append(" ( ? ");
		query.append(" , ? )");
		
		
	

		try {
			pstmt = session.prepareStatement(query.toString()); // 쿼리실행
			pstmt.setString(1, genreId);
			pstmt.setString(2, movieId);
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {
			}

			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}

		try {
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
			try {
				session.close();
			} catch (Exception e2) {
			}
		}

	}
	
	
	
	
	
	

	public String selectGenreIdByGenreName(String genreName) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();

		query.append(" SELECT GNR_ID         ");
		query.append("   FROM GNR            ");
		query.append("  WHERE GNR_NM = ?     ");

		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}

		String gnrId = null;

		try {
			while (resultSet.next()) {
				gnrId = resultSet.getString("GNR_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return gnrId;
	}

	public String selectNewMovieId() {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}

		Connection session = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		// 데이터베이스 연결
		try {
			String orcleURl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(orcleURl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user/password가 틀렸습니다.");
		}

		StringBuffer query = new StringBuffer();
		query.append("  SELECT ");
		query.append("  'MV-'|| TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD( MV_PK_SEQ.NEXTVAL, 6, '0' ) AS MV_ID ");
		query.append("  FROM DUAL ");
		;

		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}

		String mvId = null;
		try {
			while (resultSet.next()) {
				mvId = resultSet.getString("MV_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘 못 되었습니다.");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				session.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mvId;

	}

	
	






	
	
	
	
	public int deleteMovie(String mvId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE    		 ");
		query.append("   FROM MV   		 ");
		query.append("  WHERE MV_ID = ?  ");
		
		try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
			
			 pstmt.setString(1, mvId);
			 
			 int deleteCount = 0 ;
			 deleteCount = pstmt.executeUpdate();
			 if(deleteCount > 0) {
					this.deleteMovieGenreByMovieId(mvId);
			 }
				
			 return deleteCount;
		}catch (SQLException e) {
	        throw new RuntimeException("영화 삭제 중 오류 발생", e);
		}
	}
	
	
	
	public int deleteGenre(String gnrId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE    		 ");
		query.append("   FROM GNR   	 ");
		query.append("  WHERE GNR_ID = ? ");
		
		try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
			pstmt.setString(1, gnrId);
			int deleteCount = 0 ;
			 deleteCount = pstmt.executeUpdate();

			if(deleteCount > 0 ) {
				this.deleteMovieGenreByGenreId(gnrId);
			}
			 
			 return deleteCount;
		}catch (SQLException e) {
	        throw new RuntimeException("영화 삭제 중 오류 발생", e);
		}
	}
	
	
	
	
	public int deleteMovieGenreByMovieId(String mvId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE    		 ");
		query.append("   FROM MV_GNR   	 ");
		query.append("  WHERE MV_ID = ? ");
		
		try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
			 pstmt.setString(1, mvId);
			 
			 
			 return pstmt.executeUpdate();
		}catch (SQLException e) {
	        throw new RuntimeException("영화 삭제 중 오류 발생", e);
		}
	}
	
	
	
	
	public int deleteMovieGenreByGenreId(String genreId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE    		 ");
		query.append("   FROM MV_GNR   	 ");
		query.append("  WHERE GNR_ID = ? ");
		
		try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
			 pstmt.setString(1, genreId);
			 				
			 return pstmt.executeUpdate();
		}catch (SQLException e) {
	        throw new RuntimeException("영화 삭제 중 오류 발생", e);
		}
	}
	
	
//----------------------------------------------------------------------------------------------------------------------------------	
		
	// 새로운 영화를 등록한다.
		public int insertNewMovie(MvVO movie) {
		    String newMovieId = this.selectNewMovieId();
		    movie.setMvId(newMovieId);

		    StringBuffer query = new StringBuffer();
		    query.append(" INSERT INTO MV   ");
		    query.append(" ( MV_ID, MV_TTL, MV_ORGNL_TTL, MV_SUB_TTL, MV_LNG, MV_RNG_TM, ");
		    query.append("   MV_OPN_DT, MV_DESC, MV_PSTR, MV_OPN_STTS, MV_RTNG, MV_CST, MV_PRFT ) ");
		    query.append(" VALUES ( ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, ? ) ");

		    try (Connection conn = getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(query.toString())) {

		        pstmt.setString(1, movie.getMvId());
		        pstmt.setString(2, movie.getMvTtl());
		        pstmt.setString(3, movie.getMvOrgnlTtl());
		        pstmt.setString(4, movie.getMvSubTtl());
		        pstmt.setString(5, movie.getMvLng());
		        pstmt.setLong(6, movie.getMvRngTm());
		        pstmt.setString(7, movie.getMvOpnDt());
		        pstmt.setString(8, movie.getMvDesc());
		        pstmt.setString(9, movie.getMvPstr());
		        pstmt.setString(10, movie.getMvOpnStts());
		        pstmt.setString(11, movie.getMvRtng());
		        pstmt.setLong(12, movie.getMvCst());
		        pstmt.setLong(13, movie.getMvPrft());

		        int insertCount = pstmt.executeUpdate();

		        // 영화가 정상적으로 삽입된 경우, 장르 등록 진행
		        if (insertCount > 0) {
		            for (GnrVO gnr : movie.getGnrList()) {
		                String gnrId = this.selectGenreIdByGenreName(gnr.getGnrNm());

		                if (gnrId == null) { // 장르가 없으면 새로 추가
		                    this.insertNewGenre(gnr.getGnrNm());
		                    gnrId = this.selectGenreIdByGenreName(gnr.getGnrNm());
		                }
		                gnr.setGnrId(gnrId);

		                // 영화-장르 관계 등록
		                this.insertMovieGenre(movie.getMvId(), gnr.getGnrId());
		            }
		            
		         
	            	if(movie.getCastList() == null) {
	            		movie.setCastList( this.getCastListByMovieId(movie.getMvId()) );
	            	}
		            
		        }
		        return insertCount;
		    } catch (SQLException e) {
		        throw new RuntimeException("영화 등록 중 오류 발생", e);
		    }
		}
	
	
		// ACTR_ID 로 배우 조회
		public ActrVO findActorByActrId(String actrId) {
			StringBuffer query = new StringBuffer();
			query.append(" SELECT ACTR_ID  		 ");
			query.append("      , ACTR_NM  		 ");
			query.append("      , ACTR_PHT       ");
			query.append("   FROM ACTR   	     ");
			query.append("  WHERE ACTR_ID = ?    ");
			
			ActrVO actor = null;
			
			try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
				ResultSet fetchResult = null;
				pstmt.setString(1, actrId);
				fetchResult = pstmt.executeQuery();
				
				
				while(fetchResult.next()) {
					actor = new ActrVO();
					actor.setActrId( fetchResult.getString("ACTR_ID") );	
					actor.setActrNm( fetchResult.getString("ACTR_NM") );	
					actor.setActrPht( fetchResult.getString("ACTR_PHT"));	
				}
				 
			} catch (SQLException e) {
			    throw new RuntimeException("배우 조회 중 오류 발생", e);
			}
			
			return actor;
		}
	
		
		// ACTR_ID 로 배우 조회
		public ActrVO findActorByActrName(String actrNM) {
			StringBuffer query = new StringBuffer();
			query.append(" SELECT ACTR_ID  		 ");
			query.append("      , ACTR_NM  		 ");
			query.append("      , ACTR_PHT       ");
			query.append("   FROM ACTR   	     ");
			query.append("  WHERE ACTR_NM = ?    ");
			
			ActrVO actor = null;
			
			try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
				ResultSet fetchResult = null;
				pstmt.setString(1, actrNM);
				fetchResult = pstmt.executeQuery();
				
				
				while(fetchResult.next()) {
					actor = new ActrVO();
					actor.setActrId( fetchResult.getString("ACTR_ID") );	
					actor.setActrNm( fetchResult.getString("ACTR_NM") );	
					actor.setActrPht( fetchResult.getString("ACTR_PHT"));	
				}
				 
			} catch (SQLException e) {
			    throw new RuntimeException("배우 조회 중 오류 발생", e);
			}
			
			return actor;
		}
		
	
		
		// ACTR_ID 생성
		private String generateActrId() {
			StringBuffer query = new StringBuffer();
			query.append("  SELECT ");
			query.append("  'AC-'|| TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD( MV_PK_SEQ.NEXTVAL, 6, '0' ) AS MV_ID ");
			query.append("  FROM DUAL ");
			
			String actorId = null;
			
			try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
				ResultSet resultSet = pstmt.executeQuery();
				
				while (resultSet.next()) {
					actorId = resultSet.getString("MV_ID");
				}
				
			} catch (SQLException e) {
			    throw new RuntimeException("배우 조회 중 오류 발생", e);
			}
			
			return actorId;
		}
		
		
		// 배우 생성
		public int insertActor(ActrVO actrVO) {
			actrVO.setActrId(generateActrId()); // Id 삽입 
			
			StringBuffer query = new StringBuffer();
			query.append(" INSERT INTO ACTR  	 ");
			query.append("      ( ACTR_ID		 ");
			query.append("      , ACTR_NM  		 ");
			query.append("      , ACTR_PHT )     ");
			query.append(" VALUES   	         ");
			query.append("      ( ?              ");
			query.append("      , ?              ");
			query.append("      , ? )            ");
			
			int insertCount = 0;

			try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
				pstmt.setString(1, actrVO.getActrId());
				pstmt.setString(2, actrVO.getActrNm());
				pstmt.setString(3, actrVO.getActrPht());

				insertCount = pstmt.executeUpdate(); // 실행된 쿼리의 결과 반환
				
				 
			} catch (SQLException e) {
			    throw new RuntimeException("배우 생성 중 오류 발생", e);
			}
			
			return insertCount;
		}
	
	
		// 배우 삭제
		public int deleteActor (String actrId) {
			StringBuffer query = new StringBuffer();
			query.append(" DELETE  	 		  ");
			query.append("   FROM ACTR		  ");
			query.append("  WHERE ACTR_ID = ? ");
			
			int deleteCount = 0;
			
			try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
				pstmt.setString(1, actrId);
				
				deleteCount = pstmt.executeUpdate();
				
			} catch (SQLException e) {
			    throw new RuntimeException("배우 삭제 중 오류 발생", e);
			}
			
			
			return deleteCount ;
		}
	
		// MV_ID로 배역들 조회
		public List<CastVO> getCastListByMovieId(String mvId){
			StringBuffer query = new StringBuffer();
			query.append(" SELECT CAST_ID   ");
			query.append(" 	    , CAST_NM  	");
			query.append(" 	    , ACTR_ID  	");
			query.append(" 	    , MV_ID  	");
			query.append("   FROM CAST		");
			query.append("  WHERE MV_ID = ? ");
			
			List<CastVO> casts = new ArrayList<>();
			CastVO cast = null;
		
			try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())){
				pstmt.setString(1, mvId);
				ResultSet resultSet = null;
				resultSet = pstmt.executeQuery(); // db에 SELECT 쿼리 실행을 요청한다.

				while(resultSet.next()) {
					cast = new CastVO();
					cast.setCastId( resultSet.getString("CAST_ID") );
					cast.setCastNm( resultSet.getString("CAST_NM") );
					cast.setActrId( resultSet.getString("ACTR_ID") );
					cast.setMvId( resultSet.getString("MV_ID")     );
					
					casts.add(cast);
				}
				
				
			} catch (SQLException e) {
				throw new RuntimeException("배역을 불러오는 중 오류 발생" + e);
			}
			
			return casts;
		}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
