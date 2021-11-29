/**
 *La classe <code>Matrice</code> permet d'effectuer des opérations sur des tableaux à deux dimensions.
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */


import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.swing.filechooser.*;


public class Matrice {


  /**
   * Attribut qui sert transmettre une fenêtre à un objet de la classe Menu.
   */
  private Fenetre newWindow = new Fenetre();

  /**
   * Attribut de la classe Menu, pour que le menu puisse être réaffiché si jamais le joueur venait à annuler la sélection de fichier.
   */
  private Menu menu = new Menu(newWindow);

  /**
   *Tableau à deux dimensions contenant les lettres relatives aux éléments de la grille.
   */
  static public char[][] table = new char[10][15];

  /**
   *Tableau à deux dimensions contenant un si l'élément appartient au groupe survolé.
   */
  static public int[][] actif = new int[10][15];


  /**
   * Constante servant à ne pas afficher une fenêtre avec une grille vide si aucun fichier n'était sélectionné.
   */
  static public byte check=0;

  /**
  * Permet de remplir la matrice table des lettres R, V, ou B de manière aléatoire.
  */
  public void remplirMatriceAlea() {
    int alea;
    int ligne = 0;
    int colonne = 0;
    for (ligne = 0; ligne < 10; ligne++) {

      for (colonne = 0; colonne < 15; colonne++) {

        alea = new Random().nextInt(3);

        if (alea == 0) {
          Matrice.table[ligne][colonne] = 'R';

        } else if (alea == 1) {
          Matrice.table[ligne][colonne] = 'V';

        } else if (alea == 2) {
          Matrice.table[ligne][colonne] = 'B';
        }
      }
    }
  }


  /**
   *Permet de sélectionner un fichier et de remplir en fonction de son contenu, la matrice table des lettres R, V, ou B.
   */
  public void remplirMatriceFichier() {
    
    int ligne = 0;
    BufferedReader lecteurAvecBuffer = null;
    String ligne_texte;
    File repertoireCourant = null;
    try {

      repertoireCourant = new File(".").getCanonicalFile();
      //System.out.println("Répertoire courant : " + repertoireCourant);
    } catch (IOException e1) {
      System.err.println("Erreur !!");

    }

    JFileChooser dialogue = new JFileChooser(repertoireCourant);
    dialogue.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
    dialogue.addChoosableFileFilter(filter);


    dialogue.showOpenDialog(null);
    

    if (dialogue.getSelectedFile()==null){
      check=1;
      System.err.println("Erreur, aucun fichier choisi");
      menu.afficherAccueil();
    } else {
      check=0;
      File file = dialogue.getSelectedFile();
      //System.out.println("Fichier choisi : " + dialogue.getSelectedFile());

      try {

        lecteurAvecBuffer = new BufferedReader(new FileReader(file));
      } catch (FileNotFoundException exc) {
        System.out.println("Erreur d'ouverture");
      }

      try {

        while ((ligne_texte = lecteurAvecBuffer.readLine()) != null) {
          for (int colonne = 0; colonne < 15; colonne++) {
            //System.out.print(ligne_texte.charAt(colonne));
            Matrice.table[ligne][colonne] = ligne_texte.charAt(colonne);

          }
          //System.out.println("");
          ligne++;
        }

      } catch (IOException e2) {
        System.err.println("Problème de lecture");
      }

      try {
        lecteurAvecBuffer.close();
      } catch (IOException e3) {
        System.err.println("Problème de fermeture");
      }

    }
  
  }

}