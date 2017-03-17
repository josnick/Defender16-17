package com.Defenders.Menu.Pantallas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import com.Defenders.Main;
import com.Defenders.Juego.PanelJuego;
import com.Defenders.Menu.PantallaAbstracta;

public class PantallaJuego extends PantallaAbstracta {

	/**
	 * 
	 */
	private JPanel panelSuperior;
	private PanelJuego panelJuego;
	private JPanel panelInfo, minimapPanel, panelAux;
	// private List<Entidad> entidades;
	// private final int GRIDSIZE = 124;
	//
	//
	// private MotorJuego motorJuego;
	private static final long serialVersionUID = -1873911106724974784L;

	public PantallaJuego() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		cargarGui();
	
		

	}

	@Override
	public void construirEscena() {
		setBackground(Color.BLACK);

		add(this.panelSuperior, BorderLayout.NORTH);
		add(this.panelJuego, BorderLayout.SOUTH);
		//this.panelJuego.add(this.gordaco);
		
		// TODO Auto-generated method stub
		// this.entidades=FactoriaEntidades.cargarPersonajes();
		// this.motorJuego=new MotorJuego(this.entidades, this);
		// //iniciar el juego
		// this.motorJuego.run();
	}

	@Override
	public void dibujar(Graphics2D g2) {
		// TODO Auto-generated method stub
		pintarFondo(g2);
		this.panelJuego.paint(g2);
	}

	private void pintarFondo(Graphics2D g2) {
		g2.setColor(getBackground());
		g2.fillRect(0, 0, Main.SCREEN_WIDHT, Main.SCREEN_HEIGHT);

	}

	/**
	 * Carga los elementos de la GUI
	 */
	private void cargarGui() {
		this.panelSuperior = new JPanel();
		this.panelSuperior.setPreferredSize(new Dimension(Main.SCREEN_WIDHT, (int) (Main.SCREEN_HEIGHT * 0.25)));
		this.panelSuperior.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
		this.panelSuperior.setLayout(new GridLayout(1, 3));
		this.panelSuperior.setBackground(Color.BLACK);

		this.panelInfo = new JPanel();

		// this.panelInfo.setBorder(new LineBorder(Color.BLUE, 5));
		this.panelInfo.setBackground(Color.BLACK);

		this.minimapPanel = new JPanel();
		this.minimapPanel.setPreferredSize(
				new Dimension((int) (this.panelSuperior.getWidth() * 0.6), this.panelSuperior.getHeight()));
		this.minimapPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.BLUE));
		this.minimapPanel.setBackground(Color.BLACK);

		this.panelJuego = new PanelJuego();
		this.panelJuego.setPreferredSize(new Dimension((int) (Main.SCREEN_WIDHT*3.0), (int) (Main.SCREEN_HEIGHT * 0.75)));
		this.panelJuego.setBackground(Color.BLACK);

		this.panelAux = new JPanel();
		this.panelAux.setBackground(Color.BLACK);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.25;
		gbc.weighty = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.panelSuperior.add(this.panelInfo, gbc);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.5;
		gbc.weighty = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.panelSuperior.add(this.minimapPanel, gbc);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.25;
		gbc.weighty = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.panelSuperior.add(this.panelAux,gbc);

	}

	/**
	 * Eventos
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.panelJuego.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.panelJuego.keyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
