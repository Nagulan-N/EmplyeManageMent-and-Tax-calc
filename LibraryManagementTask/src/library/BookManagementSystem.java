package library;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class BookManagementSystem {

	public static void main(String[] args) {
		
		Scanner myScnner = new Scanner(System.in); 
		Short operation_No ;
		Library library = new Library();
		DateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
		Date currentDate = new Date();
		String title;
		String bookID;
		String insertDate;
		String author;
		//Rack no making it easy to identify which book is located on which rack;
		String rackNo;
		String department;
		//takeAwayDate is when book taken by student; 
		String takeAwayDate;
		String searchString;
		//studentID collect by librarian when book return and for to collect fine ammount and Additionally, if a book is damaged, the studentID makes it easier to identify the responsible student.  
		String studentID;
		while(true) {
			System.out.println("1 : For add new book");
			System.out.println("2 : For display book");
			System.out.println("3 : For search book by book title");
			System.out.println("4 : For add take away book");
			System.out.println("5 : For return book");
			System.out.println("6 : For exit");
			
			
			   while(true) {
				   try {
					   System.out.println("Enter operation no.");
					   operation_No = myScnner.nextShort();
					   break;
				   }catch(Exception e) {
					   System.out.println("Enter valid operation no.");
					   myScnner.nextLine();
				   }
			   };
//				operation_No = myScnner.nextShort();
			   myScnner.nextLine();
				switch(operation_No) {
				case 1:
					Book newBook = new Book();
					System.out.println("Enter Title.");
					while(true) {
						title = myScnner.nextLine();
						if(!title.isEmpty()){
							break;
						}else {
							System.out.println("Input empty! Please enter title.");
							
						}
					}
//					myScnner.nextLine();
					System.out.println("Enter author name.");
					while(true) {
						author = myScnner.nextLine();
						if(!author.isEmpty()){
							break;
						}else {
							System.out.println("Input empty! Please enter author name.");
							
						}
					}
//					myScnner.nextLine();
					System.out.println("Enter rack no.");
					while(true) {
						rackNo = myScnner.nextLine();
						if(!rackNo.isEmpty()){
							break;
						}else {
							System.out.println("Input empty! Please enter rack no.");
						}
					}
//					myScnner.nextLine();
					System.out.println("Enter Department.");
					while(true) {
						department = myScnner.nextLine();
						if(!department.isEmpty()){
							break;
						}else {
							System.out.println("Input empty! Please enter department.");
						}
					}
//					myScnner.nextLine();

					System.out.println("Enter Book ID.");
					while(true) {
						bookID = myScnner.nextLine();
						if(!bookID.isEmpty()){
							break;
						}else {
							System.out.println("Input empty! Please enter bookID.");
						}
					}
//					myScnner.nextLine();
					currentDate = new Date();
					insertDate = sdf.format(currentDate);
					
					newBook.setAuthor(author);
					newBook.setTitle(title);
					newBook.setRackNo(rackNo);
					newBook.setBookID(bookID);
					newBook.setDepartMent(department);
					newBook.setBookInsertDate(insertDate);
					library.add(newBook);
					System.out.println(newBook.getTitle()+"  Successfully added.");
					break;
				case 2:
					String getBook_ID = myScnner.nextLine();
					while(true) {
						if(!getBook_ID.isEmpty()) {
							library.displayBook(getBook_ID);
							break;
						}else {
							System.out.println("Input empty! Please enter bookID.");
						}
					}
					break;
				case 3:
					System.out.println("Search by book title.");
					while(true){
						searchString = myScnner.nextLine();
						if(!searchString.isEmpty()){
							library.searchBook(searchString);
							break;
						}else {
							System.out.println("Input empty! Please enter book title.");
						}
					}
					break;
				case 4:
					currentDate = new Date();
					takeAwayDate = sdf.format(currentDate);
					System.out.println("Enter Book ID.");
					while(true) {
						bookID = myScnner.nextLine();
						if(!bookID.isEmpty()){
							library.addTakeAwayBook(bookID,takeAwayDate);
							break;
						}else {
							System.out.println("Input empty! Please enter bookID.");
						}
					}
					break;
				case 5:
					System.out.println("Enter Student ID.");
					Short index = -1;
					Book returnBook;
					while(true) {
						studentID = myScnner.nextLine();
						if(!studentID.isEmpty()){
							break;
						}else{
							System.out.println("Input empty! Please enter student ID.");
						}
					}
					System.out.println("Enter return book ID.");
					while(true){
						bookID = myScnner.nextLine();
						currentDate = new Date();
						if(!bookID.isEmpty()){
							try{								
								returnBook = library.getBYBookID(bookID);
								index = (short) (!returnBook.getIsAvailable()?0:2);
								break;
							}catch(Exception e) {
								System.out.println("Input empty! Please enter book name.");
							}
						}else{
							System.out.println("Input empty! Please enter book name.");
						}
					}
					System.out.println(returnBook.getTakeAwayDate());
					if(index == 0) {
						try {
							Date takeawayDate = sdf.parse(returnBook.getTakeAwayDate());
							Date crntDate = new Date();
							long noOfDaysTakeAway = Math.round((takeawayDate.getTime()-crntDate.getTime())/(1000*60*60*24));
							// fineAmount If a book is returned within 5 days, no fine is charged. However, a fine of rs 2  is levied for each day beyond the initial 5-day period.
							long fineAmount = noOfDaysTakeAway <= 5 ?0:(noOfDaysTakeAway-5)*2;
							Student stud = new Student();
							stud.setFineAmoount(fineAmount);
							stud.setStudentID(studentID);
							stud.setTakeAwayTime(returnBook.getTakeAwayDate());
							stud.setBookID(returnBook.getBookID());
							library.addStudent(stud);
							System.out.println(returnBook.getTitle()+"  returned to the library.");
							if(fineAmount == 0) {
								System.out.println(studentID+"have no fine amount.");
							}else {
								System.out.println(studentID+" have to paid Rs" +fineAmount+".");
							}
						}catch(Exception e) {
							System.out.println("Insert time err.");
						}
					}
					if(index ==-1) {
						System.out.println("No book found with the given ID.");
					}else if(index == 2) {
						System.out.println("The book you requested is now shelved in the library.");
					}
					
					break;
				case 6:
					while(true){
						String studID = myScnner.nextLine();
						if(!studID.isEmpty()){
							library.getStudentByID(studID);
							break;
						}else{
							System.out.println("No book found with the given ID.");
						}
					}
					break;
				
				}
				
				if(operation_No ==7) {
                     break;
				}else if(operation_No <=0 || operation_No >7) {
					System.out.println("No operation found with the given operation no.");
				}
        		
		};
		
		myScnner.close();
	}

}
