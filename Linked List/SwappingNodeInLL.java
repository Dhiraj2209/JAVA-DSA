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

    public static void swapNodes(int x, int y, ListNode headA){

        if(x == y){
            return;
        }

        ListNode temp1 = null, temp2 = headA;
        for(int i = 1 ; i < x && temp2 != null; i++){
            temp1 = temp2;
            temp2 = temp2.next;
        }
        //temp2 = temp1.next;
        ListNode temp3 = null, temp4 = headA;
        for(int i = 1 ; i < y && temp4 != null; i++){
            temp3 = temp4;
            temp4 = temp4.next;
        }

        ListNode temp = temp4.next;
        temp4.next = temp2.next;
        temp3.next = temp2;
        if(x == 1){
            //temp1 = temp4;
            headA = temp4;
        }else{
        temp1.next = temp4;
        }
        temp2.next = temp;
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

        swapNodes(2, 5, headA);
        printll(headA);
    }
}
