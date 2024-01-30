import java.util.Stack;

public class NextGreaterElement {
    static int arr[] = {6,8,0,3,1};
    static int finalarr[] = new int[arr.length];
    
    public static void Next_Greater_Element(int arr[]){
        Stack<Integer> s = new Stack<>();
        
        //O(n)
        
        // With values
        // for(int i = (arr.length - 1); i >= 0; i--){
        //     while(!s.empty() && s.peek() <= arr[i]){
        //         s.pop();
        //     }

        //     if(s.empty()){
        //         finalarr[i] = -1;
        //     }
        //     else {
        //         finalarr[i] = s.peek();
        //     }

        //     s.push(arr[i]);
        // }

        //With Index
        for(int i = arr.length - 1; i >=0 ; i--){

            while(!s.empty() && arr[s.peek()] <= arr[i]){
                s.pop();
            } 

            if(s.empty()) {
                finalarr[i] = -1;
            }
            else {
                finalarr[i] = arr[s.peek()];
            }

            s.push(i);
        }

    }
    
    public static void main(String[] args) {
        
        Next_Greater_Element(arr);

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(finalarr[i] + " ");
        }
    }
}
