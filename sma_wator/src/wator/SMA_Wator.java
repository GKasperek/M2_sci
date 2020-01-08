package wator;
import core.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import core.Agent;
import core.Environment;
import core.SMA;
import particules.Vue;

public class SMA_Wator extends SMA{
	
	private ArrayList<Nageur> nageurs = new ArrayList<Nageur>();
	private ArrayList<Nageur> nextNageurs = new ArrayList<Nageur>();
	protected VueWater vue;
	

	public SMA_Wator(Environment e, int nbTicks, int gridX, int gridY, int canvasX, int canvasY, Boolean grilleVisible,int waitingTime) {
		super(e, nbTicks, gridX, gridY, canvasX, canvasY, grilleVisible, waitingTime);
		vue = new VueWater(gridX, gridY, canvasX, canvasY,this, grilleVisible);
		addObserver(vue);
		setChanged();
		notifyObservers();
	}

	@Override
	public void run() throws FileNotFoundException {
		int i = 0;
		//PrintStream o = new PrintStream(new File("sma_wator.csv"));
		
		while(i != nbTicks) {
			sequential();
			this.cleanNageur();
			i++;
		}
	}

	@Override
	public void sequential() {
		Collections.shuffle(nageurs);
		for(Nageur n : nageurs) {
			n.decide(this.environment, this);
		}
		try {

			Thread.sleep(this.waitingTime);
			setChanged();
			notifyObservers();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addSwimmer(Nageur n) {
		nextNageurs.add(n);
		this.environment.addAgent(n.getPosX(), n.getPosY(), n);
	}
	
	public ArrayList<Nageur> getSwimmers(){
		return this.nageurs;
	}
	
	public ArrayList<Nageur> getNextNageurs(){
		return this.nextNageurs;
	}
	
	public void cleanNageur() {
		for(Nageur n : nextNageurs) {
			if(n.getVivant()) {
				nageurs.add(n);
			}
		}
		nextNageurs.clear();
	}

}
