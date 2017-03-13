package com.Defenders.Entidades;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public abstract class Entidad extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7311007324247891976L;
	protected float x, y, z;
	protected float sx, sy, sz;
	protected List<Entidad> componentes;

	public enum Direccion {
		NONE, UP, DW, RG, LF, UPRG, UPLF, DWRG, DWLF
	};

	public enum TipoEntidad {
		CONSUMIBLE, SPRITE, ARMA
	};

	public enum Faccion {
		NONE, ALIADO, ENEMIGO
	};

	protected Direccion direccionEntidad;
	protected Faccion faccionEntidad;
	protected TipoEntidad tipoEntidad;

	/**
	 * Constructor que inicializa una entidad en un espacion 2d
	 */
	public Entidad(float x, float y) {
		this(x, y, 0.0f, 0.0f, 0.0f, 0.0f);
	}

	/**
	 * 
	 * Constructor que inicializa una entidad en un espacio 3d
	 */
	public Entidad(float x, float y, float z) {
		this(x, y, z, 0.0f, 0.0f, 0.0f);
	}

	/**
	 * Constructor que inicializa una entidad en un espacion 2d
	 */
	public Entidad(float x, float y, float sx, float sy) {
		this(x, y, 0.0f, sx, sy, 0.0f);
	}

	/**
	 * 
	 * Constructor que inicializa una entidad en un espacio 3d
	 */
	public Entidad(float x, float y, float z, float sx, float sy, float sz) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.sx = sx;
		this.sy = sy;
		this.sz = sz;
		this.componentes=new ArrayList<>();
	}
	

	public float getXPos() {
		return this.x;
	}

	public float getYPos() {
		return this.y;
	}

	public float getZPos() {
		return this.z;
	}

	public float getXSize() {
		return this.sx;
	}

	public float getYSize() {
		return this.sy;
	}

	public float getZSize() {
		return this.sz;
	}
	
	
	public void setXPos(float x) {
		this.x = x;
	}
	public void setYPos(float y) {
		this.y = y;
	}

	public TipoEntidad getTipoEntidad() {
		return this.tipoEntidad;
	}

	public Faccion getFaccionEntidad() {
		return this.faccionEntidad;
	}
	
	public Direccion getDireccionEntidad() {
		return this.direccionEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	
	public List<Entidad> getComponentes() {
		return this.componentes;
	}

	/**
	 * Metodo que devuelve true si la entidad actual esta colisionando con otra
	 * entidad
	 */
	public boolean estaColisionando(Entidad e) {
		return x < e.x + e.sx && x + sx > e.x && y < e.y + e.sy && y + sy > e.y;
	}

	// actualiza la posicion de una entidad
	public abstract void actualizar();
	// dibuja una entidad
	public abstract void dibujar(Graphics2D g);
	//actualizar posicion entidad
	public abstract void actualizarPosicion(Direccion d);

}
