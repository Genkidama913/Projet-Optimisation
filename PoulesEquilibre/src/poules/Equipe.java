package poules;

import java.util.ArrayList;

import matrice.Matrice;

public class Equipe implements Comparable<Equipe>{
	private int classement;
	private ArrayList<Double> distance;

	public Equipe (int classement,Matrice mat){
		this.classement = classement;
		distance = new ArrayList <Double> ();	
		for (int i=0 ; i < mat.getTaille() ; i++) {
			distance.add(mat.getDistanceBetween(classement, i));
		}
	}

	public int getClassement() {
		return classement;
	}

	public double getDistanceFrom (int i) {
		return distance.get(i);
	}

	public int compareTo(Equipe o) {
			return Integer.compare(this.classement, o.getClassement());
	}
}
