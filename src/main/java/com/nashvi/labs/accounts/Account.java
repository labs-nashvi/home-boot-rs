package com.nashvi.labs.accounts;

import java.util.Date;

public class Account {

	private int id;
	private AccountType accountType;
	private String name;
	private double openingBalance;
	private double closingBalance;
	private Date openedOn;
	private Date modifiedOn;

	public Account() {
	}

	public Account(int id) {
		this.id = id;
	}

	public Account(int id, AccountType accountType, String name, double openingBalance, double closingBalance,
			Date openedOn, Date modifiedOn) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.name = name;
		this.openingBalance = openingBalance;
		this.closingBalance = closingBalance;
		if (this.openedOn == null) {
			this.openedOn = openedOn;
		}
		this.modifiedOn = modifiedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getOpenedOn() {
		return openedOn;
	}

	public void setOpenedOn(Date openedOn) {
		this.openedOn = openedOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

enum AccountType {
	CREDIT, DEBIT, SAVINGS, CHECKING, LINKED;

}
