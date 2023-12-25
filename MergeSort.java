public class MergeSort {
    
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = si + (ei-si)/2; // calculating mid index of array

        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        Merge(arr, si, mid, ei);    
    }

    public static void Merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid+1, k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++; 
                k++;
            }
            else{
                temp[k] = arr[j];
                j++;
                k++; 
            }
        }

        //remaining element if avalible
        //for left part
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        
        //for right part
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // copy temp arr to original arr
        for(k = 0, i= si; k< temp.length ; k++,i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String args[]){
        int arr[] = {1,5,9,7,2,3,6,45,2,22};
        System.out.print("Before sorting : ");
        printArr(arr);
        mergeSort(arr, 0, arr.length -1);
        System.out.print("After sorting : ");
        printArr(arr);
    }
}
