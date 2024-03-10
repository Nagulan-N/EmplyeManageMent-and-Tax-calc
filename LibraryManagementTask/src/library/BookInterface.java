package library;

public interface BookInterface {
	String bookID = "";
	String title = "";
	String author = "";
	Boolean isAvailable = true;
	String bookInsertDate ="";

	void getBookID();
	
	abstract void setBookID(String bookID);
	

	
	
}
