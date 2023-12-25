public class Subset_of_String {
    
    public static void subset_of_String (String  raw, String answer, int i){
      
        if(i == raw.length()){ // basecase
            if(answer.length() == 0){
                System.err.println("Null");
            }else {
            System.err.println(answer);
            }
            return;
        }
      
        subset_of_String(raw, answer + raw.charAt(i), i +1); // Character joins the subset
        subset_of_String(raw, answer, i +1); // Characted not joins the subset
    }
    public static void main(String args[]){
        String s1 = "JAVA";
        subset_of_String(s1, "", 0);
    }
}
