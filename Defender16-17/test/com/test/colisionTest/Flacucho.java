package com.test.colisionTest;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import com.Defenders.AssetsManager;
import com.Defenders.Entidades.EntidadDinamica;
import com.Defenders.Entidades.Armas.BolaFuego;

public class Flacucho extends EntidadDinamica {

	private Image image;
	private final Random r=new Random();
	private static final long serialVersionUID = 3076302560818437078L;

	public Flacucho(float x, float y) {
		this(x, y, AssetsManager.imagenflacucho);
		faccionEntidad = Faccion.ENEMIGO;
		tipoEntidad = TipoEntidad.SPRITE;
		direccionEntidad = Direccion.values()[FullScreen.r.nextInt(Direccion.values().length-1)+1];
		// TODO Auto-generated constructor stub
	}

	public Flacucho(float x, float y, ImageIcon img) {
		super(x, y);
		this.image = img.getImage();
		// TODO Auto-generated constructor stub
	}

	public Flacucho(float x, float y, Image img) {
		super(x, y);
		this.image = img;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(this.image, (int) getXPos(), (int) getYPos(), this);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		// si la entidad se escapa de la pantalla cambiamos la direccion
		if (x >= FullScreen.SCREEN_WIDHT) {
			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.LF;
				break;

			case 1:
				direccionEntidad = Direccion.DWLF;
				break;
			case 2:
				direccionEntidad = Direccion.DWRG;
				break;
			}
		}
		if (x <= 0) {
			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.RG;
				break;

			case 1:
				direccionEntidad = Direccion.UPRG;
				break;
			case 2:
				direccionEntidad = Direccion.DWRG;
				break;
			}
		}
		if (y >= FullScreen.SCREEN_HEIGHT) {
			switch (FullScreen.r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.DW;
				break;

			case 1:
				direccionEntidad = Direccion.DWLF;
				break;
			case 2:
				direccionEntidad = Direccion.DWRG;
				break;
			}

		}
		if (y <= 0) {
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
		}
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
//		if (r.nextFloat() > 0.99f)
//			//FullScreen.c.addEntidad(new BolaFuego(this));
	}

}
