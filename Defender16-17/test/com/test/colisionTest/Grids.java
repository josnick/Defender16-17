package com.test.colisionTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.Defenders.Entidades.Entidad;
import com.Defenders.Entidades.Entidad.Faccion;
import com.Defenders.Entidades.Entidad.TipoEntidad;
import com.Defenders.Juego.UniformGridColision;

public class Grids extends JComponent {

	/**
	* 
	*/
	private final int GRIDSIZE = 124;
	private ArrayList<Entidad> entidades;
	private UniformGridColision sistemaColision;
	private static final long serialVersionUID = 4526264963680953272L;

	public Grids(int row, int colum) {
		// setLayout(new GridLayout(row, colum));
		// setBorder(BorderFactory.createEmptyBorder() );
		this.entidades = new ArrayList<Entidad>();
		this.sistemaColision = new UniformGridColision(FullScreen.SCREEN_WIDHT, FullScreen.SCREEN_HEIGHT, GRIDSIZE);
		JLabel[][] grid = new JLabel[row][colum];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colum; j++) {
				grid[i][j] = new JLabel();
				grid[i][j].setBorder(new LineBorder(Color.BLACK));
				grid[i][j].setOpaque(true);
				add(grid[i][j]);
			}
		}

		Thread miniEngine = new Thread() {
			@Override
			public void run() {
				while (true) {
					// para cada una de las entidades
					for (int i = 0; i < entidades.size(); i++) {
						// borrar la entidad del sistema de colisiones
						Entidad e = entidades.get(i);
						sistemaColision.borrarEntidad(e);
						// actualizar la posicion de la entidad
						entidades.get(i).actualizar();
						// ver si colisiona con algo
						for (Entidad e1 : sistemaColision.getEntidadesCercanas(e)) {

							if (e.estaColisionando(e1)) {
								/**
								 * 
								 * 
								 * Gestion de colisiones
								 * 
								 * 
								 */
								if (e.getTipoEntidad() == TipoEntidad.SPRITE
										&& e1.getTipoEntidad() == TipoEntidad.SPRITE) {

									if ((e.getFaccionEntidad() == Faccion.ALIADO
											&& e1.getFaccionEntidad() == Faccion.ENEMIGO)) {
										entidades.remove(e);
										e = null;
										break;
									} else if (e1.getFaccionEntidad() == Faccion.ALIADO
											&& e.getFaccionEntidad() == Faccion.ENEMIGO) {
										entidades.remove(e1);
										sistemaColision.borrarEntidad(e1);
									}
								} else if (e.getTipoEntidad() == TipoEntidad.ARMA) {
									if (e.getFaccionEntidad() != e1.getFaccionEntidad()) {
										entidades.remove(e);
										entidades.remove(e1);
										sistemaColision.borrarEntidad(e1);
										break;
									}

								} else if (e1.getTipoEntidad() == TipoEntidad.ARMA) {
									if (e.getFaccionEntidad() != e1.getFaccionEntidad()) {
										entidades.remove(e);
										entidades.remove(e1);
										sistemaColision.borrarEntidad(e1);
										break;
									}
								}
								/**
								 * 
								 * 
								 * Fin gestion de colisiones
								 */
							}
						}
						if (e != null)
							sistemaColision.añadirEntidad(e);
						repaint();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		miniEngine.start();
	}

	public ArrayList<Entidad> getEntidades() {
		return this.entidades;
	}

	public boolean addEntidad(Entidad e) {
		this.sistemaColision.añadirEntidad(e);
		return this.entidades.add(e);
	}

	public boolean removeEntidad(Entidad e) {
		this.sistemaColision.borrarEntidad(e);
		return this.entidades.remove(e);
	}

	private void paintBackground(Graphics2D g2) {
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

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		paintBackground(g2);

		for (int i = 0; i < entidades.size(); i++) {
			entidades.get(i).dibujar(g);
		}
	}

}
