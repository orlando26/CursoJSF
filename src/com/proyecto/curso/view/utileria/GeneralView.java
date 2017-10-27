package com.proyecto.curso.view.utileria;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import com.proyecto.curso.model.Usuario;

public abstract class GeneralView {
	
	protected static final String USUARIO = "usuario" ;
	
	/**
	 * Obtiene el objeto Usuario de sesion
	 * @return
	 */
	public Usuario obtenerUsuario(){
				
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		
		Usuario objUsuario = (Usuario) sessionMap.get(USUARIO);
		
		return objUsuario;
		
	}
	
	/**
	 * Subir variable a session
	 * @param variable
	 * @param obj
	 */
	public void subirVariableSesion(String variable, Object obj){
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(variable, obj);
	}
	
	/**
	 * Obtiene el objeto flash del contexto de JSF.
	 * @return
	 */
	public Flash obtenerFlash(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(false);
		flash.setRedirect(false);
		
		return flash;
	}
	
	/**
	 * Muestra mensajes de error
	 * @param detalle
	 * @param severity
	 */
	public void mensajes(String detalle , Severity severity){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		facesContext.addMessage("mensaje", new FacesMessage(severity, detalle, ""));
	}


}
