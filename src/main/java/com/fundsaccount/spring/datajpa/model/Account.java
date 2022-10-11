package com.fundsaccount.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "accountNo")
    private String accountNo;
    @Column(name = "accoutnName")
    private String accoutnName;
    @Column(name = "balance")
    private double balance;
    @Column(name = "date")
    private String date;
	
	public Account(){

	}

    public Account(String accountType, String accountNo, String accoutnName, double balance, String date) {
        this.accountType = accountType;
        this.accountNo = accountNo;
        this.accoutnName = accoutnName;
        this.balance = balance;
        this.date = date;
    }

	

	public long getId() {
		return id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String ac) {
		this.accountType = ac;
	}
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String ac) {
		this.accountNo = ac;
	}
	public String getAccoutnName() {
		return accoutnName;
	}

	public void setAccoutnName(String ac) {
		this.accoutnName = ac;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Double b) {
		this.balance = b;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	public String getDate() {
		return date;
	}

	
	@Override
	public String toString() {
		return "Person [id=" + id + ", accountType=" + accountType + ", accountNo=" + accountNo + ", accoutnName=" + accoutnName + ", balance" + balance + ", date" + date + "]";
	}

}
