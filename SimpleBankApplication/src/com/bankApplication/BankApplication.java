package com.bankApplication;

import java.util.ArrayList;
import java.util.List;

public class BankApplication {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<Account>();
		// Create 20 accounts and deposit $10 dollar each
		for (int i = 0; i < 20; i++) {
			accounts.add(new Account("Customer" + i, 10));
		}

		// Select random customer - customer6 to get it's initial balance
		accounts.get(6).getBalance();
		// deposit $100 customer6's account
		accounts.get(6).deposit(100);
		// get current balance after the deposit
		accounts.get(6).getBalance();
		// Test other costomer's account is not affected after the deposit
		accounts.get(4).getBalance();
		// withdraw $35 from customer6's account
		accounts.get(6).withdraw(35);
		// Try to withdraw more than balance on the account
		accounts.get(6).withdraw(300); // Expected Result-> Not enough balance !
		// now see this customer's new balance
		accounts.get(6).getBalance();
		// Try to deposit negative amount
		accounts.get(6).deposit(-28); // Expected Result-> Can not deposit negative amount
		// Try to withdraw negative amount
		accounts.get(6).withdraw(-42); // Expected Result-> Can not withdraw negative amount

	}
}

class Account {
	private String name;
	private double balance;

	public Account(String name, double initialBalance) {
		this.name = name;
		if (initialBalance > 0)
			this.balance = initialBalance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			System.out.println(name + " deposited $" + amount + " on his account");
		} else {
			System.out.println("Can not deposit negative amount ");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0) {
			this.balance -= amount;
			System.out.println(name + " withdrawen $" + amount);
		} else if (amount > this.balance) {
			System.out.println("Not enough balance ! ");
		} else {
			System.out.println("Can not withdraw negative amount ");
		}
	}

	public double getBalance() {
		System.out.println("Current balance for " + name + " is now: $" + balance);
		return balance;
	}
}
