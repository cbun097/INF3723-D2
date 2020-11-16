import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class TriThreadsMain {
    public static Integer[] ListOr;
    public static SortThread[] ThreadList;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String demandeUtilisateur = "Entrer votre choix pour la liste des nombres entiers" +"\n" +
                "Entrer 1 pour entrés directe des valeurs entiers." + "\n" +
                "Entrer 2 pour entreé a taille de la liste et le programme va la crée.";

        // Demander a l'utilisateur son mode d'entre
        System.out.println(demandeUtilisateur);

        String choix = scanner.nextLine();
        System.out.println("choix " + choix);

        if(choix.equals("1")) {
            System.out.println("veuillez ecrire les chiffres que vous voulez organizer separer par des virgules");
            ListOr = ParseList(scanner.nextLine());
        }

        if(choix.equals("2")) {
            System.out.println("quel grandeur de list voulez-vous?");
            ListOr = CreateList(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("Combien de Thread voulez-vous?");
        int NLIST = Integer.parseInt(scanner.nextLine());

        //trouve comment diviser la liste
        int count = ListOr.length/NLIST;
        System.out.println("there will be " + count + " per list");

        ThreadList = new SortThread[NLIST];

        //créer des thread
        for(int i = 0; i<NLIST; i++)
        {
            if(i != NLIST-1) {
                //si pas la derniere
                ThreadList[i] = new SortThread("thread" + i, Arrays.copyOfRange(ListOr, i * count, (i + 1) * count));
            }
            else
            {
                //si la derniere (pour ne pas oublier certain ex : 100/3 == 33)
                ThreadList[i] = new SortThread("thread" + i, Arrays.copyOfRange(ListOr, i*count, (ListOr.length)));
            }
            ThreadList[i].start();
        }

        //attend que tout les thread finissent
        for(int i = 0; i<NLIST; i++) {
            ThreadList[i].join();
        }
        System.out.println("sorting complete");

        //met toutes les list ensemble pour etre mis ensemble
        Integer[][] GroupedList = new Integer[NLIST][];
        for(int i = 0; i<NLIST; i++) {
            GroupedList[i] = ThreadList[i].getArray();
        }
        MergeThread mergeThread = new MergeThread(GroupedList);
        mergeThread.start();


    }

    public static Integer[] CreateList(Integer taille)
    {
        Integer[] arr = new Integer[taille];
        Integer len = arr.length;
        long starttime= System.nanoTime()/1000000;

        for (Integer i = 0; i < arr.length; i++)
        {
            arr[i] = ((i % 2) * i) + ((len - i) * ((i + 1) % 2)); // entiers non triés
            if (i<50|| i> len-50) {
                System.out.println(arr[i]); // affichage partiel de la liste
            }

        }
        long endtime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "creation and display time in milliseconds:  "  ,  endtime-starttime));
        return arr;
    }

    public static Integer[] ParseList(String list)
    {
        long starttime= System.nanoTime()/1000000;
        list = list.replaceAll(" ", "");
        String[] stringlist = list.split(",");
        Integer[] arr = new Integer[stringlist.length];
        for(int i = 0; i< arr.length; i++) {
            arr[i] = Integer.parseInt(stringlist[i]);
            if (i<50|| i> arr.length-50) {
                System.out.println(arr[i]); // affichage partiel de la liste
            }
        }
        long endtime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "creation and display time in milliseconds:  "  ,  endtime-starttime));
        return arr;
    }

    // TODO: faire des methodes pour l'affichage demandé à la fin par le prof
}
