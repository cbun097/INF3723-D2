public class SortThread extends java.lang.Thread {

    Integer[] array;
    String nom;

    public SortThread(String nom, Integer[] array) {
        this.nom = nom;
        this.array = array;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //retourne la valeur de l'array organizer
    public Integer[] getArray() {
        return this.array;
    }

    //code du prof
    void selectionSort(Integer[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int swap = a[i];
                a[i] = a[min];
                a[min] = swap;
            }
        }
    }

    @Override
    public String toString() {
        return "Thread{" +
                "nom='" + nom + '\'' +
                '}';
    }

    @Override
    public void run() {
        super.run();
        long starttime= System.nanoTime()/1000000;
        System.out.println(currentThread() + " is running");
        System.out.println(getNom() + " is running");
        selectionSort(array);
        //affiche la liste organiser
        for(int i = 0; i<array.length;i++)
        {
            System.out.println(getNom() + " : " + array[i]);
        }
        long endtime = System.nanoTime()/1000000;
        System.out.println(String.format("Sort time for %s : %d", getNom()  ,  endtime-starttime));
    }
}
