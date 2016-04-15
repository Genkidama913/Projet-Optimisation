package matrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import parametrage.CSVFile;

public class Matrice {

	private double [] [] matrice;
	private int taille = 18;
	
	public Matrice () throws NumberFormatException, IOException {
		
		matrice = new double [18][18];
		
		BufferedReader br = new BufferedReader(new FileReader(CSVFile.csvFile18));
		String ligne = null;
		int i = 0;
		
		while ( ((ligne = br.readLine()) != null) && i < 18 ) {
			
			// Retourner la ligne dans un tableau
			String[] line = ligne.split(";");
			//System.out.println("====="+i+"=====");
			// Transfert la ligne lue dans un tableau de Doubles
			for (int j = 0 ; j < line.length ; j++) {	
				//System.out.println(j+" : "+line[j]);
				matrice [i][j]  = Double.parseDouble(line[j]);
			}
			i++;
		}
		br.close();
	}
	
	public double getDistanceBetween(int i, int j) {
		return matrice [i][j];
	}
	
	public String toString () {
		String ret = "";
		for (int i = 0 ; i < 18 ; i++) {
			for (int j = 0 ; j < 18 ; j++) {
				ret = ret +matrice[i][j]+"\t" ;
			}
			ret = ret + "\n";
		}
		return ret;
	}

	public int getTaille() {
		return taille;
	}
	public double []  getTabDist(int i) {
		return matrice [i];
	}

}
