package championnats;

/**
 * Championnat est une interface contenant toutes les methodes que doivent implementer un championnat
 * @author Alexandre Enouf
 * @version 1.0
 */

public interface Championnat {
	
	/**
	 * Renvoie la distance ramenee sur 100.
	 * @return NoteDistance
	 */
	public double getNoteDistance() ;
	
	/**
	 * Renvoie l'equilibre des poules ramenee sur 100.
	 * @return NoteEquilibre
	 */
	public double getNoteEquilibre() ;
	
	/**
	 * Renvoie la moyenne ponderee de la note d'equilibre et de la note de distance.
	 * @return noteMoyennePondereeEqDist
	 */
	public double getNoteMoyennePondereeEqDist() ;
	
	/**
	 * Renvoie la distance totale parcourue.
	 * @return distanceTotale
	 */
	public double getDistanceTotale() ;
	
	/**
	 * Renvoie la distance totale parcourue divisee par le nombre d'equipe.
	 * @return distanceMoyenne
	 */
	public double getDistanceMoyenne() ;
	
	/**
	 * Renvoie l'equilibre des poules.
	 * @return equilibreDesPoule
	 */
	public double getEquilibreDesPoules();
	
	/**
	 * Renvoie une presentation des poules avec la distance et l'equilibre des poules.
	 * @return equilibreDesPoule
	 */
	public String toString ();
	
	/**
	 * Renvoie une presentation des poules avec les notes ramenees sur 100.
	 * @return equilibreDesPoule
	 */
	public String toString2 ();

}