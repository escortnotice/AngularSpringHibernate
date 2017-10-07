package com.example.model;

/**
 * A one to one mapping example with Residential Address table(ResidentialAddress.java)
 */
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO) 
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_gen")
	//@SequenceGenerator(name = "user_id_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator="user_id_seq_gen")
	@SequenceGenerator(name = "user_id_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
	@Column(name="USER_ID",unique = true, nullable = false)
	private long userId;
	
	@Column(name="NAME",length=255)
	private String name;
	
	@Column(name="GENDER",length=255)
	private String gender;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="LOCATION_ID",nullable=false)
	private ResidentialAddress residentialAddress;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ResidentialAddress getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(ResidentialAddress residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	
	
}
