package com.developer.joseph.idat.example.webServiceII.dto;

public class WomenAndUbicationsDTO {

	private String nombrecompleto;
	private int edad;
	private String ubication;
	

	public WomenAndUbicationsDTO(String nombrecompleto, int edad, String ubication) {
		super();
		this.nombrecompleto = nombrecompleto;
		this.edad = edad;
		this.ubication = ubication;
	}
	
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getUbication() {
		return ubication;
	}
	public void setUbication(String ubication) {
		this.ubication = ubication;
	}
	
	
}
