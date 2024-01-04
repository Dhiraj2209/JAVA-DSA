package Queue;

public class QueueUsingLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next= null;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    static class Queue {

        public boolean IsEmpty(){
            return head == null;
        }

        public void Enqueue(int data){
            
            Node newnode = new Node(data);
            if(IsEmpty()){
                head = tail = newnode;
            }

            tail.next = newnode;
            tail = newnode;
        }

        public int Dequeue(){
            if(IsEmpty()){
                System.out.println("Queue is Empty.");
                return -1;
            }

            int val = head.data;
            head = head.next;
            return val;
        }

        public void PrintQueue(){
            Node temp = head;
            if(head == null){
                System.out.println("Queue is Empty.");
            }

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }  
        
        public int Peek(){
            if(head == null){
                System.out.println("Queue is Empty.");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        
        q.Enqueue(2);
        q.Enqueue(1);
        q.Enqueue(21);
        q.Enqueue(123);
        q.PrintQueue();
        System.out.println("Dequeued Element from Queue : "+q.Dequeue());
        System.out.println("Dequeued Element from Queue : "+q.Dequeue());
        q.PrintQueue();
        System.out.println("First Element of Queue : "+q.Peek());
    }
}
