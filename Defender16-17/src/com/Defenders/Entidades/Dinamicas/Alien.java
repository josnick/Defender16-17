package com.Defenders.Entidades.Dinamicas;

import java.awt.Graphics2D;


import java.awt.image.BufferedImage;
import java.util.Random;

import com.Defenders.AssetsManager;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.EntidadDinamica;
import com.Defenders.Entidades.Armas.ArmaAlien;
import com.test.GameEngineTest.Game;
import com.test.GameEngineTest.Pantallas.ScreenManager;

public class Alien extends EntidadDinamica {

	/**
	 * 
	 */
	private BufferedImage[] spritesJugador;
	private int frameActual;
	private static final long serialVersionUID = -7973137117508923127L;
	private Random r;

	public Alien(float x, float y) {
		super(x, y);
		this.r = new Random();
		this.spritesJugador = AssetsManager.spritesAlien;
		this.sx = this.spritesJugador[0].getWidth();
		this.sy = this.spritesJugador[0].getHeight();

		tipoEntidad=TipoEntidad.SPRITE;
		faccionEntidad = Faccion.ENEMIGO;
		direccionEntidad = Direccion.values()[r.nextInt(Direccion.values().length - 1) + 1];
		identificadorEntidad=IdentificadorEntidad.ALIEN;
		// direccionEntidad = Direccion.NONE;

		this.frameActual = 0;
		aceleracion = 0f;
		velocidadActual = 2f;

		this.framesActualizar = (r.nextInt(19) + 1) * 10;
		this.framesAtuales = this.framesActualizar;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(this.spritesJugador[frameActual], (int) x, (int) y, this);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		/**
		 * Eleccion de una posicion si choca
		 */
		if (getXPos() >= Game.SCREEN_WIDHT) {
			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.DWLF;
				break;
			case 1:
				direccionEntidad = Direccion.LF;
				break;
			case 2:
				direccionEntidad = Direccion.UPLF;
				break;
			}
		} else if (getXPos() <= 10) {
			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.DWRG;
				break;
			case 1:
				direccionEntidad = Direccion.RG;
				break;
			case 2:
				direccionEntidad = Direccion.UPRG;
				break;
			}
		}

		if (getYPos() >= Game.SCREEN_HEIGHT-32) {
			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.UP;
				break;
			case 1:
				direccionEntidad = Direccion.UPLF;
				break;
			case 2:
				direccionEntidad = Direccion.UPRG;
				break;
			}
		} else if (getYPos() <= 10) {
			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.DW;
				break;
			case 1:
				direccionEntidad = Direccion.DWRG;
				break;
			case 2:
				direccionEntidad = Direccion.DWLF;
				break;
			}
		}

		actualizarPosicion(direccionEntidad);
		if (framesAtuales % 10 == 0) {
			frameActual = (frameActual + 1) % this.spritesJugador.length;
			//dispara y genera un tiempo aleatorio hasta el siguiente disparo
			if (framesAtuales == 0) {
				disparar();
				framesAtuales = (r.nextInt(19) + 1) * 10;
			}
		}		
		framesAtuales--;
	}
	
	@Override
	public void disparar(){
		ScreenManager.getInstance().getPantallaActual().añadirEntidad(new ArmaAlien(this));
	}

	@Override
	public void destruirEntidad(Entidad e) {
		// TODO Auto-generated method stub
		ScreenManager.getInstance().getPantallaActual().borrarEntidad(this);
	}

	@Override
	public void iniciarEntidad() {
		// TODO Auto-generated method stub
		
	}

}
