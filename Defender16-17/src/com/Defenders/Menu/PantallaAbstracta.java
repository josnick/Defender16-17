package com.Defenders.Menu;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * Clase para cargar de manera generica las pantallas del juego
 * @author Portátil1
 *
 */
public abstract class PantallaAbstracta extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = -8182053087664035163L;

	/**
	 * Metodo en donde se monta la escena
	 */
	public abstract void construirEscena();
	public abstract void dibujar(Graphics2D g2);
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		setOpaque(true);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		dibujar(g2);
	}

}
