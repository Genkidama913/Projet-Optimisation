package OLD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatriceDistances {

	private Double [][] distances;
	
	public MatriceDistances () throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(Parametrage.csvFile));
		String ligne = null;
		int i = 0;
		
		while ((ligne = br.readLine()) != null) {
			
			// Retourner la ligne dans un tableau
			String[] line = ligne.split(";");
			
			// Transfert la ligne lue dans un tableau de Doubles
			for (int j = 0 ; j < line.length ; j++) {	
				distances [i][j]  = Double.parseDouble(line[j]);
			}
			i++;
		}
		br.close();
	}
	
	public Double getCase (int i, int j) {
		return distances [i][j];
	}
	
	public Boolean distancesBienRemplies () {
		int i = 0;
		if (distances.length == Parametrage.nombreEquipes) {
			while (i<Parametrage.nombreEquipes && distances[i].length == Parametrage.nombreEquipes) {
				i++;
			}
		}
		return (i == 18);
	}
	
}