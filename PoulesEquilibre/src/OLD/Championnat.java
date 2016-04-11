package OLD;

public class Championnat {

	private Poule pouleA;
	private Poule pouleB;
	private int evaluationChampionnat;
	private double distanceMoyenne;
	
	public Championnat (Poule a,Poule b) {
		pouleA=a;
		pouleB=b;
		
		distanceMoyenne = (a.getDistanceMoyenne() + b.getDistanceMoyenne()) / 2;
		
		for (int i = 0 ; i < 10 ; i++) {
			if (a.getClassementI(i) > b.getClassementI(i)) {
				evaluationChampionnat= evaluationChampionnat+a.getClassementI(i) - b.getClassementI(i);
			} else {
				evaluationChampionnat= evaluationChampionnat + b.getClassementI(i) - a.getClassementI(i);
			}
		}
	}

	public double getDistanceMoyenne() {
		return distanceMoyenne;
	}

	public int getEvaluationChampionnat() {
		return evaluationChampionnat;
	}
	
}
