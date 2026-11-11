import java.util.*;
import java.io.*;

public class Admin extends User implements HasMenu, Serializable{

	public static void main(String[] args){
		Admin a = new Admin();
		a.login();
	} //end main
	
	public Admin(){
		this.userName = "admin";
		this.PIN = "0000";
	} //end admin
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Admin Menu.");
		System.out.println();
		System.out.println("0.) Quit");
		System.out.println("1.) Full Customer Report.");
		System.out.println("2.) Add User.");
		System.out.println("3.) Apply Interest to Savings Account.");
		System.out.println();
		System.out.print("Action: ");
		String result = input.nextLine();

		return result;
	} //end menu

	public String getReport(){
		String report = "User: " + this.getUserName();
		report += ", Pin: " + this.getPIN();
		return report;
	} //end getReport
	
	public void start(){

	}
} //end class def
