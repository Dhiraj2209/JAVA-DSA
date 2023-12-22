public class Majority_Element_in_Array {
    
    public static int majorityelement(int arr[]){
        
        for(int i = 0; i < arr.length ;i++){
            int value = arr[i];
            int count = 0;
            for(int j = 0 ; j < arr.length ;j++){
                if(arr[j] == value){
                    count++;
                }
            }
            if(count > (arr.length)/2){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = {1, 1, 2, 3, 5, 10 };
        if((majorityelement(arr)) == -1){
            System.out.println("No Majority Element present in Array.");
        }else
        System.out.println("Majority Element : " + majorityelement(arr));
    }
}
