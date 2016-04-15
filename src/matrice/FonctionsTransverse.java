package matrice;

import java.util.ArrayList;

public class FonctionsTransverse {

	public static int [] tirage (int nbEquipes) {
		int  ret [] =  new int [nbEquipes];
		ArrayList<Integer> liste = new ArrayList<Integer> ();
		int aleat = -1;
		for ( int i = 0 ; i < nbEquipes ; i++ ) {
			liste.add(i+1);
		}
		for (int j = nbEquipes; j>0 ;j--) {
			aleat = (int) ( Math.random() * (j-1));
			ret [nbEquipes-j] = liste.get(aleat);	
			liste.remove(aleat);
		}
		return ret;
	}

}
