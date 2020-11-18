import java.util.Arrays;
import java.util.Scanner;

class TriThreadsMain {
    public static int[] listOr;
    public static SortThread[] threadList;
    public static MergeThread mergeThread;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String demandeUtilisateur = "Entrer votre choix pour la liste des nombres entiers" + "\n" +
                "Entrer 1 pour entrée directe des valeurs entiers." + "\n" +
                "Entrer 2 pour entreé la taille de la liste et le programme va la crée.";

        // Demander a l'utilisateur son mode d'entre
        System.out.println(demandeUtilisateur);

        String choix = scanner.nextLine();
        if (choix.equals("1")) {
            System.out.println("Veuillez écrire les chiffres que vous voulez organizer et séparer par des virgules");
            listOr = RessourcesMethodes.ParseList(scanner.nextLine());
        }

        if (choix.equals("2")) {
            System.out.println("Quelle taille de liste voulez-vous?");
            listOr = RessourcesMethodes.CreateList(scanner.nextInt());
        }
        RessourcesMethodes.printTwoParts(listOr, listOr.length);
        //System.out.println("Combien de Thread voulez-vous?");
        // int NLIST = Integer.parseInt(scanner.nextLine());
        // TODO Fix the sub-list
        int NLIST = 2;
        //int NList = RessourcesMethodes.printTwoParts(listOr, listOr.length);
        //2System.out.println(NList);
        //trouve comment diviser la liste
        int count = listOr.length / NLIST;
        System.out.println("there will be " + count + " per list");

        threadList = new SortThread[NLIST];

        //créer des thread
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

        //attend que tout les thread finissent
        for (int i = 0; i < NLIST; i++) {
            threadList[i].join();
        }

        //met toutes les list ensemble pour etre mis ensemble
        int[][] GroupedList = new int[NLIST][];
        for (int i = 0; i < NLIST; i++) {
            GroupedList[i] = threadList[i].getArray();
        }
        mergeThread = new MergeThread(GroupedList);
        System.out.println("Merge: " + mergeThread);
        mergeThread.start();
    }
    // TODO: faire des methodes pour l'affichage demandé à la fin par le prof
}
