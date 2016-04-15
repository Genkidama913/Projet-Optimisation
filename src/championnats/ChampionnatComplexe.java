package championnats;

import java.util.Arrays;

import matrice.FonctionsTransverse;
import matrice.Matrice;
import parametrage.Options;

public class ChampionnatComplexe implements Comparable<ChampionnatComplexe>, Championnat{

	private int [] grpA1,grpA2,grpB1,grpB2;
	private double distanceTotale = 0;
	private int equilibreDesPoule = 0;
	private Options opt;
	private double noteDistance;
	private double noteEquilibre;
	private double noteMoyennePondereeEqDist;

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
				// deux deplacement par adversaire du groupe
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA2[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB2[j]-1)*2;
				// un deplacement par adrversaire  du groupe jumeau
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA1[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB1[j]-1);
			}

			// un deplacement aleatoire dans le groupe adverse
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
			//equilibreDesPoule = equilibreDesPoule + Integer.max(grpA1[z], grpB1[z]) - Integer.min(grpA1[z], grpB1[z]) + Integer.max(grpA2[z], grpB2[z]) - Integer.min(grpA2[z], grpB2[z]);
			equilibrea = grpA1[z] + grpA2[z] ;
			equilibreb = grpB1[z] + grpB2[z] ;
		}
		equilibreDesPoule = Integer.max(equilibrea, equilibreb) - Integer.min(equilibreb, equilibreb);
		noteDistance = getDistanceTotale() * 100 / 52000 ;
		noteEquilibre = getEquilibreDesPoules() * 100 / 36 ;
		noteMoyennePondereeEqDist = ( (noteDistance * opt.getPourcentageDistance()) + (noteEquilibre * (100 - opt.getPourcentageDistance()) ))/100;
	}

	public ChampionnatComplexe (Matrice mat,Options o) {
		opt = o;
		int [] Eq12 = FonctionsTransverse.tirage(12);
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
				// deux deplacement par adversaire du groupe
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA2[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB1[j]-1)*2;
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB2[j]-1)*2;
				// un deplacement par adrversaire  du groupe jumeau
				distanceTotale += mat.getDistanceBetween(grpA1[i]-1,grpA2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpA2[i]-1,grpA1[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB1[i]-1,grpB2[j]-1);
				distanceTotale += mat.getDistanceBetween(grpB2[i]-1,grpB1[j]-1);
			}

			// un deplacement aleatoire dans le groupe adverse
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
		return getDistanceTotale () / 12;
	}

	// ici l'equilibre de la poule est l'equilibre des sous poules (eauilibre (A1,B1) + equilibre A2,B2))
	public double getEquilibreDesPoules() {
		return equilibreDesPoule;
	}

	public int getTaillePoule (){
		return 3;
	}

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
		a = a + "\nEquilibre des poules :\t" + getEquilibreDesPoules()+" (RAMENE SUR 100 = "+ noteEquilibre +")\n" ;
		a = a + "Distance totale parcourue : " +getDistanceTotale()+" (RAMENE SUR 100 = "+ noteDistance +")\nDistance moyenne par equipe parcourue : "+getDistanceMoyenne()+"\n";
		a = a + "Moyenne pondérée de l'equilibre et de la distance ramenées sur 100 : "+getNoteMoyennePondereeEqDist()+" (avec un coefiscient de "+opt.getPourcentageDistance()+" pour la distance et de "+(100-opt.getPourcentageDistance())+" pour l'equilibre) \n";
		return a;
	}

	// l'equilibre des poules est primordiale.
	// equilibre le moins bon = (7+8+9+10+11+12) - (1+2+3+4+5+6) = 36
	//distance max = 52000 env
	
	//noteDistance;
	//private double noteEquilibre;
	//private double noteMoyennePondereeEqDist;
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
