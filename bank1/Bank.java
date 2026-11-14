import java.util.*;
import java.io.*;

public class Bank implements HasMenu{

	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

       	public static void main(String[] args){
                new Bank();
        } //end main
	
	public Bank(){
		this.fullCustomerReport();
		this.start();
	} //end bank
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Bank Menu.");
		System.out.println();
		System.out.println("0.) Exit System.");
		System.out.println("1.) Login as Admin.");
		System.out.println("2.) Login as Customer.");
		System.out.println();
		System.out.print("Action: ");
		String result = input.nextLine();

		return result;
	} //end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String result = menu();
			if (result.equals("0")){
				keepGoing = false;
			}
			else if (result.equals("1")){
				System.out.println("Admin login.");
				if (this.admin.login()){
					startAdmin();
				} //end if
			}
			else if (result.equals("2")){
				System.out.println("Customer login.");
				this.loginAsCustomer();
			}
			else {
				System.out.println("Not a valid input.");
			} //end if
		} //end while
	} //end start
	
	public void startAdmin(){
		boolean keepGoing = true;
		while (keepGoing){
			String result = admin.menu();
			if (result.equals("0")){
				keepGoing = false;
			}
			else if (result.equals("1")){
				System.out.println("Full Customer Report.");
				this.reportAllCustomers();
			}
			else if (result.equals("2")){
				System.out.println("Add a User.");
				this.addUser();
			}
			else if (result.equals("3")){
				System.out.println("Apply Interest to Savings.");
				this.applyInterest();
			}
			else {
				System.out.println("Not a valid input.");
			} //end if
		} //end while
	} //end startAdmin
	
	public void loadSampleCustomers(){
		customers.add(new Customer("Alice", "0000"));
		customers.add(new Customer("Bob", "1111"));
		customers.add(new Customer("Cindy", "2222"));
	} //end loadSampleCustomers

	public void fullCustomerReport(){
		for (Customer customer: customers){
			System.out.println(customer.getReport());
		} //end for loop
	} //end fullCustomerReport
	
	public void addUser(){
		Scanner input = new Scanner(System.in);
		System.out.print("Username: ");
		String userName = input.nextLine();
		System.out.print("PIN: ");
		String PIN = input.nextLine();
		customers.add(new Customer(userName, PIN));
	} //end addUser
	
	public void applyInterest(){
		for (Customer customer: customers){
			customer.savings.calcInterest();
		} //end for
	} //end applyInterest
	
	public void loginAsCustomer(){
		Scanner input = new Scanner(System.in);
                System.out.print("Username: ");
                String userName = input.nextLine();
                System.out.print("PIN: ");
                String PIN = input.nextLine();

		Customer currentCustomer = null;
		for (Customer customer : customers){
			if (customer.login(userName, PIN)){
				currentCustomer = customer;
			} //end if
		} //end for
		
		if (currentCustomer == null){
			System.out.println("Customer not found.");
		}
		else {
			currentCustomer.start();
		} //end if
	} //end loginAsCustomer
} //end class def

class CustomerList extends ArrayList<Customer> {};
