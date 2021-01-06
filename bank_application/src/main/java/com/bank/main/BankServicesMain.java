package com.bank.main;

import java.util.List;
import java.util.Scanner;

import com.bank.exception.BusinessException;
import com.bank.model.Customers;
import com.bank.service.BankServices;
import com.bank.service.impl.BankServiceImpl;

public class BankServicesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Bank Service Application");
		System.out.println("===================================");
		int choice = 0;
		do {
			
		}while(choice!=0);*/
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
		
		
	}

}
