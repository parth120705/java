package LinkedList;

public class AddFirst {
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
        public void addFirst(int data){
            Node temp=new Node();
            temp.data=data;
            temp.next=head;
            head=temp;
            size++;
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
        LinkedList ll=new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.addFirst(100);
        ll.display();
        

    }
}
