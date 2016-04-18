package championnats;

import java.util.Arrays;

import matrice.FonctionsTransverses;
import matrice.Matrice;
import parametrage.Options;

/**
 * CampionnatSimple est une classe qui implémente l'interface Championnat.
 * Un championnat à 18 équipes réparties en deux poules de 9 et jouant une fois chaque adversaire de la poule.
 * 
 * @author Alexandre Enouf
 * @version 1.0
 */

public class ChampionnatSimple implements Comparable<ChampionnatSimple>, Championnat {
	private int [] pouleA,pouleB;
	private int equilibreDesPoule;
	private double distanceTotale;
	Options opt;
	private double noteDistance;
	private double noteEquilibre;
	private double noteMoyennePondereeEqDist;
	
	/**
	 * Creer un championnat simple à partir d'un tableau donné en paramètre.
	 * @param Eq12 [18]
	 * @param matrice des distances
	 * @param les options du fichier de parametrage
	 * @return Un Championnat complexe
	 */
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
			for ( j = 0 ; j < 9 ; j++ ){
				this.distanceTotale = this.distanceTotale + mat.getDistanceBetween(pouleA[i]-1, pouleA[j]-1) + mat.getDistanceBetween(pouleB[i]-1, pouleB[j]-1);
			}
		}
		noteDistance = getDistanceTotale() * 100 / 36000 ;
		noteEquilibre = getEquilibreDesPoules() * 100 / 81 ;
		noteMoyennePondereeEqDist = ( (noteDistance * opt.getPourcentageDistance()) + (noteEquilibre * (100 - opt.getPourcentageDistance()) ))/100;
	}

	/**
	 * Creer un championnat simple aléatoire.
	 * @param matrice des distances
	 * @param les options du fichier de parametrage
	 * @return Un Championnat complexe
	 */
	public ChampionnatSimple (Matrice mat,Options o) {
		opt = o;
		int [] t = FonctionsTransverses.tirage(18);
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
	
	/**
	 * Renvoie la distance ramenée sur 100. 
	 * Le calcul est : distanceTotale * 100 / 36000. (36000 est environ la distance maximale)
	 * @return NoteDistance
	 */
	public double getNoteDistance() {
		return noteDistance;
	}
	
	/**
	 * Renvoie l'equilibre des poules ramenée sur 100.
	 * Le calcul est : equilibre * 100 / 81. (81 est l'equilibre des poules maximal)
	 * @return NoteEquilibre
	 */
	public double getNoteEquilibre() {
		return noteEquilibre;
	}
	
	/**
	 * Renvoie la moyenne pondérée de la note d'équilibre et de la note de distance.
	 * Le coeficient est a gerer dans le fichier de parametrage par l'utilisateur.
	 * @return noteMoyennePondereeEqDist
	 */
	public double getNoteMoyennePondereeEqDist() {
		return noteMoyennePondereeEqDist;
	}

	/**
	 * Renvoie la distance totale parcourue.
	 * @return distanceTotale
	 */
	public double getDistanceTotale() {
		return distanceTotale;
	}
	
	/**
	 * Renvoie la distance totale parcourue divisée par le nombre s'equipe.
	 * @return distanceMoyenne
	 */
	public double getDistanceMoyenne() {
		return getDistanceTotale() / 18;
	}
	
	/**
	 * Renvoie l'equilibre des poules. 
	 * L'equilibre est la différence de classement de chaque rang de chaque poule apres l'avoir classée.
	 * @return equilibreDesPoule
	 */
	public double getEquilibreDesPoules() {
		return equilibreDesPoule;
	}

	/**
	 * Renvoie la taille des poules.
	 * @return taillesDesPoules
	 */
	public int getTaillePoule (){
		return 9;
	}

	/**
	 * Renvoie un tableau du classement des poules.
	 * @return TableauDesPoules
	 */
	public int [] getChampionnatSimple () {
		int ChampionnatSimple [] = new int [18];
		for (int i = 0 ; i < 9 ; i++ ) {
			ChampionnatSimple [i] = pouleA [i];  
			ChampionnatSimple  [i+9] = pouleB [i] ;  
		}
		return ChampionnatSimple;
	}

	/**
	 * Renvoie une présentation des poules avec la disatnce et l'equilibre des poules.
	 * @return equilibreDesPoule
	 */
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
		a = a + "\nEquilibre des poules:\t" + getEquilibreDesPoules()+" (note = "+ noteEquilibre +")\n" ;
		a = a + "Distance totale parcourue:\t" +getDistanceTotale()+" (note = "+ noteDistance +")\nDistance moyenne par equipe parcourue : "+getDistanceMoyenne()+"\n";
		if (opt.getEvaluation() == 2) {
			a = a + "Moyenne pondérée de l'equilibre et de la distance ramenées sur 100 : "+getNoteMoyennePondereeEqDist()+" (avec un coefiscient de "+opt.getPourcentageDistance()+" pour la distance et de "+(100-opt.getPourcentageDistance())+" pour l'equilibre) \n";
		}
		return a;
	}
	
	/**
	 * Renvoie une présentation des poules avec les notes ramenées sur 100.
	 * @return equilibreDesPoule
	 */
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

	/**
	 * Compare deux championnats sur leur notes. L'evaluation est soit sur la distance, ou l'equilibre des poules ou la moyenne pondérée.
	 * La comparison est donnée dans le fichier d'options données.
	 * @param ChampionnatSimple 
	 * @return la comparaison des deux championnat
	 */
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
