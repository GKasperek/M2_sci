package particules;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import core.Environment;
import core.SMA;

/**
 * Main class, initialise les diff�rents �l�ments de la simulation
 * Permet le param�trage de celle-ci.
 * @author Gautier Kasperek Alice Sparrow
 *
 */
public class Main {

	/**
	 * Main function
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int nbAgent=0;
		
		int canvasX=0;
		int canvasY=0;
		
		int gridX=0;
		int gridY=0;
		
		int nbTicks=0;
		int waitingTime = 0;
		Boolean torus = false;
		
		Boolean grilleVisible = false;
		
		String fileName = "src/properties.txt"; 
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while(line != null){
				String[] parts = line.split(":");
				if(parts[0].trim().equals("nbAgent")){
					nbAgent = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("canvasX")){
					canvasX = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("canvasY")){
					canvasY = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("gridX")){
					gridX = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("gridY")){
					gridY = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("nbTicks")){
					nbTicks = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("tmps")){
					waitingTime = Integer.parseInt(parts[1].trim());
				}
				if(parts[0].trim().equals("torus")){
					torus = Boolean.parseBoolean(parts[1].trim()) ;
				}
				if(parts[0].trim().equals("grille")){
					grilleVisible = Boolean.parseBoolean(parts[1].trim());
				}
				
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e ){
			e.printStackTrace();
		}
		int i = (int) gridX;
		int j = (int) gridY;
		
		 
		
		Environment environment = new Environment(i,j, torus);
		SMA_Particule sma = new SMA_Particule(environment, nbTicks, gridX, gridY, canvasX, canvasY, grilleVisible,waitingTime); 
		
		for(int f = 0; f < nbAgent; f++) {
			int x = (int) (Math.random() * (gridX));
			int y = (int) (Math.random() * (gridY));
			int pasX;
			int pasY;
			if(Math.random() <0.5) {
				pasX = -1;
			}else {
				pasX = 1;
			}
			if(Math.random() <0.5) {
				pasY = -1;
			}else {
				pasY = 1;
			}
			if(environment.getAgent(x, y) == null) {
				sma.addParticule(new Particule(x,y,pasX,pasY));
			}
		}	
		//Vue v = new Vue(70,70,700,700);
		System.out.println("Running ...");
		sma.run();
	}


}
