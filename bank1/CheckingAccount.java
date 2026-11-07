import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable{
	double balance;

	public static void main(String[] args){
		CheckingAccount ca = new CheckingAccount();
		ca.start();
	}//end main

	public CheckingAccount(){
		this.balance = 0d;	
	}//end CheckingAccount

	public CheckingAccount(double balance){
		this.balance = balance;
	}//end CheckingAccount

	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("0.) Quit");
		System.out.println("1.) Check Balance");
		System.out.println("2.) Make a Deposit");
		System.out.println("3.) Make a Withdrawal");
		System.out.println();
		System.out.print("Please enter your selection: ");
		String response = input.nextLine();
		return response;
	}//end menu

	public void start(){
		boolean keepGoing = true;
		String response;

		while(keepGoing){
			response = menu();
			if (response.equals("0")){
				keepGoing = false;
			}
			else if (response.equals("1")){
				System.out.println(" Checking balance...");
				this.checkBalance();
			}
			else if (response.equals("2")){
				System.out.println(" Making a deposit...");
				this.makeDeposit();
			}
			else if (response.equals("3")){
				System.out.println(" Making a withdrawal...");
				this.makeWithdrawal();
			}
			else{
				System.out.println("Not a valid input. Please enter 0, 1, 2, or 3.");
			}//end if
		}//end while loop
	}//end start

	public double getBalance(){
		return this.balance;
	}//end getBalance
	
	public String getBalanceString(){
		String result = String.format("$%.02f", this.balance);
		return result;
	} //end getBalanceString
	
	public void setBalance(double balance){
		this.balance = balance;
	}//end setBalance
	
	private double getDouble(){
		Scanner input = new Scanner(System.in);
		String resultString = input.nextLine();
		double result = 0d;
		try {
			result = Double.parseDouble(resultString);
		}
		catch (Exception e){
			System.out.println("Not a legal input. Changing to 0.");
			result = 0d;
		} //end try
		return result;
	} //end getDouble

	public void checkBalance(){
		System.out.println("Current Balance: ");
		System.out.println(this.getBalanceString());
	} //end checkBalance

	public void makeDeposit(){
		System.out.print("How much would you like to deposit? ");
		double deposit = this.getDouble();
		while (deposit < 0){
                        System.out.print("Invalid input. Please enter a positive amount: ");
                        deposit = this.getDouble();
                } //end while
		this.balance += deposit;
		System.out.println("New Balance: " + this.getBalanceString());
	} //end makeDeposit
	
	public void makeWithdrawal(){
		System.out.print("How much would you like to withdrawal? ");
		double withdrawal = this.getDouble();
		while (withdrawal < 0){
			System.out.print("Invalid input. Please enter a positive amount: ");
			withdrawal = this.getDouble();
		} //end while
		if (withdrawal > this.balance){
			System.out.println("Insufficient Funds.");
		}
		else {
			this.balance -= withdrawal;
		} //end if
		System.out.println("New Balance: " + this.getBalanceString());
	} //end makeWithdrawal

}//end class def
