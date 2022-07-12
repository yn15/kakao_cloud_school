package com.kakao.bank;

public class Account {
	private String name; // 예금주
	private String account; // 계좌
	private int balance; // 잔액
	
	public Account() {
		
	}
	
	public Account(String name, String account, int balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
		
		printAccount();
		accountBalance();
	}
	
	// 계좌정보 출력
	public void printAccount(){
		System.out.println("계좌 " + getAccount() + "(예금주 : " + getName() + ")");
	}
	
	// 입금
	public void deposit(int money) {
		System.out.println(money + " 원 입금합니다.");
		this.balance += money;
		accountBalance();
	}
	
	// 출금
	public void withdraw(int money) {
		System.out.println(money + " 원 출금합니다.");
		this.balance -= money;
		accountBalance();
	}
	
	// 잔액
	public void accountBalance() {
		System.out.println("잔액 : " + getBalance() + "원");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static void main(String[] args) {
		Account b1 = new Account("홍길동", "123-45678", 10000);
		b1.deposit(20000);
		b1.withdraw(45000);
	}

}
