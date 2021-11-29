/**
 *La class <code>TracerTitre</code> permet d'afficher le titre du jeu pour le menu.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import javax.swing.*;
import java.awt.*;

public class TracerTitre extends JComponent {
  
  /**
   *Image représentant le titre du jeu.
   */
  private Image titre;

  /**
   *Permet d'attribuer à l'objet Image son image correspondante.
   */
  public TracerTitre() {
    super();
    this.titre = Toolkit.getDefaultToolkit().getImage("SameGame.png");
  }


  /**
   *Affiche le titre du jeu.
   */
  @Override
  protected void paintComponent(Graphics pinceau) {
   
    Graphics secondPinceau = pinceau.create();
 
    if (this.isOpaque()) {

      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    secondPinceau.drawImage(this.titre, 0, 0, this);
  }
}
