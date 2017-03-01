package com.nashvi.labs.accounts;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private Long id;

	@Column(name = "ACCOUNT_TYPE")
	private AccountType accountType;

	@Column(name = "ACCOUNT_NAME")
	private String name;

	@Column(name = "OPENING_BALANCE")
	private double openingBalance;

	@Column(name = "CLOSING_BALANCE")
	private double closingBalance;

	@Column(name = "OPENED_ON")
	private Date openedOn;

	@Column(name = "MODIFIED_ON")
	private Date modifiedOn;

	public Accounts() {
	}

	public Accounts(Long id) {
		this.id = id;
	}

	public Accounts(Long id, AccountType accountType, String name, double openingBalance, double closingBalance,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		result = (int) (prime * result + id);
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
		Accounts other = (Accounts) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

enum AccountType {
	CREDIT, DEBIT, SAVINGS, CHECKING, LINKED;

}
