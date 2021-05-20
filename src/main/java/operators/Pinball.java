package operators;

import java.util.Scanner;

/** Clase que define una partida de Pinball
 * 
 * @author Luis Rafael Arroyo Caballero
 *
 */

public class Pinball {
	
	/** ID de partida */
	private static int idPinball = 0;
	
	/** Nombre del jugador */
	private String player;
	
	/** Seguimmiento de puntos */
	private int points;
	
	/** Seguimiento de turnos */
	private int turns;
	
	/** Posicion de la palanca izquierda */
	private boolean leftButton = false;
	
	/** Posicion de la palanca derecha */
	private boolean rightButton = false;
	
	/** Constructor */
	
	public Pinball(String player,int turns) {
		setIdPinball(++idPinball);
		setPlayer(player);
		setPoints(0);
		setTurns(turns);
	}
	
	/** Metodo que maneja el flujo de la partida de Pinball
	 * 
	 * @author Luis Rafael Arroyo Caballero
	 */
	
	public void launchBall() {
		System.out.println("Has comenzado una nueva partida. Buena suerte!!");
		while (turns != 0) {
			int pressedLever = moveScanner();
			if (pressedLever == 1) {
				pressRightButton();
			} else if (pressedLever == 2) {
				pressLeftButton();
			}
			generateBallImpact();
			generateRandomRoute();
		}
		
		System.out.println(generateGameResults());
	}
	
	/** Metodo encargado de generar el mensaje final del juego
	 * 
	 * @return Devuelve el mensaje construido
	 */
	
	private StringBuilder generateGameResults() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Enhorabuena ");
		strBuilder.append(getPlayer());
		strBuilder.append(", has conseguido ni mas ni menos la increible cantidad de: ");
		strBuilder.append(getPoints());
		strBuilder.append(" puntos. Felicidades!!!");
		return strBuilder;
	}
	
	/** Metodo utilizado para que el jugador utilice una palanca
	 * 
	 * @author Luis Rafael Arroy Caballero
	 * @return Devuelve la palanca levantada por el jugador
	 */
	
	public int moveScanner() {
		Scanner sc = new Scanner(System.in);
		int lever = 0;
		System.out.println("Introduzca una acción: \n 1. Levantar palanca derecha \n 2. Levantar palanca izquierda");
		lever = sc.nextInt();
		while (lever != 1 && lever != 2) {
			System.out.println("Amigo mío, no es tan complicado, vuelve a intentarlo anda.");
			System.out.println("Introduzca una acción: \n 1. Levantar palanca derecha \n 2. Levantar palanca izquierda");
			lever = sc.nextInt();
		}
		return lever;
	}
	
	
	/** Metodo que identifica si la bola ha golpeado la palanca pulsada.
	 * 
	 * @author Luis Rafael Arroyo Caballero
	 */
	
	public void generateBallImpact() {
		if (leftButton || rightButton) {
			int typeRouteImpact = (int) (Math.random()*((3)+1));
			if (typeRouteImpact >= 0 || typeRouteImpact <= 2) {
				setTurns(--turns);
			} else if (typeRouteImpact == 3) {
				setTurns(0);
			}
		} 
	}
	
	
	
	/** Metodo que genera que ruta ha seguido la bola. Puede o ganar puntos o perder.
	 * 
	 * @author Luis Rafael Arroyo Caballero
	 */

	public void generateRandomRoute() {
		int typeRoute = (int) (Math.random()*((3)+1));
		
		if (typeRoute == 0) {
			setPoints(points+=25);
			
		} else if (typeRoute == 1) {
			setPoints(points+=50);
			
		} else if (typeRoute == 2) {
			setPoints(points+=100);
			
		} else if (typeRoute == 3) {
			setTurns(0);
		}
		
	}
	
	/** Metodo para levantar la palanca izquierda y bajar la derecha.
	 * 
	 * @author Luis Rafael Arroyo Caballero
	 */
	
	public void pressLeftButton() {
		if ((!leftButton && rightButton) || (!leftButton && !rightButton) || (leftButton && rightButton)) {
			setLeftButton(true);
			setRightButton(false);
		} 
	}
	
	/**Metodo para levantar la palanca derecha y bajar la izquierda.
	 *
	 * @author Luis Rafael Arroyo Caballero
	 */
	
	public void pressRightButton() {
		if ((leftButton && !rightButton) || (!leftButton && !rightButton) || (leftButton && rightButton)) {
			setLeftButton(false);
			setRightButton(true);
		} 
	}
	
	
	/** Getters & Setters */

	public static int getIdPinball() {
		return idPinball;
	}


	public static void setIdPinball(int idPinball) {
		Pinball.idPinball = idPinball;
	}


	public String getPlayer() {
		return player;
	}


	public void setPlayer(String player) {
		this.player = player;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getTurns() {
		return turns;
	}


	public void setTurns(int turns) {
		this.turns = turns;
	}

	
	public boolean isLeftButton() {
		return leftButton;
	}

	public void setLeftButton(boolean leftButton) {
		this.leftButton = leftButton;
	}

	public boolean isRightButton() {
		return rightButton;
	}

	public void setRightButton(boolean rightButton) {
		this.rightButton = rightButton;
	}
	
	
	
	
	

}
