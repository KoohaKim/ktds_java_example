package com.ktdsuniversity.edu.tmdb.vo;

import java.util.List;

public class ActrVO {
	private String actrId;
	private String actrNm;
	private String actrPht;
	
	private List<CastVO> castList; 
	
	
	
	public List<CastVO> getCastList() {
		return this.castList;
	}
	public void setCastList(List<CastVO> castList) {
		this.castList = castList;
	}
	
	
	public String getActrId() {
		return this.actrId;
	}
	public void setActrId(String actrId) {
		this.actrId = actrId;
	}
	public String getActrNm() {
		return this.actrNm;
	}
	public void setActrNm(String actrNm) {
		this.actrNm = actrNm;
	}
	public String getActrPht() {
		return this.actrPht;
	}
	public void setActrPht(String actrPht) {
		this.actrPht = actrPht;
	}


	
	
	
}
