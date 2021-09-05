package com.iu.s1.util;

public class Pager {
	
	private Long startRow; // 시작번호
	private Long lastRow;  // 끝번호
	
	private Long pn; // page number
	private Long perPage;
	
	private Long startNum;
	private Long lastNum;
	

	public void makeNum() {
		//1. totalCount 구하기
		Long totalCount = 212L;
		
		//2. totalPage 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage += 1;
		}
		
		//3. totalBlock 구하기
		Long totalBlock = totalPage/5;
		if(totalPage/5 != 0) {
			totalBlock += 1;
		}
		
		//4. pn으로 curBlock 구하기
		Long curBlock = this.getPn()/5;
		if(this.getPn()%5 !=0) {
			curBlock += 1;
		}
		
		//5. curBlock으로 시작번호와 마지막번호 구하기
		this.startNum = (curBlock-1)*5+1;
		this.lastNum = curBlock*5;
	}
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage()+1;
		this.lastRow = this.getPn()*this.getPerPage();
	}
	
	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPn() {
		if(this.pn==null || this.pn<=0) {
			this.pn = 1L;
		}
		return pn;
	}

	public void setPn(Long pn) {
		this.pn = pn;
	}
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
}