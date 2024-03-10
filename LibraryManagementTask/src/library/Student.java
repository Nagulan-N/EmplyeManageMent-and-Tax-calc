package library;

public class Student {
	private String studentID;
	private long fineAmoount;
	private Boolean isPaid = false;
	private String bookID;
	private String takeAwayTime;
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public long getFineAmoount() {
		return fineAmoount;
	}
	
	public void setFineAmoount(long fineAmoount) {
		this.fineAmoount = fineAmoount;
		this.isPaid = this.fineAmoount == 0?true:false;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getTakeAwayTime() {
		return takeAwayTime;
	}

	public void setTakeAwayTime(String takeAwayTime) {
		this.takeAwayTime = takeAwayTime;
	}
}
