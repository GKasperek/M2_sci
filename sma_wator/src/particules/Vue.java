package particules;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import core.SMA;

/**
 * JFrame qui contient les vues de la SMA
 * @author Gautier Kasperek Alice Sparrow
 * Oberver Java Patron : D�pr�ci� /!\
 */
public class Vue extends JFrame implements Observer {

	private int gridSizeX, gridSizeY;
	private int canvasSizeX, canvasSizeY;
	private int boxSizeX, boxSizeY;
	
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	/**
	 * Constructeur du frame
	 * Instancie le panel de la grille et des agents
	 * @param gridX : Nombre de carreaux souhait�s
	 * @param gridY : Nombre de varreaux souhait�s
	 * @param canvasX : Taille en pixel du canvas
	 * @param canvasY : Taille en pixel du canvas
	 * @param sma : SMA associ� � la vue
	 * @param visibleGrille
	 */
	public Vue(int gridX, int gridY, int canvasX, int canvasY,SMA_Particule sma, Boolean visibleGrille){ 
		VueGrille grille = new VueGrille(gridX, gridY,canvasX,canvasY,sma, visibleGrille);
	    this.setTitle("SMA");
	    this.setLocationRelativeTo(null);
	    this.setExtendedState(MAXIMIZED_BOTH);
	    
	   /* JScrollPane scrollPane = new JScrollPane(grille);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBounds(0, 0, 30, 700);*/
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    
		this.gridSizeX = gridX;
		this.gridSizeY = gridY;
		this.canvasSizeX = canvasX;
		this.canvasSizeY = canvasY;
		this.boxSizeX = canvasSizeX/gridSizeX;
		this.boxSizeY = canvasSizeY/gridSizeY;
		this.setSize(canvasSizeX, canvasSizeY);
		this.setContentPane(grille);
		this.setVisible(true);
		
	}
	
}
