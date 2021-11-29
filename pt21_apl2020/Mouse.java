/**
 * La classe <code>Mouse</code> permet d'effectuer une action lorsque le joueur clique sur sa souris.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import java.awt.event.*;

public class Mouse implements MouseListener{

	/**
	 * Attribut permettant d'utiliser les méthodes de la classe Calculation.
	 */
	private Calculation board = new Calculation();

	/**
     * Coordonnées en x de la souris.
     */
	private int x;

	/**
     * Coordonnées en y de la souris. 
     */
	private int y;

	/**
	 * Attribut permettant de recevoir l'information à partir de quel élément la grille de jeu a été crée.
	 */
    private short choice;
    
    /**
     *Constructeur qui récupère le choix de l'utilisateur et le transmet à la variable choice.
     *
     *@param oneChoice le choix sur la génération de la grille de jeu
     */
    public Mouse(short oneChoice){
    	this.choice=oneChoice;
    }

    /**
     * Execute différentes méthodes à la suite d'un clique. 
     */
	@Override
	public void mouseClicked(MouseEvent click){
		x = click.getX();
        y = click.getY();
        
        if (x > 232 && x < 982) {
            if (y>180 && y < 680) {


            	board.groupClick();

                //affichage de la grille
                Tracer_Grille affichage_grille = new Tracer_Grille();
                if (choice==1){
	                ActionGameAleatoire.secondWindow.add(affichage_grille);
	                ActionGameAleatoire.secondWindow.repaint();	
                } else {
	                ActionGameFichier.secondWindow.add(affichage_grille);
	                ActionGameFichier.secondWindow.repaint();
                }

                

                board.gravityVertical();

	            board.gravityHorizontal();

	        	//affichage de la grille
                if (choice==1){
	                ActionGameAleatoire.secondWindow.add(affichage_grille);
	                ActionGameAleatoire.secondWindow.repaint();	
                } else {
	                ActionGameFichier.secondWindow.add(affichage_grille);
	                ActionGameFichier.secondWindow.repaint();
                }

                board.end2(choice);
				
            }
        }
	}

	public void mouseEntered(MouseEvent e){
	}

	public void mouseExited(MouseEvent e){
	}

	public void mousePressed(MouseEvent e){
	}

	public void mouseReleased(MouseEvent e){
	}
}