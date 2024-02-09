package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharInStream {

    public static void firstNonRepeatingCharInStream(String s){
        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26]; // frequency of characters
        char ch;
        for(int i = 0 ; i < s.length() ;i++){
            ch = s.charAt(i);
            q.add(ch);
            freq[ch - 'a']++; // incrementing Freq of ch

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){ // Repeting char
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print("-1 ");
            }
            else{
                System.out.print(q.peek()+ " ");
            }
        }

    }
    public static void main(String[] args) {
        firstNonRepeatingCharInStream("aabbcxxcd");
    }
}
