package com.bank.main;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.service.dao.impl.BankServiceDAOImpl;

/**
 * 
 * @author Melody
 *
 */
public class BankServicesMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("Welcome to ABC Bank Service Application");
		System.out.println("=========================================");
		System.out.println("Enter 1 for Customer");
		System.out.println("Enter 2 for Employee");
		int selection = sc.nextInt();
		int customerChoice = 0;
		int employeeChoice = 0;

		if (selection == 1) {
			do {
				displayMenu();

				try {
					customerChoice = Integer.parseInt(sc.nextLine());// if you enter special symbols
				} catch (NumberFormatException e) {

				}

				switch (customerChoice) {
				case 1:
					createBankAccount(sc);

					break;
				case 2:
					BankServiceDAOImpl bankDAOWithdraw = new BankServiceDAOImpl();
					System.out.println("Please enter the withdraw amount: ");
					double withdrawAmount = Double.parseDouble(sc.nextLine());
					System.out.println("Enter email: ");
					String withdrawEmail = sc.nextLine();

					try {
						bankDAOWithdraw.withdraw(withdrawAmount, withdrawEmail);
					} catch (BusinessException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					BankServiceDAOImpl bankDAODeposit = new BankServiceDAOImpl();
					System.out.println("Please enter the deposit amount: ");
					double depositAmount = Double.parseDouble(sc.nextLine());
					System.out.println("Enter email: ");
					String depositEmail = sc.nextLine();

					try {
						bankDAODeposit.deposit(depositAmount, depositEmail);
					} catch (BusinessException e) {
						e.printStackTrace();
					}

					break;
				case 4:
					BankServiceDAOImpl bankDAOViewBal = new BankServiceDAOImpl();
					System.out.println("Please enter the account email to view the balance");

					try {
						String byEmail = sc.nextLine();
						CustomerAccount cAccount = bankDAOViewBal.getCustomerByEmail(byEmail);
						if (cAccount != null) {
							System.out.println(cAccount);
						}

					} catch (BusinessException e) {
						e.printStackTrace();
					}

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
			} while (customerChoice != 7);
		} // end customer menu

		// employee choices
		if (selection == 2) {
			do {
				System.out.println(" Employee Menu");
				System.out.println("----------------");
				System.out.println("1) Create a Bank Account");
				System.out.println("2) View Customer Bank Account");
				System.out.println("3) View Transaction History");
				System.out.println("4) Exit");
				System.out.println("Please enter appropriate choice between 1-4");

				try {
					employeeChoice = Integer.parseInt(sc.nextLine());// if you enter special symbols
				} catch (NumberFormatException e) {

				}

				switch (employeeChoice) {
				case 1:
					System.out.println("Create a Bank Account....");
					createBankAccount(sc);
					break;
				case 2:
					System.out.println("view Account....");
					System.out.println("Enter the email of the account you want to view:");
					String viewByEmail = sc.nextLine();
					BankServiceDAOImpl bankDAOViewAcc = new BankServiceDAOImpl();
					try {
						CustomerAccount cAccount = bankDAOViewAcc.getCustomerByEmail(viewByEmail);
						if (cAccount != null) {
							System.out.println(cAccount);
						}

					} catch (BusinessException e) {
						e.printStackTrace();
					}

					break;
				case 3:
					System.out.println("View Transaction History....");
					break;
				case 4:
					System.out.println("Exit....");
					break;
				default:
					System.out.println("Unrecognized choice");
					break;
				}
			} while (employeeChoice != 6);
		} // end employee choice
	} // end main

	private static void displayMenu() {
		System.out.println(" Customer Menu");
		System.out.println("---------------");
		System.out.println("1) Apply Bank Account");
		System.out.println("2) Withdraw");
		System.out.println("3) Deposit");
		System.out.println("4) View Balance");
		System.out.println("5) Transfer Money");
		System.out.println("6) Accept Money");
		System.out.println("7) Exit");
		System.out.println("Please enter appropriate choice between 1-7");
	}

	/**
	 * 
	 * @param sc
	 */
	private static void createBankAccount(Scanner sc) {
		System.out.println("Applying for a bank account....");
		CustomerAccount newCustomer = new CustomerAccount();

		// prompt for name
		System.out.println("Enter your name: ");
		newCustomer.setName(sc.nextLine().toString());

		// prompt for email
		System.out.println("Enter your email: ");
		newCustomer.setEmail(sc.nextLine().toString());

		// username
		System.out.println("Enter your username: ");
		newCustomer.setUsername(sc.nextLine().toString());

		// pwd
		System.out.println("Enter your pwd: ");
		newCustomer.setPassword(sc.nextLine().toString());

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
			System.out.println("Your bank account has been created successfully!");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
} // end class
