package com.Defenders.Juego;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.Defenders.Entidades.Entidad;

/**
 * Clase que utiliza grids para gestionar las colisiones dentro del juego
 * Referencia http://www.java-gaming.org/index.php?topic=29244.0
 */
public class UniformGridColision {

	private int filas, columnas;
	private float cellSize; // tamaño de cada una de las celdas
	private ArrayList<Entidad>[][] entidadesGrid;

	@SuppressWarnings("unchecked")
	public UniformGridColision(float ancho, float alto, float tamañoCeldas) {
		// TODO Auto-generated constructor stub
		this.cellSize = tamañoCeldas;
		this.filas = (int) ((ancho + cellSize - 1) / cellSize);
		this.columnas = (int) ((alto + cellSize - 1) / cellSize);
		this.entidadesGrid = new ArrayList[this.filas][this.columnas];
	}

	@SuppressWarnings("unchecked")
	public UniformGridColision(float ancho, float alto, float tamañoCeldas, List<Entidad> entidades) {
		// TODO Auto-generated constructor stub
		this.cellSize = tamañoCeldas;
		this.filas = (int) ((ancho + cellSize - 1) / cellSize);
		this.columnas = (int) ((alto + cellSize - 1) / cellSize);
		this.entidadesGrid = new ArrayList[this.filas][this.columnas];
		for (Entidad e : entidades)
			añadirEntidad(e);
	}

	/**
	 * Añade una entidad a los grids correspondientes a su posicion
	 */
	public void añadirEntidad(Entidad e) {
		/**
		 * Itera sobre las celdas que ocupa la entidad
		 */
		for (int x = (int) (e.getXPos() / this.cellSize); x <= (int) ((e.getXPos() + e.getXSize())
				/ this.cellSize); x++) {
			for (int y = (int) (e.getYPos() / this.cellSize); y <= (int) ((e.getYPos() + e.getYSize())
					/ this.cellSize); y++) {
				// si no existe el grid lo inicializamos
				if (this.entidadesGrid[x][y] == null)
					this.entidadesGrid[x][y] = new ArrayList<Entidad>();
				this.entidadesGrid[x][y].add(e);
			}
		}

	}

	/**
	 * Elimina la entidad de sus grids correspondientes
	 */
	public void borrarEntidad(Entidad e) {
		/**
		 * Itera sobre las celdas que ocupa la entidad
		 */
		for (int x = (int) (e.getXPos() / this.cellSize); x <= (int) ((e.getXPos() + e.getXSize())
				/ this.cellSize); x++) {
			for (int y = (int) (e.getYPos() / this.cellSize); y <= (int) ((e.getYPos() + e.getYSize())
					/ this.cellSize); y++) {
				// si no existe el grid lo inicializamos
				this.entidadesGrid[x][y].remove(e);
			}
		}

	}

	/**
	 * Devuelve la entidades cercanas a una posicion
	 */
	public ArrayList<Entidad> getEntidadesCercanas(float xPos, float yPos) {
		return this.entidadesGrid[(int) (xPos / cellSize)][(int) (yPos / cellSize)];
	}

	/**
	 * Devuelve la entidades cercanas a una entidad sin repetirse ella misma
	 */
	public ArrayList<Entidad> getEntidadesCercanas(Entidad e) {
		Set<Entidad> s = new LinkedHashSet<Entidad>();
		for (int x = (int) (e.getXPos() / this.cellSize); x <= (int) ((e.getXPos() + e.getXSize()-1)
				/ this.cellSize); x++) {
			for (int y = (int) (e.getYPos() / this.cellSize); y <= (int) ((e.getYPos() + e.getYSize()-1)
					/ this.cellSize); y++) {
				
				if (this.entidadesGrid[x][y] != null)
					s.addAll(this.entidadesGrid[x][y]);
			}
		}
		s.remove(e);
		return new ArrayList<>(s);
	}

	public ArrayList<Entidad>[][] getEntidadesGrid() {
		return this.entidadesGrid;
	}

	/**
	 * Limpia todas las entidades del mapa
	 */
	public void clear() {
		for (int x = 0; x < this.columnas; x++) {
			for (int y = 0; y < this.filas; y++) {
				this.entidadesGrid[x][y].clear();
			}
		}
	}

}
