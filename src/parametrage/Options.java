package parametrage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Options {
	private int typeChampionnat; // 0 -> simple, 1 -> complexe
	private int nbGen; //nb de générations
	private int nbIndiv; //nb d'individus dans une population
	private int evaluation; //0 -> distance, 1 -> equilibre, 2 -> mixte
	private int pourcentageDistance; // Si evaluation mixte
	private int pourcentageSelection;
	private int pourcentageMutation;
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
		ligne = br.readLine();
		line = ligne.split(";");
		pourcentageSelection = Integer.parseInt(line[1]);
		ligne = br.readLine();
		line = ligne.split(";");
		pourcentageMutation = Integer.parseInt(line[1]);
		
		br.close();
	}

	public int getTypeChampionnat() {
		return typeChampionnat;
	}

	public int getNbGen() {
		return nbGen;
	}

	public int getNbIndiv() {
		return nbIndiv;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public int getPourcentageDistance() {
		return pourcentageDistance;
	}

	public int getPourcentageSelection(){
		return pourcentageSelection;
	}
	public int getPourcentageMutation(){
		return pourcentageMutation;
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
		ret = ret + "Pourcentage des meilleurs éléments gardés dans une population lors de la creation d'une nouvelle génération:\t"+getPourcentageSelection()+"\n";
		ret = ret + "Pourcentage du nombre d'éléments mutés dans une population lors de la creation d'une nouvelle génération:\t"+getPourcentageMutation()+"\n";
		ret = ret + "===============================================================================\n";
		return ret;
	}
}
