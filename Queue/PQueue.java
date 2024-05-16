import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

public class PQueue {
    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.add("George");
        queue1.add("Jim");
        queue1.add("John");
        queue1.add("Blake");
        queue1.add("Kevin");
        queue1.add("Michael");

        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.add("George");
        queue2.add("Katie");
        queue2.add("Kevin");
        queue2.add("Michelle");
        queue2.add("Ryan");

        // Union
        PriorityQueue<String> union = new PriorityQueue<>(queue1);
        union.addAll(queue2);
        System.out.println("Union: " + union);

        // Intersection
        PriorityQueue<String> intersection = new PriorityQueue<>(queue1);
        intersection.retainAll(queue2);
        System.out.println("Intersection: " + intersection);

        // Difference
        PriorityQueue<String> difference = new PriorityQueue<>(queue1);
        difference.removeAll(queue2);
        System.out.println("Difference: " + difference);
    }
}
