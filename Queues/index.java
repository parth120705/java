import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
// import java.util.concurrent.ArrayBlockingQueue;

// import implementation.queue;

public class index {
    public static void main(String[] args) {
        Queue <Integer> list=new LinkedList<>();
        list.add(1);
        System.out.println(list.size());
        System.out.println(list.remove());
        System.out.println(list.poll());
        System.out.println(list.element());
        //System.out.println(list.peek());

        // Queue<Integer> q=new ArrayBlockingQueue<>(2); //fix sized queue

        // System.out.println(q.offer(1));//true
        // System.out.println(q.offer(2));//true
        // System.out.println(q.offer(3));//false  offer=add

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());//for reverse priorty
        // PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->x-y);//asssending order
        // PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);//decending order
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);

        System.out.println(pq);  ///do not sort 
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }//will give sorted value
        System.out.println(pq.remove());//will give smallest value
        System.out.println(pq.peek());

    }
}
