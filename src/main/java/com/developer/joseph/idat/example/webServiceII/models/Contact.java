package com.developer.joseph.idat.example.webServiceII.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact")
public class Contact { //first

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	
	@Size(min =2,max = 30,message = "The company name has as min character 2 and max 30")
	@Column(name = "companyName",nullable = false,length = 30)
	private String companyName;
	
	@Size(min = 2,max = 100,message = "Description has two characters as min & 100 chars as max")
	@Column(name = "description",nullable = false,length = 100)
	private String description;

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		String result = String.format("[#] Contact Register:\n "
				+ "- idContact: %s,\n"
				+ "- companyName: %s,\n"
				+ "- description: %s",
				idContact,companyName,description);
		return result;
	}
	
	
}
