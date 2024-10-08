package edu.utkarsh.springboot.dto;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "spend")
public class Spend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String spendName;
	private double rs;
	private LocalDate date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpendName() {
		return spendName;
	}
	public void setSpendName(String spendName) {
		this.spendName = spendName;
	}
	public double getRs() {
		return rs;
	}
	public void setRs(double rs) {
		this.rs = rs;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
