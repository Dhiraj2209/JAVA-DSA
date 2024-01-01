public class Doubly_LL {
    public class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data =data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){ // O(1)
        Node newnode = new Node(data);
        size++;
        if(head ==null){
            head = tail = newnode;
            return;
        }

        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    public void addLast(int data){ // O(1)
        Node newnode = new Node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }

        tail.next = newnode;
        newnode.prev = tail;
        newnode.next =null;
        tail = newnode;
    }

    public void RemoveFirst(){// O(1)
        if(head == null){
            System.out.println(" Doubly linked list is Empty.");
            return;
        }
        if(size == 1){
            System.out.println("Deleted Element From Start : " + head.data);
            head = tail = null;
            size--;
            return;
        }

        System.out.println("Deleted Element From Start : " + head.data);
        head =head.next;
        head.prev = null;
        size--;
    }

    public void RemoveLast(){// 0(1)
        if(head == null){
            System.out.println(" Doubly linked list is Empty.");
            return;
        }
        if(size == 1){
            System.out.println("Deleted Element From End : " + head.data);
            head = tail = null;
            size--;
            return;
        }

        System.out.println("Deleted Element From End : " + tail.data);
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void PrintDLL(){ // O(n)
        Node temp = head;

        if(head!= null){
        System.out.print("NULL <-> ");
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
        }
        else{
        System.out.println("Doubly linked list is empty.");
        }
    }

    public void ReverseDLL(){ // O(n)
        Node curr = head;
        Node prev = null;
        Node next;
        if(head == null){
            System.out.println("Doubly linked list is empty.");
            return;
        }
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev =curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        Doubly_LL dll = new Doubly_LL();

        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addLast(1);
        dll.PrintDLL();

        dll.RemoveFirst();
        dll.RemoveLast();
        dll.PrintDLL();

        System.out.println(size);

        dll.ReverseDLL();
        dll.PrintDLL();
    }
}
