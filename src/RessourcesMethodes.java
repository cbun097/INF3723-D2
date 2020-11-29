import java.util.Scanner;

public class RessourcesMethodes {

    // Méthode qui lit les valeurs entrées par l'utilisateur, séparer par des virgules
    public static int[] ParseList(String list)
    {
        long startTime= System.nanoTime()/1000000;
        list = list.replaceAll(" ", "");
        String[] stringList = list.split(",");
        int[] arr = new int[stringList.length];
        System.out.println("Liste entrée: ");
        for(int i = 0; i< arr.length; i++) {
            arr[i] = Integer.parseInt(stringList[i]);
            if (i<50|| i> arr.length-50) {
                System.out.print("[" + arr[i] + "]"); // affichage partiel de la liste
            }
        }
        System.out.println();
        long endTime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "Création et temps en millisecondes:  "  ,  endTime-startTime));
        return arr;
    }

    // Créer la liste désirée selon les valeurs alléatoires
    public static int[] CreateList(int taille)
    {
        int[] arr = new int[taille];
        int len = arr.length;
        long startTime= System.nanoTime()/1000000;

        System.out.println("Liste crée: ");
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = ((i % 2) * i) + ((len - i) * ((i + 1) % 2)); // entiers non triés
            if (i<50|| i> len-50) {
                System.out.print("[" + arr[i] + "]"); // affichage partiel de la liste
            }

        }
        System.out.println();
        long endTime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "Création et temps en millisecondes: "  ,  endTime-startTime));
        return arr;
    }

    // Affichage des listes
    public static void ShowList(int[] listOr)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous voir les premieres 100 entrées de la liste? (y/n) :");
        String choix = scanner.nextLine();
        if (choix.equals("y")) {
            try {
                for (int i = 0; i < 100; i++) {
                    if (i != 99)
                        System.out.print(listOr[i] + ", ");
                    else
                        System.out.println(listOr[i]);
                }
                int counteur = 1;
                while (true) {
                    System.out.println("Voulez-vous voir les prochaines 100 entrées? (y/n) :");
                    choix = scanner.nextLine();
                    if (choix.equals("y")) {

                        for (int i = counteur * 100; i < ((counteur + 1) * 100); i++) {
                            if (i != 99)
                                System.out.print(listOr[i] + ", ");
                            else
                                System.out.println(listOr[i]);
                        }

                    } else break;
                }
            }
            catch (ArrayIndexOutOfBoundsException | NullPointerException e)
            {
                System.out.println("\nIl n'y a plus d'entrées dans la liste");
            }
        }
    }
}
