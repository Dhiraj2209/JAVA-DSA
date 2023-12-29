public class Linked_List {
    
    public class Node {
        int data;
        Node next;

        public Node(int data){ // Object of Node Class
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; // static head and tail
    public static Node tail;
    public int Size;

    public void AddFirst(int data){ // O(1)
        Node newNode = new Node(data);
    // classname objectname new_keyword classname(data)
        Size++;

        if(head == null){ // Linked list is Empty.
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void AddLast(int data){ // O(1)
        Node newNode = new Node(data);
        Size++;

        if(tail == null){ // head == null
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void AddInMiddle(int idx, int data){ // O(n)
        Node temp = head;
        int i = 0;
        Node newNode = new Node(data);

        if(idx == 0){
            AddFirst(data);
            return;
        }
        Size++;

        while(i < idx -1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int RemoveFirst(){

        if(Size == 0){
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        }
        else if(Size == 1){
            int val = head.data;
            head = tail = null;
            Size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        Size--;
        return val;
    }

    public int RemoveLast(){
        if(Size == 0){
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        }
        else if(Size == 1){
            int val = tail.data;
            head = tail = null;
            Size--;
            return val;
        }

        Node temp = head;
        for(int i = 0 ; i < Size - 2 ; i++){
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        Size--;
        tail = temp;

        return val;
    }

    public void Print_LL(){ // O(n)
        Node temp = head;

        if(temp == null){
            System.out.println("Linked List is Empty.");
            return;
        }

        while(temp != null){
        System.out.print(temp.data + " -> ");
        temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Linked_List ll = new Linked_List(); //New Linked List.
        ll.AddFirst(900);
        ll.AddFirst(2024);
        ll.AddLast(2004);
        ll.Print_LL();
        ll.AddInMiddle(0, 220);
        ll.Print_LL();
        System.out.println("Size of Linked List is : "+ll.Size);

        int tempval = ll.RemoveFirst();
        if(tempval == -2147483648){
            System.out.println("No element present in linked list to Remove.");
        }else{
        System.out.println("Removed Element is : " + tempval);
        }

        ll.Print_LL();
        System.out.println("Size of Linked List is : "+ll.Size);

        int tempval2 = ll.RemoveLast();
        if(tempval == -2147483648){
            System.out.println("No element present in linked list to Remove.");
        }else{
        System.out.println("Removed Element is : " + tempval2);
        }

        ll.Print_LL();
        System.out.println("Size of Linked List is : "+ll.Size);
    }
}
