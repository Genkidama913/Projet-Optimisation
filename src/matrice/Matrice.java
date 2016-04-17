package matrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import parametrage.CSVFile;

/**
 * Matrice est une classe creer une matrice des distances de 18 sur 18 a partir du fichier MatriceDeDistance.csv.
 * 
 * @author Alexandre Enouf
 * @version 1.0
 */

public class Matrice {

	private double [] [] matrice;
	private int taille = 18;
	
	/**
	 * Créée une matrice de double en lisant dans le fichier cvs de matrice.
	 * @return Une matrice de double créée a partir du fichier csv.
	 */
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
	
	/**
	 * Retourne le contenu de matrice [i][j].
	 * @param indice i
	 * @param indice j
	 * @return contenu de matrice [i][j].
	 */
	public double getDistanceBetween(int i, int j) {
		return matrice [i][j];
	}
	
	/**
	 * Retourne la chaine de caractere de la matrice.
	 * @return l'afichage de la matrice [i][j].
	 */
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
	
	/**
	 * Retourne le a taille de la matrice.
	 * @return taille.
	 */
	public int getTaille() {
		return taille;
	}
	
	/**
	 * Retourne le tableau de distance de la ville i.
	 * @param indice i.
	 * @return tableau.
	 */
	public double []  getTabDist(int i) {
		return matrice [i];
	}

}
