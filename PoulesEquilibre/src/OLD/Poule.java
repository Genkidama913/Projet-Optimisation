package OLD;

public class Poule {
	
	private Equipe equipes [] ;
	private double distances [] ;
	private double distanceMoyenne = -1;
	
	public Poule (Equipe i1, Equipe i2, Equipe i3, Equipe i4, Equipe i5, Equipe i6, Equipe i7, Equipe i8, Equipe i9) {
		
		int j,i,min,mini,a;
		// equipesNonClassee -> tableau d'equipes non classées
		Equipe [] equipesNonClassee = {i1,i2,i3,i4,i5,i6,i7,i8,i9}  ;
		
		// On cherche l'equipe la mieux classée (clasement le plus faible) dans equipesNonClassee, on la stocke dans equipes 
		// puis on remplace cette equioe par null dans equipeNonClassee et on passe a la suivante.
		for (i = 0 ; i < 9 ; i ++) {
			for (j = 0 ; j < 9 ; j ++) {
				min = 20;
				mini = 30;
 				if (equipesNonClassee [j] != null ){
					a=equipesNonClassee [j].getClassement();
					if (min > a) {
						min = a;
						mini = j;
					}
				}
				equipes [i] = equipesNonClassee [mini];
				equipesNonClassee [mini] = null;
			}
		}
		// equipes [] est maintenant composé des 9 equipes en fonction de leur classement
		
		
		// Pour la distance, les equipes jouant un seul match (pas d'aller rertour) il suffit de calculer les dstances
		for ( i = 0 ;  i < 9 ; i++ ) {
			for (j = i ; j < 9 ; i++ ) {
				distances [i] = distances [i] + equipes [i].getDistanceFromI(j);
			}
			distanceMoyenne = distanceMoyenne + distances [i];
		}
		distanceMoyenne = distanceMoyenne/9;
	}
	
	public double getDistanceMoyenne () {
		return distanceMoyenne;
	}
	
	public int getClassementI (int i) {
		return equipes[i].getClassement(); 
	}
	
}
