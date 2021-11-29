/**
 *La classe <code>Souris</code> permet d'effectuer une action lorsque la souris se déplace.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

import java.awt.event.*;

public class Souris implements MouseMotionListener {

    /**
     * Attribut permettant d'utiliser les méthodes de la classe Calculation.
     */  
    private Calculation board = new Calculation();

    /**
     *Numéro de la ligne de la matrice relative à la position de la souris.
     */
    private int ligne;

    /**
     * Numéro de la colonné de la matrice relative à la position de la souris.
     */
    private int colonne;

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
    public Souris(short oneChoice){
        this.choice=oneChoice;
    }

    /**
     * Execute différentes méthodes à la suite d'un mouvement de souris.
     */
    @Override
    public void mouseMoved(MouseEvent bouge) {
        x = bouge.getX();
        y = bouge.getY();
        
        if (x > 232 && x < 982) {
            if (y>180 && y < 680) {
                ligne = (y - 180)/50;
                colonne = (x - 232)/50;

                board.resetMatrice();

                board.group(ligne, colonne);


                //affichage de la grille
                Tracer_Grille affichage_grille = new Tracer_Grille();
                if (choice==1){
                    ActionGameAleatoire.secondWindow.add(affichage_grille);
                    ActionGameAleatoire.secondWindow.repaint(); 
                } else {
                    ActionGameFichier.secondWindow.add(affichage_grille);
                    ActionGameFichier.secondWindow.repaint();
                }
                
                board.end1(this.choice);
            }
        }

    }

    public void mouseDragged(MouseEvent e) {
    }
}