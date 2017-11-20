package com.proyecto.curso.dao.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.proyecto.curso.model.Usuario;

public class UsuarioRM implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet resultSet, int line) throws SQLException {
		/*-------- Inicia bloque de columnas --------*/
		
		//Obtener los nombres de las columnas que contiene el result set
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		
		//Obtiene el número de columnas de la consulta
		int intNumeroDeColumas = rsMetaData.getColumnCount();
		
		String[] columnasResultSet = new String[intNumeroDeColumas];
		
		for (int i = 1; i <= intNumeroDeColumas; i++) {
			String strNombreColumna = rsMetaData.getColumnName(i);
			
			columnasResultSet[i-1] = strNombreColumna;
		}
		
		List<String> lstColumnas = Arrays.asList(columnasResultSet);
		
		/*-------- Termina bloque de columnas --------*/
		
		Usuario objUsuario = new Usuario();
		
		if(lstColumnas.contains("ID")){
			objUsuario.setIntId(resultSet.getInt("ID"));
		}
		
		if(lstColumnas.contains("USUARIO")){
			objUsuario.setStrUsuario(resultSet.getString("USUARIO"));
		}
		
		if(lstColumnas.contains("NOMBRE")){
			objUsuario.setStrNombre(resultSet.getString("NOMBRE"));
		}
		
		if(lstColumnas.contains("PATERNO")){
			objUsuario.setStrPaterno(resultSet.getString("PATERNO"));
		}
		
		if(lstColumnas.contains("MATERNO")){
			objUsuario.setStrMaterno(resultSet.getString("MATERNO"));
		}
		
		//
		
		if(lstColumnas.contains("RFC")){
			objUsuario.setStrRfc(resultSet.getString("RFC"));
		}
		
		if(lstColumnas.contains("FECHA_NACIMIENTO")){
			objUsuario.setDatFechaNacimiento(resultSet.getDate("FECHA_NACIMIENTO"));
		}
		
		if(lstColumnas.contains("CORREO")){
			objUsuario.setStrCorreo(resultSet.getString("CORREO"));
		}
		
		if(lstColumnas.contains("ID_ESTADO")){
			objUsuario.getObjMunicipio().getObjEstado().setIntId(resultSet.getInt("ID_ESTADO"));
		}
		
		if(lstColumnas.contains("ID_MUNICIPIO")){
			objUsuario.getObjMunicipio().setIntId(resultSet.getInt("ID_MUNICIPIO"));
		}
		
		//
		
		if(lstColumnas.contains("ID_ESTATUS")){
			objUsuario.getObjEstatus().setIntId(resultSet.getInt("ID_ESTATUS"));
		}
		
		if(lstColumnas.contains("ESTATUS_DESCRIPCION")){
			objUsuario.getObjEstatus().setStrDescripcion(resultSet.getString("ESTATUS_DESCRIPCION"));
		}
		
		if(lstColumnas.contains("CALLE")){
			objUsuario.setStrCalle(resultSet.getString("CALLE"));
		}
		
		if(lstColumnas.contains("CODIGO_POSTAL")){
			objUsuario.setStrCodigoPostal(resultSet.getString("CODIGO_POSTAL"));
		}
		
		if(lstColumnas.contains("FECHA_MODIFICACION")){
			objUsuario.setDatFechaModificacion(resultSet.getDate("FECHA_MODIFICACION"));
		}
		
		return objUsuario;
	}

}