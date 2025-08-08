import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class implementation 
{
    public class queue{
        static int[] arr;
        static int size;
        static int rear=-1;
        queue(int size){
            arr=new int[size];
            this.size=size;
        }
        public static boolean isEmpty(){
            return rear==-1;
        }
        public static void add(int num){
            if(rear==size-1){
                System.out.println("full queue");
                return;
            }
            rear++;
            arr[rear]=num;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front=0;
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }
        //add o(1)
        //remove peek() o(n)
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }

	public static void main(String[] args) {
        
    }
}

    