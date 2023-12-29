import java.util.ArrayList;
//import java.util.*;
public class Maximum_water_in_container {
    
    //TC = O(n) 2 pointer approch
    public static int Mostwater(ArrayList<Integer> Ht){
        int si = 0;
        int ei = Ht.size() -1;
        int Max_Water = Integer.MIN_VALUE;

        while(si <ei){
            int width = ei - si;
            int Height = Math.min(Ht.get(si), Ht.get(ei));
            int Curr_Water = width * Height;

            Max_Water = Math.max(Max_Water, Curr_Water);
            
            if(Ht.get(si) < Ht.get(ei)){
                si++;
            }
            else {
                ei--;
            }
        }
        return Max_Water;
    }
    public static void main(String[] args) {
        ArrayList<Integer> Height = new ArrayList<>();
        Height.add(1);
        Height.add(8);
        Height.add(6);
        Height.add(2);
        Height.add(5);
        Height.add(4);
        Height.add(8);
        Height.add(3);
        Height.add(7);
        Height.add(1);
        
        System.out.println("Maximum water that can be stored in Container : " + Mostwater(Height));
    }
}
