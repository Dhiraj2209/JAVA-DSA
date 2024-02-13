/* We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate
into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive
integer. This cost does not depend on the size of the part that is being broken but only depends on
the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines
with xl, x2, ..., xm-l and along horizontal lines with YI, Y2
yn-l.
Compute the minimal cost of breaking the whole chocolate into single squares. */
import java.util.*;

public class Chocola {

    public static void main(String[] args) {
        //int n = 4, m = 6;

        Integer costver[] = {2,1,3,1,4}; // m-1
        Integer costhor[] = {4,1,2};  //n-1

        Arrays.sort(costver , Collections.reverseOrder());
        Arrays.sort(costhor, Collections.reverseOrder());

        int h =0, v = 0;
        int hp = 1 , vp = 1;
        int cost = 0;

        while (h < costhor.length && v < costver.length) {
            //Vertical cost < horizontal cost
            if(costver[v] <= costhor[h]){ // horizontal cut
                cost += (costhor[h] * vp);
                hp++;
                h++;
            }
            else {
                cost += (costver[v] * hp);
                vp++;
                v++;
            }
        }

        while(h < costhor.length){
            cost += (costhor[h] * vp);
            hp++;
            h++;
        }

        while(v < costver.length){
            cost += (costver[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Final Minimal cost to Make 1X1 chocolate part : " + cost);
    }
}
