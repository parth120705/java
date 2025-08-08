package LinkedList;

public class RemoveFirst {
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size;
        public void add(int data){
            if(size==0){
                Node temp=new Node();
                temp.data=data;
                temp.next=null;
                head=tail=temp;
                size++;
            }
            else{
                Node temp=new Node();
                temp.data=data; 
                temp.next=null;
                tail.next=temp;
                tail=temp;
                size++;
            }


        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;

            }
            System.out.println();
        }
        public void removeFirst(){
            if(size==0){
                System.out.println("LinkedList is empty");
            }
            else if(size==1){
                head=tail=null;
                size=0;
            }
            else{
                head=head.next;
                size--;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.removeFirst();
        ll.display();
        

    }
}
