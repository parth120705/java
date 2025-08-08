package LinkedList;

public class DisplayAndSize {
    public static class Node{
        int data;
        Node next;
    }
    public static class Linked{
        Node head;
        Node tail;
        int size;
        public void addLast(int data){
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
        public int size(){
            return size;
        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Linked ll=new Linked();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.display();
        System.out.println("Size of the linked list is "+ll.size());

    }
}
