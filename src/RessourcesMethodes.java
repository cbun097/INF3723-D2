public class RessourcesMethodes {

    public static int[] ParseList(String list)
    {
        long starttime= System.nanoTime()/1000000;
        list = list.replaceAll(" ", "");
        String[] stringlist = list.split(",");
        int[] arr = new int[stringlist.length];
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

    public static int[] CreateList(int taille)
    {
        int[] arr = new int[taille];
        int len = arr.length;
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

    public static int findSplitPoint(int arr[], int n)
    {
        // traverse array element and compute sum
        // of whole array
        int leftSum = 0;

        for (int i = 0 ; i < n ; i++)
            leftSum += arr[i];

        // again traverse array and compute right
        // sum and also check left_sum equal to
        // right sum or not
        int rightSum = 0;

        for (int i = n-1; i >= 0; i--)
        {
            // add current element to right_sum
            rightSum += arr[i];

            // exclude current element to the left_sum
            leftSum -= arr[i] ;

            if (rightSum == leftSum)
                return i ;
        }

        // if it is not possible to split array
        // into two parts.
        return -1;
    }

    public static int[] printTwoParts(int arr[], int n)
    {
        int splitPoint = findSplitPoint(arr, n);
        int result[] = new int[arr.length];

        if (splitPoint == -1 || splitPoint == n )
        {
            System.out.println("Not Possible" );
        }

        for (int i = 0; i < n; i++) {
            if (splitPoint == i)
                System.out.println();

            System.out.println("[ " + arr[i] + " ]");
            result[i] = arr[i];
        }
        return result;
    }
}
