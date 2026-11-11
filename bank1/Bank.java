import java.util.*;
import java.io.*;

public class Bank implements HasMenu{

	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

       	public static void main(String[] args){
                new Bank();
        } //end main
	
	public Bank(){
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
				System.out.println("Admin login");
			}
			else if (result.equals("2")){
				System.out.println("Customer login");
			}
			else {
				System.out.println("Not a valid input.");
			} //end if
		} //end while
	} //end start
	
} //end class def

class CustomerList extends ArrayList<Customer> {};
