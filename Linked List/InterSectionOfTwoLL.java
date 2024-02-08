public class InterSectionOfTwoLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to find the intersection point of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { // O(n^2)
        ListNode tempA = headA;
        
        while(tempA != null){
            ListNode tempB = headB;
            while(tempB != null){
                if(tempA == tempB){
                    return tempA;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeByLen(ListNode headA, ListNode headB){ //O(m+n) = O(n)
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        ListNode currA = headA;
        ListNode currB = headB;

        while (lenA > lenB){
            currA = currA.next;
            lenA--;
        }

        while (lenB > lenA){
            currB = currB.next;
            lenB--;
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        if(currA != null || currB != null){
        int lena = getLen(currA);
        int posa = getLen(headA) - lena + 1 ;
        int lenb = getLen(currB);
        int posb = getLen(headB)- lenb + 1;
        // System.out.println(getLen(headA) +" A a " +lena);
        // System.out.println(getLen(headB) +" " +lenb);
        System.out.println("Found Intersection at Position "+ posa + " of LL A & "+ posb + " of LL B.");
        }
        return currB;
    }

    public int getLen(ListNode head){
        int len = 0 ;
        ListNode temp = head;

        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static void main(String[] args) {
        
        InterSectionOfTwoLL solution = new InterSectionOfTwoLL();

        // Constructing linked lists for testing
        ListNode intersectionNode = new ListNode(800);
        
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectionNode;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(50);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next =  new ListNode(6); 
        headB.next.next.next.next =intersectionNode;// intersecting point

        ListNode result = solution.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection Node: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }

        ListNode result1 = solution.getIntersectionNodeByLen(headA, headB);
        if (result1 != null) {
            System.out.println("Intersection Node: " + result1.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
