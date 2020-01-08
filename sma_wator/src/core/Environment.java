package core;


/**
 * Repr�sente l'environnement o� agissent les Agents
 * Contient un tableau d'Agents de taille gridX sur gridY
 * Peut �tre un plan ou un tore
 * @author Gautier Kasperek Alice Sparrow
 *
 */
public class Environment{
	
	private Agent espace[][];
	private int x, y;
	private Boolean torus;
	
	/**
	 * Constructeur de la classe consturit un tableau d'Agent de taille i,j
	 * @param i
	 * @param j
	 * @param torus
	 */
	public Environment(int i, int j, Boolean torus){
		espace = new Agent[i][j];
		this.setX(i -1);
		this.setY(j-1);
		this.torus = torus;
	}
	
	/**
	 * Getter du tableau d'Agent[][]
	 * @return
	 */
	public Agent[][] getEspace(){
		return this.espace;
	}
	
	/**
	 * Ajoute un Agent dans le tableau d'Agents � la position i, j
	 * Il n'y a pas de test interne, attention � ne pas �craser un Agent
	 * @param i
	 * @param j
	 * @param a
	 */
	public void addAgent(int i, int j, Agent a){
		this.espace[i][j] = a;
	}
	
	/**
	 * Retire l'Agent � la position i,j 
	 * Il n'y a pas de test interne, attention � ne pas �craser un agent
	 * @param i
	 * @param j
	 */
	public void removeAgent(int i, int j){
		this.espace[i][j] = null;
	}

	/**
	 * Getter du dernier indice en abscisse
	 * (i -1) dans le constructeur
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter de x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter de y
	 * Constructeur (j -1)
	 * @return
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Setter de y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Getter de l'Agent � la position x, y 
	 * @param x
	 * @param y
	 * @return
	 */
	public Agent getAgent(int x, int y){
		return getEspace()[x][y];
	}
	
	/**
	 * Getter de la valeur de Torus
	 * @return
	 */
	public Boolean getTorus() {
		return this.torus;
	}
	
	/**
	 * Setter de la valeur de Torus
	 * @param torus
	 */
	public void setTorus(Boolean torus) {
		this.torus = torus;
	}
	
}
