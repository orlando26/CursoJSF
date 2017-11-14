package com.proyecto.curso.dao;

import java.util.Collection;
import java.util.Date;

import com.proyecto.curso.model.Respuesta;
import com.proyecto.curso.model.Usuario;

public interface IUsuarioDAO {
	
	public Collection<Usuario> obtenerUsuarios(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal, int intTipoConsulta);
	
	public Respuesta guardarUsuario(Usuario objUsuario);
	
	public Respuesta editarUsuario(Usuario objUsuario);
	
}
