import java.util.Scanner;
public class LongestCommonPrefix {
    class LongestCommPrefix {

        public static String longestCommPrefix(String s1, String s2) {
            StringBuilder s = new StringBuilder();
    
            for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) { // If both Character matches
                    s.append(s1.charAt(i));
                } else {
                    break; // Else break the loop
                }
            }
     
            return s.toString(); // return string
        }
    }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            System.out.print("Enter String 1 : ");
            String s1 = sc.nextLine();
    
            System.out.print("Enter String 2 : ");
            String s2 = sc.nextLine();
    
            System.out.println("Lonest Common Prefix : " + LongestCommPrefix.longestCommPrefix(s1, s2));
            sc.close();
        }
    
}
