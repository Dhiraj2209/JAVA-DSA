public class Array_Backtracking {

    public static int value = 1;

    public static void arr_backtracking(int arr[], int si){
        
        if(si == arr.length){
            printArr(arr);
            return;
        }
        
        arr[si] = value++;
        arr_backtracking(arr, si+1); // Recursive function call
        arr[si] = arr[si] -2; // Backtracking step
         
    }

    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[] = new int[10];
        arr_backtracking(arr,0);
        printArr(arr);
    }
}