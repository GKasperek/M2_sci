package wator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import core.Environment;

public class MainWator {

	public static void main(String[] args) throws FileNotFoundException {
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
		
		Environment environment = new Environment(i, j, torus);
		SMA_Wator wator = new SMA_Wator(environment, nbTicks, gridX, gridY, canvasX, canvasY, grilleVisible,waitingTime); 
		
		Fish nemo = new Fish(5,5,1,1,3);
		
		wator.addSwimmer(nemo);
		
		System.out.println("Running ...");
		wator.run();
		
	}

}
