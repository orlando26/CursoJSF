package com.proyecto.curso.dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.proyecto.curso.dao.IUsuarioDAO;
import com.proyecto.curso.dao.mapper.UsuarioRM;
import com.proyecto.curso.model.Respuesta;
import com.proyecto.curso.model.Usuario;

import oracle.jdbc.internal.OracleTypes;


public class UsuarioDAO implements IUsuarioDAO{
	
	private DataSource ds;
	
	@Override
	public Collection<Usuario> obtenerUsuarios(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal, int intTipoConsulta){
		SpConUsuario obj = new SpConUsuario(ds);
		Collection<Usuario> lst = obj.ejecutar(objUsuario, datFechaInicial, datFechaFinal, intTipoConsulta);
		return lst;
	}
	
	@Override
	public Respuesta guardarUsuario(Usuario objUsuario){
		SpInsertarUsuario obj = new SpInsertarUsuario(ds);
		Respuesta objRespuesta = obj.ejecutar(objUsuario);
		return objRespuesta;
	}
	
	@Override
	public Respuesta editarUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		SpActualizaUsuario obj = new SpActualizaUsuario(ds);
		Respuesta objRespuesta = obj.ejecutar(objUsuario);
		return objRespuesta;
	}
	
	
	//Stored procedures
	/**Stored Procedure Insertar Usuario */
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
			declareParameter(new SqlParameter("p_password", Types.VARCHAR));
			
			declareParameter(new SqlParameter("p_out_idusuario", Types.VARCHAR));
			declareParameter(new SqlParameter("p_out_codigo", Types.VARCHAR));
			declareParameter(new SqlParameter("p_out_mensaje", Types.VARCHAR));
			
			compile();
		}
		
		public Respuesta ejecutar(Usuario objUsuario){
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("p_usuario", objUsuario.getStrUsuario());
			parameters.put("p_nombre", objUsuario.getStrNombre());
			parameters.put("p_materno", objUsuario.getStrMaterno());
			parameters.put("p_paterno", objUsuario.getStrPaterno());
			parameters.put("p_rfc", objUsuario.getStrRfc());
			parameters.put("p_fecha_nacimiento", objUsuario.getDatFechaNacimiento());
			parameters.put("p_correo", objUsuario.getStrCorreo());
			parameters.put("p_calle", objUsuario.getStrCalle());
			parameters.put("p_codigo_postal", objUsuario.getStrCodigoPostal());
			parameters.put("p_municipio", objUsuario.getObjMunicipio().getIntId());
			parameters.put("p_password", objUsuario.getStrPassword());
			
			Map<String, Object> resultado = execute(parameters);
			
			int intIdUsuario = (int)(resultado.containsKey("p_out_idusuario")? resultado.get("p_out_idusuario") : 0);
			objUsuario.setIntId(intIdUsuario);
			
			int intCodigo = (int)(resultado.containsKey("p_out_codigo")? resultado.get("p_out_codigo") : 0);
			String strMensaje = (String)(resultado.containsKey("p_out_mensaje")? resultado.get("p_out_mensaje") : "");
			
			Respuesta respuesta = new Respuesta();
			respuesta.setIntId(intCodigo);
			respuesta.setStrMensaje(strMensaje);
			
			return respuesta;
		}
	}
	
	/**Stored Procedure Actualizar Usuario */
	private final class SpActualizaUsuario extends StoredProcedure{
		private  SpActualizaUsuario(DataSource dataSource){
			super(dataSource, "PCK_USUARIO.Actualiza_Usuario");
			
			declareParameter(new SqlParameter("p_id_usuario", Types.BIGINT));
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
			declareParameter(new SqlParameter("p_id_estatus", Types.INTEGER));
			declareParameter(new SqlParameter("p_password", Types.VARCHAR));
			
			declareParameter(new SqlParameter("p_out_codigo", Types.VARCHAR));
			declareParameter(new SqlParameter("p_out_mensaje", Types.VARCHAR));
			
			compile();
		}
		
		public Respuesta ejecutar(Usuario objUsuario){
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("p_id_usuario", objUsuario.getIntId());
			parameters.put("p_usuario", objUsuario.getStrUsuario());
			parameters.put("p_nombre", objUsuario.getStrNombre());
			parameters.put("p_materno", objUsuario.getStrMaterno());
			parameters.put("p_paterno", objUsuario.getStrPaterno());
			parameters.put("p_rfc", objUsuario.getStrRfc());
			parameters.put("p_fecha_nacimiento", objUsuario.getDatFechaNacimiento());
			parameters.put("p_correo", objUsuario.getStrCorreo());
			parameters.put("p_calle", objUsuario.getStrCalle());
			parameters.put("p_codigo_postal", objUsuario.getStrCodigoPostal());
			parameters.put("p_municipio", objUsuario.getObjMunicipio().getIntId());
			parameters.put("p_id_estatus", objUsuario.getObjEstatus());
			parameters.put("p_password", objUsuario.getStrPassword());
			
			Map<String, Object> resultado = execute(parameters);
			
			
			int intCodigo = (int)(resultado.containsKey("p_out_codigo")? resultado.get("p_out_codigo") : 0);
			String strMensaje = (String)(resultado.containsKey("p_out_mensaje")? resultado.get("p_out_mensaje") : "");
			
			Respuesta respuesta = new Respuesta();
			respuesta.setIntId(intCodigo);
			respuesta.setStrMensaje(strMensaje);
			
			return respuesta;
		}
	}
	
	/**Stored Procedure Consultar Usuario */
	private final class SpConUsuario extends StoredProcedure{
		private SpConUsuario(DataSource ds){
			super(ds, "PCK_USUARIO.Obtener_Usuarios");
			
			UsuarioRM rowMapper = new UsuarioRM();
			
			declareParameter(new SqlParameter("p_id_usuario", Types.BIGINT));
			declareParameter(new SqlParameter("p_usuario", Types.VARCHAR));
			declareParameter(new SqlParameter("p_nombre", Types.VARCHAR));
			declareParameter(new SqlParameter("p_paterno", Types.VARCHAR));
			declareParameter(new SqlParameter("p_materno", Types.VARCHAR));
			declareParameter(new SqlParameter("p_rfc", Types.VARCHAR));
			declareParameter(new SqlParameter("p_correo", Types.VARCHAR));
			
			declareParameter(new SqlParameter("p_id_municipio", Types.INTEGER));
			declareParameter(new SqlParameter("p_id_estado", Types.INTEGER));
			declareParameter(new SqlParameter("p_id_estatus", Types.VARCHAR));
			
			declareParameter(new SqlParameter("p_fecha_inicial", Types.DATE));
			declareParameter(new SqlParameter("p_fecha_final", Types.DATE));
			
			declareParameter(new SqlParameter("p_id_tipo", Types.INTEGER));
			
			declareParameter(new SqlOutParameter("p_out_cur_resultado", OracleTypes.CURSOR, rowMapper));
			
			compile();
		}
		
		@SuppressWarnings("unchecked")
		public Collection<Usuario> ejecutar(Usuario objUsuario, Date datFechaInicial, Date datFechaFinal, int intTipoConsulta){
			
			Map<String, Object> parameters = new HashMap<>();
			
			parameters.put("p_id_usuario", objUsuario.getIntId());
			parameters.put("p_usuario", objUsuario.getStrUsuario());
			parameters.put("p_nombre", objUsuario.getStrNombre());
			parameters.put("p_materno", objUsuario.getStrMaterno());
			parameters.put("p_paterno", objUsuario.getStrPaterno());
			parameters.put("p_rfc", objUsuario.getStrRfc());
			parameters.put("p_id_estado", objUsuario.getObjMunicipio().getObjEstado().getIntId());
			parameters.put("p_correo", objUsuario.getStrCorreo());
			parameters.put("p_id_estatus", objUsuario.getObjEstatus());
			parameters.put("p_id_municipio", objUsuario.getObjMunicipio().getIntId());
			parameters.put("p_fecha_inicial", datFechaInicial);
			parameters.put("p_fecha_final", datFechaFinal);
			parameters.put("p_id_tipo", intTipoConsulta);
			
			Map<String, Object> resultado = execute(parameters);
			
			
			Collection<Usuario> lstUsuarios = resultado.containsKey("p_out_cur_resultado")? (Collection<Usuario>)resultado.get("p_out_cur_resultado"): new ArrayList<Usuario>();
			
			return lstUsuarios;																		
			
		}
	}


	
	
}
