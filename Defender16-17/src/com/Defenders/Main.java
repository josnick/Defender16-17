package com.Defenders;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import com.Defenders.Menu.GestorPantalla;
import com.Defenders.Menu.PantallaEnum;

public class Main extends JFrame implements KeyListener{
	
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
		setSize(SCREEN_WIDHT, SCREEN_HEIGHT);
		/**
		 * A�adir entidades aleatorias
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE | WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		device.setFullScreenWindow(this);

		addKeyListener(this);
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			dispose();
		
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
