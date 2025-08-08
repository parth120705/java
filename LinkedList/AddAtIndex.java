package LinkedList;

public class AddAtIndex {
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
        public void addAtIndex(int index,int data){
            if(index<0 || index>size){
                System.out.println("Invalid index");
            }
            else if(index==0){
                Node temp=new Node();
                temp.data=data;
                temp.next=head;
                head=temp;
                size++;
            }
            else if(index==size){
                add(data);
                size++;
            }
            else{
                Node temp=new Node();
                temp.data=data;
                Node prev=head;
                for(int i=0;i<index-1;i++){
                    prev=prev.next;

                }
                temp.next=prev.next;
                prev.next=temp;
                size++;
                
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
        ll.addAtIndex(2,100);
        ll.display();

        
        

    }
}
