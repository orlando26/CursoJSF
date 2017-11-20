package com.proyecto.curso.service.impl;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.curso.dao.IUsuarioDAO;
import com.proyecto.curso.model.Respuesta;
import com.proyecto.curso.model.Usuario;
import com.proyecto.curso.service.IUsuarioBS;

@Service
public class UsuarioBS implements IUsuarioBS{
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	private static final int CONSULTA_SIMPLE = 1;
	private static final int CONSULTA_DETALLADA = 2;	

	@Override
	public Collection<Usuario> obtenerUsuarios(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal) {		
		return usuarioDAO.obtenerUsuarios(objUsuario, datFechaInicial, datFechaFinal, CONSULTA_SIMPLE);
	}

	@Override
	public Collection<Usuario> obtenerUsuariosDetalles(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal) {		
		return usuarioDAO.obtenerUsuarios(objUsuario, datFechaInicial, datFechaFinal, CONSULTA_DETALLADA);
	}

	@Override
	public Usuario obtenerUsuarioDetalle(int intIdUsuario) {
		
		Collection<Usuario> lst = usuarioDAO.obtenerUsuarios(new Usuario(intIdUsuario), null, null, 2);
		Usuario objUsuario = lst.iterator().next();
		
		return objUsuario;
	}

	@Override
	public Respuesta insertUsuario(Usuario objUsuario) {
		
		return usuarioDAO.guardarUsuario(objUsuario);
	}

	@Override
	public Respuesta actualizaRespuesta(Usuario objUsuario) {
		
		return usuarioDAO.editarUsuario(objUsuario);
	}
	

}