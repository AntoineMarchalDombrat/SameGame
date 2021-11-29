/**
 * La classe <code>RestartGame</code> permet de recommencer le jeu.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import java.awt.event.*;

public class RestartGame implements ActionListener {

	/**
	 * Attribut permettant de recevoir la fenêtre ouverte pour la fermer.
	 */
	private Fenetre thirdWindow;

	/**
	 * Attribut qui sert à transmettre une fenêtre à l'attribut menu.
	 */
	private Fenetre newWindow = new Fenetre();

	/**
	 * Attribut de la classe Menu pour afficher le menu du début.
	 */
	private Menu menu = new Menu(newWindow);

	/**
	 * Attribut servant à vérifier que la méthode afficherAccueil() ne s'effectue qu'une fois.
	 */
	private byte check=0;

	/**
	 * Constructeur qui récupère la fenêtre ouverte.
	 *
	 *@param window la fenêtre ouverte
	 */
	public RestartGame(Fenetre window){
		this.thirdWindow=window;
	}

	/**
     * Action utilisé pour recommencer le jeu lorsque le bouton est cliqué.
     */
	public void actionPerformed(ActionEvent evenement){

		this.thirdWindow.setVisible(false);
		this.thirdWindow.dispose();

		for (int line=0 ; line<10; line++){
			for (int column=0 ; column<15; column++){
				if (Matrice.actif[line][column]!=0){
					Matrice.actif[line][column]=0;
				}
			}
		}
		Calculation.score.restartGame();

		Calculation.oneEnd=0;

		if (check!=1){
			check+=1;
    		menu.afficherAccueil();
		}
	}

}