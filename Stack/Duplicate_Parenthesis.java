import java.util.Stack;

public class Duplicate_Parenthesis { // O(n)
    
    public static boolean duplicate_parenthesis(String s){
        Stack<Character> st = new Stack<>();
        int n = s.length();

        st.push(s.charAt(0));
        //System.out.println(st.peek());
        
        for(int i = 1 ; i< n ; i++){

            if(s.charAt(i) == ')'){
                int count = 0;
                while(st.pop() != '('){
                    //System.out.println("Pop: "+ st.pop());
                    count++;
                }
                //System.out.println("value of count: "+ count);
                if(count < 1){
                    return true;
                }  
                //System.out.println("POP : "+st.pop()); 
            }
            else{
            st.push(s.charAt(i));
            //System.out.println("Push "+st.peek());
            }
        }
        return false;
    }
    public static void main(String args[]){
        String s = "(a(b+c((S))))";
        String s1 ="(A+b+(C)+(-d))";
        System.out.println(duplicate_parenthesis(s));
        System.out.println(duplicate_parenthesis(s1));
    }
}
