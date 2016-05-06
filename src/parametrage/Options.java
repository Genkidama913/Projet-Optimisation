package parametrage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Options est une classe regroupant les options renseignees dans le fichier de parametrage.
 * @author Alexandre Enouf
 * @version 1.0
 */
public class Options {
	private int typeChampionnat; // 0 -> simple, 1 -> complexe
	private int nbGen; //nb de générations
	private int nbIndiv; //nb d'individus dans une population
	private int evaluation; //0 -> distance, 1 -> equilibre, 2 -> mixte
	private int pourcentageDistance; // Si evaluation mixte
	/**
	 * Creer une instance d'options a partir d'un fichier de parametres. 
	 * Options prises en compte :
	 * - type de Championnat (0 pour des poules simples, 1 pour des poules complexes)
	 * - nombre de generations pour l'algorithme genetique
	 * - nombre de championnats par populations
	 * - type d'evaluation (0 pour evaluet la distance, 1 l'equilibre des poules et 2 pour une evaluation par moyenne ponderee)
	 * - pourcentage de la distance lors d'une evaluation par moyenne ponderee (100 - pourcentage distance pour l'equilibre des poules)
	 * - pourcentage des meilleurs elements gardes apres chaque evaluation
	 * - pourcentage d'element a muter
	 * @param Eq12 [12]
	 * @param matrice des distances
	 * @param les options du fichier de parametrage
	 * @return Un Championnat complexe
	 */
	public Options () throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(CSVFile.FicParam));
		String ligne = null;
		
		ligne = br.readLine();
		String[] line = ligne.split(";");
		typeChampionnat=Integer.parseInt(line[1]); // 0 -> simple, 1 -> complexe
		ligne = br.readLine();
		line = ligne.split(";");
		nbGen=Integer.parseInt(line[1]); //nb de générations
		ligne = br.readLine();
		line = ligne.split(";");
		nbIndiv=Integer.parseInt(line[1]); //nb d'individus dans une population
		ligne = br.readLine();
		line = ligne.split(";");
		evaluation=Integer.parseInt(line[1]); //0 -> distance, 1 -> equilibre, 3 -> mixte
		ligne = br.readLine();
		line = ligne.split(";");
		pourcentageDistance=Integer.parseInt(line[1]); // Si evaluation mixte
		
		br.close();
	}
	
	/**
	 * Retourne le type de championnat. O pour des poules simples, 1 pour des poules complexes.
	 * @return le type de championnat.
	 */
	public int getTypeChampionnat() {
		return typeChampionnat;
	}

	/**
	 * Retourne le nombre de generation a faire. O pour des poules simples, 1 pour des poules complexes.
	 * @return le nombre de generations.
	 */
	public int getNbGen() {
		return nbGen;
	}

	/**
	 * Retourne le nombre d'individus par populations 
	 * * @return le nombre d'individus.
	 */
	public int getNbIndiv() {
		return nbIndiv;
	}

	/**
	 * Retourne le type d'evaluations.
	 * * @return le type d'evaluations.
	 */
	public int getEvaluation() {
		return evaluation;
	}

	/**
	 * Retourne le coeficient de la distance pour la moyenne ponderee.
	 * @return ceoficient de la distance.
	 */
	public int getPourcentageDistance() {
		return pourcentageDistance;
	}
	
	public String toString () {
		String ret = "===============================================================================\n";
		ret = ret + "Paramétrage\n";
		ret = ret + "-----------\n";
		ret = ret + "Type de championnat :\t"+getTypeChampionnat()+"\n";
		ret = ret + "Nombre de générations:\t"+getNbGen()+"\n";
		ret = ret + "Nombre d'individus:\t"+getNbIndiv()+"\n";
		ret = ret + "Type d'évaluation:\t"+getEvaluation()+"\n";
		ret = ret + "Pourcentage de la distance dans l'evaluation:\t"+getPourcentageDistance()+"\n";
		ret = ret + "Pourcentage des meilleurs éléments sélectionnés et gardés:\t35 (fixe)\n";
		ret = ret + "Pourcentage du nombre de mutations dans une population lors de la creation d'une nouvelle génération:\t33 (fixe)\n";
		ret = ret + "===============================================================================\n";
		return ret;
	}
}
