public class Ways_to_go_from_one_point_to_another_in_Grid {

    // Tc =O( 2 ^(n+m))
    public static int Grid_ways(int i , int j ,int n , int m){

        if(i == (n-1) && j == (m-1)){ // Destination
            return 1;
        }
        else if(i == n || j == n){ // above Grid boundry condition
            return 0;
        }

        return Grid_ways(i, j + 1 , n, m) + Grid_ways(i +1, j, n, m);
    }

    //TC = O(n)
    public static long grid_ways(int n, int m){ // Permutation
        return Factorial(n + m - 2) / (Factorial(n - 1) * Factorial(m - 1));
    }

    public static long Factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * Factorial(n-1);
    }
    public static void main(String[] args) {
        int n = 10, m = 10;
        System.out.println(Grid_ways(0, 0, n, m));
        System.out.println(grid_ways(n, m));
    }
}