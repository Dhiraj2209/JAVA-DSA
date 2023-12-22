// package JAVA-DSA;

public class SerchinSortedRotatedArray {
    public static void main(String args[]){
        int arr[] = {5,7,9,10,14,18,0,1,2,3};
        System.out.println( "Length of Array : " + (arr.length - 1));
        int target = 55;
        System.out.println("Target found on index : " + (serch(arr, target, 0, arr.length - 1)));
    }

    public static int serch(int arr[], int target, int si, int ei){

        if(si > ei){
            return -1;
        }

        int mid = (si+ei)/2; // Finding mid index of the array

        if(arr[mid] == target){ //case 1
            return mid;
        }

        if(arr[si] <= arr[mid]){ // Mid on L1
            if(arr[si] <= target && target <= arr[mid]){
                return serch(arr, target, si, mid -1);
            }
            else {
                return serch(arr, target, mid+1, ei);
            }
        }
        else {
            if(arr[mid] <= target && target <= arr[ei]){
                return serch(arr, target, mid+1, ei);
            }
            else {
                return serch(arr, target, si, mid-1);
            }
        }
        
    }
}
