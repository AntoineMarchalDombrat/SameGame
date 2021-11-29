/**
 *La classe <code>ExitGame</code> ferme le jeu quand l'utilisateur clique sur le bouton 'Quitter'.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import java.awt.event.*;

public class ExitGame implements ActionListener {
	/**
	 * Attribut permettant de recevoir la fenêtre ouverte pour la fermer.
	 */
	private Fenetre window;

	/**
	 * Constructeur qui récupère la fenêtre ouverte.
	 *
	 *@param window la fenêtre ouverte
	 */
	public ExitGame(Fenetre windows){
		this.window=windows;
	}

	/**
	 * Ferme la fenêtre après avoir cliqué sur le bouton 'Quitter'.
	 */
	public void actionPerformed(ActionEvent evenement){
		this.window.setVisible(false);
		this.window.dispose();
	}
	
}