/* Given two arrays A and B of equal length n. Pair each element of array A to an element
in array B, such that sum S of absolute differences of all the pairs is minimum.*/

import java.util.Arrays;
import java.math.*;

public class MinimumSumAbsoluteDiff { // O(nlogn)
    public static void main(String[] args) {
        int a[] = {3,2,3,5};
        int b[] = {2,1,3,8};

        Arrays.sort(a);
        Arrays.sort(b);

        int minAbsDiff = 0;

        for(int i = 0 ; i < a.length ; i++){
            minAbsDiff += Math.abs(a[i] - b[i]);
        }

        System.out.println("Minimum Diff : "+ minAbsDiff);
    }
}
