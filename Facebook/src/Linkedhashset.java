import java.util.*;
import java.io.*;
public class Linkedhashset{
    private static LinkedHashSet<Integer> hashset = new LinkedHashSet<Integer>();
    private static int[] a = {4,6,5,3,4,4,5,3,2,2,1,7,6,7,1};
    public static void main(String[] args) throws IOException{
        for(int i: a)
            hashset.add(i);
        Iterator<Integer> iterator = hashset.iterator();
        while(iterator.hasNext())
        	System.out.print(iterator.next() + " ");        
    }
}