package wator;

import java.awt.Color;

import core.Agent;
import core.Environment;

public class Shark extends Nageur {
	

	public Shark(int x, int y, int pasX, int pasY, int gestationTime) {
		super(x, y, pasX, pasY, gestationTime);
		this.setCol(Color.PINK, 0);
		this.setCol(Color.RED , 1);
	}

	public void decide(Environment environment, SMA_Wator sma) {
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
	
	public void reproduct(Environment environment, int x, int y, SMA_Wator sma) {
		sma.addSwimmer(new Shark(x,y,0,0,this.gestationTime));
	}
	
	@Override
	public void decide(Environment environment) {

	}

	@Override
	public void update(Environment environment) {
		
	}

	@Override
	public void update(Environment environment, SMA_Wator sma) {
		// TODO Auto-generated method stub
		
	}

}
