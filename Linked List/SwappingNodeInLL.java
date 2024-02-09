public class SwappingNodeInLL {
    static class ListNode { //Node for linked list
        int data;
        ListNode next;

        ListNode(int x) {
            data = x;
            next = null;
        }
    }

    static void printll(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public static ListNode swapNodes(int x, int y, ListNode head){

        if(x == y || head == null){
            return head;
        }

        ListNode Xprev = null;
        ListNode Yprev = null;

        ListNode X = head;
        ListNode Y = head;

        for(int i = 1 ; i < x && X != null;i++){
            Xprev = X;
            X = X.next;
        }

        for(int i = 1 ; i < y && Y != null; i++){
            Yprev = Y;
            Y = Y.next;
        }

        if(X == null || Y == null){
            return head;
        }

        // if (Xprev == null) {
        //     head = Y;
        // } else {
        //     Xprev.next = Y;
        // }

        if(Xprev != null){
            Xprev.next = Y;
        }
        else{
            head = Y;
        }
        
        
        if (Yprev == null) {
            head = X;
        } else {
            Yprev.next = X;
        }

        ListNode temp = X.next;
        X.next = Y.next;
        Y.next = temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);
        headA.next.next.next.next.next.next = new ListNode(7);
        // headA.next.next.next.next.next.next.next = new ListNode(80);

        printll(headA);
        swapNodes(3, 1, headA);
        printll(headA);
    }
}
