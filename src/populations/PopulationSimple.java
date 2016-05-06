package populations;

import java.util.ArrayList;
import java.util.Collections;

import championnats.ChampionnatSimple;
import matrice.Matrice;
import mutations.MutationSimple;
import parametrage.Options;

/**
* PopulationSimple est une classe implementant l'interface Population.
* Ici la population est une ArrayListe de championnat simples.
** @author Alexandre Enouf
* @version 1.0
*/

public class PopulationSimple implements Population {

	private ArrayList<ChampionnatSimple> pop;
	private int nbIndiv;
	private int nbSel;
	private int nbMut; 
	
	/**
	 * Creer une population complexe a partir des donnees renseignees dans le fichier de parametrage.
	 * @param matrice
	 * @param options
	 */
	public PopulationSimple (Matrice mat, Options o) {
		this.nbIndiv = o.getNbIndiv();
		nbSel = 35 * nbIndiv / 100; 
		nbMut = 33 * nbIndiv / 100;
		pop = new ArrayList<ChampionnatSimple> (); 
		for ( int i = 0 ; i < o.getNbIndiv() ; i ++ ) {
			pop.add(new ChampionnatSimple (mat,o));
		}
		
	}

	/**
	 * Classe une population simple du meilleur au plus mauvais selon l'evaluation entree en parametre.
	 */
	public void evaluation () {
		Collections.sort (pop);
	}

	/**
	 * Fait la selection/mutation/tirage de nouveaux individus d'une population selon les parameres du fichier de parametrage.
	 * @param Matrice 
	 * @param Options
	 */
	public void selectionAndMutation  (Matrice mat, Options o){
		int i;
		ChampionnatSimple n ; 
		for (i = 1; i <= nbMut ; i ++) {
			n = MutationSimple.mutationsAleatoire(pop.get((int)Math.random()*nbSel),mat,o);
			pop.set (i+nbSel,n);
		}
		for (i = nbSel+nbMut; i < nbIndiv ; i ++) {
			pop.set (i,new ChampionnatSimple(mat,o));
		}
	
	}
	
	/**
	 * retourne le ieme championnat d'une population.
	 * @param i
	 */
	public ChampionnatSimple getChampionnat (int i) {
		return pop.get(i);
	}

}
