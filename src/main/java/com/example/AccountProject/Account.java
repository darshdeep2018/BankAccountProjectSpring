package com.example.AccountProject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account{

	private String ownerName;
	private String address;
	private int balanceAmount;
	private String createdDate;
	private String status;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void depositMoney(int money) {
		if(status=="INACTIVE") {
			System.err.println("Account is inactive can't process the request");
			return;
		}else if(status=="CLOSED") {
			System.err.println("Account is closed can't process the request");
			return;
		}
		balanceAmount+=money;
		System.out.println("Money Deposited Successfully");
	}

	public void withdrawMoney(int money) {
		if(status=="INACTIVE") {
			System.err.println("Account is inactive can't process the request");
			return;
		}else if(status=="CLOSED") {
			System.err.println("Account is closed can't process the request");
			return;
		}
		if(money>balanceAmount) {
			System.err.println("Money exceeds balance");
			return;
		}
		balanceAmount-=money;
		System.out.println("Transaction Done Successfully");
	}
	
	public int getBalance() {
		return balanceAmount;
	}

	public void showDetails() {
		System.out.println("Owner : "+ownerName);
		System.out.println("Adress : "+address);
		System.out.println("Account created on : "+createdDate);
		System.out.println("Current Balance : "+balanceAmount);
	}	
}

