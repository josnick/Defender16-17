package com.Defenders;

import java.awt.EventQueue;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import com.Defenders.Menu.GestorPantalla;
import com.Defenders.Menu.PantallaEnum;

public class Main extends JFrame{
	
	private static final long serialVersionUID = -8961797987530734026L;
	public static final int SCREEN_WIDHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static GraphicsDevice device = env.getDefaultScreenDevice();
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main();
			}
		});
		
	}
	
	public Main() {
		/**
		 * Añadir entidades aleatorias
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE | WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		device.setFullScreenWindow(this);
		setFocusable(true);
		
		/*
		 * Inicializar gestor de pantallas
		 */
		GestorPantalla.getInstance().iniciar(this);
		GestorPantalla.getInstance().mostrarPantalla(PantallaEnum.PANTALLA_JUEGO);
		
		validate();
		repaint();
		setVisible(true);
	}

}
