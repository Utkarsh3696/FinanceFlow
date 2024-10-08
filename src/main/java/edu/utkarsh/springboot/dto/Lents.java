package edu.utkarsh.springboot.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lent_name;
	private double rs;
	private LocalDate localDate;
	private String toUser;
	
	
	
	public String getLent_name() {
		return lent_name;
	}
	public void setLent_name(String lent_name) {
		this.lent_name = lent_name;
	}
	
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getRs() {
		return rs;
	}
	public void setRs(double rs) {
		this.rs = rs;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	
}
