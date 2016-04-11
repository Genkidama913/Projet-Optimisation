package OLD;

import java.util.ArrayList;

public class Equipe {

	private int classement;
	private ArrayList<Double> distance;
	
	public Equipe (int classement,MatriceDistances mat){
		this.classement = classement;
		distance = new ArrayList <Double> ();	
		for (int i=0;i<Parametrage.nombreEquipes;i++) {
			distance.add(mat.getCase(classement, i));
		}
	}
	
	public int getClassement() {
		return classement;
	}
	
	public double getDistanceFromI (int i) {
		return distance.get(i);
	}
	
}
