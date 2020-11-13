
public class ExampleCreateTime {
   public static void main(String[] args)
    {
              
       int[] arr = new int[1000];
       int len = arr.length;
       long starttime= System.nanoTime()/1000000;
       
       for (int i = 0; i < arr.length; i++)
       {
          arr[i] = (i%2)*i + (i+1)%2*(len-i) ; // entiers non triés
          if (i<50|| i> len-50)
          System.out.println(arr[i]); // affichage partiel de la liste

       }
       long endtime = System.nanoTime()/1000000;
       System.out.println(String.format("%s %,d", "creation and display time in milliseconds:  "  ,  endtime-starttime));
    }
 

}
