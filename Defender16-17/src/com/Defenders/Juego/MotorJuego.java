package com.Defenders.Juego;

import java.util.List;

import com.Defenders.Main;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.Entidad.Faccion;
import com.Defenders.Entidades.Entidad.TipoEntidad;
import com.Defenders.Menu.PantallaAbstracta;

/**
 * Clase que se encarga de gestionar todo el proceso de juego
 *
 */
public class MotorJuego extends Thread {

	private final int GRID = 124;
	private List<Entidad> entidades;
	private PantallaAbstracta pantalla;
	private UniformGridColision gestorColisiones;

	public MotorJuego(List<Entidad> entidades, PantallaAbstracta pantalla) {
		// TODO Auto-generated constructor stub
		this.pantalla = pantalla;
		this.entidades = entidades;
		this.gestorColisiones = new UniformGridColision(Main.SCREEN_WIDHT, Main.SCREEN_HEIGHT, GRID, this.entidades);
	}

	/**
	 * Hilo que gestiona la logica del juego
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			System.out.println(this.entidades.size());
			// para cada una de las entidades
			for (int i = 0; i < this.entidades.size(); i++) {
				Entidad e = this.entidades.get(i);
				// borrar la entidad del sistema de colisiones
				this.gestorColisiones.borrarEntidad(e);
				// actualizar la posicion de la entidad
				e.actualizar();
				// ver si colisiona con algo
				for (Entidad e1 : gestorColisiones.getEntidadesCercanas(e)) {

					if (e.estaColisionando(e1)) {
						/**
						 * 
						 * 
						 * Gestion de colisiones
						 * 
						 * 
						 */
						if (e.getTipoEntidad() == TipoEntidad.SPRITE && e1.getTipoEntidad() == TipoEntidad.SPRITE) {

							if ((e.getFaccionEntidad() == Faccion.ALIADO
									&& e1.getFaccionEntidad() == Faccion.ENEMIGO)) {
								entidades.remove(e);
								e = null;
								break;
							} else if (e1.getFaccionEntidad() == Faccion.ALIADO
									&& e.getFaccionEntidad() == Faccion.ENEMIGO) {
								entidades.remove(e1);
								gestorColisiones.borrarEntidad(e1);
							}
						} else if (e.getTipoEntidad() == TipoEntidad.ARMA) {
							if (e.getFaccionEntidad() != e1.getFaccionEntidad()) {
								entidades.remove(e);
								entidades.remove(e1);
								gestorColisiones.borrarEntidad(e1);
								break;
							}

						} else if (e1.getTipoEntidad() == TipoEntidad.ARMA) {
							if (e.getFaccionEntidad() != e1.getFaccionEntidad()) {
								entidades.remove(e);
								entidades.remove(e1);
								gestorColisiones.borrarEntidad(e1);
								break;
							}
						}
						/**
						 * 
						 * 
						 * Fin gestion de colisiones
						 */
					}
				}
				if (e != null)
					gestorColisiones.añadirEntidad(e);
				this.pantalla.repaint();
				super.run();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
