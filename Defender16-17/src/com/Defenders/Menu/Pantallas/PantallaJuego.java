package com.Defenders.Menu.Pantallas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import com.Defenders.Menu.PantallaAbstracta;

public class PantallaJuego extends PantallaAbstracta{


	/**
	 * 
	 */
	private final int GRIDSIZE = 124;
	private static final long serialVersionUID = -1873911106724974784L;

	@Override
	public void construirEscena() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dibujar(Graphics2D g2) {
		// TODO Auto-generated method stub
		pintarFondo(g2);
	}
	
	
	private void pintarFondo(Graphics2D g2) {
		g2.setPaint(Color.LIGHT_GRAY);
		for (int i = 0; i < getSize().width; i += GRIDSIZE) {
			Shape line = new Line2D.Float(i, 0, i, getSize().height);
			g2.draw(line);
		}

		for (int i = 0; i < getSize().height; i += GRIDSIZE) {
			Shape line = new Line2D.Float(0, i, getSize().width, i);
			g2.draw(line);
		}

	}

}
