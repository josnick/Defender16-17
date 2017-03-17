package com.Defenders.Entidades.Estaticas;

import java.awt.Graphics2D;

import com.Defenders.Entidades.Entidad;
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
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarPosicion(Direccion d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruirEntidad(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarEntidad() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}
