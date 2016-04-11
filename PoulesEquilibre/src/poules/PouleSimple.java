package poules;

import java.util.ArrayList;


public class PouleSimple {
	private ArrayList<Equipe> equipes ;
	private double distanceParcourueChaqueEquipe [];
	private double distanceMoyenne ;
	private int [] classement ;
	
	public PouleSimple (Equipe a, Equipe b, Equipe c, Equipe d, Equipe e, Equipe f, Equipe g, Equipe h, Equipe i) {

		int j, k;
		double distanceMoyenne = 0;
		equipes = new ArrayList<Equipe> ();
		distanceParcourueChaqueEquipe = new double [9];
		classement = new int [9];
		
		Equipe eq[] = new Equipe [18];
		for (j=0; j< 18 ; j++) {
			eq [0] = null;
		}
		eq [a.getClassement()] = a;
		eq [b.getClassement()] = b;
		eq [c.getClassement()] = c;
		eq [d.getClassement()] = d;
		eq [e.getClassement()] = e;
		eq [f.getClassement()] = f;
		eq [g.getClassement()] = g;
		eq [h.getClassement()] = h;
		eq [i.getClassement()] = i;
		for (j=0; j< 18 ; j++) {
			if (eq[j] != null) {
				equipes.add(eq[j]) ;
			}
		}

		for (j = 0; j < 9; j++ ) {
			for (k = 0; k < 9; k++ ) {
				distanceParcourueChaqueEquipe [j] = distanceParcourueChaqueEquipe [j] + equipes.get(j).getDistanceFrom(k);
			}
			distanceMoyenne = distanceMoyenne + distanceParcourueChaqueEquipe [j];
		}
		classement [j] = equipes.get(j).getClassement();
		distanceMoyenne = distanceMoyenne/9 ;
	}
	
	public double getDistanceMoyenne() {
		return distanceMoyenne;
	}
	
	public double getDistanceParcourueEquipe (int i) {
		return distanceParcourueChaqueEquipe[i];
	}

	public Equipe getEquipe (int i) {
		return equipes.get(i);
	}
	
}