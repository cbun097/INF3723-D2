import java.util.Arrays;
import java.util.Scanner;

class TriThreadsMain {
    public static Integer[] listOr;
    public static SortThread[] threadList;
    public static MergeThread mergeThread;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String demandeUtilisateur = "Entrer votre choix pour la liste des nombres entiers" + "\n" +
                "Entrer 1 pour entrés directe des valeurs entiers." + "\n" +
                "Entrer 2 pour entreé a taille de la liste et le programme va la crée.";

        // Demander a l'utilisateur son mode d'entre
        System.out.println(demandeUtilisateur);

        String choix = scanner.nextLine();
        if (choix.equals("1")) {
            System.out.println("veuillez ecrire les chiffres que vous voulez organizer separer par des virgules");
            listOr = RessourcesMethodes.ParseList(scanner.nextLine());
            System.out.println("List or choix 1 " + Arrays.toString(listOr));
        }

        if (choix.equals("2")) {
            System.out.println("quel grandeur de list voulez-vous?");
            listOr = RessourcesMethodes.CreateList(Integer.parseInt(scanner.nextLine()));
            System.out.println("List or choix 2 " + Arrays.toString(listOr));
        }
        //System.out.println("Combien de Thread voulez-vous?");
        // int NLIST = Integer.parseInt(scanner.nextLine());
        // TODO Fix the sub-list
        int NLIST = 2;

        //trouve comment diviser la liste
        int count = listOr.length / NLIST;
        System.out.println("there will be " + count + " per list");

        threadList = new SortThread[NLIST];

        //créer des thread
        for (int i = 0; i < NLIST; i++) {
            if (i != NLIST - 1) {
                //si pas la derniere
                threadList[i] = new SortThread("thread" + i, Arrays.copyOfRange(listOr, i * count, (i + 1) * count));
                System.out.println("Sub-list " + Arrays.toString(listOr));
            } else {
                //si la derniere (pour ne pas oublier certain ex : 100/3 == 33)
                threadList[i] = new SortThread("thread" + i, Arrays.copyOfRange(listOr, i * count, (listOr.length)));
                System.out.println("Sub-list " + Arrays.toString(listOr));
            }
            threadList[i].start();
        }

        //attend que tout les thread finissent
        for (int i = 0; i < NLIST; i++) {
            threadList[i].join();
        }

        //met toutes les list ensemble pour etre mis ensemble
        Integer[][] GroupedList = new Integer[NLIST][];
        for (int i = 0; i < NLIST; i++) {
            GroupedList[i] = threadList[i].getArray();
        }
        mergeThread = new MergeThread(GroupedList);
        System.out.println("Merge: " + mergeThread);
        mergeThread.start();
    }
    // TODO: faire des methodes pour l'affichage demandé à la fin par le prof
}
