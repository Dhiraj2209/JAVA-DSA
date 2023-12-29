package Sorting;

public class Optimised_Bubble_Sort {
    
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void optimized_bubble_sort(int arr[]){
        for(int i = 0; i < arr.length -1; i++){
            boolean swaps = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps = true;
                }
            }
            if(swaps == false && i == 0){
                System.out.println("Array is already Sorted.");
                break;
            }
            else if(swaps == false) {
                break;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {10,22,3,48,5,-2,-9966,999};
        printArr(arr);
        optimized_bubble_sort(arr);
        printArr(arr);

        int arr2[] = {1,2,3,4};
        printArr(arr2);
        optimized_bubble_sort(arr2);
        printArr(arr2);
    }
}
