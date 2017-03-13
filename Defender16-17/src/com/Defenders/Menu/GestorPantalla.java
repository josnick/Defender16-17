package com.Defenders.Menu;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Clase que se encargara de cargar las diferentes pantallas del juego, usa un
 * singleton para no repetir pantallas
 *
 */
public class GestorPantalla {

	private static GestorPantalla instance;
	private JFrame game;
	private PantallaEnum pantallaActual;

	// Singleton: private constructor
	private GestorPantalla() {
		super();
	}

	/**
	 * Inicializa el gestor de pantallas
	 * 
	 * @param game
	 */
	public void iniciar(JFrame game) {
		this.game = game;
	}

	// Singleton: retrieve instance
	public static GestorPantalla getInstance() {
		if (instance == null) {
			instance = new GestorPantalla();
		}
		return instance;
	}

	/**
	 * Muestra la pantalla seleccionada
	 */
	public void mostrarPantalla(PantallaEnum screenEnum, Object... params) {
		if(screenEnum!=null && screenEnum==pantallaActual) return;
		pantallaActual=screenEnum;
		// Elimina los elementos de la pantalla anterior
		this.game.getContentPane().removeAll();
		// carga la nueva pantalla
		PantallaAbstracta newScreen = screenEnum.obtenerPantalla(params);
		newScreen.construirEscena();
		this.game.add(newScreen, BorderLayout.CENTER);
		this.game.addKeyListener(newScreen);
		this.game.validate();
		this.game.repaint();
		


	}

}
