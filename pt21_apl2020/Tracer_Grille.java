/**
 * La classe <code>Tracer_Grille</code> permet d'afficher la grille de jeu à la fenêtre.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import javax.swing.*;
import java.awt.*;

public class Tracer_Grille extends JComponent {


  /**
   * Image du cactus.
   */
  private Image figure_verte;

  /**
   *Image de la plume.
   */
  private Image figure_rouge;

  /**
   * Image du nuage.
   */
  private Image figure_bleue;

  /**
   * Image du nuage lorsqu'il est survolé.
   */
  private Image figure_bleue_surlignee;

  /**
   * Image du cactus lorsqu'il est survolé.
   */
  private Image figure_verte_surlignee;

  /**
   * Image de la plume survolée.
   */
  private Image figure_rouge_surlignee;

  /**
   * Image de la même couleur que le second-plan.
   */
  private Image fond;

  /**
   * Image de second-plan.
   */
  private Image background;

  /**
   * Score.
   */
  private String score;

  /**
  *Attribue à chaque objet Image son image correspondante.
  */
  public Tracer_Grille() {
    super();   
    this.figure_rouge = Toolkit.getDefaultToolkit().getImage("plume.png");
    this.figure_verte = Toolkit.getDefaultToolkit().getImage("cactus.png");
    this.figure_bleue = Toolkit.getDefaultToolkit().getImage("nuage.png");
    this.figure_rouge_surlignee = Toolkit.getDefaultToolkit().getImage("plume_surligne.png");
    this.figure_verte_surlignee = Toolkit.getDefaultToolkit().getImage("cactus_surligne.png");
    this.figure_bleue_surlignee = Toolkit.getDefaultToolkit().getImage("nuage_surligne.png");
    this.fond = Toolkit.getDefaultToolkit().getImage("fond.PNG");
    this.background = Toolkit.getDefaultToolkit().getImage("fond_beige.png");

  }
  /**
   *Affiche la grille à la fenêtre.
   */
  @Override
  protected void paintComponent(Graphics pinceau) {

    Graphics secondPinceau = pinceau.create();

    if (this.isOpaque()) {

      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    secondPinceau.drawImage(this.background, 0, 0, this);

    for (int ligne = 0; ligne < 10; ligne++) {
      for (int colonne = 0; colonne < 15; colonne++) {
        if (Matrice.table[ligne][colonne] == 'R') {
          if (Matrice.actif[ligne][colonne] == 1) {
            secondPinceau.drawImage(this.figure_rouge_surlignee, 225 + colonne * 50, 150 + ligne * 50, this);
          } else if (Matrice.actif[ligne][colonne] == 2){
            secondPinceau.drawImage(this.fond, 225 + colonne * 50, 150 + ligne * 50, this);
          } else {

            secondPinceau.drawImage(this.figure_rouge, 225 + colonne * 50, 150 + ligne * 50, this);
          }
        } else if (Matrice.table[ligne][colonne] == 'V') {
          if (Matrice.actif[ligne][colonne] == 1) {
            secondPinceau.drawImage(this.figure_verte_surlignee, 225 + colonne * 50, 150 + ligne * 50, this);
          } else if (Matrice.actif[ligne][colonne] == 2){
            secondPinceau.drawImage(this.fond, 225 + colonne * 50, 150 + ligne * 50, this);
          } else {

            secondPinceau.drawImage(this.figure_verte, 225 + colonne * 50, 150 + ligne * 50, this);
          }
        } else if (Matrice.table[ligne][colonne] == 'B') {
          if (Matrice.actif[ligne][colonne] == 1) {
            secondPinceau.drawImage(this.figure_bleue_surlignee, 225 + colonne * 50, 150 + ligne * 50, this);
          } else if (Matrice.actif[ligne][colonne] == 2){
            secondPinceau.drawImage(this.fond, 225 + colonne * 50, 150 + ligne * 50, this);
          } else {

            secondPinceau.drawImage(this.figure_bleue, 225 + colonne * 50, 150 + ligne * 50, this);
          }
        } else {
          secondPinceau.drawImage(this.fond, 225 + colonne * 50, 150 + ligne * 50, this);
        }

      }

    }

    score="Ton score : " + Calculation.score.toString();
    secondPinceau.setFont(new Font("Century Schoolbook L", Font.PLAIN, 50));
    secondPinceau.drawString(score,200,100);

  }

}