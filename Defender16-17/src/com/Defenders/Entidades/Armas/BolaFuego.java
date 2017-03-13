package com.Defenders.Entidades.Armas;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.Defenders.AssetsManager;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.EntidadDinamica;
import com.test.colisionTest.FullScreen;

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
		velocidadActual = 5f;
		// TODO Auto-generated constructor stub
	}

	private BolaFuego(float x, float y, ImageIcon img) {
		super(x + ((float) img.getIconWidth() / 2), y + ((float) img.getIconHeight() / 2), (float) img.getIconWidth(),
				(float) img.getIconHeight());
		this.image = img.getImage();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizar() {
		if (x >= FullScreen.SCREEN_WIDHT || x <= 0 || y >= FullScreen.SCREEN_HEIGHT || y <= 0) {
			FullScreen.c.removeEntidad(this);
			return;
		}
		// TODO Auto-generated method stub
		switch (direccionEntidad) {
		case DW:
			y -= velocidadActual;
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
			y += velocidadActual;
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

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(this.image, (int) x, (int) y, this);

	}

}
