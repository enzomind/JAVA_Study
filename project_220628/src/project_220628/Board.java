package project_220628;

public class Board {
	
	private int bno;
	private String mid;
	private String title;
	private String wcontents;
	private String wdate;
	private String div;
	
	private int mno;
	private String mpw;
	
	
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
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
	
	public Board(int bno, String mid) {
		this.bno = bno;
		this.mid = mid;
	}
	
	public Board(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}
	@Override
	public String toString() {
		
		return "[" + wcontents + "]";
	}
		
}
