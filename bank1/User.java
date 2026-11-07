import java.util.*;
import java.io.*;

public abstract class User implements Serializable, HasMenu{
	String userName = "";
	String PIN = "";
	
	public boolean login(){
		Scanner input = new Scanner(System.in);
		boolean result = false;
		System.out.print("Username: ");
		String userNameIn = input.nextLine();
		if (userNameIn.equals(this.userName)){
			System.out.print("PIN: ");
			String pinIn = input.nextLine();

			if (pinIn.equals(this.PIN)){
				System.out.println("Login Successful.");
				result = true;
			}
			else {
				System.out.println("Incorrect PIN.");
			} //end pin if
		}
		else {
			System.out.println("Incorrect Username.");
		} //end user if
		return result;
	} //end login

	public boolean login(String userNameIn, String pinIn){
		boolean result = false;
		if (userNameIn.equals(this.userName)){
			if(pinIn.equals(this.PIN)){
				result = true;
			} //end pin if
		} //end user if
		return result;
	} //end login
	
	public void setUserName(String userName){
		this.userName = userName;
	} //end setUserName
	
	public String getUserName(){
		return this.userName;
	} //end getUserName
	
	public void setPIN(String PIN){
		if (PIN.matches("^\\d{4}$")){
			this.PIN = PIN;
		}
		else {
			System.out.println("PIN must be 4 digits...");
			System.out.println("Setting PIN to 0000");
			this.PIN = "0000";
		} //end if

	} //end setPIN
	
	public String getPIN(){
		return this.PIN;
	} //end getPIN
	
	public abstract String getReport();

} //end class def
