package com.Defenders;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.Defenders.Entidades.utils.SpriteSheetLoader;

/**
 * Clase donde se cargaran estaticamente en memoria todos los recursos
 * @author Portátil1
 *
 */
public class AssetsManager{
	public static ImageIcon imagenGordaco=new ImageIcon("assets/test/gordaco.png");
	public static ImageIcon imagenflacucho=new ImageIcon("assets/test/flacucho.png");
	public static ImageIcon imagenbolafuego=new ImageIcon("assets/test/bola_fuego.png");
	
	public static BufferedImage[]  spritesJugador= SpriteSheetLoader.cargarSprites("assets/game/sprites2.png",65,40, 2, 1);
	public static ImageIcon  llama_motor_Izq=new ImageIcon("assets/game/llama_motor_izq.png");
	public static ImageIcon  llama_motor_Drch=new ImageIcon("assets/game/llama_motor_der.png");
}
