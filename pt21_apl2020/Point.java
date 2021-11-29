/**
 * La classe <code>Point</code> sert de compteur pour les points obtenu du joueur.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

public class Point {

  /**
   * Attribut pour les points du joueur.
   */
	private int number;

  /**
   * Construteur qui initialise les points du joueur à zéro.
   *
   */
	public Point(){
		this.number=0;
	}

  /**
   * Méthode qui détermine les points du joueur.
   */
	public void sum(int counter){
		this.number=this.number+((counter-2)*(counter-2));
	} 

  /**
   * Méthode pour obtenir les points du joueur sous la forme d'un int.
   *
   * @return les points du joueur sous la forme d'un int.
   */
	public int getValue() {
    return this.number;
  	}

  /**
   * Méthode pour remettre les points du joueur à 0.
   */
  public void restartGame(){
  	this.number=0;
  }

  /**
   * Méthode pour obtenir les points du joueur sous la forme d'un string.
   *
   * @return les points du joueur sous la forme d'un string.
   */
  @Override
  public String toString(){
  	return Integer.toString(this.number);
  }
}