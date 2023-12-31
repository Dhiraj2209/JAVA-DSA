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

    public int RemoveFirst(){ // O(1)

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

    public int RemoveLast(){// O(n)
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

    public int IterativeSerch(int target){ // O(n) 
        Node temp = head;
        int position = 1;
        
        while(temp != null){
            if(temp.data == target){
                return position;
            }
            else {
                temp = temp.next;
                position++;
            }
        }
        
        return -1;
    }

    public int HelperOfRecursiveSerch(int target, Node head){ // O(n)
        if(head == null){
            return -1;
        }

        if(head.data == target){
            return 0;
        }
        int idx = HelperOfRecursiveSerch(target , head.next);
        
        if(idx == -1){
            return -1;
        }

        return idx + 1;
    }
    
    public int RecursiveSerch(int target){
        return HelperOfRecursiveSerch(target, head);
    }

    public void ReverseLL(){ // O(n)
        Node curr = tail = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deletNthFromEnd(int n){ // O(n)
        int i = 1; 
        Node temp = head;

        if(n == Size){
            head =head.next;
            return;
        }

        while(i < (Size- n)){
            temp = temp.next;
            i++;
        }

        temp.next= temp.next.next;
        return;
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

    //Slow -Fast Approch
    public Node FindMid(){
        Node Slow = head;
        Node Fast = head;
        
        while(Fast != null && Fast.next != null){
            Slow = Slow.next;
            Fast = Fast.next.next;
        }

        return Slow;
    }

    public boolean IsPalindrom(){
        if(head == null || head.next == null){
            return true;
        }
    
        Node mid = FindMid();

        // For reversing second half of LL
        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node Righthead = prev;
        Node Lefthead = head;

        // Checking LL is palindrome or not 

        while(Righthead != null){
            if(Righthead.data != Lefthead.data){
                return false;
            }
            Lefthead = Lefthead.next;
            Righthead = Righthead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Linked_List ll = new Linked_List(); //New Linked List.
        ll.AddFirst(900);
        ll.AddFirst(2024);
        ll.AddLast(2024);
        ll.AddLast(2784);
        ll.AddLast(84);
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

        System.out.println("Target element found at position : " + ll.IterativeSerch(220));
        System.out.println("Target element found at position : " + (ll.RecursiveSerch(2004) + 1));
        
        ll.ReverseLL();
        ll.Print_LL();
        System.out.println("Target element found at position : " + (ll.RecursiveSerch(900) + 1));

        ll.deletNthFromEnd(4);
        ll.Print_LL();

        System.out.println(ll.IsPalindrom());
    }
}
