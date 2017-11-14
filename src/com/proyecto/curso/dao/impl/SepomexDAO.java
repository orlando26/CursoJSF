package com.proyecto.curso.dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import com.proyecto.curso.dao.ISepomexDAO;
import com.proyecto.curso.dao.mapper.EstadoRM;
import com.proyecto.curso.dao.mapper.MunicipioRM;
import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;

import oracle.jdbc.internal.OracleTypes;

@Repository
public class SepomexDAO implements ISepomexDAO{

	@Autowired
	private DataSource dataSource;

	@Override
	public Collection<Estado> obtenerEstados(Estado objEstado) {
		// TODO Auto-generated method stub
		SpConEstado objSpConEstado = new SpConEstado(dataSource);
		return objSpConEstado.ejecutar(objEstado);
	}

	@Override
	public Collection<Municipio> obtenerMunicipios(Municipio objMunicipio) {
		// TODO Auto-generated method stub
		SpConMunicipio objSpConMunicipio = new SpConMunicipio(dataSource);
		return objSpConMunicipio.ejecutar(objMunicipio);
	}

	/*******StoreProcedures******/

	private final class SpConEstado extends StoredProcedure {
		private SpConEstado(DataSource dataSource) {
			super(dataSource, "PCK_SEPOMEX.Obtener_Estados");

			EstadoRM rowMapper = new EstadoRM();

			declareParameter(new SqlParameter("p_id_estado", Types.INTEGER));
			declareParameter(new SqlOutParameter("p_out_cur_resultado", OracleTypes.CURSOR, rowMapper));

			compile();
		}   


		@SuppressWarnings("unchecked")
		public Collection<Estado> ejecutar(Estado objEstado) {
			Map<String, Object> parameters = new HashMap<String, Object>();   
			parameters.put("p_id_estado", objEstado.getIntId());

			Map<String,Object> resultado = execute(parameters);

			Collection<Estado> lstEstado = resultado.containsKey("p_out_cur_resultado") 
					? (Collection<Estado>)resultado.get("p_out_cur_resultado") : new ArrayList<Estado>();

					return lstEstado;
		}
	}
	
	private final class SpConMunicipio extends StoredProcedure {
        private SpConMunicipio(DataSource dataSource) {
            super(dataSource, "PCK_SEPOMEX.Obtener_Municipios");

            MunicipioRM rowMapper = new MunicipioRM();
                        
            declareParameter(new SqlParameter("p_id_estado", Types.INTEGER));
            declareParameter(new SqlOutParameter("p_out_cur_resultado", OracleTypes.CURSOR, rowMapper));
            
            compile();
        }   
        
        
		@SuppressWarnings("unchecked")
		public Collection<Municipio> ejecutar(Municipio objMunicipio) {
            Map<String, Object> parameters = new HashMap<String, Object>(); 
            
            parameters.put("p_id_estado", objMunicipio.getObjEstado().getIntId());

            Map<String,Object> resultado = execute(parameters);
            
            Collection<Municipio> lstMunicipio = resultado.containsKey("p_out_cur_resultado") 
            		? (Collection<Municipio>)resultado.get("p_out_cur_resultado") : new ArrayList<Municipio>();
            
            return lstMunicipio;
        }
    }


}
