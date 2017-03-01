package com.Defenders.Entidades.Dinamicas;

import com.Defenders.Entidades.EntidadDinamica;

public class Ciudadano extends EntidadDinamica {

	/**
	 * Metodo constructor que inicializa un ciudadano en un espacio 2d
	 */
	public Ciudadano(float x, float y) {
		super(x, y);
		tipoEntidad = TipoEntidad.ALIADO;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor que inicializa un ciudadano en un espacio 3d
	 */
	public Ciudadano(float x, float y, float z) {
		super(x, y, z);
		super.tipoEntidad = TipoEntidad.ALIADO;
		// TODO Auto-generated constructor stub
	}

}
