package com.proyecto.curso.enums;

import java.util.HashMap;
import java.util.Map;

public enum RespuestaENUM {
	
	EXITO(1,"Exito"),
    ERROR(0,"Error");   
	
    private int intIdCodigo;
    private String strDescripcion;
    
    RespuestaENUM(int intIdCodigo, String strDescripcion) {
		this.intIdCodigo = intIdCodigo;
		this.strDescripcion = strDescripcion;
	}
	
	private static Map<Integer, RespuestaENUM> map = new HashMap<Integer, RespuestaENUM>();

    static {
        for (RespuestaENUM enumCodigo : RespuestaENUM.values()) {
            map.put(enumCodigo.intIdCodigo, enumCodigo);
        }
    }
    
    public static RespuestaENUM getCodigo(int valorCodigo) {
        return map.get(valorCodigo);
    }
    
    public static int getIdCodigo(RespuestaENUM enumValorCodigo) {
        return map.get(enumValorCodigo).getIdCodigo();
    }

	public int getIdCodigo() {
		return intIdCodigo;
	}

	public String getDescripcion() {
		return strDescripcion;
	}

}