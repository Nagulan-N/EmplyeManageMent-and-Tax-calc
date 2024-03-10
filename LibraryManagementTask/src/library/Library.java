package library;
import java.util.ArrayList;

public class Library {
	private ArrayList<Book> book =  new ArrayList<>();
	
	private ArrayList<Student> studentArray =  new ArrayList<>();
	
	
	public void replaceBook(Book book1) {
		for(Short i =0;i <book.size();i++){
			if(book.get(i).getBookID() == book1.getBookID()){
			book.set(i,book1);
			break;	
			}
		}
	}
	
	public void addTakeAwayBook(String bookID,String takeAwayDate) {
		Short index = -1;
		for(Short i =0;i <book.size();i++){
			if(book.get(i).getBookID().equals(bookID)){
				index = i;
				book.get(i).setTakeAwayDate(takeAwayDate);
				book.get(i).setAvailable(false);
				System.out.println(book.get(i).getTitle() +" is currently unavailable.");
			break;
			}
		}
		if(index == -1) {
			System.out.println("No bbok found given ID.");
		}
	}
	
	public void returnBook(String bookID) {
		for(Short i =0;i <book.size();i++){
			if(book.get(i).getBookID().equals(bookID)){
			break;
			}
		}
	}
	
	public void searchBook(String searchString) {
		Short index = -1;
		for(Short i =0;i <book.size();i++){
			if(book.get(i).getTitle().toLowerCase().contains(searchString.toLowerCase())){
				index = (short) (index+1);
				System.out.println((index+1)+"  "+book.get(i).getTitle());
			}
		}
		if(index == -1) {
			System.out.println("No book found...");
		}
	}
	
	public void removeBook(String bookID) {
		Short inedex = -1;
		for(Short i =0;i <book.size();i++){
			if(book.get(i).getBookID().equals(bookID)){
				inedex = i;
				System.out.println(book.get(i).getTitle() +" book was removed successfully.");
				book.remove(i);
				break;
			}
		};
		if(inedex == -1) {
			System.out.println("No book found with the given ID.");
		}
	}
	
	public void add(Book book1) {
		this.book.add(book1);
		System.out.println(this.book.get(this.book.size()-1).getAuthor());
	}
	
	public void displayBook(String bookID) {
		Short index = -1;
		for(Short i =0;i <book.size();i++){
			System.out.println(book.get(i).getBookID() == bookID);
			if(book.get(i).getBookID().equals(bookID)){
				System.out.println(book.get(i).getBookID());
				index = i;
			break;
			}
		};
		if(index == -1) {
			System.out.println("No book found with the given ID.");
		}else {
			System.out.println("ID found successfully.");
			System.out.println("Title : "+book.get(index).getTitle());
			System.out.println("Autor :"+book.get(index).getAuthor());
			System.out.println("Department :"+book.get(index).getDepartMent());
			System.out.println("Rack No :"+book.get(index).getRackNo());
			System.out.println("Is Availabe: "+((book.get(index).getIsAvailable()||false)!= false?"Yes":"No"));
			
		}
	}
	
	public  Book getBYBookID(String ID) {
		Short index = -1;
		for(Short i =0;i <book.size();i++){
			if(book.get(i).getBookID().equals(ID)){
				index = i;
			break;
			}
		};
		return book.get(index);
	}
	
	public void addStudent(Student st) {
		studentArray.add(st);
	}
	
	public void getStudentByID(String ID) {
		Short index = -1;
		for(Short i =0;i <studentArray.size();i++){
			if(studentArray.get(i).getStudentID().equals(ID)){
				index = studentArray.get(i).getIsPaid()?-1:i;
			break;
			}
		};
		if(index == -1) {
			System.out.println("No student found with the given ID.");
		}else if(studentArray.get(index).getIsPaid()) {
			System.out.println("Fine for this student has already been paid.");
		}else {
			System.out.println("Payable fine ammount is Rs"+studentArray.get(index).getFineAmoount());
		}
	}
	
}
