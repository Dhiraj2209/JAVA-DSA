import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(2);
        originalList.add(4);
        originalList.add(3);

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        System.out.println("Original List: " + originalList);
        System.out.println("List with duplicates removed: " + uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> set = new HashSet<>(list); // Convert list to a HashSet to remove duplicates
        return new ArrayList<>(set); // Convert back HashSet to ArrayList
    }
}
