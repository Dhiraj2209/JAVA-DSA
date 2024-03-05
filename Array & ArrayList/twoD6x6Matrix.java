public class twoD6x6Matrix {
/*Write a program that generate 6*6 two-dimensional matrix, filled with 0‘s and 1‘s , 
display the matrix, check every raw and column have an odd number‘s of 1‘s.*/
    public static void main(String[] args) {
        int twoDArr[][] = new int[6][6];

        int row[] = {0,0,0,0,0,0};

        for(int i = 0 ; i < 6 ;i++){
            for(int j = 0 ; j < 6 ;j++){
                long last = (System.nanoTime() / 100 )% 10;

                // System.out.println((last));
                if(last == 0 || last == 2 || last == 3 || last == 7 || last == 8){
                    twoDArr[i][j] = 0;
                }
                else {
                    twoDArr[i][j] = 1;
                    row[i]++;
                }
                System.out.print(twoDArr[i][j] + " ");
            }
            
            System.out.println();
        }
    

        for(int i = 0 ; i < 6 ;i++){
            if(row[i] % 2 == 1){
                System.out.println("Row number " + (i +1)+ " has Odd number of 1's");
            }
        }

        int col[] = {0,0,0,0,0,0};
        for(int i  = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 6 ;j++){
                if(twoDArr[j][i] == 1){
                    col[i]++;
                }
            }
            if(col[i] % 2 == 1){
                System.out.println("col number " + (i + 1)+ " has Odd number of 1's");
            }
        } 
    }
}
