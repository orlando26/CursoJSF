package com.proyecto.curso.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proyecto.curso.model.Usuario;

public class UsuarioRM implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
