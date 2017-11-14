package com.proyecto.curso.service;

import java.util.Collection;

import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;

public interface ISepomexBS {

	public Collection<Estado> obtenerEstados(Estado objEstado);

	public Collection<Municipio> obtenerMunicipios(Municipio objMunicipio);

}
