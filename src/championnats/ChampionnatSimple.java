package championnats;

import java.util.Arrays;

import matrice.Matrice;

public class ChampionnatSimple implements Comparable<ChampionnatSimple> {
	private int [] pouleA,pouleB;
	private int equilibreDesPoule;
	private double distanceTotale;

	public ChampionnatSimple (int [] eq18,Matrice mat) {
		pouleA = new int [9];
		pouleB = new int [9];
		for (int i = 0 ; i < 9 ; i++ ) {
			pouleA [i] = eq18 [i];  
			pouleB [i] = eq18 [i+9];  
		}
		Arrays.sort(pouleA);
		Arrays.sort(pouleB);
		this.equilibreDesPoule = 0;
		int z;
		for ( z= 0; z < 9 ; z++) {
			this.equilibreDesPoule = this.equilibreDesPoule + Integer.max(pouleA[z], pouleB[z]) - Integer.min(pouleA[z], pouleB[z]);
		}
		int i, j ;
		this.distanceTotale=0;
		for ( i = 0 ; i < 9 ; i++ ){
			for ( j = i ; j < 9 ; j++ ){
				this.distanceTotale = this.distanceTotale + mat.getDistanceBetween(pouleA[i]-1, pouleA[j]-1) + mat.getDistanceBetween(pouleB[i]-1, pouleB[j]-1);
			}
		}
	}

	public ChampionnatSimple (Matrice mat) {
		int [] t = FonctionsTransverse.tirage(18);
		pouleA = new int [9];
		pouleB = new int [9];
		for (int i = 0 ; i < 9 ; i ++ ) {
			pouleA [i] = t [i];
			pouleB [i] = t [i+9];
		}
		Arrays.sort(pouleA);
		Arrays.sort(pouleB);
		this.equilibreDesPoule = 0;
		int z;
		for ( z= 0; z < 9 ; z++) {
			equilibreDesPoule = equilibreDesPoule + Integer.max(pouleA[z], pouleB[z]) - Integer.min(pouleA[z], pouleB[z]);
		}
		this.distanceTotale = 0;
		int i, j ;
		for ( i = 0 ; i < 9 ; i++ ){
			for ( j = i ; j < 9 ; j++ ){
				this.distanceTotale = this.distanceTotale + mat.getDistanceBetween(pouleA[i]-1, pouleA[j]-1) + mat.getDistanceBetween(pouleB[i]-1, pouleB[j]-1);
			}
		}
	}

	public double getDistanceTotale() {
		return distanceTotale;
	}

	public double getDistanceMoyenne() {
		return getDistanceTotale() / 18;
	}

	public double getEquilibreDesPoules() {
		return equilibreDesPoule;
	}

	public int getTaillePoule (){
		return 9;
	}

	public int [] getChampionnatSimple () {
		int ChampionnatSimple [] = new int [18];
		for (int i = 0 ; i < 9 ; i++ ) {
			ChampionnatSimple [i] = pouleA [i];  
			ChampionnatSimple  [i+9] = pouleB [i] ;  
		}
		return ChampionnatSimple;
	}

	public String toString () {
		String a = "ChampionnatSimple :\n";
		a = a + "Poule A :\t" ;
		for ( int i = 0 ; i < 9 ; i++ ) {
			a = a + pouleA [i] +" \t" ;
		}
		a = a + "\nPoule B :\t" ;
		for ( int i = 0 ; i < 9 ; i++ ) {
			a = a + pouleB [i] +" \t" ;
		}
		a = a + "\nEquilibre des poules :\t" + getEquilibreDesPoules()+"\n" ;
		a = a + "Distance totale parcourue : " +getDistanceTotale()+"\nDistance moyenne par equipe parcourue : "+getDistanceMoyenne()+"\n" ;
		return a;
	}

	// La distance est primordiale
	public int compareTo(ChampionnatSimple o) {
		if (o.getDistanceTotale() == this.getDistanceMoyenne()) {
			if (o.getEquilibreDesPoules() > this.getEquilibreDesPoules()) {
				return 1;
			}else if (o.getEquilibreDesPoules() < this.getEquilibreDesPoules()) {
				return -1;
			} else {
				return 0;
			}
		}else if (o.getDistanceTotale() > this.getDistanceTotale() ) {
			return 1;
		}else {
			return -1;
		}
	}

}
