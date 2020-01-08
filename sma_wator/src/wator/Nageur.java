package wator;

import core.Agent;
import core.Environment;

public abstract class Nageur extends Agent {

	protected int gestationTime;
	protected int gestation = 0;


	public Nageur(int x, int y, int pasX, int pasY, int gestationTime) {
		super(x, y, pasX, pasY);
		this.gestationTime = gestationTime;
	}

	
	public abstract void update(Environment environment, SMA_Wator sma);

	
	public abstract void decide(Environment environment, SMA_Wator sma);

	
	public void setRandomPas() {
		double dir = Math.random();
		if(dir < 0.3) {
			this.pasX = 0;
		}else if(dir < 0.65) {
			this.pasX = 1;
		}else {
			this.pasX = -1;
		}
		
		dir = Math.random();
		if(dir < 0.3) {
			this.pasY = 0;
		}else if(dir < 0.65){
			this.pasY = 1;
		}else {
			this.pasY = -1;
		}
	}

}
