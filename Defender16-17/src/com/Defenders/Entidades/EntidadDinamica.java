package com.Defenders.Entidades;

import com.Defenders.Entidades.Armas.Arma;
import com.Defenders.Entidades.Entidad.Direccion;
import com.test.colisionTest.FullScreen;

public abstract class EntidadDinamica extends Entidad{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8711557094846423221L;
	protected final float MAX_VELOCITY=10.0f; //pixeles por frame
	protected final float ACELERACION=0.5f; //pixeles por frame
	protected final float INI_VELOCIDAD=3.0f; //pixeles por frame
	
	
	protected float rx,ry,rz;
	private Direccion mydireccion;
	protected float velocidadActual=INI_VELOCIDAD;
	
	protected float aceleracion=1.0f; //pixeles por frame
	
	
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
	
	
	@Override
	public void actualizarPosicion(Direccion d) {
		//aceleracion
		if(direccionEntidad==d){
			if(velocidadActual<MAX_VELOCITY)
				velocidadActual+=aceleracion;
		}else {
			direccionEntidad=d;
			velocidadActual=INI_VELOCIDAD;
		}
		
		switch (direccionEntidad) {
		case DW:
			y += velocidadActual;
			break;
		case DWLF:
			y -= velocidadActual;
			x -= velocidadActual;
			break;
		case DWRG:
			y -= velocidadActual;
			x += velocidadActual;
			break;
		case LF:
			x -= velocidadActual;
			break;
		case NONE:
			break;
		case RG:
			x += velocidadActual;
			break;
		case UP:
			y -= velocidadActual;
			break;
		case UPLF:
			y += velocidadActual;
			x -= velocidadActual;
			break;
		case UPRG:
			y += velocidadActual;
			x += velocidadActual;
			break;
		default:
			break;

		}
	}

}
