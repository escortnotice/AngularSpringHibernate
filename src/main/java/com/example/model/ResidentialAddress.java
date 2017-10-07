package com.example.model;
/**
 * A one to one mapping with user table (Student.java)
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESIDENTIAL_ADDRESS")
public class ResidentialAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESIDENTIAL_ID",unique = true, nullable = false)
	private long residential_id;
	
	@Column(name="CITY",length=255)
	private String city;
	
	@Column(name="STATE",length=255)
	private String state;

	public long getResidential_id() {
		return residential_id;
	}

	public void setResidential_id(long residential_id) {
		this.residential_id = residential_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
