package mains;

import java.io.IOException;

import matrice.Matrice;
import populations.PopulationSimple;

public class MainTestSimple {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Matrice mat = new Matrice ();
		PopulationSimple p = new PopulationSimple (5000, mat);
		for (int i = 0 ; i< 1000 ; i++) {
			p.evaluation();
			p.selectionAndMutation(30, 40, mat);
		}
		p.evaluation();
		System.out.println(p.getChampionnat(1).toString ());
	}
	
}
