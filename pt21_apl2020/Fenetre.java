/**
 *La classe <code>Fenetre</code> permet de créer une fenêtre.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

	/**
	 *Le constructeur permet de créer la fenêtre avec certaines dimensions.
	 */
  public Fenetre(){
    super();
    this.setSize(1200, 700);
    this.setLocation(100, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
  }
}