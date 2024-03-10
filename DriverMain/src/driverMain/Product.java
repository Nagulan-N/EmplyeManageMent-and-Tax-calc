package driverMain;

public class Product implements Taxable {
	private String pid;
	private double price;
	private int quantity;

    Product(String pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

	
	public double calcTax() {
		
		return price * salesTax;
	}


	public double getSalesTax() {
		return salesTax;
	}
	
}
