package com.Defenders.Juego;

import java.util.ArrayList;

import java.util.List;
import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.Dinamicas.Alien;
import com.Defenders.Entidades.Dinamicas.Ciudadano;
import com.test.GameEngineTest.Game;
/**
 * 
 * Clase encargada de cargar todas las entidades en un mapa
 *
 */
public class FactoriaEntidades {

	public static List<Entidad> cargarGUI() {

		return null;
	}

	public static List<Entidad> cargarPersonajes() {
		List<Entidad> e=new ArrayList<Entidad>();
		e.add(new Alien(200	, 200));
		e.add(new Alien(Game.SCREEN_WIDHT / 2, (Game.SCREEN_HEIGHT / 2) - 200));
		e.add(new Alien(Game.SCREEN_WIDHT / 2, (Game.SCREEN_HEIGHT / 2) - 200));
		e.add(new Alien(Game.SCREEN_WIDHT / 2, (Game.SCREEN_HEIGHT / 2) - 200));
		e.add(new Alien(Game.SCREEN_WIDHT / 2, (Game.SCREEN_HEIGHT / 2) - 200));
		e.add(new Alien(Game.SCREEN_WIDHT / 2, (Game.SCREEN_HEIGHT / 2) - 200));
		e.add(new Alien(100, 100));
		e.add(new Alien(100, 100));
		e.add(new Alien(100, 100));
		e.add(new Alien(100, 100));
		e.add(new Alien(100, 100));
		e.add(new Alien(100, 100));
		
		
		e.add(new Ciudadano(200));
		e.add(new Ciudadano(300));
		e.add(new Ciudadano(100));
		e.add(new Ciudadano(450));
		e.add(new Ciudadano(500));
		e.add(new Ciudadano(400));
		return e;
	}

}
