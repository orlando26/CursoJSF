package com.proyecto.curso.model;

public class Estado {
	
	private int intId;
	private String strDescripcion;
	
	public Estado() {
		super();
		this.intId = 0;
		this.strDescripcion = "";
	}
	
	public Estado(int intId, String strDescripcion) {
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
