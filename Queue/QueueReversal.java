package Queue;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class QueueReversal {

    public static void QueueRevers(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ;i < 5;i++){
            q.add(i+1);
        }
        QueueRevers(q);
        
        while(!q.isEmpty()){
            System.out.print(q.remove()+ " ");
        }
    }    
}
