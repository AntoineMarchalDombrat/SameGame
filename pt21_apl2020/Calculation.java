/**
 * La classe <code>Calculation</code> regroupe toutes les méthodes qui permettent de réaliser les règles du jeu. La gravité, effet de groupe...
 *
 * @version 1.1 
 * @author Antoine MARCHAL DOMBRAT et Romain SAVARY
 */

public class Calculation {

    /**
     * Attibut permettant de transmettre la fenêtre de jeu qui a été lancer depuis une grille aléatoire.
     */
	private End endAlea = new End(ActionGameAleatoire.secondWindow);

    /**
     * Attibut permettant de transmettre la fenêtre de jeu qui a été lancer depuis un fichier.
     */
    private End endFile = new End(ActionGameFichier.secondWindow);
	
	/**
     * Constante permettant d'éviter que la fin de la partie se lance plusieurs fois par erreur.
     */
	static public byte oneEnd=0;

	/**
     * Constante qui permet de suivre les points du joueur tout au long de la partie.
     */
	static public Point score = new Point();


	/**
     * Méthode qui permet de remettre la matrice actif à 0 pour les images qui n'ont pas été encore pris par le joueur.
     */
	public void resetMatrice(){
		for (int line = 0; line < 10; line++) {
            for (int column = 0; column < 15; column++) {
                if (Matrice.actif[line][column]!=2){
                    Matrice.actif[line][column]=0;
                }
            }
        }
	}

