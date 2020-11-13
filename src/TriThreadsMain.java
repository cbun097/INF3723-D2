import java.util.Scanner;

class TriThreadsMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String demandeUtilisateur = "Entrer votre choix pour la liste des nombres entiers" +"\n" +
                "Entrer 1 pour entrés directe des valeurs entiers." + "\n" +
                "Entrer 2 pour entreé a taille de la liste et le programme va la crée.";

        // Demander a l'utilisateur son mode d'entre
        System.out.println(demandeUtilisateur);

        String choix = scanner.nextLine();
        System.out.println("choix " + choix);

        if(choix.equals("1")) {
            // séparés la liste entree par le user - Methode
        }

        if(choix.equals("2")) {
            System.out.println("demander la taille");
            // ask user taille
        }

        Thread thread0 = new Thread("thread0");
        Thread thread1 = new Thread("thread1");

        thread0.start();
        thread1.start();

        // code du prof
        int[] arr = new int[1000];
        int len = arr.length;
        long starttime= System.nanoTime()/1000000;

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = ((i % 2) * i) + ((len - i) * ((i + 1) % 2)); // entiers non triés
            if (i<50|| i> len-50) {
                System.out.println(arr[i]); // affichage partiel de la liste
            }

        }
        long endtime = System.nanoTime()/1000000;
        //System.out.println(String.format("%s %,d", "creation and display time in milliseconds:  "  ,  endtime-starttime));
    }

    // TODO: faire des methodes pour l'affichage demandé à la fin par le prof
}
