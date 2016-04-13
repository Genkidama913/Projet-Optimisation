package mutations;

import championnats.ChampionnatSimple;
import matrice.Matrice;

public class MutationSimple {

	// creer un nouveau championat a partir de celui donné en parametre, en echangeat la aleatoirement la ieme equipe de chaque poule par celle de l'autre
	public static ChampionnatSimple mutationUniqueAleatoire (ChampionnatSimple champ, Matrice mat) {
		int i =  (int) (Math.random()*8) ;
		int [] champi = champ.getChampionnatSimple();
		int swap = champi[i] ;
		champi[i] = champi [i + 9];
		champi [i + 9] = swap;
		ChampionnatSimple nouveau = new ChampionnatSimple (champi, mat);
		return nouveau ;
	}


	public static ChampionnatSimple nbMutationsAleatoire (int nb, ChampionnatSimple champ, Matrice mat) {
		int i;
		int [] champi= champ.getChampionnatSimple();
		int swap;
		for (int j = 0 ; j< nb ; j ++) {
			i =  (int)(Math.random()*8) ;
			swap = champi[i] ;
			champi[i] = champi [i + 9];
			champi [i + 9] = swap;
		}

		ChampionnatSimple nouveau = new ChampionnatSimple (champi, mat);
		return nouveau ;
	}

	
	public static ChampionnatSimple mutationsAleatoire (ChampionnatSimple champ, Matrice mat) {
		int i;
		int nb = (int)(Math.random()*5)+1 ;
		for (int j = 0 ; j< nb ; j ++) {
			i = (int)Math.random();
			if (i==0) {
				champ = mutationUniqueAleatoire(champ, mat);
			} else {
				champ = nbMutationsAleatoire(j, champ, mat);
			}
		}
		return champ ;
	}
}
