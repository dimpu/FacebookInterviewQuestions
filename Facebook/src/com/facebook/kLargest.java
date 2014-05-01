package com.facebook;

import java.io.*;
import java.util.*;
public class kLargest{
    private static int[] array = {10,4,7,3,5,2};
    private static int k = 3;
    public static void main(String[] args){
        int element = kthLargest(array,0,array.length - 1,k - 1);
        System.out.println("Kth largest element is " + element);
    }
    /*
     * returns the Kth largest element
     */
    public static int kthLargest(int array[], int low, int high, int m){
        if(low == high)
            return array[low];
        int pivot = partition(array,low,high);
        if(pivot == m){
            return array[pivot];
        }
        else if(pivot < m)
            return kthLargest(array,pivot + 1,high,m);
        else
            return kthLargest(array,low, pivot - 1,m);
    }
    /*
     * return the position where the pivot belongs to
     */
    public static int partition(int array[], int low, int high){
        int pivot = low;
        int i = low + 1;
        int j = high;
        // until i < j
        while(true){
        	// increment i until a[i] < a[pivot] and i doesn't cross high
            while(array[i] < array[pivot] && i < high){
                i++;
            }
            //decrement j until a[j] > a[pivot] and j doesn't cross over 0
            while(array[j] > array[pivot] && j > 0){
                j--;
            }
            if(i >= j)
            	break;
            // if i is still less than j exchange the elements in that position
            exchange(array,i,j);
        }
        // We have found the position where pivot belongs i.e., j
        exchange(array,pivot,j);
        return j;
    }
    /*
     * exchange the array element and i and j
     */
    public static void exchange(int array[], int i, int j){
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap; 
    }
}
