package com.Defenders.Menu.Pantallas;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.Defenders.Main;
import com.Defenders.Menu.GestorPantalla;
import com.Defenders.Menu.PantallaAbstracta;
import com.Defenders.Menu.PantallaEnum;

public class PantallaSplash extends PantallaAbstracta {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8560177197827418136L;
	JLabel label;

	public PantallaSplash() {
		// TODO Auto-generated constructor stub
		setBackground(Color.RED);

		ImageIcon icon = new ImageIcon("/assets/menu/intro_splash1.gif");
		
		label = new JLabel("BUKAKEEE");
		label.setIcon(icon);
		label.setBounds(0, 0, Main.SCREEN_WIDHT, Main.SCREEN_HEIGHT);
		icon.setImageObserver(label);
		add(label);

	}

	@Override
	public void construirEscena() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void dibujar(Graphics2D g2) {
		// TODO Auto-generated method stub
		pintarFondo(g2);
	}

	/**
	 * Metodo que pinta el fondo
	 * 
	 * @param g2
	 */
	private void pintarFondo(Graphics2D g2) {
		g2.setColor(getBackground());
		g2.fillRect(0, 0, Main.SCREEN_WIDHT, Main.SCREEN_HEIGHT);

	}

	/**
	 * Eventos
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
		// cargar pantalla menu
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			GestorPantalla.getInstance().mostrarPantalla(PantallaEnum.PANTALLA_MENU);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
