package populations;

import java.util.ArrayList;
import java.util.Collections;

import championnats.ChampionnatSimple;
import matrice.Matrice;
import mutations.MutationSimple;

public class PopulationSimple {

	private ArrayList<ChampionnatSimple> pop;
	private int nbIndiv;

	public PopulationSimple (int nb, Matrice mat) {
		this.nbIndiv = nb;
		pop = new ArrayList<ChampionnatSimple> (); 
		for ( int i = 0 ; i < nb ; i ++ ) {
			pop.add(new ChampionnatSimple (mat));
		}
	}

	public void evaluation () {
		Collections.sort (pop);
	}

	public void selectionAndMutation (int pourcentageSel,int pourcentageMut, Matrice mat){
		int pourcTot = pourcentageSel + pourcentageMut,i;
		ChampionnatSimple n ;
		if ( pourcTot >= 0 || pourcTot <= 100 ) {
			pourcentageSel =50 ;
			pourcentageMut = 25 ;
		} 
		int nbSel = (pourcentageSel/100) * nbIndiv; 
		int nbMut = (pourcentageMut/100) * nbIndiv; 
		for (i = 0; i<nbMut ; i ++) {
			n = MutationSimple.mutationsAleatoire(pop.get(i),mat);
			pop.set (i+nbSel,n);	
		}
		for (i = nbSel+nbMut; i< nbIndiv ; i ++) {
			pop.set (i,new ChampionnatSimple(mat));
		}
	
	}
	
	public ChampionnatSimple getChampionnat (int i) {
		return pop.get(i);
	}

}