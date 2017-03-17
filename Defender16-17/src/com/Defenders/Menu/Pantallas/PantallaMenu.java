package com.Defenders.Menu.Pantallas;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import com.Defenders.Main;
import com.Defenders.Menu.PantallaAbstracta;
import com.Defenders.Menu.Pantallas.utils.StyledButtonUI;

public class PantallaMenu extends PantallaAbstracta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2125504541066060084L;
	private JButton salir, opciones, jugar;

	public PantallaMenu() {
		// TODO Auto-generated constructor stub
		setBackground(Color.PINK);
		this.jugar = new JButton("Jugar");
		this.opciones = new JButton("Opciones");
		this.salir = new JButton("Salir");
	}

	@Override
	public void construirEscena() {
		// TODO Auto-generated method stub
		this.jugar.setUI(new StyledButtonUI());
		this.opciones.setUI(new StyledButtonUI());
		this.salir.setUI(new StyledButtonUI());

		
		add(jugar);
		add(opciones);
		add(salir);

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
