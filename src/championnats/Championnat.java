package championnats;

/**
 * Championnat est une interface contenant toutes les methodes que doivent implémenter un chapionnat
 * @author Alexandre Enouf
 * @version 1.0
 */

public interface Championnat {
	
	/**
	 * Renvoie la distance ramenée sur 100.
	 * @return NoteDistance
	 */
	public double getNoteDistance() ;
	
	/**
	 * Renvoie l'equilibre des poules ramenée sur 100.
	 * @return NoteEquilibre
	 */
	public double getNoteEquilibre() ;
	
	/**
	 * Renvoie la moyenne pondérée de la note d'équilibre et de la note de distance.
	 * @return noteMoyennePondereeEqDist
	 */
	public double getNoteMoyennePondereeEqDist() ;
	
	/**
	 * Renvoie la distance totale parcourue.
	 * @return distanceTotale
	 */
	public double getDistanceTotale() ;
	
	/**
	 * Renvoie la distance totale parcourue divisée par le nombre s'equipe.
	 * @return distanceMoyenne
	 */
	public double getDistanceMoyenne() ;
	
	/**
	 * Renvoie l'equilibre des poules.
	 * @return equilibreDesPoule
	 */
	public double getEquilibreDesPoules();
	
	/**
	 * Renvoie une présentation des poules avec la disatnce et l'equilibre des poules.
	 * @return equilibreDesPoule
	 */
	public String toString ();
	
	/**
	 * Renvoie une présentation des poules avec les notes ramenées sur 100.
	 * @return equilibreDesPoule
	 */
	public String toString2 ();

}