package particules;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import core.SMA;


/**
 * Vue grille dessine la grille (s'il faut) et les agents
 * @author Gautier Kasperek Alice Sparrow
 *
 */
public class VueGrille extends JPanel{
	private SMA_Particule sma;
	protected int gridSizeX, gridSizeY;
	protected int canvasSizeX, canvasSizeY;
	protected int boxSizeX, boxSizeY;
	
	protected Boolean grilleVisible = false;
	
	/**
	 * Constructeur du panel
	 * @param gridX : Nombre de carreaux suhait�s
	 * @param gridY : Nombre de carreaux souhait�s
	 * @param canvasX : Taille du canvas
	 * @param canvasY : Taille du canvas
	 * @param sma : SMA Associ�
	 * @param grilleVisible
	 */
	public VueGrille(int gridX, int gridY, int canvasX, int canvasY, SMA_Particule sma, Boolean grilleVisible){
		this.gridSizeX = gridX;
		this.gridSizeY = gridY;
		this.canvasSizeX = canvasX;
		this.canvasSizeY = canvasY;
		this.boxSizeX = canvasSizeX/gridSizeX;
		this.boxSizeY = canvasSizeY/gridSizeY;
		this.setSize(canvasSizeX, canvasSizeY);
		this.sma = sma;
		this.grilleVisible = grilleVisible;
	}
	
	/**
	 * Peinds la grille si n�cessaire et les agents en fonction de leur couleur
	 * 
	 */
	
	public void paintComponent(Graphics g){
		
		int i;
		
		if(this.grilleVisible) {
			for( i = 0; i < gridSizeX; i++)
				g.drawLine(0, i*this.boxSizeX , canvasSizeY, i*this.boxSizeX );
			
			for(i = 0; i < gridSizeY; i++)
				g.drawLine(i * this.boxSizeY, 0,  i*this.boxSizeY, canvasSizeX);
		}
		//System.out.println("Painting");
		for(Particule agent : this.sma.getParticules()){
			//System.out.println(agent.getPosX() +" "+ agent.getPosY());
			Graphics2D g2d = (Graphics2D) g;
			Ellipse2D.Double circle = new Ellipse2D.Double(agent.getPosX()*boxSizeX,agent.getPosY()*boxSizeY,boxSizeX,boxSizeY);
			

			g2d.setColor(agent.getCol()[0]);

			
	        g2d.fill(circle);
		}
	}
}
