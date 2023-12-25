public class Permutation_Calculation {
    //Tc = O(n * n!)
    //Sc = O(n)
    public static void Permutation(String raw, String answer){
        
        if(raw.length() == 0){
            System.out.println(answer); // Printing Every Single permutation.
            return;
        }

        for(int i = 0; i < raw.length() ; i++){
            char curr = raw.charAt(i);
            String newStr = raw.substring(0, i) + raw.substring(i+1);
            Permutation(newStr, answer+curr); //Recursive call and backtracking.
        }
    }

    public static int Factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * Factorial(n-1);
    }
    public static void main(String args[]){
        String s = "pqzm";
        System.out.println("Total Possible Purmutation : " + Factorial(s.length()));
        Permutation(s, "");
    }
}
