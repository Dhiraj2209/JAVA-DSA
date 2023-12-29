import java.util.ArrayList;

public class Pair_Sum {
    
    // Function to check that target exist in arraylist by adding any two element of the Arraylist.
    // In Sorted Array.
    public static boolean Check_pair_sum(ArrayList<Integer> a, int target){ // O(n) Linear time 
        int si = 0 ;
        int ei = a.size() - 1;

        while(si<ei){
        if(a.get(ei) + a.get(si) == target){
            return true;
        }
        else if(a.get(ei) + a.get(si) > target){
            ei--;
        }
        else{
            si++;
        }
        }

        return false;
    }

    // Function to check that target exist in arraylist by adding any two element of the Arraylist.
    // In Rotated Sorted Array.
    // O(n) Complexity
    // We can also do brute force approch in O(n^2) complexity by checking every single possible pair sum.
    public static boolean Check_pair_sum_in_RSarray(ArrayList<Integer> a , int target){
        int bp = -1;
        int n = a.size();
        for(int i = 0 ; i < a.size() ;i++){
            if(a.get(i) > a.get(i+1)){{
                bp = i;
                break;
            }}
        }

        int si = bp +1 ;
        int ei = bp;

        while (si != ei) {
            if(a.get(si) + a.get(ei) == target){
                return true;
            }
            else if(a.get(si) + a.get(ei) > target){
                ei = (n + ei - 1) % n ; // Part of Modular Arithmetic.
            }
            else {
                si = (si +1) % n;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> Sortedarray = new ArrayList<>();
        
        for(int i = 0 ; i <= 7 ;i++ ){
            Sortedarray.add(i-2);
        }

        System.out.println(Sortedarray);
        System.out.println(Check_pair_sum(Sortedarray, 0));

        ArrayList<Integer> SortedRotatedarray = new ArrayList<>();
        SortedRotatedarray.add(12);
        SortedRotatedarray.add(15);
        SortedRotatedarray.add(18);
        for(int i = 3 ; i <= 7 ;i++ ){
            SortedRotatedarray.add(i+1);
        }

        System.out.println(SortedRotatedarray);

        System.out.println(Check_pair_sum_in_RSarray(SortedRotatedarray, 119));
    }
}
