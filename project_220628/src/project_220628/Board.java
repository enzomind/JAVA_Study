package project_220628;

public class Board {
	
	
	int bno;
	String mid;
	String title;
	String wcontents;
	String wdate;
	
	
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

	
	public Board(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		
		return "[" + wcontents + "]";
	}
	
	
	
}
