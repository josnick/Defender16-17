package com.test.GameEngineTest.Pantallas;

/**
 * Dato enumerado para poder cargar las diferentes pantallas segun el valor
 * elegido
 *
 */
public enum ScreenEnum {

	PANTALLA_JUEGO {
		public Screen obtenerPantalla(Object... params) {
			return new GameScreen();
		}
	},
	PANTALLA_MENU {

		public Screen obtenerPantalla(Object... params) {
			return new MenuScreen();
		}
	};

	public abstract Screen obtenerPantalla(Object... params);
}
