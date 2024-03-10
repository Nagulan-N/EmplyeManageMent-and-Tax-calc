package driverMain;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DriverMain {
	private static ArrayList<Product> product = new ArrayList();
	private static ArrayList<Employee> employee = new ArrayList();
	
	public static void main(String arg[]) {
		Scanner myScanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		Short operation_No ;
		String pid;
	    double price;
	    int quantity;
		String empID;
		String name;
		long salary;
		
		
		while(true) {
			try {
				System.out.println("1 : For add product");
				System.out.println("2 : For add employee");
				System.out.println("3 : For exit");
				operation_No = myScanner.nextShort();
				myScanner.nextLine();
				switch(operation_No) {
				case 1:
					System.out.println("Enter product ID.");
					while(true) {
						pid = myScanner.nextLine();
						if(!pid.isEmpty()) {
							break;
						}else {
							System.out.println("Input is empty.Enter product ID");
						}
					}
					System.out.println("Enter product price.");
					while(true) {
						try{
							price = myScanner.nextDouble();
							break;
						}catch(Exception e) {
							System.out.println("Input is empty.Enter product price");
						}
					}
					System.out.println("Enter product quantity.");
					while(true) {
						try {					
							quantity = myScanner.nextInt();
							if(!pid.isEmpty()) {
								break;
							}else {
								System.out.println("Input is empty.Enter Product quantity.");
							}
						}catch(Exception e){
							System.out.println("Input is empty.Enter Product quantity.");
						}
					}
					product.add(new Product(pid,price,quantity));
					
					System.out.println("Product ID "+ pid  + "have  Sales tax ("+(df.format(product.get(product.size()-1).getSalesTax()*100))+"%) for per unit is Rs."+df.format(product.get(product.size()-1).calcTax()));
//					product.get(product.size()-1).calcTax();
					
					break;
				case 2:
					System.out.println("Enter employee ID.");
					while(true) {
						empID = myScanner.nextLine();
						if(!empID.isEmpty()) {
							break;
						}else {
							System.out.println("Input is empty.Enter employee ID.");
						}
					}
					System.out.println("Enter employee name.");
					while(true) {
					
							name = myScanner.nextLine();
							if(!name.isEmpty()) {
								break;
							}else {
								System.out.println("Input is empty.Enter employee name.");
							}
						
					}
					System.out.println("Enter Product quantity.");
					while(true) {
						try {					
							salary = myScanner.nextLong();
							break;
						}catch(Exception e){
							System.out.println("Input is empty.Enter Product quantity.");
						}
					}
					employee.add(new Employee(empID,name,salary));
					System.out.println("Income tax"+df.format(employee.get(employee.size()-1).getincomeTax()*100)+"per year for  "+name + " Rs"+ df.format(employee.get(employee.size()-1).calcTax()));
					break;
				}
				if(operation_No == 3) {					
					break;
				}else if(operation_No <0 || operation_No >3) {
					System.out.println("Enter valid operation no.");
					myScanner.nextLine();
				}
			}catch(Exception e) {
				System.out.println("Enter valid operation no.");
				myScanner.nextLine();
			}
		}
		

		
	}
}
