package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import particules.Vue;

/**
 * Repr�sente la simulation dans son ensemble. 
 * Contient un Environment et une liste d'Agents ainsi qu'une vue
 * Patron Observable Java : D�pr�ci� /!\
 * @author Gautier Kasperek Alice Sparrow
 *
 */
public abstract class SMA extends Observable{
	
	
	protected Environment environment;
	protected int nbTicks; 
	protected int waitingTime ;
	protected ArrayList<Integer> colisions;
	
	/**
	 * Constructeur de la Simulation
	 * @param e
	 * @param nbTicks
	 * @param gridX
	 * @param gridY
	 * @param canvasX
	 * @param canvasY
	 * @param grilleVisible
	 */
	public SMA(Environment e, int nbTicks,int gridX, int gridY, int canvasX, int canvasY, Boolean grilleVisible, int waitingTime){
		this.environment = e;
		this.nbTicks = nbTicks;
		this.waitingTime = waitingTime;
		colisions = new ArrayList<Integer>();

	}
	
	/**
	 * Lance la simulation dans le mode choisis (Seulement sequential pour le moment)
	 * @throws FileNotFoundException 
	 */
	public abstract void run() throws FileNotFoundException;
	

	
	/**
	 * Mode Sequential : Prends al�atoirement chaque agent l'un apr�s l'autre 
	 * 1 tour = tout les agents interrog�
	 */
	public abstract void sequential();
	
	
}

