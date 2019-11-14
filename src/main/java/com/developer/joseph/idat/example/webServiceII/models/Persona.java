package com.developer.joseph.idat.example.webServiceII.models;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del objeto Persona")
public class Persona {

	private Integer idPersona;
	private String namePersona;
	private String lastNamePersona;
	
	
	public Persona(Integer idPersona,String namePersona, String lastNamePersona) {
		this.idPersona = idPersona; this.namePersona = namePersona; this.lastNamePersona = lastNamePersona;
	}
	
	@ApiModelProperty(position = 1,notes = "Persona ID, tipo datos, longitud")
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
	@ApiModelProperty(position = 2,notes = "Name Persona, tipo datos, longitud")
	@Size(min=2, max=5, message = "solo se permite 2 a 5 caracteres")
	public String getNamePersona() {
		return namePersona;
	}
	public void setNamePersona(String namePersona) {
		this.namePersona = namePersona;
	}
	
	@ApiModelProperty(position = 2,notes = "LastName Persona, tipo datos, longitud")
	public String getLastNamePersona() {
		return lastNamePersona;
	}
	public void setLastNamePersona(String lastNamePersona) {
		this.lastNamePersona = lastNamePersona;
	}
	
	
}
