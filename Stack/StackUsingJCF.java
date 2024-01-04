package Stack;
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
    }
}