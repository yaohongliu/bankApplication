package com.bank.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customers;
import com.bank.service.BankServices;
import com.bank.service.dao.BankServiceDAO;
import com.bank.service.dao.impl.BankServiceDAOImpl;
import com.bank.service.impl.BankServiceImpl;


public class BankServicesMain {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		System.out.println("Welcome to ABC Bank Service Application");
		System.out.println("=========================================");
		System.out.println("Enter 1 for Customer");
		System.out.println("Enter 2 for Employee");
		System.out.println("Enter 3 for Apply an Account");
		int s = sc.nextInt();
		int Customer_choice = 0;
		int Employee_choice = 0;
		if(s == 1)
		{
			do {
				System.out.println("Customer Menu");
				System.out.println("==================================");
				System.out.println("1) Apply Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposite");
				System.out.println("4) View Balance");
				System.out.println("5) Transfer Money");
				System.out.println("6) Accept Money");
				System.out.println("7) Exit");
				System.out.println("Please enter appropriate choice between 1-7");
				try {
					Customer_choice = Integer.parseInt(sc.nextLine());//if you enter special symbols 
				}catch(NumberFormatException e) {
				}
				
				switch(Customer_choice) {
				case 1:
					System.out.println("Applying account....");
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
		     }while(Customer_choice!=7);
		}
		if(s == 2) 
		{
			do {
				
				System.out.println("Employee Menu");
				System.out.println("==================================");
				System.out.println("1) Approve Account");
				System.out.println("2) Reject Account");
				System.out.println("3) View Customer Account");
				System.out.println("4) Register Customer Account");
				System.out.println("5) View Transaction History");
				System.out.println("6) Exit");
				System.out.println("Please enter appropriate choice between 1-6");
				try {
					Employee_choice = Integer.parseInt(sc.nextLine());//if you enter special symbols 
				}catch(NumberFormatException e) {
				}
				switch(Employee_choice) {
				case 1:
					System.out.println("Approve Account....");
					break;
				case 2:
					System.out.println("Reject Account....");
					break;
				case 3:
					BankServices bs =new BankServiceImpl();
					try {
						List<Customers> cList=bs.getCustomerInfo();
						if(cList!=null && cList.size()>0) {
							System.out.println("\nThere are "+cList.size()+" customers in Database:");
							for(Customers c:cList) {
								System.out.println(c.toString());
							}
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Register Customer Account....");
					BankServiceDAO bsa =new BankServiceDAOImpl();
					Account a = new Account(1000000008, 100008,2,500.00);
					
				
					//List<Account> accountList = bsa.getAccountInfo();
					try {
						if(bsa.createAccout(a)!=0)
							System.out.println("Account created successfully!");
						List<Account> aList=bsa.getAccountInfo();
						if(aList != null && aList.size()!=0) {
							for(Account a1:aList) {//traverse every player inside playerList
								System.out.println(a1);
								}
						}
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("View Transaction History....");
					break;
				case 6:
					System.out.println("Exit....");
					break;
				
				}
		}while(Employee_choice != 6);
		}
		/*
		BankServices bs =new BankServiceImpl();
		try {
			List<Customers> cList=bs.getCustomerInfo();
			if(cList!=null && cList.size()>0) {
				System.out.println("\nThere are "+cList.size()+" num of customers in Database:");
				for(Customers c:cList) {
					System.out.println(c.toString());
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		*/
		
	}

}
