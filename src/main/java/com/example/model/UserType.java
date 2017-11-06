package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERTYPE")
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="usertype_id_seq_gen")
	@SequenceGenerator(name = "usertype_id_seq_gen", sequenceName = "usertype_id_seq", allocationSize = 1)
	@Column(name="USERTYPE_ID",unique = true, nullable = false,length = 20)
	private long userTypeId;
	
	@Column(name= "USER_TYPE",unique = true, nullable = false,length = 20)
	private String typeOfUser;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="userType") //mapped by says it is the inverse side of the relationship
	//@JsonIgnore
	private Set<User> users;

	//setters and getters
	public long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getTypeOfUser() {
		return typeOfUser.toUpperCase();
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser.toUpperCase();
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}	
}
