package com.proyecto.curso.model;

import java.util.Date;

public class Usuario {
	
	private int intId;
	private String strUsuario;
	private String strNombre;
	private String strPaterno;
	private String strMaterno;
	
	private String strRfc;
	private Date datFechaNacimiento;
	private String strCorreo;
	private String strColonia;
	private String strCalle;
	private String strCodigoPostal;
	private String strPassword;
	private Municipio objMunicipio;
	private Estatus objEstatus;
	private Date datFechaModificacion;
	
	public Usuario(int intId) {
		super();
		this.intId = intId;
		this.strUsuario = "";
		this.strNombre = "";
		this.strPaterno = "";
		this.strMaterno = "";
		this.strRfc = "";
		this.strPassword = "";
		this.datFechaNacimiento = null;
		this.strCorreo = "";
		this.strColonia = "";
		this.strCalle = "";
		this.strCodigoPostal = "";
		this.objMunicipio = new Municipio();
		this.objEstatus = new Estatus();
		this.datFechaModificacion = null;
	}
	
	public Usuario() {
		super();
		this.intId = 0;
		this.strUsuario = "";
		this.strNombre = "";
		this.strPaterno = "";
		this.strMaterno = "";
		this.strRfc = "";
		this.strPassword = "";
		this.datFechaNacimiento = null;
		this.strCorreo = "";
		this.strColonia = "";
		this.strCalle = "";
		this.strCodigoPostal = "";
		this.objMunicipio = new Municipio();
		this.objEstatus = new Estatus();
		this.datFechaModificacion = null;
	}
	
	public Usuario(int intId, String strUsuario, String strNombre,
			String strPaterno, String strMaterno, String strRfc,
			Date datFechaNacimiento, String strCorreo, String strColonia,
			String strCalle, String strCodigoPostal, Municipio objMunicipio,
			Estatus objEstatus, Date datFechaModificacion, String strPassword) {
		super();
		this.intId = intId;
		this.strUsuario = strUsuario;
		this.strNombre = strNombre;
		this.strPaterno = strPaterno;
		this.strMaterno = strMaterno;
		this.strRfc = strRfc;
		this.datFechaNacimiento = datFechaNacimiento;
		this.strCorreo = strCorreo;
		this.strColonia = strColonia;
		this.strCalle = strCalle;
		this.strCodigoPostal = strCodigoPostal;
		this.objMunicipio = objMunicipio;
		this.objEstatus = objEstatus;
		this.datFechaModificacion = datFechaModificacion;
		this.strPassword = strPassword;
	}
	
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public String getStrUsuario() {
		return strUsuario;
	}
	public void setStrUsuario(String strUsuario) {
		this.strUsuario = strUsuario;
	}
	public String getStrNombre() {
		return strNombre;
	}
	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}
	public String getStrPaterno() {
		return strPaterno;
	}
	public void setStrPaterno(String strPaterno) {
		this.strPaterno = strPaterno;
	}
	public String getStrMaterno() {
		return strMaterno;
	}
	public void setStrMaterno(String strMaterno) {
		this.strMaterno = strMaterno;
	}
	public String getStrRfc() {
		return strRfc;
	}
	public void setStrRfc(String strRfc) {
		this.strRfc = strRfc;
	}
	public Date getDatFechaNacimiento() {
		return datFechaNacimiento;
	}
	public void setDatFechaNacimiento(Date datFechaNacimiento) {
		this.datFechaNacimiento = datFechaNacimiento;
	}
	public String getStrCorreo() {
		return strCorreo;
	}
	public void setStrCorreo(String strCorreo) {
		this.strCorreo = strCorreo;
	}
	public String getStrColonia() {
		return strColonia;
	}
	public void setStrColonia(String strColonia) {
		this.strColonia = strColonia;
	}
	public String getStrCalle() {
		return strCalle;
	}
	public void setStrCalle(String strCalle) {
		this.strCalle = strCalle;
	}
	public String getStrCodigoPostal() {
		return strCodigoPostal;
	}
	public void setStrCodigoPostal(String strCodigoPostal) {
		this.strCodigoPostal = strCodigoPostal;
	}
	public Municipio getObjMunicipio() {
		return objMunicipio;
	}
	public void setObjMunicipio(Municipio objMunicipio) {
		this.objMunicipio = objMunicipio;
	}
	public Estatus getObjEstatus() {
		return objEstatus;
	}
	public void setObjEstatus(Estatus objEstatus) {
		this.objEstatus = objEstatus;
	}
	public Date getDatFechaModificacion() {
		return datFechaModificacion;
	}
	public void setDatFechaModificacion(Date datFechaModificacion) {
		this.datFechaModificacion = datFechaModificacion;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	
	

}