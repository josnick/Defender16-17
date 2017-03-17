package com.Defenders.Entidades.Jugador;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.Defenders.AssetsManager;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.EntidadDinamica;
import com.Defenders.Entidades.Armas.BolaFuego;
import com.test.GameEngineTest.Game;
import com.test.GameEngineTest.Pantallas.ScreenManager;

public class Jugador extends EntidadDinamica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007295518902850440L;
	private BufferedImage[] spritesJugador;
	private BufferedImage spriteDireccion;

	public Jugador(float x, float y) {
		super(x, y);
		this.spritesJugador = AssetsManager.spritesJugador;
		this.sx = this.spritesJugador[0].getWidth();
		this.sy = this.spritesJugador[0].getHeight();
		faccionEntidad = Faccion.ALIADO;
		tipoEntidad = TipoEntidad.SPRITE;
		direccionEntidad = Direccion.NONE;
		identificadorEntidad = IdentificadorEntidad.JUGADOR;

		this.spriteDireccion = spritesJugador[0];
		this.componentes.add(new LlamaMotor(this));
		
		

		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub

		if (direccionEntidad == Direccion.RG) {
			this.spriteDireccion = spritesJugador[0];

		} else if (direccionEntidad == Direccion.LF) {
			this.spriteDireccion = spritesJugador[1];

		}
		g2d.drawImage(this.spriteDireccion, (int) x, (int) y, this);
		for (Entidad e : componentes)
			e.dibujar(g2d);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		if (Game.input.right.down) {
			actualizarPosicion(Direccion.RG);
		}
		if (Game.input.left.down) {
			actualizarPosicion(Direccion.LF);
		}
		if (Game.input.up.down) {
			actualizarPosicion(Direccion.UP);
		}
		if (Game.input.down.down) {
			actualizarPosicion(Direccion.DW);
		}
		if (Game.input.attack.presses == 1) {
			Game.input.attack.presses = 10;
			disparar();
		}

		for (Entidad e : componentes) {
			e.actualizar();
		}

	}

	@Override
	public void actualizarPosicion(Direccion d) {
		// TODO Auto-generated method stub
		super.actualizarPosicion(d);
		for (Entidad e : componentes) {
			e.actualizarPosicion(direccionEntidad);
		}
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		ScreenManager.getInstance().getPantallaActual().añadirEntidad(new BolaFuego(this));

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
