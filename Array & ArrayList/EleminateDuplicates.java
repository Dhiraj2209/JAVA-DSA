import java.util.Arrays;

public class EleminateDuplicates {

    /*make logic in that its gives new array by eliminating the duplicate values in the original array. */
     public static void main(String[] args) {
        int arr[] = {1,1,2,5,55,20,25,22,20,500,6,7,1,2,55,55};

        int finalarr[] = new int[arr.length];
        Arrays.sort(arr); // Sorting array

        System.out.print("Original Array : ");
        for(int i = 0 ; i < arr.length ;i++){ // Printing Original Array
            System.out.print(arr[i] + "  ");
        }
        System.out.println("");
        
        int i = 0;
        int j = 0;
        while( i < arr.length - 1){
            if(arr[i] != arr[i+1]){
                finalarr[j++] = arr[i];
            }
            i++;
        }
        finalarr[j++] = arr[arr.length - 1];

        System.out.print("Final Array : ");
        for(int k = 0 ; k < j ;k++){ //Printing Removedduplicate array
            System.out.print(finalarr[k] + "  ");
        }
    }
}
