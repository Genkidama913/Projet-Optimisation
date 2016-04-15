package populations;

import championnats.Championnat;
import matrice.Matrice;
import parametrage.Options;

public interface Population {
	public void evaluation ();
	public void selectionAndMutation ( Matrice mat, Options o);
	Championnat getChampionnat (int i) ;
}
