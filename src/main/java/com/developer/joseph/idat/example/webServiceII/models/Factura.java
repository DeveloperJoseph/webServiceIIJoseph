package com.developer.joseph.idat.example.webServiceII.models;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información del objeto Factura")
public class Factura {

	private String numero; 
	private Double subtotal,impuesto,descuento, total;
	
	
	public Factura() {}
	
	public Factura(String numero,Double subtotal,
			Double descuento,Double impuesto) {
		super();
		this.numero = numero;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.impuesto = impuesto;
		total = (subtotal-descuento)+impuesto;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getTotal() {
		return total;
	}

	
	
	
	
	
	
}
