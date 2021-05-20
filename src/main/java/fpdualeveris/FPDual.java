package fpdualeveris;

import operators.Pinball;

/** Clase FPDual que permite comenzar partidas de Pinball
 * 
 * @author larroyca
 *
 */

public class FPDual {
	
	/** Metodo principal de la clase
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		startNewGame();
		
	}
	
	/** Metodo que inicializa una partida de Pinball
	 * 
	 * @author Luis Rafael Arroyo Caballero
	 */
	public static void startNewGame() {
		
		// Creamos nuevo pinball.
		
		Pinball pinball = new Pinball("Luis", 5);
		
		// Comprobamos que es un onjeto de tipo Pinball:
		
		if (pinball instanceof Pinball) {
			pinball.launchBall();
		}
	}
}
