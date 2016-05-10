package mutations;

import championnats.ChampionnatSimple;
import matrice.Matrice;
import parametrage.Options;

/**
 * MutationSimple est une classe qui renseigne les differentes types de mutations d'un ChampionnatSimple.
 * 
 * @author Alexandre Enouf
 * @version 1.0
 */

public class MutationSimple {

	/**
	 * Cree un nouveau championnat simple a partir de celui donne en parametre en changeant aleatoirement une equipe dans chaques poules.
	 * @param championnat simple
	 * @param matrice
	 * @param options
	 * @return un nouveau championnat simple.
	 */
	public static ChampionnatSimple mutationUniqueAleatoire (ChampionnatSimple champ, Matrice mat,Options o) {
		int i =  (int) (Math.random()*8) ;
		int [] champi = champ.getChampionnatSimple();
		int swap = champi[i] ;
		champi[i] = champi [i + 9];
		champi [i + 9] = swap;
		ChampionnatSimple nouveau = new ChampionnatSimple (champi, mat,o);
		return nouveau ;
	}

	/**
	 * Cree un nouveau championnat simple a partir de celui donne en parametre en effectuant un nombre donne de mutations simples aleaoires.
	 * @parem Un nombre de mutations a effectuer
	 * @param championnat simple
	 * @param matrice
	 * @param options
	 * @return un nouveau championnat simple.
	 */
	public static ChampionnatSimple nbMutationsAleatoire (int nb, ChampionnatSimple champ, Matrice mat,Options o) {
		int i;
		int [] champi= champ.getChampionnatSimple();
		int swap;
		for (int j = 0 ; j< nb ; j ++) {
			i =  (int)(Math.random()*8) ;
			swap = champi[i] ;
			champi[i] = champi [i + 9];
			champi [i + 9] = swap;
		}

		ChampionnatSimple nouveau = new ChampionnatSimple (champi, mat,o);
		return nouveau ;
	}

	/**
	 * Cree un nouveau championnat simple a partir de celui donne en parametre en effectuant aleatoirement entre 1 et 6 mutations simples aleaoires.
	 * @parem Un nombre de mutations a effectuer
	 * @param championnat simple
	 * @param matrice
	 * @param options
	 * @return un nouveau championnat simple.
	 */
	public static ChampionnatSimple mutationsAleatoire (ChampionnatSimple champ, Matrice mat,Options o) {
		int i;
		int nb = (int)(Math.random()*5)+1 ;
		for (int j = 0 ; j< nb ; j ++) {
			i = (int)Math.random();
			if (i==0) {
				champ = mutationUniqueAleatoire(champ, mat,o);
			} else {
				champ = nbMutationsAleatoire(j, champ, mat,o);
			}
		}
		return champ ;
	}
}
