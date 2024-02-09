package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveQueue {

public static void interleave(){ // O(n) , O(n)~
        int size = q.size();
        System.out.println("Size "+ size);
        Queue<Integer> q2 = new LinkedList<>();

        int i = 0;
        while(i < (size / 2)){ // Duplicate for storing First half of Queue
            q2.add(q.remove());
            i++;
        }

        while(!q2.isEmpty()){ // Modifiding Original Queue
            q.add(q2.remove());
            q.add(q.remove());
        }
    }
    
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        int n = 6;
        for(int i = 0 ; i < n ;i++){
            q.add(i+1);
        }
        interleave();
        for(int i = 0; i < n ;i++){
            System.out.print(q.remove() + " ");
        }
    }
}