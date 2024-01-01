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

    public static boolean IsCycle(){ //Floyd's Cycle Finding Algorithm
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public void RemoveCycle(){
        //Detect cycle
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        Node prev = null; // Node for breaking loop/Cycle

        while(fast != null && fast.next != null){

            prev = slow;
            slow = slow.next ;
            fast = fast.next.next;
            if(slow == fast && fast == head){ // Linked List make Full Loop (Circular Linked List)
                prev.next = null; // Break loop
                return; // Return from function
            }
            else if(slow == fast){
                cycle = true;
                break;
            } 
        }
        
        if(cycle == false){
            return;
        }
        // Find Meeting point
        slow = head; // Initializing slow with head
        
        while(slow != fast){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        // Removing Cycle
        prev.next = null;
    }

    private Node GetMidForMergeSort(Node head){
        Node Slow = head;
        Node Fast = head.next; // Initializing with first node
        
        while(Fast != null && Fast.next != null){
            Slow = Slow.next;
            Fast = Fast.next.next;
        }

        return Slow; // Mid node
    }

    public Node MergeSort(Node head){// O(nlogn)

        if(head == null || head.next == null){ //Linklist is empty or only one node is present.
            return head;
        }

        Node Mid = GetMidForMergeSort(head);

        Node rightHead = Mid.next; // New head for Right part of the linked list.
        Mid.next = null;

        Node Newleft = MergeSort(head); // Recursive calls for sorting linked list.
        Node NewRight = MergeSort(rightHead);

        return Merge(Newleft, NewRight); // Merging left and right part of the linked list to get final sorted linked list.
    }

    private Node Merge(Node left, Node right){
        Node MergeLL = new Node(Integer.MIN_VALUE);
        Node temp = MergeLL;

        while(left != null && right != null){
            if(left.data <= right.data){
                temp.next = left;
                left= left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while(left !=  null){
            temp.next =  left;
            left =left.next;
            temp = temp.next;
        }

        while(right !=  null){
            temp.next =  right;
            right =right.next;
            temp = temp.next;
        }

        return MergeLL.next;
    }


    public void ZigZag(){
        Node mid = GetMidForMergeSort(head);

        Node curr =  mid.next;
        mid.next = null;
        Node prev = null,next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node leftHead = head;
        Node rightHead = prev;
        Node l; Node r;
        //Merging in ZigZAg manner
        while (leftHead != null && rightHead != null) {
            l = leftHead.next;
            leftHead.next = rightHead;
            r = rightHead.next;
            rightHead.next = l;

            leftHead = l;
            rightHead = r;
        }
    }
    public static void main(String[] args) {
        Linked_List ll = new Linked_List(); //New Linked List.
        ll.AddFirst(900);
        ll.AddFirst(2024);
        ll.AddLast(2024);
        ll.AddLast(2784);
        ll.AddLast(84);
        ll.AddLast(840);
        ll.AddLast(-953);
        ll.AddLast(0);
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

        head = ll.new Node(8);
        head.next = ll.new Node(7);
        head.next.next = ll.new Node(78);
        head.next.next.next = ll.new Node(788);
        head.next.next.next.next = head.next.next;

        System.out.println(IsCycle());
        ll.RemoveCycle();
        ll.Print_LL();
        System.out.println(IsCycle());

        head = ll.MergeSort(head);
        ll.Print_LL();

        ll.ZigZag();
        ll.Print_LL();
    }
}
