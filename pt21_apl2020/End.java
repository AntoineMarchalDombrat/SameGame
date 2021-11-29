/**
 * La classe <code>End</code> sert à gérer l'écran de fin.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import javax.swing.*;
import java.awt.*;

public class End{
	
	/**
	 * Attribut permettant de recevoir la fenêtre ouverte pour la fermer.
	 */
	private Fenetre secondWindow;

	/**
	 * Attribut qui sert à afficher la fenêtre de fin.
	 */
	private Fenetre thirdWindow = new Fenetre();

	/**
	 * Attribut rajoutant un titre à l'écran de fin.
	 */
	private	EndDesign message = new EndDesign();
	
	/**
	 * Attribut permettant de séparer la fenêtre pour qu'elle puisse accepter le titre et le JPanel.
	 */
	private GridLayout grid = new GridLayout(2,1);

	/**
	 * Attribut JPanel pour contenir les deux boutons.
	 */ 
	private	JPanel button_panel = new JPanel();

	/**
	 * Bouton pour recommencer le jeu.
	 */
	private	JButton restart =  new JButton("Rejouer");

	/**
	 * Bouton pour quitter le jeu.
	 */
	private	JButton exit = new JButton("Quitter");

	/**
	 * Constructeur qui récupère la fenêtre de jeu ouverte.
	 *
	 *@param window la fenêtre ouverte
	 */
	public End(Fenetre window){
		this.secondWindow=window;
	}

	/**
	 * Méthode qui ferme la fenêtre ouverte puis qui affiche la fenêtre de fin avec son contenu.
	 */
	public void endScreen(){

		this.secondWindow.setVisible(false);
		this.secondWindow.dispose();

		RestartGame reSTART = new RestartGame(thirdWindow);
		ExitGame close = new ExitGame(thirdWindow);

		thirdWindow.setLayout(grid);


		restart.setPreferredSize(new Dimension(200, 100));
		restart.addActionListener(reSTART);

		exit.setPreferredSize(new Dimension(200, 100));
		exit.addActionListener(close);

		button_panel.add(restart);
		button_panel.add(exit);
		button_panel.setBackground(new Color(226,217,202));

		thirdWindow.add(message);
		thirdWindow.add(button_panel);


		thirdWindow.setVisible(true);
	}
}