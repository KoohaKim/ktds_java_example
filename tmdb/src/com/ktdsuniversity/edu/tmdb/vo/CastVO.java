package com.ktdsuniversity.edu.tmdb.vo;

public class CastVO {
	private String castId;
	private String castNm;
	private String actrId;
	private String mvId;
	
	private ActrVO actr;  //영화의 배역을 담당(연기)한 배우의 정보
	private MvVO mv;	  // 배역을 담당(연기)한 영화의 정보
	
	

	
	public ActrVO getActr() {
		return this.actr;
	}

	public void setActr(ActrVO actr) {
		this.actr = actr;
	}

	public MvVO getMv() {
		return this.mv;
	}

	public void setMv(MvVO mv) {
		this.mv = mv;
	}

	
	
	public String getCastId() {
		return this.castId;
	}
	
	public void setCastId(String castId) {
		this.castId = castId;
	}
	
	public String getCastNm() {
		return this.castNm;
	}
	
	public void setCastNm(String castNm) {
		this.castNm = castNm;
	}
	
	public String getActrId() {
		return this.actrId;
	}
	
	public void setActrId(String actrId) {
		this.actrId = actrId;
	}
	
	public String getMvId() {
		return this.mvId;
	}
	
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	
	
	
	
	
}
