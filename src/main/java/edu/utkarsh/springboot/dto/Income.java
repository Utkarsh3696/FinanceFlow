package edu.utkarsh.springboot.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "income")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String income_name;
	@Column(nullable = false, unique = false)
	private LocalDate date;
	@Column(nullable = false, unique = false)
	private double rs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIncome_name() {
		return income_name;
	}
	public void setIncome_name(String income_name) {
		this.income_name = income_name;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getRs() {
		return rs;
	}
	public void setRs(double rs) {
		this.rs = rs;
	}
	
	
	
}
