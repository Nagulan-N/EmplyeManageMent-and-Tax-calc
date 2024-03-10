package driverMain;

public class Employee implements Taxable{
	private String empID;
	private String name;
	private double salary;
	
    Employee(String empId, String name, double salary) {
        this.empID = empId;
        this.name = name;
        this.salary = salary;
    }
	
	public String getEmpID() {
		return empID;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	 public double calcTax() {
//		 System.out.println("Income tax per year for  "+name + " Rs"+ (salary * incomeTax));
	        return Math.round(salary * incomeTax);
	    }

	public double getincomeTax() {

		return incomeTax;
	}
}
