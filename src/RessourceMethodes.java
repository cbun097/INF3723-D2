// Classe qui prend des methodes généraux dans le programme
public class RessourceMethodes {

    // Methode pour faire la selection sort
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

    // TODO fonction merge
    void mergeSortedList() {

    }
}
