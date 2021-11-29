### VARIABLES ###
 
JC = javac

JFLAGS = -encoding UTF-8 -implicit:none

EXE = ActionGameAleatoire.class   \
	  ActionGameFichier.class 	  \
	  Calculation.class 		  \
	  End.class			  		  \
	  EndDesign.class             \
	  ExitGame.class 			  \
	  Fenetre.class 			  \
	  Main.class 			   	  \
	  Matrice.class 			  \
   	  Menu.class 			   	  \
   	  Mouse.class 				  \
	  Point.class                 \
	  RestartGame.class 		  \
	  Souris.class 				  \
	  Tracer_Grille.class 	   	  \
	  TracerTitre.class           

JFILES = ActionGameAleatoire.java \
		 ActionGameFichier.java   \
		 Calculation.java 		  \
		 End.java         		  \
		 EndDesign.java  		  \
		 ExitGame.java 			  \
		 Fenetre.java 			  \
		 Main.java 			   	  \
		 Matrice.java 			  \
		 Menu.java 			   	  \
		 Mouse.java 			  \
		 Point.java 			  \
		 RestartGame.java 		  \
		 Souris.java       		  \
		 Tracer_Grille.java 	  \
		 TracerTitre.java 	      

 
### BUT PAR DEFAUT ###
 
but : ${EXE}
 
### REGLES ESSENTIELLES ###
 
ActionGameAleatoire.class : ActionGameAleatoire.java

ActionGameFichier.class : ActionGameFichier.java

Calculation.class : Calculation.java

End.class : End.java

EndDesign.class : EndDesign.java

ExitGame.class : ExitGame.java

Fenetre.class : Fenetre.java

Main.class : Main.java
 
Matrice.class : Matrice.java

Menu.class : Menu.java

Mouse.class : Mouse.java

Point.class : Point.java

RestartGame.class : RestartGame.java

Souris.class : Souris.java

Tracer_Grille.class : Tracer_Grille.java

TracerTitre.class : TracerTitre.java


${EXE} : ${JFILES}
	$(JC) $(JFLAGS) ${JFILES}

### REGLES OPTIONNELLES ###
 
clean :
	-rm -f ${EXE}

mrproper : clean but

run :
	java Main

### BUTS FACTICES ###
 
.PHONY : but clean mrproper
 
### FIN ###