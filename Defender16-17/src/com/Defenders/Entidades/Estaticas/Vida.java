package com.Defenders.Entidades.Estaticas;

import java.awt.Graphics;

import com.Defenders.Entidades.EntidadEstatica;

/**
 * Clase que representa un objeto en el juego que da vida a quien lo toca
 * @author Portátil1
 *
 */
public class Vida extends EntidadEstatica{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3120564295548224087L;

	public Vida(float x, float y) {
		super(x, y);
		tipoEntidad=TipoEntidad.CONSUMIBLE;
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
