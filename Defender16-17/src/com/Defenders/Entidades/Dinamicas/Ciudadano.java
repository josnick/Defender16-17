package com.Defenders.Entidades.Dinamicas;

import java.awt.Graphics;

import com.Defenders.Entidades.EntidadDinamica;

public class Ciudadano extends EntidadDinamica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5179120436029007022L;

	/**
	 * Metodo constructor que inicializa un ciudadano en un espacio 2d
	 */
	public Ciudadano(float x, float y) {
		super(x, y);
		faccionEntidad=Faccion.ALIADO;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor que inicializa un ciudadano en un espacio 3d
	 */
	public Ciudadano(float x, float y, float z) {
		super(x, y, z);
		faccionEntidad=Faccion.ALIADO;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	

}
