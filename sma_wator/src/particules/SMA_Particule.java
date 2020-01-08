package particules;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import core.Agent;
import core.Environment;
import core.SMA;

public class SMA_Particule extends SMA{
	
	private ArrayList<Particule> particules = new ArrayList<Particule>();
	protected Vue vue;
	
	
	public SMA_Particule(Environment e, int nbTicks, int gridX, int gridY, int canvasX, int canvasY,Boolean grilleVisible,int waitingTime) {
		super(e, nbTicks, gridX, gridY, canvasX, canvasY, grilleVisible,waitingTime);
		vue = new Vue(gridX, gridY, canvasX, canvasY,this, grilleVisible);
		addObserver(vue);
		setChanged();
		notifyObservers();
	}

	public void run() throws FileNotFoundException{
		int i = 0;
		PrintStream o = new PrintStream(new File("sma.csv"));
		
		while(i != nbTicks){
			sequential();
			int colision = 0;
			for(Particule a : particules) {
				if(a.getCol()[0] == Color.RED) colision++;
			}
			PrintStream console = System.out;
			
			System.setOut(o);
			System.out.println(i+";"+colision);
			System.setOut(console); 
			
			//System.out.println("It�ration : " + i + " => " + colision + " agents colision�s.");
			System.out.println(i + " " + colision);
			colisions.add(colision);
			i++;
		}
	}
	public void sequential(){
		Collections.shuffle(particules);
		for(Particule a : particules){
			a.decide(environment);
		}
		 try {
			Thread.sleep(this.waitingTime);
			setChanged();
			notifyObservers();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/** 
	 * Ajoute un Particule � la simulation
	 * @param a
	 */
	public void addParticule(Particule a){
		particules.add(a);
		this.environment.addAgent(a.getPosX(), a.getPosY(), a);
	}
	
	/**
	 * Getter de la liste de particule
	 * @return
	 */
	public ArrayList<Particule> getParticules(){
		return this.particules;
	}

}
