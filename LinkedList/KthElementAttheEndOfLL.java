package LinkedList;

public class KthElementAttheEndOfLL{
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
        public void kthelementatlast(int index){
            Node s=head;
            Node f=head;
            for(int i=0;i<index;i++){
                f=f.next;
            }
            while(f!=tail){
                s=s.next;
                f=f.next;
            }
            System.out.println(s.data);

        }
    }
    public static void main(String[] args) {
        Linked ll=new Linked();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.display();
        ll.kthelementatlast(2);
        

    }
}