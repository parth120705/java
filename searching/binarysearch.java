package searching;

import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

public class binarysearch {
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.println("enter the target element");
        int x=scn.nextInt();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        // for(int i=0;i<10;i++){
        // 	System.out.println(arr[i]);
        // }
        System.out.println();
        int low = 0;
            int high = n - 1;
            boolean flag = false;
            while (low <= high) {
                int mid = (high + low) / 2;
                if (arr[mid] == x) {
                    System.out.println("Element found at index " + mid);
                    flag = true;
                    break;-
                    
                } else if (arr[mid] > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (!flag) {
                System.out.println("Element not found");
            }
    }
}
