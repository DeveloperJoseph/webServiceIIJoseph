package com.developer.joseph.idat.example.webServiceII.models;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Informacion sobre la clase ubicaciones")
public class Ubications {

	
	private Integer ubicationID;
	private String descriptionUbication;
	private LocalDateTime register;
	

	public Ubications(Integer ubicationID, String descriptionUbication) {
		super();
		this.ubicationID = ubicationID;
		this.descriptionUbication = descriptionUbication;
		register = LocalDateTime.now();
	}
	
	
	public Integer getUbicationID() {
		return ubicationID;
	}
	public void setUbicationID(Integer ubicationID) {
		this.ubicationID = ubicationID;
	}
	public String getDescriptionUbication() {
		return descriptionUbication;
	}
	public void setDescriptionUbication(String descriptionUbication) {
		this.descriptionUbication = descriptionUbication;
	}
	public LocalDateTime getRegister() {
		return register;
	}

	
}
