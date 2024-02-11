/*We are given an infinite supply of denominations
[1, 2, 5, 10, 20, 50, 100, 500, 20001.
Find min no. of coinslnotes to make change for a value V. */
import java.util.*;

public class MinCoinChangeOfValue {

    public static void main(String[] args) {
        Integer curr[] = {1,2,5,10,20,50,100,200,500,2000};

        Arrays.sort(curr, Comparator.reverseOrder());

        int amount = 2537;
        int count= 0;
        System.out.print("Notes to Make Change : " );
        for(int i = 0 ; i < curr.length ;i++){
            if(curr[i] <= amount){
                while(curr[i] <= amount){
                    System.out.print(curr[i] + ", ");
                    count++;
                    amount -= curr[i];
                }
            }
        }

        System.out.println("\nTotal notes for Making Change : " + count);
    }
}