package com.bank.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.service.dao.BankServiceDAO;
import com.bank.service.dao.impl.BankServiceDAOImpl;


public class BankServicesMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("Welcome to ABC Bank Service Application");
		System.out.println("=========================================");
		System.out.println("Enter 1 for Customer");
		System.out.println("Enter 2 for Employee");
		System.out.println("Enter 3 for Apply an Account");
		int selection = sc.nextInt();
		int Customer_choice = 0;
		int Employee_choice = 0;
		
		if (selection == 1) {
			do {
				System.out.println("Customer Menu");
				System.out.println("==================================");
				System.out.println("1) Create Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) View Balance");
				System.out.println("5) Transfer Money");
				System.out.println("6) Accept Money");
				System.out.println("7) Exit");
				System.out.println("Please enter appropriate choice between 1-7");
				
				try {
					Customer_choice = Integer.parseInt(sc.nextLine());// if you enter special symbols
				} catch (NumberFormatException e) {
					
				}

				switch (Customer_choice) {
				case 1:
					System.out.println("Applying for account....");
					CustomerAccount newCustomer = new CustomerAccount();
					
					// prompt for name
					System.out.println("Enter your name: ");
					newCustomer.setCustomer_name(sc.nextLine().toString());
					
					// prompt for email
					System.out.println("Enter your email: ");
					newCustomer.setCustomerEmail(sc.nextLine().toString());
					
					// user
					System.out.println("Enter your username: ");
					newCustomer.setCustomer_login(sc.nextLine().toString());
					
					//pwd
					System.out.println("Enter your pwd: ");
					newCustomer.setCustomer_password(sc.nextLine().toString());
					
					// prompt for starting bal
					System.out.println("Enter your starting balance: ");
					double bal = Double.parseDouble(sc.nextLine());
					newCustomer.setBalance(bal);
					
					// prompt for dob
					System.out.println("Enter your dob (YYYY-MM-DD): ");
					newCustomer.setDob(sc.nextLine());
					
					BankServiceDAOImpl bankDAO = new BankServiceDAOImpl();
					try {
						bankDAO.createAccount(newCustomer);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 2:
					System.out.println("Withdraw money....");
					break;
				case 3:
					System.out.println("Deposite money....");
					break;
				case 4:
					System.out.println("View balance....");
					break;
				case 5:
					System.out.println("Transfer money....");
					break;
				case 6:
					System.out.println("Accepte money....");
					break;
				case 7:
					System.out.println("Exit....");
					break;

				}
			} while (Customer_choice != 7);
		}
		
		// employee choices
		if (selection == 2) {
			do {
				System.out.println("Employee Menu");
				System.out.println("==================================");
				System.out.println("1) Approve Account");
				System.out.println("2) Reject Account");
				System.out.println("3) View Customer Account");
				System.out.println("5) View Transaction History");
				System.out.println("6) Exit");
				System.out.println("Please enter appropriate choice between 1-6");

				try {
					Employee_choice = Integer.parseInt(sc.nextLine());// if you enter special symbols
				} catch (NumberFormatException e) {

				}

				switch (Employee_choice) {
					case 1:
						System.out.println("Approve Account....");
						break;
					case 2:
						System.out.println("Reject Account....");
						break;
					case 3:
												
						break;
					case 5:
						System.out.println("View Transaction History....");
						break;
					case 6:
						System.out.println("Exit....");
						break;
					default: 
						System.out.println("Unrecognized choice");
						break;
				}
			} while (Employee_choice != 6);
		}

	} // end main
} // end class
