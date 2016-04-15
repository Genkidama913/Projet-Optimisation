package populations;

import java.util.ArrayList;
import java.util.Collections;

import championnats.ChampionnatSimple;
import matrice.Matrice;
import mutations.MutationSimple;
import parametrage.Options;

public class PopulationSimple implements Population {

	private ArrayList<ChampionnatSimple> pop;
	private int nbIndiv;
	
	public PopulationSimple (Matrice mat, Options o) {
		this.nbIndiv = o.getNbIndiv();
		pop = new ArrayList<ChampionnatSimple> (); 
		for ( int i = 0 ; i < o.getNbIndiv() ; i ++ ) {
			pop.add(new ChampionnatSimple (mat,o));
		}
	}

	public void evaluation () {
		Collections.sort (pop);
	}

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
	
	public ChampionnatSimple getChampionnat (int i) {
		return pop.get(i);
	}

}
