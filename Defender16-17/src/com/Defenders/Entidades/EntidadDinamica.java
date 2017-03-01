package com.Defenders.Entidades;

import com.Defenders.Entidades.Armas.Arma;

public class EntidadDinamica extends Entidad{
	
	
	public enum Direccion{NONE,UP,DW,RG,LF,UPRG,UPLF,DWRG,DWLF};
	public enum TipoEntidad{NONE,ALIADO,ENEMIGO};
	protected TipoEntidad tipoEntidad;
	protected Direccion direccionEntidad;
	protected float rx,ry,rz;
	private Direccion mydireccion;
	protected float MAX_VELOCITY=0.7f;
	protected float velocidadActual=0.0f;
	
	
	//arma de la entidad en caso de que posea
	protected Arma arma;
	
	
	public EntidadDinamica(float x, float y) {
		super(x, y);
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
