package com.proyecto.curso.view.utileria;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	/**
	 * Gets the response object
	 * @return the response Object
	 */
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}
	
	/**
	 * Gets the request object
	 * @return the request Object
	 */
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	
	/**
	 * Performs a redirect to another page
	 * @param url
	 */
	public void redirect(String url){
		assert url != null;
		assert url.startsWith("/");
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.responseComplete();
		HttpServletResponse response = getResponse();
		try{
			response.sendRedirect(response.encodeRedirectURL(getRequest().getContextPath() + url));
			System.out.println("redirecting");
		}catch(IOException e){
			throw new RuntimeException(e);
		}	
	}


}
