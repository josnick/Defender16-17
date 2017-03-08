package com.test.colisionTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FullScreen extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6806457404922283799L;
	static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static GraphicsDevice device = env.getDefaultScreenDevice();

	public static final Random r = new Random();
	public static final int SCREEN_WIDHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public static Grids c;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FullScreen();
			}
		});
	}

	public FullScreen() {
		setSize(SCREEN_WIDHT, SCREEN_HEIGHT);
		c = new Grids(25, 25);
		/**
		 * Añadir entidades aleatorias
		 */
		// c.addEntidad(new Gordaco(500, 0));
		for (int i = 0; i < 50; i++) {
			// gordaco
			if (r.nextBoolean())
				c.addEntidad(new Gordaco(r.nextInt(getWidth() / 2), r.nextInt(getHeight())));
			// flacucho
			else
				c.addEntidad(new Flacucho((getWidth() / 2) + r.nextInt(getWidth() / 2), r.nextInt(getHeight())));

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE | WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		device.setFullScreenWindow(this);

		addKeyListener(this);
		setFocusable(true);

		add(c, BorderLayout.CENTER);

		validate();
		repaint();
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			this.dispose();
		
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
