package com.Defenders.Juego;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.Timer;

import com.Defenders.Main;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.Entidad.Faccion;
import com.Defenders.Entidades.Entidad.TipoEntidad;
import com.Defenders.Entidades.Estaticas.Mapa;
import com.Defenders.Entidades.Jugador.Jugador;
import com.Defenders.Menu.GestorPantalla;

/**
 * Clase que se encarga de gestionar todo el proceso de juego
 *
 */
public class MotorJuego extends Thread {

	private final int GRID = 124;
	private final int FPS = 30;
	private List<Entidad> entidades;
	private UniformGridColision gestorColisiones;

	private static MotorJuego instance;
	private JComponent pantalla;
	private BufferedImage backBuffer; // buffer del frame actual
	private Insets insets; 

	private Entidad mapa;
	private Entidad jugador;

	private boolean isRunning;

	/*
	 * Auxiliar
	 */

	/**
	 * Inicia el motor de juego sobre una pantalla
	 * 
	 * @param pantalla
	 */
	public void iniciar(JComponent pantalla) {
		this.pantalla = pantalla;
		this.entidades = FactoriaEntidades.cargarPersonajes();
		this.gestorColisiones = new UniformGridColision(Main.SCREEN_WIDHT, Main.SCREEN_HEIGHT, GRID, this.entidades);

		this.jugador = new Jugador((int) this.pantalla.getPreferredSize().getWidth() / 2,
				(int) this.pantalla.getPreferredSize().getHeight() / 2);
		this.mapa = new Mapa(Main.SCREEN_WIDHT, (int) (Main.SCREEN_HEIGHT * 0.2));
		this.isRunning = false;
	}

	// Singleton: retrieve instance
	public static MotorJuego getInstance() {
		if (instance == null) {
			instance = new MotorJuego();
		}
		return instance;
	}

	public void iniciarJuego() {
		if (instance == null) {
			instance = new MotorJuego();
		}
		isRunning = true;
		instance.run();
	}

	public void pausarJuego() {
		if (instance == null) {
			instance = new MotorJuego();
		}
		instance.interrupt();
	}

	public void terminarJuego() {
		if (instance == null) {
			instance = new MotorJuego();
		} else {
			try {
				instance.finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Hilo que gestiona la logica del juego
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		// while (true) {
		// para cada una de las entidades
		// for (int i = 0; i < this.entidades.size(); i++) {
		// Entidad e = this.entidades.get(i);
		// // borrar la entidad del sistema de colisiones
		// //this.gestorColisiones.borrarEntidad(e);
		// // actualizar la posicion de la entidad
		// e.actualizar();
		// ver si colisiona con algo
		// for (Entidad e1 : gestorColisiones.getEntidadesCercanas(e)) {
		//
		// if (e.estaColisionando(e1)) {
		// /**
		// *
		// *
		// * Gestion de colisiones
		// *
		// *
		// */
		// if (e.getTipoEntidad() == TipoEntidad.SPRITE && e1.getTipoEntidad()
		// == TipoEntidad.SPRITE) {
		//
		// if ((e.getFaccionEntidad() == Faccion.ALIADO
		// && e1.getFaccionEntidad() == Faccion.ENEMIGO)) {
		// entidades.remove(e);
		// e = null;
		// break;
		// } else if (e1.getFaccionEntidad() == Faccion.ALIADO
		// && e.getFaccionEntidad() == Faccion.ENEMIGO) {
		// entidades.remove(e1);
		// gestorColisiones.borrarEntidad(e1);
		// }
		// } else if (e.getTipoEntidad() == TipoEntidad.ARMA) {
		// if (e.getFaccionEntidad() != e1.getFaccionEntidad()) {
		// entidades.remove(e);
		// entidades.remove(e1);
		// gestorColisiones.borrarEntidad(e1);
		// break;
		// }
		//
		// } else if (e1.getTipoEntidad() == TipoEntidad.ARMA) {
		// if (e.getFaccionEntidad() != e1.getFaccionEntidad()) {
		// entidades.remove(e);
		// entidades.remove(e1);
		// gestorColisiones.borrarEntidad(e1);
		// break;
		// }
		// }
		// /**
		// *
		// *
		// * Fin gestion de colisiones
		// */
		// }
		// }
		// if (e != null)
		// gestorColisiones.añadirEntidad(e);
		// this.pantalla.repaint();
		// super.run();
		// }
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		/**
		 * V2
		 */

		// Timer t = new Timer(5, new ActionListener() {
		// public void actionPerformed(ActionEvent ae) {
		// mapa.dibujar((Graphics2D) pantalla.getGraphics());
		// for(Entidad e:entidades)
		// e.dibujar((Graphics2D) pantalla.getGraphics());
		// }
		// });
		// t.start();

		this.backBuffer = new BufferedImage(this.pantalla.getPreferredSize().width, this.pantalla.getPreferredSize().height, BufferedImage.TYPE_INT_RGB);
		this.insets = this.pantalla.getInsets(); 
        this.pantalla.setSize(insets.left + this.pantalla.getPreferredSize().width + insets.right, 
                          insets.top + this.pantalla.getPreferredSize().height + insets.bottom); 
		
		
		while (isRunning) {
			long time = System.currentTimeMillis();

			// update();
			draw();

			time = (1000 / FPS) - (System.currentTimeMillis() - time);

			if (time > 0) {
				try {
					Thread.sleep(time);
				} catch (Exception e) {
				}
			}

		}
	}

	/**
	 * Metodo encargado de dibujar el frame actual
	 */
	private void draw(){
		Graphics g=GestorPantalla.getInstance().getGame().getGraphics();
        Graphics bbg = backBuffer.getGraphics();

////         bbg.setColor(Color.WHITE); 
////         bbg.fillRect(0, 0, windowWidth, windowHeight); 
//
////         bbg.setColor(Color.BLACK); 
////         bbg.drawOval(x, 10, 20, 20); 
         jugador.dibujar((Graphics2D) bbg);

         g.drawImage(backBuffer, insets.left, insets.top, this.pantalla); 
	}
}
