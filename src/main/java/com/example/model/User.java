package com.example.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="user_id_seq_gen")
	@SequenceGenerator(name = "user_id_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
	@Column(name="ID",unique = true, nullable = false,length = 20)
	private long userId;
	
	@Column(name="USERNAME",length=15,nullable=false,unique=true)
	private String username;
	
	@Column(name="PASSWORD",length=15,nullable=false)
	private String password;
	
	@Column(name="CREATIONDATE",nullable=false)
	private Timestamp creationDate;
	
	@Column(name="ISACTIVE")
	private boolean isActive = true;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USERTYPE_ID",nullable=false)
	private UserType userType;


	//setters and getters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
	
}
