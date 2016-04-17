package populations;

import java.util.ArrayList;
import java.util.Collections;

import championnats.ChampionnatComplexe;
import matrice.Matrice;
import mutations.MutationComplexe;
import parametrage.Options;

/**
* PopulationComplexe est une classe implementant l'interface Population.
* Ici la population est une ArrayListe de championnat complexes.
** @author Alexandre Enouf
* @version 1.0
*/

public class PopulationComplexe implements Population{
	
	private ArrayList<ChampionnatComplexe> pop;
	private int nbIndiv;
	
	/**
	 * Creer une population complexe a partir des données rensegnées dans le fichier de parametrage
	 * @param mat
	 * @param o
	 */
	public PopulationComplexe ( Matrice mat, Options o) {
		this.nbIndiv = o.getNbIndiv();
		pop = new ArrayList<ChampionnatComplexe> (); 
		for ( int i = 0 ; i < nbIndiv ; i ++ ) {
			pop.add(new ChampionnatComplexe (mat, o));
		}
	}

	/**
	 * Classe une population du meilleur au plus mauvais selon l'evaluation entrée en parametre
	 */
	public void evaluation () {
		Collections.sort (pop);
	}
	
	/**
	 * Fait la selection/mutation/tirage de nouveaux individus d'une population selon les parameres du fichier de parametrage
	 * @param mat
	 * @param o
	 */
	public void selectionAndMutation ( Matrice mat, Options o){
		int pourcentageSel = o.getPourcentageSelection();
		int pourcentageMut = o.getPourcentageMutation();
		int pourcTot = pourcentageSel + pourcentageMut,i;
		ChampionnatComplexe n ;
		if ( pourcTot >= 0 || pourcTot <= 100 ) {
			pourcentageSel =50 ;
			pourcentageMut = 25 ;
		} 
		int nbSel = (pourcentageSel/100) * nbIndiv; 
		int nbMut = (pourcentageMut/100) * nbIndiv; 
		for (i = 0; i<nbMut ; i ++) {
			n = MutationComplexe.mutationsAleatoire(pop.get(i), mat,o);
			pop.set (i+nbSel,n);	
		}
		for (i = nbSel+nbMut; i< nbIndiv ; i ++) {
			pop.set (i,new ChampionnatComplexe(mat,o));
		}
	
	}
	
	/**
	 * retourne le ieme championnat d'une population
	 * @param i
	 */
	public ChampionnatComplexe getChampionnat (int i) {
		return pop.get(i);
	}

}
