package com.proyecto.curso.model;

public class Municipio {
	

	private int intId;
	private int intIdMunicipio;
	private Estado objEstado;	
	private String strDescripcion;
	
	public Municipio() {
		super();
		this.intId = 0;
		this.intIdMunicipio = 0;
		this.objEstado = new Estado();
		this.strDescripcion = "";
	}
	
	public Municipio(int intId, int intIdMunicipio, Estado objEstado,
			String strDescripcion) {
		super();
		this.intId = intId;
		this.intIdMunicipio = intIdMunicipio;
		this.objEstado = objEstado;
		this.strDescripcion = strDescripcion;
	}
	
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public int getIntIdMunicipio() {
		return intIdMunicipio;
	}
	public void setIntIdMunicipio(int intIdMunicipio) {
		this.intIdMunicipio = intIdMunicipio;
	}
	public Estado getObjEstado() {
		return objEstado;
	}
	public void setObjEstado(Estado objEstado) {
		this.objEstado = objEstado;
	}
	public String getStrDescripcion() {
		return strDescripcion;
	}
	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}
	
	

}
