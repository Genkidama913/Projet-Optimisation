package populations;

import java.util.ArrayList;
import java.util.Collections;

import championnats.ChampionnatComplexe;
import matrice.Matrice;
import mutations.MutationComplexe;

public class PopulationComplexe {
	
	private ArrayList<ChampionnatComplexe> pop;
	private int nbIndiv;

	public PopulationComplexe (int nb, Matrice mat) {
		this.nbIndiv = nb;
		pop = new ArrayList<ChampionnatComplexe> (); 
		for ( int i = 0 ; i < nb ; i ++ ) {
			pop.add(new ChampionnatComplexe (mat));
		}
	}

	public void evaluation () {
		Collections.sort (pop);
	}
	
	public void selectionAndMutation (int pourcentageSel,int pourcentageMut, Matrice mat){
		int pourcTot = pourcentageSel + pourcentageMut,i;
		ChampionnatComplexe n ;
		if ( pourcTot >= 0 || pourcTot <= 100 ) {
			pourcentageSel =50 ;
			pourcentageMut = 25 ;
		} 
		int nbSel = (pourcentageSel/100) * nbIndiv; 
		int nbMut = (pourcentageMut/100) * nbIndiv; 
		for (i = 0; i<nbMut ; i ++) {
			n = MutationComplexe.mutationsAleatoire(pop.get(i), mat);
			pop.set (i+nbSel,n);	
		}
		for (i = nbSel+nbMut; i< nbIndiv ; i ++) {
			pop.set (i,new ChampionnatComplexe(mat));
		}
	
	}
	
	public ChampionnatComplexe getChampionnat (int i) {
		return pop.get(i);
	}

}
