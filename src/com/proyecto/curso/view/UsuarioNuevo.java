package com.proyecto.curso.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;
import com.proyecto.curso.model.Usuario;
import com.proyecto.curso.view.utileria.GeneralView;

@ManagedBean
@ViewScoped
public class UsuarioNuevo extends GeneralView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Datos del usuario
	private Usuario usuario;
	
	//Lista de estados para el combo estado
	private Collection<Estado> lstEstado;
	
	//Lista de municipios para el combo municipio
	private Collection<Municipio> lstMunicipio;

	@PostConstruct
	public void init(){
		usuario = new Usuario();
		lstEstado = new ArrayList<Estado>();
		lstMunicipio = new ArrayList<Municipio>();
	}
	
	/** Metodos */
	public String btnGuardar() {
		System.out.println("Se presiono boton");
		String page = "/usuario/detalleUsuario.xhtml";
		mensajes("Se guardo exitosamente!", FacesMessage.SEVERITY_INFO);
		return page;
	}
	
	public void ajaxLlenaComboMunicipio(){
		lstMunicipio = new ArrayList<>();
		if (usuario.getObjMunicipio().getObjEstado().getIntId() != 0){
			lstMunicipio = new ArrayList<Municipio>();
		}
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Estado> getLstEstado() {
		return lstEstado;
	}

	public void setLstEstado(Collection<Estado> lstEstado) {
		this.lstEstado = lstEstado;
	}

	public Collection<Municipio> getLstMunicipio() {
		return lstMunicipio;
	}

	public void setLstMunicipio(Collection<Municipio> lstMunicipio) {
		this.lstMunicipio = lstMunicipio;
	}
	
	
}
