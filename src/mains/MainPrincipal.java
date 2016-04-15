package mains;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import matrice.Matrice;
import parametrage.Options;
import populations.Population;
import populations.PopulationComplexe;
import populations.PopulationSimple;

public class MainPrincipal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Matrice mat = new Matrice ();
		Options o = new Options();
		Population p ;

		//Trirage de la population
		if (o.getTypeChampionnat() == 0 ) {
			p = new PopulationSimple (mat,o);
		} else {
			p = new PopulationComplexe (mat,o);
		}
		
		// Ecriture des resultats dans le fichier
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Resultats/Resultats_"+LocalDateTime.now()+".txt")));
			// normalement si le fichier n'existe pas, il est crée à la racine du projet
			writer.write(o.toString());
			writer.write("\n\nPremière Génération\n\n");
			writer.write("Championnat 1 : \n---------------\n");
			writer.write( p.getChampionnat(0).toString2());
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbGen()/2+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbGen()/2).toString2()); 
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbGen()+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbGen()-1).toString2()); 

			//Algo Génétique 
			for (int i = 0 ; i< o.getNbGen() ; i++) {
				p.evaluation();
				p.selectionAndMutation(mat,o);
			}
			p.evaluation();


			writer.write("===============================================================================\n");
			writer.write("\n\nDernière Génération\n\n");
			writer.write("Championnat 1 : \n---------------\n");
			writer.write( p.getChampionnat(0).toString2());
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbGen()/2+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbGen()/2).toString2()); 
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbGen()+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbGen()-1).toString2()); 
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}