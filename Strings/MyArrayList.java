package Strings;

import java.util.*;

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        System.out.println(al + " " + al.size());

        al.add(1,1000);
        System.out.println(al + " " + al.size());

        al.set(1,2000);
        System.out.println(al + " " + al.size());

        int val=al.get(1);
        System.out.println(val);

        al.remove(1);
        System.out.println(al + " " + al.size());

        System.out.println(al.contains(40));
        Collections.sort(al);
        System.out.println(al);

        int[] arr={2,4,5,6,7,8,9};
        ArrayList<Integer> aal=new ArrayList<>();
        System.out.println(aal);
        for(int i=0;i<arr.length;i++){
            aal.add(arr[i]);
        }
        System.out.println(aal);

    }

}
