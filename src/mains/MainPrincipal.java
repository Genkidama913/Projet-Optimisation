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

/**
 * MainPrincipal est le main principal du programme.
 * Il lit les parametres du fichier Parametrage.csv, et fait le programme en consequence. 
 * Ecrit dans un fichier de resultats les parametres, le meilleur championnat, celui du milieu et le dernier d'une population. 
 * De la premiere, milieu et de la derniere generation de population.
 * 
 * @author Alexandre Enouf
 * @version 1.0
 */

public class MainPrincipal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Matrice mat = new Matrice ();
		Options o = new Options();
		Population p ;

		// Ecriture des resultats dans le fichier
		try {

			//Trirage de la population
			if (o.getTypeChampionnat() == 0 ) {
				p = new PopulationSimple (mat,o);
			} else {
				p = new PopulationComplexe (mat,o);
			}

			p.evaluation();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Resultats/Resultats_"+LocalDateTime.now()+".txt")));
			// normalement si le fichier n'existe pas, il est crée à la racine du projet
			writer.write(o.toString());
			writer.write("Première Génération\n\n");
			writer.write("Championnat 1 : \n---------------\n");
			writer.write( p.getChampionnat(0).toString());
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbIndiv()/2+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbIndiv()/2).toString()); 
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbIndiv()+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbIndiv()-1).toString()); 
			writer.write("\n===============================================================================\n");

			//Algo Genetique 
			for (int i = 0 ; i< o.getNbGen() ; i++) {
				p.selectionAndMutation(mat,o);
				p.evaluation();
				if ( (i == (int)o.getNbGen()/2) || (i== (int)o.getNbGen()-1) ) {
					
				}
			}
			
			writer.write(o.getNbGen()+"ème Génération\n\n");
			writer.write("Championnat 1 : \n---------------\n");
			writer.write( p.getChampionnat(0).toString());
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbIndiv()/2+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbIndiv()/2).toString()); 
			writer.write("\n\n");
			writer.write("Championnat "+o.getNbIndiv()+" : \n---------------\n");
			writer.write( p.getChampionnat(o.getNbIndiv()-1).toString()); 

			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}