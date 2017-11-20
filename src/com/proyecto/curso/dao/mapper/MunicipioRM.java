package com.proyecto.curso.dao.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.proyecto.curso.model.Municipio;

public class MunicipioRM implements RowMapper<Municipio>{

	@Override
	public Municipio mapRow(ResultSet resultSet, int line) throws SQLException {
		
		//Obtener los nombres de las columnas que contiene el resultSet
        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        
        //Obtiene el numero de columnas de la consulta
        int numberOfColumns = rsMetaData.getColumnCount();
        
        String[] columnasResultSet = new String[numberOfColumns];
        
        //Obtiene los nombres de las columnas de la consulta
        for (int j = 1; j < numberOfColumns + 1; j++) {
            String columnName = rsMetaData.getColumnName(j);
            columnasResultSet[j-1] = columnName; 
        }
        
        List<String> listaColumnasResultSet = Arrays.asList(columnasResultSet);
        
        Municipio objMunicipio = new Municipio();
        
        if(listaColumnasResultSet.contains("ID"))
	      {
        	objMunicipio.setIntId(resultSet.getInt("ID"));
	      }
        
        if(listaColumnasResultSet.contains("ID_MUNICIPIO"))
	      {
        	objMunicipio.setIntIdMunicipio(resultSet.getInt("ID_MUNICIPIO"));
	      }
		 
		 if(listaColumnasResultSet.contains("DESCRIPCION"))
	      {
			 objMunicipio.setStrDescripcion(resultSet.getString("DESCRIPCION"));
	      }
		 
		 if(listaColumnasResultSet.contains("IDESTADO"))
	      {
			 objMunicipio.getObjEstado().setIntId(resultSet.getInt("IDESTADO"));
	      }
		 
		return objMunicipio;
	}

}