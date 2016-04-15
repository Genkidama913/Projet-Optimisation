package championnats;

import java.util.Arrays;

import matrice.FonctionsTransverse;
import matrice.Matrice;
import parametrage.Options;

public class ChampionnatSimple implements Comparable<ChampionnatSimple>, Championnat {
	private int [] pouleA,pouleB;
	private int equilibreDesPoule;
	private double distanceTotale;
	Options opt;
	private double noteDistance;
	private double noteEquilibre;
	private double noteMoyennePondereeEqDist;
	
	// EQUILIBRE DES POULES = DIFFERENCE ENTRE LA SOMME DES CLASSEMENT DE CHAQUES POULES
	public ChampionnatSimple (int [] eq18,Matrice mat,Options o) {
		opt = o;
		pouleA = new int [9];
		pouleB = new int [9];
		int eqPouleA = 0;
		int eqPouleB = 0;
		for (int i = 0 ; i < 9 ; i++ ) {
			pouleA [i] = eq18 [i];  
			pouleB [i] = eq18 [i+9];  
		}
		Arrays.sort(pouleA);
		Arrays.sort(pouleB);
		this.equilibreDesPoule = 0;
		int z;
		for ( z= 0; z < 9 ; z++) {
			eqPouleA += pouleA[z] ;
			eqPouleB += pouleB[z] ;
		}
		this.equilibreDesPoule = Integer.max(eqPouleA, eqPouleB) - Integer.min(eqPouleA, eqPouleB);
		int i, j ;
		this.distanceTotale=0;
		for ( i = 0 ; i < 9 ; i++ ){
			for ( j = i ; j < 9 ; j++ ){
				this.distanceTotale = this.distanceTotale + mat.getDistanceBetween(pouleA[i]-1, pouleA[j]-1) + mat.getDistanceBetween(pouleB[i]-1, pouleB[j]-1);
			}
		}
		noteDistance = getDistanceTotale() * 100 / 36000 ;
		noteEquilibre = getEquilibreDesPoules() * 100 / 90 ;
		noteMoyennePondereeEqDist = ( (noteDistance * opt.getPourcentageDistance()) + (noteEquilibre * (100 - opt.getPourcentageDistance()) ))/100;
	}

	public ChampionnatSimple (Matrice mat,Options o) {
		opt = o;
		int [] t = FonctionsTransverse.tirage(18);
		int eqA = 0,eqB = 0;
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
			eqA = eqA + pouleA[z];
			eqB = eqB + pouleB[z];
		}
		equilibreDesPoule = Integer.max(eqA, eqB) - Integer.min(eqA, eqB);
		this.distanceTotale = 0;
		int i, j ;
		for ( i = 0 ; i < 9 ; i++ ){
			for ( j = i ; j < 9 ; j++ ){
				this.distanceTotale = this.distanceTotale + mat.getDistanceBetween(pouleA[i]-1, pouleA[j]-1) + mat.getDistanceBetween(pouleB[i]-1, pouleB[j]-1);
			}
		}
		noteDistance = getDistanceTotale() * 100 / 36000 ;
		noteEquilibre = getEquilibreDesPoules() * 100 / 81 ;
		noteMoyennePondereeEqDist = ((noteDistance * opt.getPourcentageDistance()) + (noteEquilibre * (100 - opt.getPourcentageDistance()) ))/100;
	
	}
	
	public double getNoteDistance() {
		return noteDistance;
	}
	
	public double getNoteEquilibre() {
		return noteEquilibre;
	}
	
	public double getNoteMoyennePondereeEqDist() {
		return noteMoyennePondereeEqDist;
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
	
	public String toString2 () {
		String a = "ChampionnatSimple : {";
		a = a + " ( " ;
		for ( int i = 0 ; i < 9 ; i++ ) {
			a = a + pouleA [i] +" " ;
		}
		a = a + ") ( " ;
		for ( int i = 0 ; i < 9 ; i++ ) {
			a = a + pouleB [i] +" " ;
		}
		a = a + ") }\n" ;
		a = a + "\tNote Equilibre:\t"+this.getNoteEquilibre()+"\n" ;
		a = a + "\tNote Distance:\t"+this.getNoteDistance()+"\n" ;
		a = a + "\tMoyenne pondérée:\t" +getNoteMoyennePondereeEqDist()+" (coefDist="+opt.getPourcentageDistance()+", coefEq="+(100-opt.getPourcentageDistance())+")\n" ;
		return a;
	}

	// l'equilibre des poules est primordiale.
	// equilibre le moins bon = 81
	
	public int compareTo(ChampionnatSimple o) {
		if (opt.getEvaluation() == 0) {
			if (o.getNoteDistance() == this.getNoteDistance()) {
				return 0;
			}else if (o.getNoteDistance() > this.getNoteDistance() ) {
				return -1;
			}else {
				return 1;
			}
		}else if (opt.getEvaluation() == 1) {
			if (o.getNoteEquilibre() == this.getNoteEquilibre()) {
				return 0;
			}else if (o.getNoteEquilibre() > this.getNoteEquilibre() ) {
				return -1;
			}else {
				return 1;
			}
		} else  {
			if (o.getNoteMoyennePondereeEqDist() == this.getNoteMoyennePondereeEqDist()) {
				return 0;
			}else if (o.getNoteMoyennePondereeEqDist() > this.getNoteMoyennePondereeEqDist() ) {
				return -1;
			}else {
				return 1;
			}
		}
	}

}