	/**
     * Méthode permettant de créer un groupe.
     *
     * On regarde d'abord quelle image est survolé, son emplacement plus sa couleur.
     * Puis on regarde ses voisins s'ils sont de la même couleur.
     * Si oui alors on les met ensemble pour former un groupe
     * S'il n'a aucun voisin de la même couleur alors aucun groupe ne se forme.
     */
	public void group(int ligne, int colonne){

		// l'élément survolé devient actif
		if (Matrice.actif[ligne][colonne]!=2){
            Matrice.actif[ligne][colonne]=1;
        }

        //on récupère la couleur de l'élément survolé
        char element = Matrice.table[ligne][colonne];

        //On regarde les voisins de l'élément sélectionné
        for (int i = 0; i < 23; i++){
            for (int line = 0; line < 10; line++){
                for (int column = 0; column < 15; column++){
                    if (Matrice.actif[line][column]==1){
                        if ((line-1==-1) && (column-1==-1)){
                            if (Matrice.table[line+1][column]==element && Matrice.actif[line+1][column]!=1){
                                Matrice.actif[line+1][column]=1;
                            } 
                            if (Matrice.table[line][column+1]==element && Matrice.actif[line][column+1]!=1){
                                Matrice.actif[line][column+1]=1;
                            } 
                        } else if ((line-1==-1) && (column+1==15)){
                            if (Matrice.table[line][column-1]==element && Matrice.actif[line][column-1]!=1){
                                Matrice.actif[line][column-1]=1;
                            }
                            if (Matrice.table[line+1][column]==element && Matrice.actif[line+1][column]!=1){
                                Matrice.actif[line+1][column]=1;
                            }
                        } else if ((line+1==10) && (column-1==-1)){
                            if (Matrice.table[line-1][column]==element && Matrice.actif[line-1][column]!=1){
                                Matrice.actif[line-1][column]=1;
                            }
                            if (Matrice.table[line][column+1]==element && Matrice.actif[line][column+1]!=1){
                                Matrice.actif[line][column+1]=1;
                            }
                        } else if ((line+1==10) && (column+1==15)){
                            if (Matrice.table[line-1][column]==element && Matrice.actif[line-1][column]!=1){
                                Matrice.actif[line-1][column]=1;
                            }
                            if (Matrice.table[line][column-1]==element && Matrice.actif[line][column-1]!=1){
                                Matrice.actif[line][column-1]=1;
                            }
                        } else if (line-1==-1) {
                            if (Matrice.table[line+1][column]==element && Matrice.actif[line+1][column]!=1){
                                Matrice.actif[line+1][column]=1;
                            } 
                            if (Matrice.table[line][column+1]==element && Matrice.actif[line][column+1]!=1){
                                Matrice.actif[line][column+1]=1;
                            }
                            if (Matrice.table[line][column-1]==element && Matrice.actif[line][column-1]!=1){
                                Matrice.actif[line][column-1]=1;
                            }
                        } else if (line+1==10) {
                            if (Matrice.table[line-1][column]==element && Matrice.actif[line-1][column]!=1){
                                Matrice.actif[line-1][column]=1;
                            }
                            if (Matrice.table[line][column+1]==element && Matrice.actif[line][column+1]!=1){
                                Matrice.actif[line][column+1]=1;
                            }
                            if (Matrice.table[line][column-1]==element && Matrice.actif[line][column-1]!=1){
                                Matrice.actif[line][column-1]=1;
                            }
                        } else if (column-1==-1){
                            if (Matrice.table[line+1][column]==element && Matrice.actif[line+1][column]!=1){
                                Matrice.actif[line+1][column]=1;
                            }
                            if (Matrice.table[line-1][column]==element && Matrice.actif[line-1][column]!=1){
                                Matrice.actif[line-1][column]=1;
                            }
                            if (Matrice.table[line][column+1]==element && Matrice.actif[line][column+1]!=1){
                                Matrice.actif[line][column+1]=1;
                            }
                        } else if (column+1==15){
                            if (Matrice.table[line+1][column]==element && Matrice.actif[line+1][column]!=1){
                                Matrice.actif[line+1][column]=1;
                            }
                            if (Matrice.table[line-1][column]==element && Matrice.actif[line-1][column]!=1){
                                Matrice.actif[line-1][column]=1;
                            }
                            if (Matrice.table[line][column-1]==element && Matrice.actif[line][column-1]!=1){
                                Matrice.actif[line][column-1]=1;
                            }
                        } else {
                            if (Matrice.table[line+1][column]==element && Matrice.actif[line+1][column]!=1){
                                Matrice.actif[line+1][column]=1;
                            }
                            if (Matrice.table[line-1][column]==element && Matrice.actif[line-1][column]!=1){
                                Matrice.actif[line-1][column]=1;
                            }
                            if (Matrice.table[line][column-1]==element && Matrice.actif[line][column-1]!=1){
                                Matrice.actif[line][column-1]=1;
                            }
                            if (Matrice.table[line][column+1]==element && Matrice.actif[line][column+1]!=1){
                                Matrice.actif[line][column+1]=1;
                            }
                        }
                    }
                }  
            }
        }

        //On regarde si l'élément sélectionné est tout seul ou non
        short groupe=0;
        for (int column = 0; column < 15; column++) {
            for (int line = 0; line < 10; line++) {
                if (Matrice.actif[line][column]==1){
                    groupe+=1;
                }
            }
        }
        //Si oui alors on le désélectionne
        if (groupe==1){ 
            for (int column = 0; column < 15; column++) {
                for (int line = 0; line < 10; line++) {
                    if (Matrice.actif[line][column]==1){
                        Matrice.actif[line][column]=0;
                    }       
                }
            }
        }
	}

