// A set of 5 words (strings) will be taken as command line arguments. Write a program to reverse each word and check whether it is palindrome or not using method.

public class RevStrandCheckPalindrome {

    public static String reveseString(String s){
        StringBuilder str = new StringBuilder();

        for(int i = s.length() - 1; i >= 0 ;i--){
            str.append(s.charAt(i));
        }

        return str.toString();
    } 
    public static void main(String[] args) {

        for(int i = 0 ; i < 5 ;i++){
            System.out.print(args[i] + " -> Reversed string -> ");
            System.out.println(reveseString(args[i]));
            if(args[i].equals(reveseString(args[i]))){
                System.out.println(args[i] + " is Palindrome String.");
            }
        }
    }
}