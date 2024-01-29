/*
 Devoir 2
 présenté à Jean-François Landry
 par mzevallos
 aut 2022
 */

package gg.sim.mzevallos.devoir2;

import java.util.Locale;

/**
 *
 * @author mzevallos
 */
public class Devoir2 {

    public static void main(String[] args) {
         
        
        String[] etudiants = {"Vincent Crabbe", "Gregory Goyle", "Hermione Granger", "Sue Li", "Neville Longdubat",
            "Luna Lovegood", "Drago Malefoy", "Harry Potter", "Ginny Weasley", "Ron Weasley"};
        int[]    notes     = {-1 , 1, 99, 92, 84, 63, 39, 98, 87, 59 };
        
        String[] commentaires = {"Exclus du calcul de la  moyenne.", "Plus forte note :)", "Non-remis", 
            "Plus basse note :(", " "};
       
        String message= String.format(Locale.US,"%s", "---Devoir 2 par Marcelo Zevallos---");
        System.out.println(message);
        
        String separation= String.format(Locale.US,"|----------------------------------------------------------------|");
        System.out.println(separation);

        String test= String.format(Locale.US,"|Id|         Nom        |Note|          Commentaire              |");
        System.out.println(test);
        
        System.out.println(separation);
        
        float moyenne = 0f;
        float total = 0f;
        int notesMoyenne = 0;
        int max = notes[0];
        int min = 100;
        
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] > max) {
                max = notes[i];
            } else if(notes[i] < min && notes[i] > 40){
                    min  = notes[i];   
            }
        }
  
        for(int i = 0; i < etudiants.length; i++){
            
        int id = i + 1;
        
            if (notes[i] < 0){
                String resultatExclu= String.format(Locale.US,"|%02d|%20S| -- |%-35s|", id, etudiants[i], 
                        commentaires[2]);
                System.out.println(resultatExclu);
                
            } else if (notes[i] < 40){
                String resultatExclu= String.format(Locale.US,"|%02d|%20S|%4d|%-35s|", id, etudiants[i], notes[i], 
                        commentaires[0]);
                System.out.println(resultatExclu);
                             
            } else if (notes[i] > 40){
                
                if(notes[i] == max){
                    total = total + notes[i];
                    notesMoyenne = notesMoyenne + 1;

                    String resultat= String.format(Locale.US,"|%02d|%20S|%4d|%-35s|", id, etudiants[i], notes[i], 
                            commentaires[1]);
                    System.out.println(resultat);
                } else if(notes[i] == min){
                    total = total + notes[i];
                    notesMoyenne = notesMoyenne + 1;

                    String resultat= String.format(Locale.US,"|%02d|%20S|%4d|%-35d|", id, etudiants[i], notes[i], 
                            commentaires[3]);
                    System.out.println(resultat);
                } else {
                                    
                    total = total + notes[i];
                    notesMoyenne = notesMoyenne + 1;

                    String resultat= String.format(Locale.US,"|%02d|%20S|%4d|%-35s|", id, etudiants[i], notes[i], 
                            commentaires[4]);
                    System.out.println(resultat);
                }
            }
        }
        moyenne = total/notesMoyenne;
        System.out.println(separation);
        System.out.println("Moyenne (" + notesMoyenne + "): " + ((float)Math.round(moyenne*10)/10));
       
         
    }
}
