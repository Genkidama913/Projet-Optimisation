package championnats;

import java.util.Arrays;

import matrice.FonctionsTransverses;
import matrice.Matrice;
import parametrage.Options;

/**
 * ChampionnatComplexe est une classe qui implemente l'interface Championnat.
 * Un championnat a 12 equipes dont les equipes sont repartis en 2 groupes de 6 et 2 sous-groupes de 3 au sein de chaque groupe de 6.
 * Les equipes se deplacant 2 fois chez chaque adversaire du sous groupe, 1 fois chez chaque autre adversaires du groupe et 1 fois chez 3 des 6 adversaires de l'autre groupe.
 * 
 * @author Alexandre Enouf
 * @version 1.0
 */

public class ChampionnatComplexe implements Comparable<ChampionnatComplexe>, Championnat{

	private int [] grpA1,grpA2,grpB1,grpB2;
	private double distanceTotale = 0;
	private int equilibreDesPoule = 0;
	private Options opt;
	private double noteDistance;
	private double noteEquilibre;
	private double noteMoyennePondereeEqDist;
	
	/**
	 * Creer un championnat complexe a partir d'un tableau donne en parametre.
	 * @param Eq12
	 * @param matrice des distances
	 * @param les options du fichier de parametrage
	 * @return Un Championnat complexe
	 */
	public ChampionnatComplexe (int [] Eq12,Matrice mat,Options o ) {
		opt = o;
		int equilibrea = 0;
		int equilibreb = 0;
		grpA1 = new int [3];  
		grpA2 = new int [3];  
		grpB1 = new int [3];  
		grpB2 = new int [3];  
		for (int i = 0 ; i < 3 ; i++ ) {
			grpA1 [i] = Eq12 [i];  
			grpA2 [i] = Eq12 [i+3];  
			grpB1 [i] = Eq12 [i+6];  
			grpB2 [i] = Eq12 [i+9];  
		}
		Arrays.sort(grpA1);
		Arrays.sort(grpA2);
		Arrays.sort(grpB1);
		Arrays.sort(grpB2);
		int a=0;
		for ( int i = 0 ; i < 3 ; i ++ ) {
			for ( int j = 0 ; j < 3 ; j ++ ) {
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA2[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB2[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA1[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB1[j]-1);
			}

			a = (int) Math.random();
			if (a==0) {
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpB1[i]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpB1[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpA1[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpA1[i]-1);
			} else {
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpB2[i]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpB2[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpA2[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpA2[i]-1);
			}
		}
		int z;
		for ( z= 0; z < 3 ; z++) {
			equilibrea = grpA1[z] + grpA2[z] ;
			equilibreb = grpB1[z] + grpB2[z] ;
		}
		equilibreDesPoule = Integer.max(equilibrea, equilibreb) - Integer.min(equilibreb, equilibreb);
		noteDistance = getDistanceTotale() * 100 / 52000 ;
		noteEquilibre = getEquilibreDesPoules() * 100 / 36 ;
		noteMoyennePondereeEqDist = ( (noteDistance * opt.getPourcentageDistance()) + (noteEquilibre * (100 - opt.getPourcentageDistance()) ))/100;
	}

	/**
	 * Creer un championnat complexe aleatoire.
	 * @param matrice des distances
	 * @param les options du fichier de parametrage
	 * @return Un Championnat complexe
	 */
	public ChampionnatComplexe (Matrice mat,Options o) {
		opt = o;
		int [] Eq12 = FonctionsTransverses.tirage(12);
		grpA1 = new int [3];  
		grpA2 = new int [3];  
		grpB1 = new int [3];  
		grpB2 = new int [3];
		for (int i = 0 ; i < 3 ; i++ ) {
			grpA1 [i] = Eq12 [i];  
			grpA2 [i] = Eq12 [i+3];  
			grpB1 [i] = Eq12 [i+6];  
			grpB2 [i] = Eq12 [i+9];  
		}
		Arrays.sort(grpA1);
		Arrays.sort(grpA2);
		Arrays.sort(grpB1);
		Arrays.sort(grpB2);
		int a=0;
		for ( int i = 0 ; i < 3 ; i ++ ) {
			for ( int j = 0 ; j < 3 ; j ++ ) {
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA2[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB2[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA1[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB1[j]-1);
			}

			a = (int) Math.random();
			if (a==0) {
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpB1[i]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpB1[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpA1[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpA1[i]-1);
			} else {
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpB2[i]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpB2[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpA2[i]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpA2[i]-1);
			}
		}
		int z;
		for ( z= 0; z < 3 ; z++) {
			equilibreDesPoule = equilibreDesPoule +  ( Integer.max(grpA1[z], grpB1[z]) - Integer.min(grpA1[z], grpB1[z])  ) + ( Integer.max(grpA2[z], grpB2[z]) - Integer.min(grpA2[z], grpB2[z]) );
		}
		noteDistance = getDistanceTotale() * 100 / 52000 ;
		noteEquilibre = getEquilibreDesPoules() * 100 / 36 ;
		noteMoyennePondereeEqDist = ( (noteDistance * opt.getPourcentageDistance()) + (noteEquilibre * (100 - opt.getPourcentageDistance()) ))/100;
	}
	
	/**
	 * Renvoie la distance ramenee sur 100. 
	 * Le calcul est : distanceTotale * 100 / 52000. (52000 est environ la distance maximale)
	 * @return NoteDistance
	 */
	public double getNoteDistance() {
		return noteDistance;
	}
	
	/**
	 * Renvoie l'equilibre des poules ramenee sur 100.
	 * Le calcul est : equilibre * 100 / 36. (36 est l'equilibre des poules maximal)
	 * @return NoteEquilibre
	 */
	public double getNoteEquilibre() {
		return noteEquilibre;
	}
	
	/**
	 * Renvoie la moyenne ponderee de la note d'equilibre et de la note de distance.
	 * Le coefficient est a gerer dans le fichier de parametrage par l'utilisateur.
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
	 * Renvoie la distance totale parcourue divisee par le nombre d'equipe.
	 * @return distanceMoyenne
	 */
	public double getDistanceMoyenne() {
		return getDistanceTotale () / 12;
	}

	/**
	 * Renvoie l'equilibre des poules. 
	 * L'equilibre est la difference de classement de chaque rang de chaque poule apres l'avoir classee.
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
		return 3;
	}
	
	/**
	 * Renvoie un tableau du classement des poules.
	 * @return TableauDesPoules
	 */
	public int [] getChampionnatComplexe () {
		int ChampionnatComplexe [] = new int [18];
		for (int i = 0 ; i < 3 ; i++ ) {
			ChampionnatComplexe [i] = grpA1 [i];  
			ChampionnatComplexe [i+3] = grpA2 [i];  
			ChampionnatComplexe [i+6] = grpB1 [i];
			ChampionnatComplexe [i+9] = grpB2 [i];
		}
		return ChampionnatComplexe;
	}
	
	/**
	 * Renvoie une presentation des poules avec la disatnce et l'equilibre des poules.
	 * @return equilibreDesPoule
	 */
	public String toString2 () {
		String a = "ChampionnatComplexe : [";
		a = a + " { ( " ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpA1 [i] +" " ;
		}
		a = a + ") ( " ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpA2 [i] +" "  ;
		}
		a = a + ") } { ( " ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpB1 [i] +" " ;
		}
		a = a + ") ( "  ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpB2 [i] +" " ;
		}
		a = a + ") } ] \n"  ;
		a = a + "\tNote Equilibre:\t"+this.getNoteEquilibre()+"\n" ;
		a = a + "\tNote Distance:\t"+this.getNoteDistance()+"\n" ;
		a = a + "\tMoyenne pondérée:\t" +getNoteMoyennePondereeEqDist()+" (coefDist="+opt.getPourcentageDistance()+", coefEq="+(100-opt.getPourcentageDistance())+")\n" ;
		return a;
	}
	
	/**
	 * Renvoie une presentation des poules avec les notes ramenees sur 100.
	 * @return equilibreDesPoule
	 */
	public String toString () {
		String a = "ChampionnatComplexe :\n";
		a = a + "Poule A Groupe 1 :\t" ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpA1 [i] +" \t" ;
		}
		a = a + "\nPoule A Groupe 2 :\t" ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpA2 [i] +" \t" ;
		}
		a = a + "\nPoule B Groupe 1 :\t" ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpB1 [i] +" \t" ;
		}
		a = a + "\nPoule B Groupe 2 :\t" ;
		for ( int i = 0 ; i < 3 ; i++ ) {
			a = a + grpB2 [i] +" \t" ;
		}
		a = a + "\nEquilibre des poules:\t" + getEquilibreDesPoules()+" (note = "+ noteEquilibre +")\n" ;
		a = a + "Distance totale parcourue:\t" +getDistanceTotale()+" (note = "+ noteDistance +")\nDistance moyenne par equipe parcourue : "+getDistanceMoyenne()+"\n";
		if (opt.getEvaluation() == 2) {
			a = a + "Moyenne pondérée de l'equilibre et de la distance ramenées sur 100 : "+getNoteMoyennePondereeEqDist()+" (avec un coefiscient de "+opt.getPourcentageDistance()+" pour la distance et de "+(100-opt.getPourcentageDistance())+" pour l'equilibre) \n";
		}
		return a;
	}
	
	/**
	 * Compare deux championnats sur leur notes. L'evaluation est soit sur la distance, ou l'equilibre des poules ou la moyenne ponderee.
	 * La comparaison est donnee dans le fichier d'options donnees.
	 * @param o Championnat complexe
	 * @return la comparaison des deux championnats
	 */
	public int compareTo(ChampionnatComplexe o) {
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
