package mains;

import java.io.IOException;

import championnats.FonctionsTransverse;
import matrice.Matrice;

public class MainTestTransverse {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [] tab = FonctionsTransverse.tirage (18);
		for ( int i = 0 ; i < 18 ; i++ ) {
			System.out.println("i = "+i+", tab [i] ="+tab[i]);
		}
		Matrice mat = new Matrice() ;
		double a = 0;
		for (int i = 0 ; i< 18; i++) {
			for (int j = i ; j< 18; j++) {
				a += mat.getDistanceBetween(i, j);
			}
		}
		System.out.println(a/2);

	}
}
