package com.Defenders.Entidades.Dinamicas;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import com.Defenders.AssetsManager;
import com.Defenders.Entidades.EntidadDinamica;
import com.Defenders.Entidades.Entidad;
import com.test.GameEngineTest.Game;
import com.test.GameEngineTest.Pantallas.ScreenManager;

public class Ciudadano extends EntidadDinamica {

	/**
	 * 
	 */
	private Image image;
	private static final long serialVersionUID = 5179120436029007022L;
	private Random r;

	private boolean abducido;
	private Entidad entidadAbducido;

	/**
	 * Metodo constructor que inicializa un ciudadano en un espacio 2d
	 */
	public Ciudadano(float x) {
		this(x, Game.SCREEN_HEIGHT - 52, AssetsManager.ciudadano);
		faccionEntidad = Faccion.ALIADO;
		this.r = new Random();
		faccionEntidad = Faccion.ALIADO;
		tipoEntidad = TipoEntidad.SPRITE;
		direccionEntidad = Direccion.NONE;
		identificadorEntidad = IdentificadorEntidad.CIUDADANO;
		velocidadActual = 1f;
		aceleracion = 0f;
		this.framesActualizar = (r.nextInt(10) + 1) * 10;

		abducido = false;
		// TODO Auto-generated constructor stub
	}

	private Ciudadano(float x, float y, ImageIcon img) {
		super(x + ((float) img.getIconWidth() / 2), y + ((float) img.getIconHeight() / 2), (float) img.getIconWidth(),
				(float) img.getIconHeight());
		this.image = img.getImage();
		this.sx = img.getIconWidth();
		this.sy = img.getIconHeight();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor que inicializa un ciudadano en un espacio 3d
	 */

	@Override
	public void dibujar(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(this.image, (int) x, (int) y, this);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		if (!abducido) {
			mover();
			actualizarPosicion(direccionEntidad);
		} else {
			x = entidadAbducido.getXPos() + (entidadAbducido.getXSize() / 2);
			y = entidadAbducido.getYPos() + entidadAbducido.getYSize();
			// Mutacion del ciudadano
			if (framesActualizar == 0 && entidadAbducido.getIdentificadorEntidad() == IdentificadorEntidad.ALIEN) {
				ScreenManager.getInstance().getPantallaActual().añadirEntidad(new Mutante(getXPos(), getYPos()));
				ScreenManager.getInstance().getPantallaActual().borrarEntidad(this);
			}
			// si ha sido "abducido por un jugador y esta a una determinada
			// altura lo liberamos"
			else if (entidadAbducido.getIdentificadorEntidad() == IdentificadorEntidad.JUGADOR
					&& y >= Game.SCREEN_HEIGHT - 52) {
				abducido = false;
				entidadAbducido = null;
				this.framesActualizar = (r.nextInt(10) + 1) * 10;
			}
		}
		framesActualizar--;

	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destruirEntidad(Entidad e) {
		// TODO Auto-generated method stub
		// ciudadano abducido
		if (e != null) {
			// si esta en tierra el jugador no puede rescatar al ciudadano
			if (e.getIdentificadorEntidad() == IdentificadorEntidad.JUGADOR && y >= Game.SCREEN_HEIGHT - 52)
				;
			// si ha sido abducido por un jugador y le disparan muere
			else if (!abducido && e.getIdentificadorEntidad() == IdentificadorEntidad.ALIEN
					|| e.getIdentificadorEntidad() == IdentificadorEntidad.JUGADOR) {
				abducido = true;
				entidadAbducido = e;
				framesActualizar = 600;
			}
		} else {
			if (abducido && entidadAbducido.getIdentificadorEntidad() == IdentificadorEntidad.ALIEN)
				;
			else
				ScreenManager.getInstance().getPantallaActual().borrarEntidad(this);
		}

	}

	@Override
	public void iniciarEntidad() {
		// TODO Auto-generated method stub

	}

	private void mover() {
		/**
		 * Limites de la pantalla
		 */
		if (getXPos() >= Game.SCREEN_WIDHT) {
			direccionEntidad = Direccion.LF;
		} else if (getXPos() <= 10) {
			direccionEntidad = Direccion.RG;
		}

		if (framesActualizar == 0) {

			switch (r.nextInt(2)) {
			case 0:
				direccionEntidad = Direccion.NONE;
				break;
			case 1:
				direccionEntidad = Direccion.RG;
				break;
			case 2:
				direccionEntidad = Direccion.LF;
				break;
			}

		}

	}

}
