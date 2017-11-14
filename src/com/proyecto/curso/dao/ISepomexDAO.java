package com.proyecto.curso.dao;

import java.util.Collection;

import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;

public interface ISepomexDAO {
	
	public Collection<Estado> obtenerEstados(Estado objEstado);
	
	public Collection<Municipio> obtenerMunicipios(Municipio objMunicipio);
}
