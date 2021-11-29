/**
 * La classe <code>EndDesign</code> permet d'affiché le titre de fin et le score.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import javax.swing.*;
import java.awt.*;

public class EndDesign extends JComponent {

  /**
   * Attribut qui permet de contenir le message des points.
   */
  private String result;

  /**
   * Attribut qui permet de contenir le titre de fin.
   */ 
  private Image end;

  /**
   * Constructeur qui met le titre de fin dans l'attribut end.
   */
	public EndDesign(){
		super();
    this.end = Toolkit.getDefaultToolkit().getImage("end.png");
	}

  /**
   * Affiche le titre de fin avec le message de score.
   */
	@Override
  	protected void paintComponent(Graphics pinceau) {
   
    Graphics secondPinceau = pinceau.create();
 
    if (this.isOpaque()) {

      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    secondPinceau.drawImage(this.end, 0, 0, this);
    
    if (Calculation.score.getValue()!=1){
      result="tu as fini avec " + Calculation.score.toString() + " points.";
    } else {
      result="tu as fini avec 1 point.";
    }
    secondPinceau.setFont(new Font("Century Schoolbook L", Font.PLAIN, 40));
    secondPinceau.drawString(result,130,300);

  }
}