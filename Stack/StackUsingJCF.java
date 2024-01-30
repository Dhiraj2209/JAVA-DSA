// package Stack;
import java.util.Stack;

public class StackUsingJCF{

    public static void PushAtBottom(int data, Stack<Integer> s){
        if(s.empty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        PushAtBottom(data, s);
        s.push(top);
    }

    public static void RevStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }

        int top = s.pop();
        RevStack(s);
        PushAtBottom(top,s);
    }

    public static Boolean ValidParentheses(String str){
        Stack<Character> sv = new Stack<>();
        int i = 0 ;
        
        if(str.length() % 2 != 0 || str.length() == 0){
            return false;
        }

        while(i < str.length()){
            char curr = str.charAt(i);
            
            if(curr == '(' || curr == '[' || curr == '{'){
                sv.push(curr);
            }
            else {

                if (sv.isEmpty()) {
                    return false;
                }

                char com = sv.pop();

                if(curr == ')' && com != '('){
                    return false;
                }
                else if(curr == '}' && com != '{'){
                    return false;
                }
                else if(curr == ']' && (com == ')' || com == '}')) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static String RevString(String str){
        Stack<Character> sc =  new Stack<>();
        int i = 0;
        StringBuilder newstr = new StringBuilder();

        while (i< str.length()) {
            char top = str.charAt(i);
            sc.push(top);
            i++;
        }

        while(!sc.empty()){
            char top = sc.pop();
            newstr.append(top);
        }

        return newstr.toString();
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(42);
        PushAtBottom(4,s);
        RevStack(s);
        System.out.println(s);
        System.out.println(RevString("dhiraj"));
        System.out.println(ValidParentheses("(()){}[]{{[(({}))]}}{{{{{{}}}}}}()()()()()()()"));
        System.out.println(ValidParentheses("}"));
    }
}