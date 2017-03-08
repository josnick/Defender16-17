package com.Defenders.Menu;

import java.awt.BorderLayout;

import java.awt.Component;
import javax.swing.JFrame;

/**
 * Clase que se encargara de cargar las diferentes pantallas del juego, usa un
 * singleton para no repetir pantallas
 *
 */
public class GestorPantalla {

	private static GestorPantalla instance;
	private JFrame game;

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

		// obtiene los componentes de la pantalla
		Component[] pantallaActual = game.getContentPane().getComponents();

		// carga la nueva pantalla
		PantallaAbstracta newScreen = screenEnum.obtenerPantalla(params);
		newScreen.construirEscena();
		game.add(newScreen, BorderLayout.CENTER);

		// Elimina los elementos de la pantalla anterior
		if (pantallaActual != null) {
			for (Component c : pantallaActual)
				game.getContentPane().remove(c);
		}

	}

}
