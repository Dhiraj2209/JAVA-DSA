package Stack;

public class Stack{
    
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class stack{

        static Node head = null;

        public boolean IsEmpty(){
            return head == null;
        }

        public void Push(int data){
            Node newnode = new Node(data);

            if(IsEmpty()){
                head = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
            return;
        }

        public int Pop(){
            if(IsEmpty()){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int Peek(){
            if(IsEmpty()){
                return -1;
            }

            return head.data;
        }

        public void PushAtBottom(int data){
            Node newnode = new Node(data);
            Node temp = head;

            if(IsEmpty()){
                head = newnode;
                return;
            }

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
            return;
        }

        public void InsertAtBottomRec(stack s, int data){
            
            if(IsEmpty()){
                s.Push(data);
                return;
            }

            int top = s.Pop();
            InsertAtBottomRec(s, data);
            s.Push(top);
        }

        public void PrintStack(){
            
            Node temp = head;

            if(IsEmpty()){
                System.out.println("Stack is empty.");
                return;
            }
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String args[]){
        stack s = new stack();
        s.Push(1);
        s.Push(2);
        s.Push(3);
        s.Push(4);
        s.PushAtBottom(50);
        s.InsertAtBottomRec(s, 500);
        s.PrintStack();
        System.out.println("The Peek Element of the Stack : " +s.Peek());
        System.out.println("Popped Element from Stack : " +s.Pop());
        s.PrintStack();
    }
}