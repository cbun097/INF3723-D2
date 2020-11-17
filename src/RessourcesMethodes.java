public class RessourcesMethodes {

    public static Integer[] ParseList(String list)
    {
        long starttime= System.nanoTime()/1000000;
        list = list.replaceAll(" ", "");
        String[] stringlist = list.split(",");
        Integer[] arr = new Integer[stringlist.length];
        System.out.println("Array entree au complet");
        for(int i = 0; i< arr.length; i++) {
            arr[i] = Integer.parseInt(stringlist[i]);
            if (i<50|| i> arr.length-50) {
                System.out.print("[" + arr[i] + "]"); // affichage partiel de la liste
            }
        }
        System.out.println();
        long endtime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "creation and display time in milliseconds:  "  ,  endtime-starttime));
        return arr;
    }

    public static Integer[] CreateList(Integer taille)
    {
        Integer[] arr = new Integer[taille];
        Integer len = arr.length;
        long starttime= System.nanoTime()/1000000;

        System.out.println("Array cree au complet");
        for (Integer i = 0; i < arr.length; i++)
        {
            arr[i] = ((i % 2) * i) + ((len - i) * ((i + 1) % 2)); // entiers non triés
            if (i<50|| i> len-50) {
                System.out.print("[" + arr[i] + "]"); // affichage partiel de la liste
            }

        }
        System.out.println();
        long endtime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "creation and display time in milliseconds: "  ,  endtime-starttime));
        return arr;
    }

}
