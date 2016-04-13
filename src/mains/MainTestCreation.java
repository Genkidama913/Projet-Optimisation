package mains;

import java.io.IOException;
import java.util.ArrayList;

import championnats.ChampionnatComplexe;
import championnats.ChampionnatSimple;
import matrice.Matrice;
import mutations.MutationSimple;

public class MainTestCreation {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Matrice mat = new Matrice (); 
		ChampionnatSimple test = new ChampionnatSimple(mat);
		//System.out.println("BASE :");
		System.out.println(test.toString());
		System.out.println(new ChampionnatComplexe(mat));
		//System.out.println("Changement du premier  :");
		//System.out.println(MutationSimple.mutationUnique (1, test).toString());
		//System.out.println("Changement aléatoire  :");
		//System.out.println(MutationSimple.mutationUniqueAleatoire(test).toString());
		
		//System.out.println(MutationSimple.nbMutationsMultipleAleatoire(2, test).toString());
		//System.out.println(MutationSimple.mutationsMultiplesAleatoire(test).toString());
	}
	
}
