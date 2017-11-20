package com.proyecto.curso.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.proyecto.curso.enums.RespuestaENUM;
import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;
import com.proyecto.curso.model.Respuesta;
import com.proyecto.curso.model.Usuario;
import com.proyecto.curso.service.ISepomexBS;
import com.proyecto.curso.service.IUsuarioBS;
import com.proyecto.curso.view.utileria.GeneralView;

@ManagedBean
@ViewScoped
public class UsuarioDetalleView extends GeneralView implements Serializable{
	
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
	
	@ManagedProperty(value="#{usuarioBS}")
	private IUsuarioBS usuarioBS;
	
	@ManagedProperty(value="#{sepomexBS}")
	private ISepomexBS sepomexBS;
	
	@PostConstruct
	public void init(){
		
		int intIdUsuario = (int)obtenerFlash().get("usuarioSeleccionado"); 
		
		usuario = usuarioBS.obtenerUsuarioDetalle(intIdUsuario);
		
		lstEstado = sepomexBS.obtenerEstados(new Estado());
		
		lstMunicipio = sepomexBS.obtenerMunicipios(usuario.getObjMunicipio());
	}
	
	/** Metodos */
	public String btnModificar() {
		System.out.println("Se presiono boton");
		String strPagina = "";
		Respuesta objRespuesta = usuarioBS.actualizaRespuesta(usuario);
		
		if(objRespuesta.getIntId() == RespuestaENUM.EXITO.getIdCodigo()){
			mensajes(objRespuesta.getStrMensaje(), FacesMessage.SEVERITY_INFO);
			strPagina = "/usuario/detalleUsuario.xhtml";
		}else{
			mensajes(objRespuesta.getStrMensaje(), FacesMessage.SEVERITY_ERROR);
		}
		
		return strPagina;
	}
	
	public void ajaxLlenaComboMunicipio(){
		lstMunicipio = new ArrayList<>();
		if (usuario.getObjMunicipio().getObjEstado().getIntId() != 0){
			lstMunicipio = sepomexBS.obtenerMunicipios(usuario.getObjMunicipio());
		}
	}
	
	public String btnRegresar(){
		return "/usuario/busquedaUsuario.xhtml";
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

	public IUsuarioBS getUsuarioBS() {
		return usuarioBS;
	}

	public void setUsuarioBS(IUsuarioBS usuarioBS) {
		this.usuarioBS = usuarioBS;
	}

	public ISepomexBS getSepomexBS() {
		return sepomexBS;
	}

	public void setSepomexBS(ISepomexBS sepomexBS) {
		this.sepomexBS = sepomexBS;
	}
	
	
}
