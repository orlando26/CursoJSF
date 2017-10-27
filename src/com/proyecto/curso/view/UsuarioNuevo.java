package com.proyecto.curso.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import com.proyecto.curso.model.Usuario;
import com.proyecto.curso.view.utileria.GeneralView;

@ManagedBean
@ViewScoped
public class UsuarioNuevo extends GeneralView{
	private Usuario usuario;

	@PostConstruct
	public void init(){
		usuario = new Usuario();
	}
	
	public String btnGuardar() {
		System.out.println("Se presiono boton");
		String page = "/usuario/detalleUsuario.xhtml";
		mensajes("Se guardo exitosamente!", FacesMessage.SEVERITY_INFO);
		return page;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
