package populations;

import java.util.ArrayList;
import java.util.Collections;

import championnats.ChampionnatComplexe;
import matrice.Matrice;
import mutations.MutationComplexe;
import parametrage.Options;

public class PopulationComplexe implements Population{
	
	private ArrayList<ChampionnatComplexe> pop;
	private int nbIndiv;

	public PopulationComplexe ( Matrice mat, Options o) {
		this.nbIndiv = o.getNbIndiv();
		pop = new ArrayList<ChampionnatComplexe> (); 
		for ( int i = 0 ; i < nbIndiv ; i ++ ) {
			pop.add(new ChampionnatComplexe (mat, o));
		}
	}

	public void evaluation () {
		Collections.sort (pop);
	}
	
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
	
	public ChampionnatComplexe getChampionnat (int i) {
		return pop.get(i);
	}

}
