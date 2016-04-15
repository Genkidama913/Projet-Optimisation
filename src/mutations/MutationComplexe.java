package mutations;

import championnats.ChampionnatComplexe;
import matrice.Matrice;
import parametrage.Options;

public class MutationComplexe {
	
	public static ChampionnatComplexe mutationUniqueGroupeEloigne (ChampionnatComplexe champ, Matrice mat, Options o) {
		int [] champi = champ.getChampionnatComplexe();
		int i = (int)(Math.random()*5);
		int swap = champi[i] ;
		champi[i] = champi [i + 6];
		champi [i + 6] = swap;
		ChampionnatComplexe nouveau = new ChampionnatComplexe (champi, mat,o);
		return nouveau ;
	}

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
	
	// effectue entre 1 et 6 mutations uniques
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
	
	public static ChampionnatComplexe nbMutationsAleatoire ( int nbMut,ChampionnatComplexe champ, Matrice mat,Options o) {
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
