import java.io.*;
import java.util.*;
public class ElementPairSum{
private static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements");
        int size = Integer.parseInt(br.readLine());
        array = new int[size];
		System.out.println("Enter the numbers in sorted order");
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int i = 0;
		while(tokenizer.hasMoreTokens()){
			array[i++] = Integer.parseInt(tokenizer.nextToken());
		}
		System.out.println("Enter the sum");
		int sum = Integer.parseInt(br.readLine());
		findElements(array,sum);
	}
	public static void findElements(int a[], int sum){
		int low = 0;
		int high = a.length - 1;
		while(low < high){
			if(a[low] + a[high] == sum){
				System.out.println("Elements are "+ a[low] + " & " + a[high]);
				return;
			}
			if(a[low] + a[high] > sum)
				high--;
			else
				low++;
		}
		System.out.println("Element not found");
	}
}
	/*public static void findElements(int a[], int sum){
	    int key,pair;
	    for(int i = 0; i < a.length;i++){
	       key = sum - a[i];
	       if(key < a[i])
	            break;
	       pair = search(a,key,i + 1, a.length - 1);
	       if(pair != -1){
	            System.out.println("Elements are " + a[i] + " & " + pair);
	            return;
	       }
	    }
	    System.out.println("No such elements found");
	}
	
	public static int search(int[] a, int key, int low, int high){
	    if(low > high)
	        return -1;
	    int mid = (high + low)/2;
	    if(a[mid] == key)
	        return a[mid];
	    if(a[mid] > key)
	        return(search(a,key,low,mid - 1));
	   else
	       return(search(a, key, mid + 1, high));
	}
}*/