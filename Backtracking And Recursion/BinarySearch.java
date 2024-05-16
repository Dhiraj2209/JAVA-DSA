public class BinarySearch {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int key = 101;
        int index = binarySearch(arr, key);
        if (index != -1) {
            System.out.println("Key " + key + " found at index: " + index);
        } else {
            System.out.println("Key " + key + " not found in the array.");
        }
    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = key.compareTo(list[mid]);

            if (comparison == 0) {
                return mid; // Key found
            } else if (comparison < 0) {
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return -1; // Key not found
    }
}
