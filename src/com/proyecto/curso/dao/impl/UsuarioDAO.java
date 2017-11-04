package com.proyecto.curso.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;


public class UsuarioDAO{
	private final class SpInsertarUsuario extends StoredProcedure{
		private  SpInsertarUsuario(DataSource dataSource){
			super(dataSource, "PCK_USUARIO.Insertar_Usuario");
			
			declareParameter(new SqlParameter("p_usuario", Types.VARCHAR));
			declareParameter(new SqlParameter("p_nombre", Types.VARCHAR));
			declareParameter(new SqlParameter("p_paterno", Types.VARCHAR));
			declareParameter(new SqlParameter("p_materno", Types.VARCHAR));
			declareParameter(new SqlParameter("p_rfc", Types.VARCHAR));
			declareParameter(new SqlParameter("p_fecha_nacimiento", Types.DATE));
			declareParameter(new SqlParameter("p_correo", Types.VARCHAR));
			declareParameter(new SqlParameter("p_colonia", Types.VARCHAR));
			declareParameter(new SqlParameter("p_calle", Types.VARCHAR));
			declareParameter(new SqlParameter("p_codigo_postal", Types.VARCHAR));
			declareParameter(new SqlParameter("p_municipio", Types.INTEGER));
			declareParameter(new SqlParameter("p_estatus", Types.VARCHAR));
		}
	}
}
