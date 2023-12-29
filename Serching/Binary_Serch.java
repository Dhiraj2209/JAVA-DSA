package Serching;
public class Binary_Serch {
    
    public static int binary_serch(int arr[], int key){
        int si = 0;
        int ei = arr.length -1;
        // Time complexity = O(logn)
        
        while(si <= ei){ // Can also be implemented with Recursion.
            int mid = (si+ei) / 2;
            if(arr[mid] == key) {
                return mid;
            }
            else if(key > arr[mid]) {
                si = mid+1;
            }
            else {
                ei = mid -1;
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("key found at index : " + binary_serch(arr, 11));
    }
}
