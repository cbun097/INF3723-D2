import java.util.concurrent.TimeUnit;

public class MergeThread extends java.lang.Thread{

    int[][] ListOfArray;

    public MergeThread(int[][] ListOfArray)
    {
        this.ListOfArray = ListOfArray;
        int SizeFinalArray = 0;
        for(int i = 0; i<this.ListOfArray.length; i++)
        {
            SizeFinalArray += ListOfArray[i].length;
        }
    }

    @Override
    public void run() {
        long starttime= System.nanoTime();
        //fait un merge avec les deux premier array
        int[] Temp = MergeAlgo(ListOfArray[0], ListOfArray[1]);
        //merge le resultat avec le reste
        for(int i = 2; i< ListOfArray.length; i++)
        {
            Temp = MergeAlgo(Temp, ListOfArray[i]);
        }
        //affiche le resultat
        System.out.print("merged list : ");
        for (int i = 0; i<Temp.length; i++)
        {
            System.out.print("[" + Temp[i] + "]");
        }
        long endtime = System.nanoTime();
        long result = endtime - starttime;
        if(result > 1000000)
            System.out.println("\nmerge est complété en milliseconds:  " + TimeUnit.NANOSECONDS.toMillis(result));
        else
            System.out.println("\nmerge est complété en nanoseconde:  " + String.format("%.5f", ((double) result)/10000000));
    }

    public int[] MergeAlgo(int[] Right, int[] Left)
    {
        //créer un array temporaire d'une grandeur plus grande pour avoir un chiffre infinit a la fin
        int[] tempRight = new int[Right.length + 1];
        int[] tempLeft = new int[Left.length + 1];
        //met les valeur des parti a la bonne place
        for(int i = 0; i<Right.length; i++)
            tempRight[i] = Right[i];
        for(int i = 0; i<Left.length; i++)
            tempLeft[i] = Left[i];
        //met l'infinit a la derniere position
        tempRight[Right.length] = 2147483647;
        tempLeft[Left.length] = 2147483647;

        //merge
        int[] TempArray = new int[Right.length + Left.length];
        int l = 0, r = 0;
        for(int i = 0; i<TempArray.length; i++)
        {
            if(tempRight[r] < tempLeft[l])
            {
                TempArray[i] = tempRight[r];
                r++;
            }
            else
            {
                TempArray[i] = tempLeft[l];
                l++;
            }
        }
        return TempArray;
    }
}
