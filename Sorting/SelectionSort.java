package Sorting;

public class SelectionSort {
    
    private static void selectionSort(int arr[]){
        
        for(int i = 0; i < arr.length ;i++){
            int min = arr[i];
            for(int j = i+1 ; j < arr.length ;j++){
                if(arr[j] <= min){
                    int temp =  arr[j];
                    arr[j] = min;
                    min = temp;
                    arr[i] = temp;
                }
            }
        }
        System.out.print("Sorterd array : ");
        for(int i = 0 ; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    } 
    public static void main(String[] args) {
        int arr[] = {9,0,-2,-12,84,-13,1020,10,22,11,10,2,1};

        System.out.print("Original Array : ");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print( arr[i]+" ");
        }
        System.out.println();

        selectionSort(arr);
    }
}
