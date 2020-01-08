package wator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import core.Agent;
import particules.Particule;
import particules.SMA_Particule;

public class VueAnimal extends JPanel {
	private SMA_Wator sma;
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
	public VueAnimal(int gridX, int gridY, int canvasX, int canvasY, SMA_Wator sma, Boolean grilleVisible){
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
		for(Nageur nageur : this.sma.getSwimmers()){
			if(nageur.getVivant()) {
				Graphics2D g2d = (Graphics2D) g;
				Ellipse2D.Double circle = new Ellipse2D.Double(nageur.getPosX()*boxSizeX,nageur.getPosY()*boxSizeY,boxSizeX,boxSizeY);
				g2d.setColor(nageur.getCol()[1]);		
		        g2d.fill(circle);
			}
		}
		for(Nageur nextNageur : this.sma.getNextNageurs()) {
			if(nextNageur.getVivant()) {
				Graphics2D g2d = (Graphics2D) g;
				Ellipse2D.Double circle = new Ellipse2D.Double(nextNageur.getPosX()*boxSizeX,nextNageur.getPosY()*boxSizeY,boxSizeX,boxSizeY);
				g2d.setColor(nextNageur.getCol()[0]);		
		        g2d.fill(circle);
			}
		}
	}
}
