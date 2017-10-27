package com.proyecto.curso.view.utileria;

import java.io.Serializable;

public class ExpresionRegular implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strExpresion;
	private String strMensaje;
		
	public ExpresionRegular() {
		super();
		this.strExpresion = "";
		this.strMensaje = "";
	}
	
	public String getStrExpresion() {
		return strExpresion;
	}
	public void setStrExpresion(String strExpresion) {
		this.strExpresion = strExpresion;
	}
	public String getStrMensaje() {
		return strMensaje;
	}
	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

}
