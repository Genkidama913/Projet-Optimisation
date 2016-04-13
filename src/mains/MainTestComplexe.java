package mains;

import java.io.IOException;

import matrice.Matrice;
import populations.PopulationComplexe;

public class MainTestComplexe {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Matrice mat = new Matrice ();
		PopulationComplexe p = new PopulationComplexe (500, mat);
		for (int i = 0 ; i< 1000 ; i++) {
			p.evaluation();
			p.selectionAndMutation(30, 40, mat);
		}
		p.evaluation();
		System.out.println(p.getChampionnat(1).toString ());
	}
	
}
