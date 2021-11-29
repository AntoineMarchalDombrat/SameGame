/**
 * La classe <code>Menu</code> permet de gérer le premier écran, c'est à dire le menu.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */


import javax.swing.*;
import java.awt.*;

public class Menu {

 	/**
	 *JFrame relative au menu.
	 */
	private Fenetre firstWindow; 

	/**
	 * Permet d'afficher le nom du jeu.
	 */
	private TracerTitre affiche = new TracerTitre();

 	/**
 	 *Panel contenant les 3 boutons.
	 */
	private	JPanel panneau_bouton = new JPanel();

	/**
	 *Grille qui permet de gérer l'affichage.
	 */
	private GridLayout grille = new GridLayout(2,1);

	/**
	 *Bouton pour lancer une partie à partir d'une grille aléatoire.
	 */
	private	JButton bouton_random = new JButton("Grille Aleatoire");

	/**
	 *Bouton pour lancer une partie à partir d'un fichier.
	 */
	private	JButton bouton_fichier = new JButton("Grille a partir d un fichier");
	
	/**
	 *Bouton pour quitter le jeu.
	 */
	private	JButton bouton_quitter = new JButton("Quitter");

	/**
     * Constructeur uniquement destiné à  la création des constantes publiques.
   	 *
     *@param window La fenêtre
   	 */
    public Menu(Fenetre window){
    	this.firstWindow=window;
    }

	/**
   	 * Affiche le menu.
   	 */
	public void afficherAccueil() {

		this.firstWindow.setLayout(grille);

		ActionGameAleatoire action1 = new ActionGameAleatoire(this.firstWindow);
		ActionGameFichier action2 = new ActionGameFichier(this.firstWindow);
		ExitGame actionThree = new ExitGame(this.firstWindow);



		bouton_random.addActionListener(action1);
		bouton_fichier.addActionListener(action2);
		bouton_quitter.addActionListener(actionThree);

		bouton_random.setPreferredSize(new Dimension(200, 100));
		bouton_fichier.setPreferredSize(new Dimension(200, 100));
		bouton_quitter.setPreferredSize(new Dimension(200, 100));

		panneau_bouton.add(bouton_random);
		panneau_bouton.add(bouton_fichier);
		panneau_bouton.add(bouton_quitter);
		panneau_bouton.setBackground(new Color(226,217,202));

		this.firstWindow.add(affiche);
		this.firstWindow.add(panneau_bouton);
		this.firstWindow.setVisible(true);
	}
}
