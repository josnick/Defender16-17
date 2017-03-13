package com.Defenders.Entidades.Jugador;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.Defenders.AssetsManager;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.EntidadDinamica;


public class Jugador extends EntidadDinamica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007295518902850440L;
	private BufferedImage[] spritesJugador;
	private BufferedImage spriteDireccion;

	public Jugador(float x, float y) {
		super(x, y);
		faccionEntidad = Faccion.ALIADO;
		tipoEntidad = TipoEntidad.SPRITE;
		direccionEntidad = Direccion.NONE;
		this.spritesJugador = AssetsManager.spritesJugador;
		this.spriteDireccion = spritesJugador[0];
		this.componentes.add(new LlamaMotor(this));

		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
		if (direccionEntidad == Direccion.RG){
			this.spriteDireccion = spritesJugador[0];
		
		}
		else if (direccionEntidad == Direccion.LF){
			this.spriteDireccion = spritesJugador[1];
			
		}
		g2d.drawImage(this.spriteDireccion, (int) x, (int) y, this);
		for(Entidad e:componentes)
			e.dibujar(g2d);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

}
