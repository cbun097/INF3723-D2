import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

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

    public void ShowSpecialFormatArray()
    {
        System.out.print(this.nom + " : ");
        if(this.array.length < 100)
        {
            try {
                for(int i = 0; i< 100; i++) {
                    System.out.print("[" + this.array[i] + "]");
                }
            }
            catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            }
        }
        else
        {
            for(int i = 0; i< 50; i++) {
                System.out.print("[" + this.array[i] + "]");
            }
            for(int i = this.array.length -1; i< 50; i--) {
                System.out.print("[" + this.array[i] + "]");
            }
        }
        System.out.println();

    }

    @Override
    public void run() {
        super.run();
        long startTime= System.nanoTime();
        selectionSort(array);
        long endTime = System.nanoTime();
        long result = endTime - startTime;
        if(result > 1000000)
            System.out.println("\nSort du " + getNom() + " est complété en milliseconds:  " + TimeUnit.NANOSECONDS.toMillis(result));
        else{
            System.out.println("Sort du " + getNom() + " est complété en milliseconds: " + String.format("%.5f", ((double) result)/10000000));
        }
    }
}
