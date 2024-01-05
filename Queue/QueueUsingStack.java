package Queue;
import java.util.Stack;

public class QueueUsingStack {
    // Implementing Queue DS using 2 Stack.
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean IsEmpty(){
            return s1.isEmpty();
        }

        public void Enqueue(int data){
            while(!IsEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int Dequeue(){
            if(IsEmpty()){
                System.out.println("Queue is Empty.");
                return -1;
            }

            return s1.pop();
        }
    }

    public static void main(String[] args) {
        Queue q =new Queue();
        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        for(int i = 4; i < 15 ;i++){
            q.Enqueue(i);
        }
        while(!q.IsEmpty()){
            System.out.println(q.Dequeue());
        }
    }
}
