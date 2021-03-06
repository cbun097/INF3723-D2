import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class TriThreadsMain {
    public static int[] listOr;
    public static SortThread[] threadList;
    public static MergeThread mergeThread;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String demandeUtilisateur = "Entrer votre choix pour la liste des nombres entiers" + "\n" +
                "Entrer 1 pour entrée directe des valeurs entiers." + "\n" +
                "Entrer 2 pour entrée la taille de la liste et le programme va la crée.";

        // Demander à l'utilisateur son mode d'entre
        System.out.println(demandeUtilisateur);

        String choix = scanner.nextLine();
        if (choix.equals("1")) {
            System.out.println("Veuillez écrire les chiffres que vous voulez organiser et les séparer par des virgules");
            listOr = RessourcesMethodes.ParseList(scanner.nextLine());
        }

        if (choix.equals("2")) {
            System.out.println("Quelle est la taille de liste désirez-vous?");
            listOr = RessourcesMethodes.CreateList(scanner.nextInt());
        }

        RessourcesMethodes.ShowList(listOr);

        System.out.println("Combien de sous-liste voulez-vous?");
        int NLIST = scanner.nextInt();
        long starttime= System.nanoTime();
        //trouve comment diviser la liste
        int count = listOr.length / NLIST;

        threadList = new SortThread[NLIST];

        //créer des threads
        for (int i = 0; i < NLIST; i++) {
            if (i != NLIST - 1) {
                //si pas la derniere
                threadList[i] = new SortThread("thread" + i, Arrays.copyOfRange(listOr, i * count, (i + 1) * count));
            } else {
                //si la derniere (pour ne pas oublier certain ex : 100/3 == 33)
                threadList[i] = new SortThread("thread" + i, Arrays.copyOfRange(listOr, i * count, (listOr.length)));
            }
            threadList[i].start();
        }

        //attend que tous les threads finissent
        for (int i = 0; i < NLIST; i++) {
            threadList[i].join();
            threadList[i].ShowSpecialFormatArray();
        }

        if(NLIST != 1) {
            //met toutes les listes ensemble
            int[][] GroupedList = new int[NLIST][];
            for (int i = 0; i < NLIST; i++) {
                GroupedList[i] = threadList[i].getArray();
            }

            mergeThread = new MergeThread(GroupedList);
            mergeThread.start();
            mergeThread.join();
        }
        else
        {
            System.out.println("avec un seul thread, il n'est pas possible de faire une fusion, fin de la tache.");
            for(int i = 0; i<threadList[0].getArray().length; i++)
            {
                System.out.print("[" + threadList[0].getArray()[i] + "]");
            }
        }
        long endtime = System.nanoTime();
        long result = endtime - starttime;
        if(result > 1000000)
            System.out.println("\nLe programmes est complété en millisecondes:  " + TimeUnit.NANOSECONDS.toMillis(result));
        else
            System.out.println("\nLe programmes est complété en millisecondes:  " + String.format("%.5f",((double) result)/10000000));
    }
}
