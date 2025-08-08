package searching;

import java.util.*;
public class firstoccurencebinarysearch{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int arr[]={5,2,1,9,6,7,5,0,5};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int x=scn.nextInt();
		int n=arr.length;
		int low=0;
		int high=n-1;
		int last=-1;
		
		while(low<=high){
			int mid=(high+low)/2;
			if(arr[mid]==x){
				last=mid;
		
				low=mid+1;
			}
			else if(arr[mid]>x){
				high=mid-1;
			}
			else{
				low=mid+1;
			}
		}
		System.out.println("the element is at index "+last);
    }
}
