/*You are given n activities with their start and end times. Select the maximum number of activities
that can be performed by a single person, assuming that a person can only work on a single
activity at a time. Activities are sorted according to end time. */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class ActivitySelection {
    
    public static void main(String[] args) {
        // int start[] = {1,3,0,5,8,5};
        // int end[] = {2,4,6,7,9,9};
        // End time basis Sorted

        int start[] = {0,1,3,5,5,8}; // Start time basis sorted
        int end[] = {6,2,4,7,9,9};

        ArrayList<Integer> ans = new ArrayList<>();
        
        //Sorting by end time.
        int act[][] = new int[start.length][3];

        for(int i  = 0 ; i < start.length ;i++){
            act[i][0] = i;
            act[i][1] = start[i];
            act[i][2] = end[i];
        }

        // Lamba function -> Shortform 
        Arrays.sort(act, Comparator.comparingDouble(o -> o[2]));

        //When sorted on end time basis
        // int maxAct = 1;
        // ans.add(0);
        // int lastEnd = end[0];

        // for(int i = 1; i < end.length ;i++){
        //     if(start[i] >= lastEnd){ // activity select
        //         maxAct++;
        //         ans.add(i);
        //         lastEnd = end[i];
        //     }
        // }

        //unsorted on end time basis
        int maxAct = 1;
        ans.add(act[0][0]);
        int lastEnd = act[0][2];

        for(int i = 1; i < end.length ;i++){
            if(act[i][1]>= lastEnd){ // activity select
                maxAct++;
                ans.add(act[i][0]);
                lastEnd = act[i][2];
            }
        }

        System.out.println("Maximum Activity : "+ maxAct);
        for(int i = 0; i <ans.size() ;i++){
            System.out.println("Activity(" + ans.get(i) + ")");
        }

    }
}
