package core;

import java.awt.Color;

/**
 * Classe repr�sentant les Agents dans la SMA
 * @author Gautier Kasperek Alice Sparrow
 *
 */
public abstract class  Agent {
	
	protected int posX, posY;
	protected int pasX, pasY;
	private Color[] col = new Color[2];
	protected Boolean vivant = true;
	
	
	/**
	 * Constructeur d'Agent
	 * @param x : Position
	 * @param y : Postion
	 * @param pasX : Direction en X
	 * @param pasY : Direction en Y
	 */
	public Agent(int x, int y, int pasX, int pasY){
		setPosX(x);
		setPosY(y);
		this.setPasX(pasX);
		this.setPasY(pasY);
	}
	
	public abstract void update(Environment environment);
	
	/**
	 * Effectue les tests de colision et de bordures en fonctions de l'environment en param�tre
	 * D�finie la futur position de l'Agent puis le fait avancer � celle-ci
	 * @param environment
	 */
	public abstract void decide(Environment environment);
	
	
	
	/**
	 * Fait avancer l'agent � sa nouvelle poistion calculer gr�ce � son Pas
	 * @param e
	 */
	protected void avancer(Environment e){
		int oldX = this.getPosX();
		int oldY = this.getPosY();
		int newPosX = getPosX() + getPasX();
		int newPosY = getPosY() + getPasY();
		if(e.getTorus()){
			if(newPosX > e.getX()){
				newPosX = newPosX % e.getX()-1;
			}
			if(newPosX < 0){
				newPosX = (newPosX + e.getX()) % e.getX()-1;
			}
			
			if(newPosY > e.getY()){
				newPosY = newPosY % e.getY()+1;
			}
			if(newPosY < 0){
				newPosY = (newPosY + e.getY()) % e.getY()+1;
			}
		}

		setPosX(newPosX);
		setPosY(newPosY);

		e.addAgent(getPosX(), getPosY(), this);
		e.removeAgent(oldX, oldY);
	}

	/**
	 * Getter pas Y
	 * @return
	 */
	public int getPasY() {
		return pasY;
	}
	
	/**
	 * Setter pasY
	 * @param pasY
	 */
	public void setPasY(int pasY) {
		this.pasY = pasY;
	}

	/**
	 * Get PasX
	 * @return
	 */
	public int getPasX() {
		return pasX;
	}

	/**
	 * Setter pasX
	 * @param pasX
	 */
	public void setPasX(int pasX) {
		this.pasX = pasX;
	}

	/**
	 * Getter de la position en Y
	 * @return
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Setter de la position Y
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Getter de la position X
	 * @return
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * setter de la position X
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public Color[] getCol() {
		return col;
	}

	public void setCol(Color col, int i) {
		this.col[i] = col;
	}

	
	public Boolean getVivant() {
		return this.vivant;
	}
	
	public void setVivant(Boolean b) {
		this.vivant = b;
	}

	
	
	
	
}
