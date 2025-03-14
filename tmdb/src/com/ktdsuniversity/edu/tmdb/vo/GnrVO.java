package com.ktdsuniversity.edu.tmdb.vo;

import java.util.List;

public class GnrVO {
	private String gnrId;
	private String gnrNm;
	
	private List<MvVO> mvList; 
	
	
	
	public List<MvVO> getMvList() {
		return this.mvList;
	}
	public void setMvList(List<MvVO> mvList) {
		this.mvList = mvList;
	}
	
	
	public String getGnrId() {
		return this.gnrId;
	}
	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}
	
	public String getGnrNm() {
		return this.gnrNm;
	}
	public void setGnrNm(String gnrNm) {
		this.gnrNm = gnrNm;
	}
	
	
	
	
}
