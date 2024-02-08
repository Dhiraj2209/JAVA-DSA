public class DeletNnodeAfterMnode {

    static class ListNode { //Node for linked list
        int data;
        ListNode next;

        ListNode(int x) {
            data = x;
            next = null;
        }
    }

    public static void deletNnodeAfterMnode(int m, int n, ListNode head){ //O(n^2)
        ListNode temp = head;
        while(temp != null){

            for(int i = 1 ; i < m && temp != null ;i++){ // Going till Mth Node
                temp = temp.next;
            }

            if(temp == null || temp.next == null){
                return;
            }

            ListNode t = temp.next; // for NextMthnode

            for(int i = 1 ; i <= n && t != null;i++){  // Deleting N node
                t = t.next;
            }
            temp.next = t;
            temp = t;
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

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(20);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(50);
        headA.next.next.next.next.next = new ListNode(500);
        headA.next.next.next.next.next.next = new ListNode(40);
        headA.next.next.next.next.next.next.next = new ListNode(80);

        printll(headA);
        deletNnodeAfterMnode(1, 2, headA);
        printll(headA);
    }
}