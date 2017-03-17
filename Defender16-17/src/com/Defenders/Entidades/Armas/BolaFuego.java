package com.Defenders.Entidades.Armas;

import java.awt.Graphics2D;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.Defenders.AssetsManager;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.EntidadDinamica;
import com.test.GameEngineTest.Game;
import com.test.GameEngineTest.Pantallas.ScreenManager;

public class BolaFuego extends EntidadDinamica {

	/**
	 * 
	 */
	private Image image;
	private static final long serialVersionUID = 3322167242591595074L;

	public BolaFuego(Entidad e) {
		this(e.getXPos(), e.getYPos(), AssetsManager.imagenbolafuego);
		faccionEntidad = e.getFaccionEntidad();
		tipoEntidad = TipoEntidad.ARMA;
		direccionEntidad = e.getDireccionEntidad();
		velocidadActual = 15f;
		aceleracion=0f;
		// TODO Auto-generated constructor stub
	}

	private BolaFuego(float x, float y, ImageIcon img) {
		super(x + ((float) img.getIconWidth() / 2), y + ((float) img.getIconHeight() / 2), (float) img.getIconWidth(),
				(float) img.getIconHeight());
		this.image = img.getImage();
		this.sx=img.getIconWidth();
		this.sy=img.getIconHeight();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizar() {
		if (x >= Game.SCREEN_WIDHT || x <= 0 || y >= Game.SCREEN_HEIGHT || y <= 0) {
			ScreenManager.getInstance().getPantallaActual().borrarEntidad(this);
		}
		else{
			actualizarPosicion(direccionEntidad);
		}
		
	}

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(this.image, (int) x, (int) y, this);

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
