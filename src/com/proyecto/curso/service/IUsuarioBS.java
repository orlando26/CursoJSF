package com.proyecto.curso.service;

import java.util.Collection;
import java.util.Date;

import com.proyecto.curso.model.Respuesta;
import com.proyecto.curso.model.Usuario;

public interface IUsuarioBS {
	
	
	public Collection<Usuario> obtenerUsuarios(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal);
	
	public Collection<Usuario> obtenerUsuariosDetalles(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal);
	
	public Usuario obtenerUsuarioDetalle(int intIdUsuario);

	public Respuesta insertUsuario(Usuario objUsuario);
	
	public Respuesta actualizaRespuesta(Usuario objUsuario);

}