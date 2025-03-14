package com.ktdsuniversity.edu.tmdb.vo;

import java.util.List;

/**
 * 데이터베이스를 연동하는 프로젝트의 vo 클래스는
 * 테이블의 구조와 동일한 형태의 데이터 클래스로 작성한다.
 */
public class MvVO {
	private String mvId;
	private String mvTtl;
	private String mvOrgnlTtl;
	private String mvSubTtl;
	private String mvLng;
	private long mvRngTm;	// number(3,0)
	private String mvOpnDt;
	private String mvDesc;
	private String mvPstr;
	private String mvOpnStts;
	private String mvRtng;
	private long mvCst;	// number(11,0)
	private long mvPrft;	// number(20,0)
	
	private List<GnrVO> gnrList;
	private List<CastVO> castList;
	
	
	public List<GnrVO> getGnrList() {
		return this.gnrList;
	}
	public void setGnrList(List<GnrVO> gnrList) {
		this.gnrList = gnrList;
	}
	
	public List<CastVO> getCastList() {
		return this.castList;
	}
	public void setCastList(List<CastVO> castList) {
		this.castList = castList;
	}
	
	
	
	
	public String getMvId() {
	    return this.mvId;
	}
	public void setMvId(String mvId) {
	    this.mvId = mvId;
	}
	public String getMvTtl() {
	    return this.mvTtl;
	}
	public void setMvTtl(String mvTtl) {
	    this.mvTtl = mvTtl;
	}
	public String getMvOrgnlTtl() {
	    return this.mvOrgnlTtl;
	}
	public void setMvOrgnlTtl(String mvOrgnlTtl) {
	    this.mvOrgnlTtl = mvOrgnlTtl;
	}
	public String getMvSubTtl() {
	    return this.mvSubTtl;
	}
	public void setMvSubTtl(String mvSubTtl) {
	    this.mvSubTtl = mvSubTtl;
	}
	public String getMvLng() {
	    return this.mvLng;
	}
	public void setMvLng(String mvLng) {
	    this.mvLng = mvLng;
	}
	public long getMvRngTm() {
	    return this.mvRngTm;
	}
	public void setMvRngTm(long mvRngTm) {
	    this.mvRngTm = mvRngTm;
	}
	public String getMvOpnDt() {
	    return this.mvOpnDt;
	}
	public void setMvOpnDt(String mvOpnDt) {
	    this.mvOpnDt = mvOpnDt;
	}
	public String getMvDesc() {
	    return this.mvDesc;
	}
	public void setMvDesc(String mvDesc) {
	    this.mvDesc = mvDesc;
	}
	public String getMvPstr() {
	    return this.mvPstr;
	}
	public void setMvPstr(String mvPstr) {
	    this.mvPstr = mvPstr;
	}
	public String getMvOpnStts() {
	    return this.mvOpnStts;
	}
	public void setMvOpnStts(String mvOpnStts) {
	    this.mvOpnStts = mvOpnStts;
	}
	public String getMvRtng() {
	    return this.mvRtng;
	}
	public void setMvRtng(String mvRtng) {
	    this.mvRtng = mvRtng;
	}
	public long getMvCst() {
	    return this.mvCst;
	}
	public void setMvCst(long mvCst) {
	    this.mvCst = mvCst;
	}
	public long getMvPrft() {
	    return this.mvPrft;
	}
	public void setMvPrft(long mvPrft) {
	    this.mvPrft = mvPrft;
	}

	


	
	
	
	
	
}
