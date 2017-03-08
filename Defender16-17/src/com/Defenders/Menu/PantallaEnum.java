package com.Defenders.Menu;

import com.Defenders.Menu.Pantallas.PantallaJuego;
import com.Defenders.Menu.Pantallas.PantallaMenu;
import com.Defenders.Menu.Pantallas.PantallaOpciones;
import com.Defenders.Menu.Pantallas.PantallaSplash;

/**
 * Dato enumerado para poder cargar las diferentes pantallas segun el valor
 * elegido
 *
 */
public enum PantallaEnum {

	PANTALLA_JUEGO {
		public PantallaAbstracta obtenerPantalla(Object... params) {
			return new PantallaJuego();
		}
	},
	PANTALLA_SPLASH

	{

		public PantallaAbstracta obtenerPantalla(Object... params) {
			return new PantallaSplash();
		}
	},
	PANTALLA_MENU {

		public PantallaAbstracta obtenerPantalla(Object... params) {
			return new PantallaMenu();
		}
	},
	PANTALLA_OPCIONES {

		public PantallaAbstracta obtenerPantalla(Object... params) {
			return new PantallaOpciones();
		}
	};

	public abstract PantallaAbstracta obtenerPantalla(Object... params);
}
