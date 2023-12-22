public class Inversion_Count_in_Array {
    
        public static void printArr(int arr[]){ //Printing Array
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    
        public static int MergeSort(int arr[], int si, int ei){
            int count = 0;
            if(si < ei){
               
               int mid = si + (ei-si)/2; // calculating mid index of array
    
            count += MergeSort(arr, si, mid); // for left part
            count += MergeSort(arr, mid+1, ei); // for right part
            count += Merge(arr, si, mid, ei); // for merging two parts
            
            }
            return count;
        }
    
        public static int Merge(int arr[], int si, int mid, int ei){
            int temp[] = new int[ei - si + 1];
            int i = si, j = mid+1, k = 0;
            int count = 0;
            while(i <= mid  && j <= ei){
                if(arr[i] <= arr[j]){
                    temp[k++] = arr[i++];
                }
                else{
                    temp[k++] = arr[j++];
                    count += (mid + 1) - (si + i); //all Possible inversion count increment
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
            
            return count;
        }
        
        public static void main(String args[]){
            int arr[] = {9,8,7,6,5,4,3,2,1,0};
            System.out.print("Before sorting : ");
            printArr(arr);
            System.out.println("Inversion needed for Sorting an Array: " + MergeSort(arr, 0, arr.length -1));
            System.out.print("After sorting : ");
            printArr(arr);
            
        }
}
