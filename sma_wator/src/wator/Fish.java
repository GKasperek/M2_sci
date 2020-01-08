package wator;

import java.awt.Color;

import core.Agent;
import core.Environment;
import particules.Particule;

public class Fish extends Nageur {

	public Fish(int x, int y, int pasX, int pasY, int gestation) {
		super(x, y, pasX, pasY, gestation);
		this.setCol(Color.YELLOW,0);
		this.setCol(Color.GREEN, 1);
	}

	
	public void decide(Environment environment,SMA_Wator sma) {
		int newPosX;
		int newPosY;
		
		this.setRandomPas();

		if(environment.getTorus()){
			newPosX = getPosX() + getPasX() ;
			newPosY = getPosY() + getPasY();
			
			if(newPosX > environment.getX()){
				newPosX = newPosX % environment.getX();
			}
			if(newPosX < 0){
				newPosX = (newPosX + environment.getX()) % environment.getX();
			}
			
			if(newPosY > environment.getY()){
				newPosY = newPosY % environment.getY();
			}
			if(newPosY < 0){
				newPosY = (newPosY + environment.getY()) % environment.getY();
			}
			
		}
		else{
			newPosX = getPosX() + getPasX();
			newPosY = getPosY() + getPasY();
			if(newPosX < 0 || newPosX > environment.getX()){
				setPasX(- getPasX());
			}
			if(newPosY < 0 || newPosY > environment.getY()){
				setPasY(- getPasY());
				
			}
		}
		
		if(environment.getEspace()[newPosX][newPosY] != null && environment.getEspace()[newPosX][newPosY].getVivant()){
			setPasX(0);
			setPasY(0);
		}
		
		gestation+= 1;

		this.update(environment,sma);
	}

	@Override
	public void update(Environment environment, SMA_Wator sma) {
		if(gestation == this.gestationTime && !(this.pasX == 0 && this.pasY == 0)) {
			int childX = this.posX;
			int childY = this.posY;
			this.avancer(environment);
			this.reproduct(environment, childX, childY, sma);
			gestation = 0;
		}else {
			this.avancer(environment);
		}
	}
	
	public void reproduct(Environment environment, int x, int y, SMA_Wator sma) {
		sma.addSwimmer(new Fish(x,y,0,0,this.gestationTime));
	}
	
	public Boolean getVivant() {
		return vivant;
	}

	public void setVivant(Boolean vivant) {
		this.vivant = vivant;
	}

	public int getGestationTime() {
		return gestationTime;
	}

	public void setGestationTime(int gestationTime) {
		this.gestationTime = gestationTime;
	}

	public int getGestation() {
		return gestation;
	}

	public void setGestation(int gestation) {
		this.gestation = gestation;
	}


	@Override
	public void decide(Environment environment) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Environment environment) {
		// TODO Auto-generated method stub
		
	}

	
}
