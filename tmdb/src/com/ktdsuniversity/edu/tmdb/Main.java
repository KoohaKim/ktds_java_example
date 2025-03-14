package com.ktdsuniversity.edu.tmdb;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.dao.OracleAccess;
import com.ktdsuniversity.edu.tmdb.vo.ActrVO;
import com.ktdsuniversity.edu.tmdb.vo.CastVO;
import com.ktdsuniversity.edu.tmdb.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.vo.MvVO;

public class Main {
	public static void main(String[] args) {
		OracleAccess oracleAccess = new OracleAccess();
		
		// 전체 영화 조회
//		List<MvVO> movieList = oracleAccess.selectMovies();
//		
//		movieList.forEach(mv -> {
//            System.out.println("=".repeat(60));
//            System.out.println("영화 아이디: " + mv.getMvId());
//            System.out.println("영화 제목: " + mv.getMvTtl());
//            System.out.println("원제목: " + mv.getMvOrgnlTtl());
//            System.out.println("부제목: " + mv.getMvSubTtl());//
//            System.out.println("원어: " + mv.getMvLng());//
//            System.out.println("러닝타임: " + mv.getMvRngTm() + " 분");
//            System.out.println("개봉일: " + mv.getMvOpnDt());
//            System.out.println("영화 개요: " + mv.getMvDesc());
//            System.out.println("영화 포스터: " + mv.getMvPstr());
//            System.out.println("영화 개봉상태: " + mv.getMvOpnStts());
//            System.out.println("평점: " + mv.getMvRtng());
//            System.out.println("제작비: " + mv.getMvCst() + " $");
//            System.out.println("수익: " + mv.getMvPrft() + " $");
//            
//            mv.getGnrList().forEach( genre -> {
//                System.out.println("=".repeat(60));
//                System.out.println(genre.getGnrId());
//                System.out.println(genre.getGnrNm());
//            });
//        });
		
		
		
		// 전체 장르 조회
//		List<GnrVO> gnrList = oracleAccess.selectGenres();
//		
//		gnrList.forEach( gnr -> {
//            System.out.println("=".repeat(60));
//			System.out.println("장르 아이디: " + gnr.getGnrId());
//			System.out.println("장르:  " + gnr.getGnrNm());
//			
//			gnr.getMvList().forEach( mv ->{
//	            System.out.println("-".repeat(30));
//	            System.out.println("영화 아이디: " + mv.getMvId());			
//	            System.out.println("영화 제목: " + mv.getMvTtl());
//			
//			});
//		});
		
		
		
// 		단일 영화 정보 조회.
//		MvVO mv =  oracleAccess.selectMovie("MV-20250305-000001");
//		System.out.println(mv.getMvId() + ", " + mv.getMvTtl());
		
// 		단일 장르 정보 조회.
//		GnrVO gnr = oracleAccess.selectGenre("GR-20250305-000001");
//		System.out.println(gnr.getGnrNm());
		
		
// 		영화의 아이디로 장르의 아이디 조회하기 
//		List<String> mvIds = oracleAccess.selectGenreIdByMovieId("MV-20250305-000001");
//		System.out.println(mvIds);
		
		
//		장르의 아이디로 영화의 아이디 조회하기 
//		List<String> gnrIds = oracleAccess.selectMovieIdByGenreId("GR-20250305-000001");
//		System.out.println(gnrIds);
		
		
//		장르 추가
//		oracleAccess.insertNewGenre("로맨스");
		
//		영화 추가
		MvVO movie = new MvVO();
		movie.setMvTtl("범죄도시");
		movie.setMvOrgnlTtl("범죄도시");
		movie.setMvSubTtl(null);
		movie.setMvLng("한국어");
		movie.setMvRngTm(120);
		movie.setMvOpnDt("2017-10-03");
		movie.setMvDesc("범죄도시 desc");
		movie.setMvPstr("url");
		movie.setMvOpnStts("Y");
		movie.setMvRtng("15");
		movie.setMvCst(1000000);
		movie.setMvPrft(50000000);
		List<GnrVO> gnrList = new ArrayList<>();
		GnrVO thril =new GnrVO();
		thril.setGnrNm("스릴러");
		gnrList.add(thril);
		GnrVO action = new GnrVO();
		action.setGnrNm("액션");
		gnrList.add(action);
		GnrVO horrro = new GnrVO();
		horrro.setGnrNm("호러");
		gnrList.add(horrro);
		movie.setGnrList(gnrList);
		
		GnrVO crim = new GnrVO();
		crim.setGnrNm("범죄");
		gnrList.add(crim);
		movie.setGnrList(gnrList);
		
		
		
		List<CastVO> moviesCastList = new ArrayList<>();
		CastVO cast = new CastVO();
		cast.setCastNm("마석도");
		ActrVO actr = new ActrVO();
		actr.setActrNm("마동석");
		cast.setActr(actr);
		moviesCastList.add(cast);
		
		CastVO cast2 = new CastVO();
		cast2.setCastNm("장첸");
		ActrVO actr2 = new ActrVO();
		actr2.setActrNm("윤계상");
		cast2.setActr(actr2);
		moviesCastList.add(cast2);
		
		CastVO cast3 = new CastVO();
		cast3.setCastNm("장이수");
		ActrVO actr3 = new ActrVO();
		actr3.setActrNm("박지환");
		cast3.setActr(actr3);
		moviesCastList.add(cast3);
		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		

//		oracleAccess.deleteMovie("MV-20250307-000044");					// 영화 삭제
			
		
//		oracleAccess.deleteGenre("GR-20250307-000011");					// 장르 삭제
		oracleAccess.insertNewMovie(movie);								// 영화 등록
		
//		oracleAccess.deleteMovieGenreByMovieId("MV-20250307-000046");	//영화 아이디로 분류 삭제
//		oracleAccess.deleteMovieGenreByGenreId("GR-20250305-000004");
		
		
		
		// 배우 삭제 
		// 배우가 삭제되면, 출연 테이블의 배우 정보도 함께 삭제된다.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		// 1. 배우 조회	pk로  (success)
//		ActrVO ryan = oracleAccess.findActorByActrId("AC-20250305-000001");
//		System.out.println(ryan.getActrId());
//		System.out.println(ryan.getActrNm());
//		System.out.println(ryan.getActrPht());
		// 1. 배우 조회	이름으로 -동명이인 고려 x  (success)
//		ActrVO josh = oracleAccess.findActorByActrName("조쉬 브롤린");
//		System.out.println(josh.getActrId());
//		System.out.println(josh.getActrNm());
//		System.out.println(josh.getActrPht());
		
		// 2. 배우 등록 (success)
//		oracleAccess.insertActor(actr); // 마동석햄
		
		// 3. 배우 삭제	(success)
//		oracleAccess.deleteActor("AC-20250307-000054");
		
		// 4. 영화 등록할 때 배우 등록하기 + 출연 정보 등록하기  (이미 등록된 배우는 등록 x, 등록안된 배우만 등록 + 출연 정보 등록)
		
		
		
		// 5. 영화 조회할 때 출연 배우 함께 조회  (지금은 영화 + 장르만 조회)
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
