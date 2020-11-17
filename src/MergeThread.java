public class MergeThread extends java.lang.Thread{

    Integer[][] ListOfArray;

    public MergeThread(Integer[][] ListOfArray)
    {
        this.ListOfArray = ListOfArray;
        Integer SizeFinalArray = 0;
        for(int i = 0; i<this.ListOfArray.length; i++)
        {
            SizeFinalArray += ListOfArray[i].length;
        }
    }

    @Override
    public void run() {
        long starttime= System.nanoTime()/1000000;
        //fait un merge avec les deux premier array
        Integer[] Temp = MergeAlgo(ListOfArray[0], ListOfArray[1]);
        //merge le resultat avec le reste
        for(int i = 2; i< ListOfArray.length; i++)
        {
            Temp = MergeAlgo(Temp, ListOfArray[i]);
        }
        //affiche le resultat
        for (int i = 0; i<Temp.length; i++)
        {
            System.out.print(Temp[i] + " ");
        }
        long endtime = System.nanoTime()/1000000;
        System.out.println(String.format("%s %,d", "\nmerge complete in milliseconds:  "  ,  endtime-starttime));
    }

    public Integer[] MergeAlgo(Integer[] Right, Integer[] Left)
    {
        //créer un array temporaire d'une grandeur plus grande pour avoir un chiffre infinit a la fin
        Integer[] tempRight = new Integer[Right.length + 1];
        Integer[] tempLeft = new Integer[Left.length + 1];
        //met les valeur des parti a la bonne place
        for(int i = 0; i<Right.length; i++)
            tempRight[i] = Right[i];
        for(int i = 0; i<Left.length; i++)
            tempLeft[i] = Left[i];
        //met l'infinit a la derniere position
        tempRight[Right.length] = 2147483647;
        tempLeft[Left.length] = 2147483647;

        //merge
        Integer[] TempArray = new Integer[Right.length + Left.length];
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
