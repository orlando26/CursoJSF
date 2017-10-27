package com.proyecto.curso.model;

public class Estatus {

	private int intId;
	private String strDescripcion;
	
	public Estatus() {
		super();
		this.intId = 0;
		this.strDescripcion = "";
	}
	
	public Estatus(int intId, String strDescripcion) {
		super();
		this.intId = intId;
		this.strDescripcion = strDescripcion;
	}
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public String getStrDescripcion() {
		return strDescripcion;
	}
	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}
	
	
	
}
