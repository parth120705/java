package sorting;

import java.util.Arrays;

public class mergesort {
     public static int[] MergeTwoSortedArray(int[] a,int[] b){
        int arr[]=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length&&j<b.length){
            if(a[i]>b[j]){
                arr[k]=b[j];
                j++;
            }
            else{
                arr[k]=a[i];
                i++;
            }
            k++;
        }
        while(i<a.length){
            arr[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length){
            arr[k]=b[j];
            j++;
            k++;
        }
        return arr;
    }
    public static int[] mergeSort(int[] arr,int low,int high){
        if(low==high){
            int[] bo=new int[1];
            bo[0]=arr[low];
            return bo;
        }
        int mid=(high+low)/2;
        int[] lf=mergeSort(arr, low, mid);
        int[] sf=mergeSort(arr, mid+1, high);
        int[] fsa=MergeTwoSortedArray(lf, sf);
        return fsa;
    }
    public static void main(String[] args){
        int[] arr={6,3,4,1,5,8,2};
        int[] arr1=mergeSort(arr, 0,arr.length-1);

        System.out.println(Arrays.toString(arr1));
    }
    
}