    /**
     * Méthode qui permet de déterminer si le joueur à encore des possibilités.
     * S'il n'a plus de coup alors elle met fin au jeu.
     */
	public void end1(short choice){

		//On regarde est-ce qu'il y a des éléments tout seul (mais nous n'avons pas besoin de passer dessu pour le savoir,ce qui est le cas de la boucle plus haut), si oui on les note avec 3.
        for (int line=0; line<10; line++){
            for (int column=0; column<15; column++){
                if(Matrice.table[line][column]=='R'){
                    if ((line-1==-1) && (column-1==-1)){
                        if (Matrice.table[line+1][column]!='R' && Matrice.table[line][column+1]!='R'){
                            Matrice.actif[line][column]=3;
                        } 
                    } else if ((line-1==-1) && (column+1==15)){
                        if (Matrice.table[line][column-1]!='R' && Matrice.table[line+1][column]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if ((line+1==10) && (column-1==-1)){
                        if (Matrice.table[line-1][column]!='R' && Matrice.table[line][column+1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if ((line+1==10) && (column+1==15)){
                        if (Matrice.table[line-1][column]!='R' && Matrice.table[line][column-1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (line-1==-1) {
                        if (Matrice.table[line+1][column]!='R' && Matrice.table[line][column+1]!='R' && Matrice.table[line][column-1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (line+1==10) {
                        if (Matrice.table[line-1][column]!='R' && Matrice.table[line][column+1]!='R' && Matrice.table[line][column-1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (column-1==-1){
                        if (Matrice.table[line+1][column]!='R' && Matrice.table[line-1][column]!='R' && Matrice.table[line][column+1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (column+1==15){
                        if (Matrice.table[line+1][column]!='R' && Matrice.table[line-1][column]!='R' && Matrice.table[line][column-1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    } else {
                        if (Matrice.table[line+1][column]!='R' && Matrice.table[line-1][column]!='R' && Matrice.table[line][column-1]!='R' && Matrice.table[line][column+1]!='R'){
                            Matrice.actif[line][column]=3;
                        }
                    }
                } else if(Matrice.table[line][column]=='V'){
                    if ((line-1==-1) && (column-1==-1)){
                        if (Matrice.table[line+1][column]!='V' && Matrice.table[line][column+1]!='V'){
                            Matrice.actif[line][column]=3;
                        } 
                    } else if ((line-1==-1) && (column+1==15)){
                        if (Matrice.table[line][column-1]!='V' && Matrice.table[line+1][column]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if ((line+1==10) && (column-1==-1)){
                        if (Matrice.table[line-1][column]!='V' && Matrice.table[line][column+1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if ((line+1==10) && (column+1==15)){
                        if (Matrice.table[line-1][column]!='V' && Matrice.table[line][column-1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (line-1==-1) {
                        if (Matrice.table[line+1][column]!='V' && Matrice.table[line][column+1]!='V' && Matrice.table[line][column-1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (line+1==10) {
                        if (Matrice.table[line-1][column]!='V' && Matrice.table[line][column+1]!='V' && Matrice.table[line][column-1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (column-1==-1){
                        if (Matrice.table[line+1][column]!='V' && Matrice.table[line-1][column]!='V' && Matrice.table[line][column+1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (column+1==15){
                        if (Matrice.table[line+1][column]!='V' && Matrice.table[line-1][column]!='V' && Matrice.table[line][column-1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    } else {
                        if (Matrice.table[line+1][column]!='V' && Matrice.table[line-1][column]!='V' && Matrice.table[line][column-1]!='V' && Matrice.table[line][column+1]!='V'){
                            Matrice.actif[line][column]=3;
                        }
                    }
                } else if(Matrice.table[line][column]=='B'){
                    if ((line-1==-1) && (column-1==-1)){
                        if (Matrice.table[line+1][column]!='B' && Matrice.table[line][column+1]!='B'){
                            Matrice.actif[line][column]=3;
                        } 
                    } else if ((line-1==-1) && (column+1==15)){
                        if (Matrice.table[line][column-1]!='B' && Matrice.table[line+1][column]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if ((line+1==10) && (column-1==-1)){
                        if (Matrice.table[line-1][column]!='B' && Matrice.table[line][column+1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if ((line+1==10) && (column+1==15)){
                        if (Matrice.table[line-1][column]!='B' && Matrice.table[line][column-1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (line-1==-1) {
                        if (Matrice.table[line+1][column]!='B' && Matrice.table[line][column+1]!='B' && Matrice.table[line][column-1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (line+1==10) {
                        if (Matrice.table[line-1][column]!='B' && Matrice.table[line][column+1]!='B' && Matrice.table[line][column-1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (column-1==-1){
                        if (Matrice.table[line+1][column]!='B' && Matrice.table[line-1][column]!='B' && Matrice.table[line][column+1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else if (column+1==15){
                        if (Matrice.table[line+1][column]!='B' && Matrice.table[line-1][column]!='B' && Matrice.table[line][column-1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    } else {
                        if (Matrice.table[line+1][column]!='B' && Matrice.table[line-1][column]!='B' && Matrice.table[line][column-1]!='B' && Matrice.table[line][column+1]!='B'){
                            Matrice.actif[line][column]=3;
                        }
                    }
                }
            }
        }
        //on regarde ici, s'il ne reste que des éléments isolés
        short notYet=0;
        for (int line = 0; line < 10; line++) {
            for (int column = 0; column < 15; column++) {
                if (Matrice.actif[line][column]==0 || Matrice.actif[line][column]==1){
                    notYet+=1;
                }
            }
        } 
        //si on rentre dans le if alors il reste des éléments non isolé (et on remet libre les éléments isolés), en revanche si on rentre dans le else il n'y a plus de coup possible
        if(notYet>0){
            for (int line = 0; line < 10; line++) {
                for (int column = 0; column < 15; column++) {
                    if (Matrice.actif[line][column]==3){
                        Matrice.actif[line][column]=0;
                    }
                }   
            } 
        } else if (oneEnd==0){
            oneEnd=1;
            if (choice==1){
                endAlea.endScreen();
            } else {
                endFile.endScreen();
            }
        }
	}

    /**
     * Méthode permettant de mettre un groupe survolé en groupe cliqué. Plus calcul les points que rapportent le groupe devenu cliqué.
     */
	public void groupClick(){
		short counter=0;
        for (int line = 0; line < 10; line++) {
            for (int column = 0; column < 15; column++) {
                if (Matrice.actif[line][column]==1) {
                    Matrice.actif[line][column]=2;
                    counter+=1;
                }
            }
        }
        if (counter!=0){
            score.sum(counter);
        }
	}

    /**
     * Méthode donnant la gravité verticale au jeu
     */ 
	public void gravityVertical(){
        for (int i=0; i<10; i++){
	        for (int line = 9; line >= 0; line--) {
	            for (int column = 0; column < 15; column++) {
	                if (Matrice.actif[line][column]==2) {
	                    if (line-1==-1){

	                    Matrice.table[line][column]='G';
	                	} else {
	                    	if (Matrice.actif[line-1][column]==0){

	                        	Matrice.actif[line-1][column]=2;
	                        	Matrice.actif[line][column]=0;

	                        	Matrice.table[line][column]=Matrice.table[line-1][column];
	                        	Matrice.table[line-1][column]='G';

	                    	} else if (Matrice.table[line-1][column]=='G'){
	                        	Matrice.table[line][column]='G';
	                    	}
	                	}
	            	}
	        	}
	    	}
		}
        
	}

    /**
     * Méthode donnant la gravité horizontal au jeu
     */ 
	public void gravityHorizontal(){
	    short empty;
        for (int i=0; i<4; i++){
		    for (int column = 0; column < 15; column++) {
		        empty=0;

	         	for (int line = 0; line < 10; line++) {
		            if (Matrice.table[line][column]=='G'){
		                empty+=1;
		                        
		            }
		            if (empty==10){
		                for (int columncolumn=column; columncolumn<15; columncolumn++){
		                	for(int lineline=0; lineline < 10; lineline++){
			                	if (columncolumn+1==15){
			                		Matrice.table[lineline][columncolumn]='G';
			                	} else {
			                		if (Matrice.actif[lineline][columncolumn+1]==0){

				                		Matrice.actif[lineline][columncolumn]=0;
				                		Matrice.actif[lineline][columncolumn+1]=2;

				                		Matrice.table[lineline][columncolumn]=Matrice.table[lineline][columncolumn+1];
				                		Matrice.table[lineline][columncolumn+1]='G';

			                		} else if (Matrice.table[lineline][columncolumn+1]=='G'){
			                			Matrice.table[lineline][columncolumn]='G';
			                		}
			                	}
		                	}
		                }
		            }
		        }
		    }
	    }
	}

    /**
     * Méthode permettant de déterminer si toutes les images ont été cliqué.
     * Et si c'est le cas, alors elle met fin au jeu.
     */
	public void end2(short choice){
        short win=0;
        for (int line = 0; line<10; line++){
            for (int column = 0; column<15; column++){
                if (Matrice.table[line][column]=='G'){
                	win+=1;
                }
            }
        }
        if (win==150 && oneEnd==0){
            oneEnd=1;
            if(choice==1){
				endAlea.endScreen();
            } else {
                endFile.endScreen();
            }
        }
	}	
}