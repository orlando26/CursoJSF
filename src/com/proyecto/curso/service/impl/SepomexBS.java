package com.proyecto.curso.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.curso.dao.ISepomexDAO;
import com.proyecto.curso.model.Estado;
import com.proyecto.curso.model.Municipio;
import com.proyecto.curso.service.ISepomexBS;

@Service
public class SepomexBS implements ISepomexBS{
	

	@Autowired
	private ISepomexDAO sepomexDAO;

	
	@Override
	public Collection<Estado> obtenerEstados(Estado objEstado) {
		// TODO Auto-generated method stub
		return sepomexDAO.obtenerEstados(objEstado);
	}

	@Override
	public Collection<Municipio> obtenerMunicipios(Municipio objMunicipio) {
		// TODO Auto-generated method stub
		return sepomexDAO.obtenerMunicipios(objMunicipio);
	}

}
