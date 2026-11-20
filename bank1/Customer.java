import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable{
	static final long serialVersionUID = 1L;

	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args){
		Customer c = new Customer();
		if (c.login()){
			c.start();
		} //end if
	} //end main
	
	public Customer(){
		this.userName = "Alice";
		this.PIN = "0000";	
	} //end customer
	
	public Customer(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
	} //end Customer
	
	public String getReport(){
		String report = "User: " + this.getUserName();
		report += ", Checking: " + this.checking.getBalanceString();
		report += ", Savings: " + this.savings.getBalanceString();
		return report;
	} //end getReport

	public void start(){
		//main loop for customer
		boolean keepGoing = true;
		String result;
		while (keepGoing){
			result = menu();
			if (result.equals("0")){
				keepGoing = false;
			}
			else if (result.equals("1")){
				System.out.println("Checking Account: ");
				System.out.println("-------------------------------");
				this.checking.start();
			}
			else if (result.equals("2")){
				System.out.println("Savings Account: ");
				System.out.println("-------------------------------");
				this.savings.start();
			}
			else if (result.equals("3")){
				System.out.println("Change PIN.");
				System.out.println("-------------------------------");
				this.changePIN();	
			}
			else{
				System.out.println("Invalid input.");
			}
		}
	} //end start
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Customer Menu.");
		System.out.println("-------------------------------");
		System.out.println("0.) Quit");
		System.out.println("1.) Manage Checking Account"); 
		System.out.println("2.) Manage Savings Account");
	   	System.out.println("3.) Change PIN");
		System.out.println();
		System.out.print("Please make a selection (0-3): ");
		String result = input.nextLine();

		return result;
	} //end menu
	
	public void changePIN(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Please enter your new PIN: ");
		String newPIN = input.nextLine();
		if (newPIN.matches("^\\d{4}$")){
			this.PIN = newPIN;
			System.out.println("PIN changed successfully.");
		}
		else {
			System.out.println("PIN must be 4 digits...");
			System.out.println("Setting PIN to 0000");
			this.PIN = "0000";
		} //end if
	} //end changePin

} //end class def
