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
	
	/**
	 * Creer une population complexe a partir des données rensegnées dans le fichier de parametrage
	 * @param matrice
	 * @param options
	 */
	public PopulationSimple (Matrice mat, Options o) {
		this.nbIndiv = o.getNbIndiv();
		pop = new ArrayList<ChampionnatSimple> (); 
		for ( int i = 0 ; i < o.getNbIndiv() ; i ++ ) {
			pop.add(new ChampionnatSimple (mat,o));
		}
	}

	/**
	 * Classe une population simple du meilleur au plus mauvais selon l'evaluation entrée en parametre
	 */
	public void evaluation () {
		Collections.sort (pop);
	}

	/**
	 * Fait la selection/mutation/tirage de nouveaux individus d'une population selon les parameres du fichier de parametrage
	 * @param Matrice 
	 * @param Options
	 */
	public void selectionAndMutation  (Matrice mat, Options o){
		int pourcentageSel = o.getPourcentageSelection();
		int pourcentageMut = o.getPourcentageMutation();
		int pourcTot = pourcentageSel + pourcentageMut,i;
		ChampionnatSimple n ;
		if ( pourcTot >= 0 || pourcTot <= 100 ) {
			pourcentageSel =50 ;
			pourcentageMut = 25 ;
		} 
		int nbSel = (pourcentageSel/100) * nbIndiv; 
		int nbMut = (pourcentageMut/100) * nbIndiv; 
		for (i = 0; i<nbMut ; i ++) {
			n = MutationSimple.mutationsAleatoire(pop.get(i),mat,o);
			pop.set (i+nbSel,n);	
		}
		for (i = nbSel+nbMut; i< nbIndiv ; i ++) {
			pop.set (i,new ChampionnatSimple(mat,o));
		}
	
	}
	
	/**
	 * retourne le ieme championnat d'une population
	 * @param i
	 */
	public ChampionnatSimple getChampionnat (int i) {
		return pop.get(i);
	}

}
