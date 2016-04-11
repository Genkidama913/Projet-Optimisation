package mains;

import java.io.IOException;

import poules.FonctionsTransverse;

public class MainTestTransverse {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [] tab = FonctionsTransverse.tirage (18);
		for ( int i = 0 ; i < 18 ; i++ ) {
			System.out.println("i = "+i+", tab [i] ="+tab[i]);
		}
		
	}
}
