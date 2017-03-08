package com.Defenders.Entidades;

import com.Defenders.Entidades.Armas.Arma;
import com.Defenders.Entidades.Entidad.TipoEntidad;

public abstract class EntidadDinamica extends Entidad{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8711557094846423221L;
	
	protected float rx,ry,rz;
	private Direccion mydireccion;
	protected float MAX_VELOCITY=3.0f; //pixeles por frame
	protected float velocidadActual=MAX_VELOCITY;
	
	
	//arma de la entidad en caso de que posea
	protected Arma arma;
	
	
	public EntidadDinamica(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public EntidadDinamica(float x, float y,float sx,float sy) {
		super(x, y,sx,sy);
		// TODO Auto-generated constructor stub
	}
	
	public EntidadDinamica(float x, float y,float z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}
	
	
	public Direccion getDireccion(){
		return this.mydireccion;
	}
	public void setDireccion(Direccion dir){
		this.mydireccion=dir;
	}

}
