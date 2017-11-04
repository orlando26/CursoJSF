package com.proyecto.curso.model;

public class Respuesta {
	
	private int intId;
	
	private String strMensaje;
	
	public Respuesta() {
		super();
		this.intId = 0;
		this.strMensaje = "";
	}
	
	public Respuesta(int intId, String strMensaje) {
		super();
		this.intId = intId;
		this.strMensaje = strMensaje;
	}

	
	public int getIntId() {
		return intId;
	}

	
	public void setIntId(int intId) {
		this.intId = intId;
	}

	public String getStrMensaje() {
		return strMensaje;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}
}
