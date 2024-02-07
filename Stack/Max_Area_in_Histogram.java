import java.util.Stack;

public class Max_Area_in_Histogram {

    public static int max_Area(int arr[]){
        int max = 0;
        int nsleft[] = new int[arr.length]; // Next smaller left element.
        int nsright[] = new int[arr.length]; // Next smaller right element.

        Stack<Integer> s = new Stack<>();

        for(int i = arr.length -1 ; i>= 0;i--){ // For next smaller right.
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsright[i] = arr.length;
            } else{
                nsright[i] = s.peek();
            }

            s.push(i);
        }

        s = new Stack<>(); //Empty stack.

        for(int i = 0 ; i< arr.length;i++){ // for next smaller left.
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsleft[i] = -1;
            } else{
                nsleft[i] = s.peek();
            }

            s.push(i);
        }

        for(int i = 0 ; i < arr.length ;i++){ //Comparing and finding maximum area
            int area = arr[i] * (nsright[i] - nsleft[i] - 1);
            max = Math.max(max, area);
        }
        
        return max;
    }
    public static void main(String args[]){
        int arr[] = {2,1,5,6,2,3};
        System.out.println(max_Area(arr));
    }
}