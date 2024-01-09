package Stack;
// Deque Using Linked List
public class Deque {

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class deque{

        static Node First = null;
        static Node Last = null;
        static int size = 0;

        public void addFirst(int data){ // O(1)
            Node newnode = new Node(data);
            size++;

            if(First == null){
                First = Last = newnode;
                return;
            }

            newnode.next = First;
            First.prev = newnode;
            First = newnode;
        }

        public void addLast(int data){ // O(1)
            Node newnode = new Node(data);
            size++;

            if(First == null){
                First = Last = newnode;
                return;
            }

            Last.next = newnode;
            newnode.prev = Last;
            Last = newnode;
        }

        public void PrintDQueue(){ //O(n)
            if(First == null){
                System.out.println("Dqueue is Empty.");
                return;
            }
            Node temp  =  First;

            while(temp != null){
                System.out.print(temp.data + "-> ");
                temp =  temp.next;
            }

            System.out.println("NULL");
        }

        public int removeFirst(){ //O(1)
            if(First == null){
                System.out.println("Dqueue is Empty.");
                return -1;
            }
            int val =  First.data;

            if(First.next ==  null){
                First = Last = null;
                return val;
            }

            First = First.next;
            First.prev = null;
            return val;
        }

        public int removeLast(){ //O(1)
            if(Last == null){
                System.out.println("Dqueue is Empty.");
                return - 1;
            }

            int val =  Last.data;

            if(Last.prev ==  null){
                First =  Last = null;
                return val;
            }

            Last = Last.prev;
            Last.next = null;
            return val;
        }
    }

    public static void main(String[] args) {
        deque q = new deque();
        
        q.PrintDQueue();
        q.addFirst(1);
        q.addFirst(2);
        q.addLast(23);
        q.PrintDQueue();
        System.out.println(q.removeFirst());
        System.out.println(q.removeFirst());
        q.PrintDQueue();
        q.addLast(230);
        q.addLast(8493);
        q.PrintDQueue();
        System.out.println(q.removeLast());
        System.out.println(q.removeLast());
        q.PrintDQueue();
    }
}
