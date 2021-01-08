package com.bank.main;

import java.util.List;
import java.util.Scanner;

import com.bank.exception.BusinessException;
import com.bank.model.Customers;
import com.bank.service.BankServices;
import com.bank.service.impl.BankServiceImpl;

public class BankServicesMain {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to ABC Bank Service Application");
		System.out.println("=========================================");
		System.out.println("Enter 1 for Customer");
		System.out.println("Enter 2 for Employee");
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
				case 2:
					System.out.println("Withdraw money....");
				case 3:
					System.out.println("Deposite money....");
				case 4:
					System.out.println("View balance....");
				case 5:
					System.out.println("Transfer money....");
				case 6:
					System.out.println("Accepte money....");
				case 7:
					System.out.println("Exit....");
				
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
				case 2:
					System.out.println("Reject Account....");
				case 3:
					System.out.println("View Customer Account....");
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
				case 4:
					System.out.println("Register Customer Account....");
				case 5:
					System.out.println("View Transaction History....");
				case 6:
					System.out.println("Exit....");
				
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
