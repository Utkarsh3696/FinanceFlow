package edu.utkarsh.springboot.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String email;
	@Column(nullable = false, unique = true)
	private String name ;
	@Column(nullable = false, unique = true)
	private long mobile;
	@Column(nullable = false, unique = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Spend> spendList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Income> incomeslist;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Borrow> borrowslist;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Lents> lents;
	

	
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public List<Borrow> getBorrowslist() {
		return borrowslist;
	}

	public void setBorrowslist(List<Borrow> borrowslist) {
		this.borrowslist = borrowslist;
	}

	public List<Lents> getLents() {
		return lents;
	}

	public void setLents(List<Lents> lents) {
		this.lents = lents;
	}

	public List<Income> getIncomeslist() {
		return incomeslist;
	}

	public void setIncomeslist(List<Income> incomeslist) {
		this.incomeslist = incomeslist;
	}

	public List<Spend> getSpendList() {
		return spendList;
	}

	public void setSpendList(List<Spend> spendList) {
		this.spendList = spendList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	
	
	
}
