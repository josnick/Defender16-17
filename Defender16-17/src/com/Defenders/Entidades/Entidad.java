package com.Defenders.Entidades;


public abstract class Entidad {

	
	private float x,y,z;
	
	public enum TipoEntidad{NONE,CONSUMIBLE,ALIADO,ENEMIGO};
	protected TipoEntidad tipoEntidad;
	
	
	
	/**
	 * Constructor que inicializa una entidad en un espacion 2d
	 */
	public Entidad(float x,float y){
		this(x,y,0.0f);
	}
	
	/**
	 * 
	 * Constructor que inicializa una entidad en un espacio 3d
	 */
	public Entidad(float x,float y,float z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public float getX() {
		return this.x;
	}public float getY() {
		return this.y;
	}public float getZ() {
		return this.z;
	}
	
	/**
	 * Metodo que devuelve true si la entidad actual esta
	 * colisionando con otra entidad
	 */
	public boolean estaColisionando(Entidad e){
		return false;
	}
	
	
	
	//public abstract void dibujar();
	
}
