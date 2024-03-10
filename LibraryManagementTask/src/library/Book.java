package library;

public class Book  {
	private String bookID = "";
	private String title = "";
	private String author = "";
	private Boolean isAvailable = true;
	private String bookInsertDate ="";
	private String takeAwayDate ="";
	private String rackNo;
	private String department;
	
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
	public String getDepartMent() {
		return department;
	}
	public void setDepartMent(String departMent) {
		this.department = departMent;
	}


	public String getBookID() {
		return bookID;
	}

	public  void setBookID(String ID) {
		this.bookID = ID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getBookInsertDate() {
		return bookInsertDate;
	}
	public void setBookInsertDate(String bookInsertDate) {
		this.bookInsertDate = bookInsertDate;
	}
	public String getTakeAwayDate() {
		return takeAwayDate;
	}
	public void setTakeAwayDate(String takeAwayDate) {
		this.takeAwayDate = takeAwayDate;
	}
	public void setAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


}


