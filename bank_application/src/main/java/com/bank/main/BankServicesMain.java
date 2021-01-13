package com.bank.main;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.service.dao.impl.BankServiceDAOImpl;

/**
 * 
 * @author Melody
 *
 */
public class BankServicesMain {

	private static Logger log = Logger.getLogger(BankServicesMain.class);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int selection = 0;
		System.out.println("Welcome to ABC Bank Service Application");
		System.out.println("=========================================");
		System.out.println("Enter 1 for Customer");
		System.out.println("Enter 2 for Employee");
		selection = Integer.parseInt(sc.nextLine());

		int customerChoice = 0, employeeChoice = 0;
		
		if (selection == 1 || selection == 2) {
			switch (selection) {
			case 1:
				do {
					displayCustomerMenu();
					try {
						customerChoice = Integer.parseInt(sc.nextLine());// if you enter special symbols

					} catch (NumberFormatException e) {

					}
					switch (customerChoice) {
					case 1: // create acct
						createBankAccount(sc);
						break;
					case 2: // withdraw (requires login)
						withdraw(sc);
						break;
					case 3: // deposit (requires login)
						deposit(sc);
						break;
					case 4: // view balance (requires login)
						viewBalance(sc);
						break;
					case 5:
						System.out.println("Transfer money....");
						break;
					case 6:
						System.out.println("Accept money....");
						break;
					case 7:
						System.out.println("Exit....");
						break;
					}

				} while (customerChoice != 7);

				break;
			case 2:
				do {
					displayEmployeeMenu();

					try {
						employeeChoice = Integer.parseInt(sc.nextLine());// if you enter special symbols
					} catch (NumberFormatException e) {

					}

					switch (employeeChoice) {
					case 1:
						System.out.println("Approve/Reject Applications....");
						createBankAccount(sc);
						break;
					case 2:
						System.out.println("View Accounts....");
						viewAccounts(sc);
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
				} while (employeeChoice != 4);

				break; // end employee choice

			default:
				System.out.println("Unrecognized choice");
				break;
			}

		} else {
			System.out.println("Invalid choice! Exit...");
		}
	} // end main

	private static void displayEmployeeMenu() {
		System.out.println(" Employee Menu");
		System.out.println("----------------");
		System.out.println("1) Create a Bank Account");
		System.out.println("2) View Customer Bank Account");
		System.out.println("3) View Transaction History");
		System.out.println("4) Exit");
		System.out.println("Please enter appropriate choice between 1-4");
	}

	/**
	 * 
	 * @param sc Scanner
	 */
	private static void viewBalance(Scanner sc) {
		CustomerAccount customer = customerLogin(sc);

		if (customer != null) {
			System.out.println(customer.showBalance());
		}
	}

	/**
	 * 
	 * @param sc Scanner
	 */
	private static void deposit(Scanner sc) {
		BankServiceDAOImpl bankDAODeposit = new BankServiceDAOImpl();
		System.out.println("Please enter the deposit amount: ");
		double depositAmount = Double.parseDouble(sc.nextLine());

		CustomerAccount customer = customerLogin(sc);

		if (customer != null) {
			try {
				bankDAODeposit.deposit(depositAmount, customer);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}

	}

	private static void withdraw(Scanner sc) {
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
	}

	private static void viewAccounts(Scanner sc) {
		// TODO: implement
	}

	private static void displayCustomerMenu() {
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
		String name = sc.nextLine();
		while (!isValidName(name)) {
			System.out.println("Invalid name! Please enter first and last name: ");
			name = sc.nextLine();
		}
		newCustomer.setName(name);

		// prompt for email
		System.out.println("Enter your email: ");
		String email = sc.nextLine();

		while (!isValidEmail(email)) {
			System.out.println("Invalid Email! example: test@mail.com: ");
			name = sc.nextLine();
		}
		newCustomer.setEmail(email);

		// username
		System.out.println("Enter your username: ");
		String userName = sc.nextLine();
		while (!isValidUsername(userName)) {
			System.out.println("Invalid userName! At least 5 letters, no special characters: ");
			name = sc.nextLine();
		}
		newCustomer.setUsername(userName);

		// pwd
		System.out.println("Enter your pwd: ");
		String pwd = sc.nextLine();

		while (!isValidPwd(pwd)) {
			System.out.println("Invalid password! Minimum eight characters, at least one letter and number: ");
			pwd = sc.nextLine();
		}
		newCustomer.setPassword(pwd);

		// prompt for starting bal
		System.out.println("Enter your starting balance: ");
		double bal = Double.parseDouble(sc.nextLine());

		while (!isBalancePositive(bal)) {
			log.warn("Balance cannot be negative, enter positive value!");
			bal = Double.parseDouble(sc.nextLine());
		}

		newCustomer.setBalance(bal);

		// prompt for dob
		System.out.println("Enter your dob (YYYY-MM-DD): ");
		String dob = sc.nextLine();
		while (!isValidDob(dob)) {
			System.out.println("Invalid DOB! Please enter valid DOB with format YYYY-MM-DD: ");
			name = sc.nextLine();
		}
		newCustomer.setDob(dob);

		BankServiceDAOImpl bankDAO = new BankServiceDAOImpl();
		try {
			bankDAO.createAccount(newCustomer);
			System.out.println("Your bank account has been created successfully!");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isValidName(String name) {
		return name.matches("[a-zA-Z]{0,20} [a-zA-Z]{0,20}");
	}

	public static boolean isValidEmail(String email) {
		return email.matches("[a-zA-Z0-9._]{2,20}@[a-zA-Z0-9._]{2,10}.[a-zA-Z]{2,6}");
	}

	public static boolean isValidPwd(String pwd) {
		return pwd.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
	}

	public static boolean isValidUsername(String userName) {
		return userName.matches("[a-zA-Z0-9._]{5,30}");
	}

	public static boolean isValidDob(String dob) {
		return dob.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}");
	}

	public static boolean isBalancePositive(double balance) {
		boolean isBalancePositive = false;

		if (balance >= 0.0) {
			isBalancePositive = true;
		}

		return isBalancePositive;
	}

	/**
	 * 
	 * @param sc Scanner
	 * @return a CustomerAccount object
	 */
	private static CustomerAccount customerLogin(Scanner sc) {
		CustomerAccount customer = null;

		System.out.println("Log in to your bank account with username / password. \n Account must be approved.");
		System.out.println("Username: ");
		String username = sc.nextLine();
		System.out.println("Password: ");
		String password = sc.nextLine();

		BankServiceDAOImpl bankDAO = new BankServiceDAOImpl();
		try {
			customer = bankDAO.getCustomerByUsernameAndPassword(username, password);
		} catch (BusinessException e) {
			System.out.println("Account cannot be found!");
			e.printStackTrace();
		}

		return customer;
	}

} // end class
