/**
 *La classe <code>ActionGameFichier</code> permet d'effectuer une action lorsque le bouton 'grille à partir d un fichier' est selectionné.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */


import java.awt.event.*;

public class ActionGameFichier implements ActionListener {

  /**
   *JFrame relative à la fenêtre du menu.
   */
  private Fenetre firstWindow;

  /**
   *JFrame relative à la fenêtre de la partie.
   */
  public static Fenetre secondWindow = new Fenetre();

  /**
   *Variable qui permet de savoir que la partie est lancée depuis un fichier.
   */
  private short oneChoice=2;

  /**
   * Constructeur uniquement destiné à  la création des variables de la classe.
   *
   *@param fenetre La fenêtre
   */
  public ActionGameFichier(Fenetre fenetre) {
    this.firstWindow = fenetre;
  }



  /**
   * Action utilisée pour lancer une partie à partir d'une grille générée à partir d'un fichier lorsque le bouton est selectionné.
   */
  public void actionPerformed(ActionEvent evenement) {

    this.firstWindow.setVisible(false);
    this.firstWindow.dispose();
    

    new Matrice().remplirMatriceFichier();

    if (Matrice.check==0){

      Tracer_Grille affichage_grille = new Tracer_Grille();
      secondWindow.add(affichage_grille);
      secondWindow.addMouseMotionListener(new Souris(oneChoice));

      secondWindow.addMouseListener(new Mouse(oneChoice));

      secondWindow.setVisible(true);
    }
  }

}