/*You are given n pairs of numbers. In every pair, the first number is always smaller than the
second number. A pair (c, d) can come after pair (a, b) if b < c.
Find the longest chain which can be formed from a given set of pairs. */
import java.util.*;

public class MazLengthChainOfPairs {
    
    public static void main(String[] args) { // O(nlogn)
        int pair[][] = {{5,24}, {39,60}, {5,28},{27,40},{50,90}};

        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        int chainlen = 1;
        int pairEnd = pair[0][1]; //Chain End

        for(int i = 0 ; i < pair.length ;i++){
            if(pair[i][0] > pairEnd){
                chainlen++;
                pairEnd = pair[i][1];
            }
        }

        System.out.println("Pair for maximum length of chain : "+ chainlen);

    }
}
