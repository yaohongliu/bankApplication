package com.bank.main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankServicesMainTest {
	
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void isBalancePositiveTest_False() {
		double negativeBalance = -5.00;
		boolean isBalancePositive = BankServicesMain.isBalancePositive(negativeBalance);
		assertFalse(isBalancePositive);
	}
	
	@Test
	void isBalancePositiveTest_True() {
		double postiveBalance = 500.00;
		boolean isBalancePositive = BankServicesMain.isBalancePositive(postiveBalance);
		assertTrue(isBalancePositive);
	}
	
	@Test
	void isValidDobTest_False() {
		String falseDob = "98-12-12";
		boolean isValidDob = BankServicesMain.isValidDob(falseDob);
		assertFalse(isValidDob);
	}
	
	@Test
	void isValidDobTest_True() {
		String trueDob = "1998-12-12";
		boolean isValidDob = BankServicesMain.isValidDob(trueDob);
		assertTrue(isValidDob);
	}
	
	@Test
	void isValidUsernameTest_True() {
		String trueUsername = "HarryPotter";
		boolean isValidUsername = BankServicesMain.isValidUsername(trueUsername);
		assertTrue(isValidUsername);
	}
	@Test
	void isValidUsernameTest_False() {
		String falseUsername = "2$jf";
		boolean isValidUsername = BankServicesMain.isValidUsername(falseUsername);
		assertFalse(isValidUsername);
	}
	
	@Test
	void isValidNameTest_True() {
		String trueName = "Linda Peters";
		boolean isValidName = BankServicesMain.isValidName(trueName);
		assertTrue(isValidName);
	}
	
	@Test
	void isValidNameTest_False() {
		String falseName = "Linda";
		boolean isValidName = BankServicesMain.isValidName(falseName);
		assertFalse(isValidName);
	}
	@Test
	void isValidEmailTest_True() {
		String trueEmail = "linda32@gmail.com";
		boolean isValidEmail = BankServicesMain.isValidEmail(trueEmail);
		assertTrue(isValidEmail);
	}
	@Test
	void isValidEmailTest_False() {
		String falseEmail = "linda32@gmai";
		boolean isValidEmail = BankServicesMain.isValidEmail(falseEmail);
		assertFalse(isValidEmail);
	}
	@Test
	void isValidPwdTest_True() {
		String truePwd = "hgkdd3ftg";
		boolean isValidPwd = BankServicesMain.isValidPwd(truePwd);
		assertTrue(isValidPwd);
	}
	@Test
	void isValidPwdTest_False() {
		String falsePwd = "hgkd2";
		boolean isValidPwd = BankServicesMain.isValidPwd(falsePwd);
		assertFalse(isValidPwd);
		
	}

}