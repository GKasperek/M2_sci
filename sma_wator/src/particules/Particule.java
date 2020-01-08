package particules;

import java.awt.Color;

import core.Agent;
import core.Environment;

public class Particule extends Agent{
	public Particule(int x, int y, int pasX, int pasY) {
		super(x, y, pasX, pasY);
		this.setCol(Color.DARK_GRAY,0);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Effectue les tests de colision et de bordures en fonctions de l'environment en param�tre
	 * D�finie la futur position de l'Agent puis le fait avancer � celle-ci
	 * @param environment
	 */
	public void decide(Environment environment){

		int newPosX;
		int newPosY;
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
	
		int i = 0;
			
		if(newPosX >= 0 && newPosX < environment.getX() && newPosY >= 0 && newPosY < environment.getY()) {
			while((environment.getEspace()[newPosX][newPosY] != null) && (i < 8)){
				Particule colAgent = (Particule) environment.getAgent(newPosX,newPosY);
				int colPasX = colAgent.getPasX();
				int colPasY = colAgent.getPasY();
				colAgent.setPasX(this.getPasX());
				colAgent.setPasY(this.getPasY());
				this.setPasX(colPasX);
				this.setPasY(colPasY);
				this.setCol(Color.RED,0);
				colAgent.setCol(Color.RED,0);
				i++;
			}
		
		}
		this.update(environment);

		
	}


	@Override
	public void update(Environment environment) {
		this.avancer(environment);		
	}
	
}
