package project_220628;

public class Board {
	
	
	int bno;
	public String mid;
	public String title;
	public String wcontents;
	public String wdate;
	public String div;
	
	
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public int getSelectno() {
		return bno;
	}
	public void setSelectno(int selectno) {
		this.bno = selectno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWcontents() {
		return wcontents;
	}
	public void setWcontents(String wcontents) {
		this.wcontents = wcontents;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	
	
	public Board() {
		
	}
	
	public Board(int bno) {
		this.bno = bno;
	}
	
	public Board(int bno, String title, String wcontents) {
		this.bno = bno;
		this.title = title;
		this.wcontents = wcontents;
		
	}
	
	
	@Override
	public String toString() {
		
		return "[" + wcontents + "]";
	}
		
}
