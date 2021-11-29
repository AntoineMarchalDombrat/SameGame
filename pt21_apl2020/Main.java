/**
 *La classe <code>Main</code> permet de lancer le projet.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

public class Main {

	public static void main(String[] args) {
    	Fenetre firstWindow = new Fenetre();
     
    	Menu menu = new Menu(firstWindow);
    	menu.afficherAccueil(); 		
   }
}