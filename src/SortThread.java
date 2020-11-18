public class SortThread extends java.lang.Thread {

    int[] array;
    String nom;

    public SortThread(String nom, int[] array) {
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
    public int[] getArray() {
        return this.array;
    }

    //code du prof
    void selectionSort(int[] a) {
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
    public void run() {
        super.run();
        long startTime= System.nanoTime()/1000000;
        selectionSort(array);
        long endTime = System.nanoTime()/1000000;
        System.out.println(String.format("Sort time for %s : %d", getNom()  ,  endTime-startTime));
    }
}
