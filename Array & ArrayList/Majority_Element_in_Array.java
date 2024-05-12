public class Majority_Element_in_Array {
    
    public static int findMajorityElement(int[] arr) {
        int candidate = findCandidate(arr);
        if (isMajority(arr, candidate)) {
            return candidate;
        } else {
            return -1;
        }
    }
    
    private static int findCandidate(int[] arr) {
        int candidate = arr[0];
        int count = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
        
        return candidate;
    }
    
    private static boolean isMajority(int[] arr, int candidate) {
        int count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
        return count > arr.length / 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 5, 10};
        int result = findMajorityElement(arr);
        if (result != -1) {
            System.out.println("Majority Element: " + result);
        } else {
            System.out.println("No Majority Element present in Array.");
        }
    }
}
