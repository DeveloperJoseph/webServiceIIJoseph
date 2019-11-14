package com.developer.joseph.idat.example.webServiceII.models;


import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Informacion sobre la clase mujeres")
public class Women {

	private Integer idWomen,ubicationID;
	private Integer edad; private LocalDateTime registerWomen;
	private String nameWomen, lastNameWomen,companyName;
	
    public Women() {}
    
    public  Women(Integer idWomen, String nameWomen,
    		String lastNameWomen,Integer edad,Integer ubicationID, String companyName)
    {
    	super();
    	this.idWomen = idWomen;
    	this.nameWomen = nameWomen;
    	this.lastNameWomen = lastNameWomen;
    	this.edad = edad;
    	this.ubicationID = ubicationID;
    	this.companyName = companyName;
    	registerWomen = LocalDateTime.now();
    	
    }

    
    @ApiModelProperty(position=1)
	public Integer getIdWomen() {
		return idWomen;
	}

	public void setIdWomen(Integer idWomen) {
		this.idWomen = idWomen;
	}
	

	@ApiModelProperty(position=2)
	public String getNameWomen() {
		return nameWomen;
	}

	public void setNameWomen(String nameWomen) {
		this.nameWomen = nameWomen;
	}

	
	@ApiModelProperty(position=3)
	public String getLastNameWomen() {
		return lastNameWomen;
	}

	public void setLastNameWomen(String lastNameWomen) {
		this.lastNameWomen = lastNameWomen;
	}

	
	@ApiModelProperty(position=4)
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	
	@ApiModelProperty(position=5)
	public Integer getUbicationID() {
		return ubicationID;
	}

	public void setUbicationID(Integer ubicationID) {
		this.ubicationID = ubicationID;
	}

	@ApiModelProperty(position=6)
	public LocalDateTime getRegisterWomen() {
		return registerWomen;
	}

	public String getCompanyName() {
		return companyName;
	}

	@ApiModelProperty(position=7)
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setRegisterWomen(LocalDateTime registerWomen) {
		this.registerWomen = registerWomen;
	}


    
    
}
