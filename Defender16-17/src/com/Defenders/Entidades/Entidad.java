package com.Defenders.Entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JComponent;

import com.Defenders.Entidades.Entidad.Direccion;

public abstract class Entidad extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7311007324247891976L;
	protected float x, y, z;
	protected float sx, sy, sz;

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

	/**
	 * Metodo que devuelve true si la entidad actual esta colisionando con otra
	 * entidad
	 */
	public boolean estaColisionando(Entidad e) {
		return x < e.x + e.sx && x + sx > e.x && y < e.y + e.sy && y + sy > e.y;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		dibujar(g);

		Toolkit.getDefaultToolkit().sync();
	}

	// actualiza la posicion de una entidad
	public abstract void actualizar();

	// dibuja una entidad
	public abstract void dibujar(Graphics g);

}
