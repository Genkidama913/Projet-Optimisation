package populations;

import championnats.Championnat;
import matrice.Matrice;
import parametrage.Options;
/**
 * Population est une interface contenant toutes les methodes que doivent implementer une population.
 * @author Alexandre Enouf
 * @version 1.0
 */

public interface Population {
	/**
	 * Classe une population du meilleur au plus mauvais selon l'evaluation entree en parametre.
	 */
	public void evaluation ();
	
	/**
	 * Fait la selection/mutation/tirage de nouveaux individus d'une population selon les parameres du fichier de parametrage.
	 * @param Matrice 
	 * @param Options
	 */
	public void selectionAndMutation ( Matrice mat, Options o);
	
	/**
	 * retourne le ieme championnat d'une population.
	 * @param i
	 */
	Championnat getChampionnat (int i) ;
}
