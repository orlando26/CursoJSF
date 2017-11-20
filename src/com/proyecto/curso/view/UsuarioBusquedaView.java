package com.proyecto.curso.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;
import com.proyecto.curso.model.Usuario;
import com.proyecto.curso.service.ISepomexBS;
import com.proyecto.curso.service.IUsuarioBS;
import com.proyecto.curso.view.utileria.GeneralView;

@ManagedBean
@ViewScoped
public class UsuarioBusquedaView extends GeneralView implements Serializable{

	/**
	 * UsuarioNuevoView :D
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Usuario objUsuario;
	
	private Date datFechaInicial;
	
	private Date datFechaFinal;
	
	
	public Collection<Usuario> lstUsuario;
	
	public Collection<Estado> lstEstados;
	public Collection<Municipio> lstMunicipios;
	
	@ManagedProperty(value="#{usuarioBS}")
	private IUsuarioBS usuarioBS;
	
	@ManagedProperty(value="#{sepomexBS}")
	private ISepomexBS sepomexBS;
	
	/* Metodos */
	@PostConstruct
	public void init(){
		objUsuario = new Usuario();
		lstUsuario = new ArrayList<Usuario>();
		datFechaInicial = null;
		datFechaFinal = null;
		lstEstados = sepomexBS.obtenerEstados(new Estado());
		lstMunicipios = new ArrayList<Municipio>();
	}
	
	public void botonBuscar(){
		System.out.println("Buscar Usuario");
		lstUsuario = usuarioBS.obtenerUsuarios(objUsuario, datFechaInicial, datFechaFinal);
		System.out.println(lstUsuario.toString());
	}
	
	public void botonNuevo(){
		System.out.println("nuevo usuario");
		redirect("/usuario/nuevoUsuario.xhtml");
	}
	
	public String botonEditar(int intIdUsuario){
		
		obtenerFlash().put("usuarioSeleccionado", intIdUsuario);
		
		return "/detalleUsuario.xhtml";
	}
	
	public void ajaxLlenaComboMunicipio(){
		lstMunicipios = new ArrayList<>();
		if (objUsuario.getObjMunicipio().getObjEstado().getIntId() != 0){
			lstMunicipios = sepomexBS.obtenerMunicipios(objUsuario.getObjMunicipio());
		}
	}
	
	
	
	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public Date getDatFechaInicial() {
		return datFechaInicial;
	}

	public void setDatFechaInicial(Date datFechaInicial) {
		this.datFechaInicial = datFechaInicial;
	}

	public Date getDatFechaFinal() {
		return datFechaFinal;
	}

	public void setDatFechaFinal(Date datFechaFinal) {
		this.datFechaFinal = datFechaFinal;
	}

	public Collection<Usuario> getLstUsuario() {
		return lstUsuario;
	}

	public void setLstUsuario(Collection<Usuario> lstUsuario) {
		this.lstUsuario = lstUsuario;
	}

	public Collection<Estado> getLstEstados() {
		return lstEstados;
	}

	public void setLstEstados(Collection<Estado> lstEstados) {
		this.lstEstados = lstEstados;
	}

	public Collection<Municipio> getLstMunicipios() {
		return lstMunicipios;
	}

	public void setLstMunicipios(Collection<Municipio> lstMunicipios) {
		this.lstMunicipios = lstMunicipios;
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
