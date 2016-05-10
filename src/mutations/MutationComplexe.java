package mutations;

import championnats.ChampionnatComplexe;
import matrice.Matrice;
import parametrage.Options;

/**
 * MutationComplexe est une classe qui renseigne les differentes types de mutations d'un ChampionnatComplexe.
 * 
 * @author Alexandre Enouf
 * @version 1.0
 */

public class MutationComplexe {

	/**
	 * Cree un nouveau championnat complexe a partir de celui donne en parametre en changeant une equipe entre deux groupes eloignes.
	 * @param championnat complexe
	 * @param matrice
	 * @param options
	 * @return un nouveau championnat complexe.
	 */
	public static ChampionnatComplexe mutationUniqueGroupeEloigne (ChampionnatComplexe champ, Matrice mat, Options o) {
		int [] champi = champ.getChampionnatComplexe();
		int i = (int)(Math.random()*5);
		int swap = champi[i] ;
		champi[i] = champi [i + 6];
		champi [i + 6] = swap;
		ChampionnatComplexe nouveau = new ChampionnatComplexe (champi, mat,o);
		return nouveau ;
	}

	/**
	 * Cree un nouveau championnat complexe a partir de celui donne en parametre en changeant une equipe entre deux groupes proches.
	 * @param championnat complexe
	 * @param matrice
	 * @param options
	 * @return un nouveau championnat complexe.
	 */
	public static ChampionnatComplexe mutationUniqueGroupeProche (ChampionnatComplexe champ, Matrice mat,Options o) {
		int [] champi = champ.getChampionnatComplexe();
		int swap;
		int i = (int)(Math.random()*2);
		if ((int)Math.random()==1) {
			i=i+6;
			swap = champi[i] ;
			champi[i] = champi [i + 3];
			champi [i + 3] = swap;
		} else {
			swap = champi[i] ;
			champi[i] = champi [i + 3];
			champi [i + 3] = swap;
		}
		ChampionnatComplexe nouveau = new ChampionnatComplexe (champi, mat,o);
		return nouveau ;
	}

	/**
	 * Cree un nouveau championnat complexe a partir de celui donne en parametre en effectuant entre 1 et 5 mutation(s).
	 * Chaque mutation est aleatoirement une mutation proche ou une mutation eloignee.
	 * @param championnat complexe
	 * @param matrice
	 * @param options
	 * @return un nouveau championnat complexe.
	 */
	public static ChampionnatComplexe mutationsAleatoire ( ChampionnatComplexe champ, Matrice mat,Options o) {
		int nbMut = (int)(Math.random()*5) + 1;
		for (int i = 0 ; i < nbMut; i++){
			if ((int)(Math.random()) == 1){
				champ = mutationUniqueGroupeProche (champ, mat,o);
			} else {
				champ = mutationUniqueGroupeEloigne (champ, mat,o);
			}
		}
		return champ ;
	}
}
