public class Sudoku {
    
    public static boolean Sukodusolver(int sudoku[][], int i,int j){
        
        if(i == 9 && j == 0){ //all boxes are fill.
            return true;
        }

        int nextrow = i, nextcol = j+1;
        if(j+1 == 9){ // last box in each row.
            nextrow = i+1;
            nextcol = 0;
        }

        if(sudoku[i][j] != 0){ // already element present in box.
            return Sukodusolver(sudoku, nextrow, nextcol);
        }

        for(int k = 1; k <= 9 ; k++){ //checking every element for boxes.
            if(issafe(k, i , j, sudoku)){
                sudoku[i][j] = k;
                if(Sukodusolver(sudoku, nextrow, nextcol)){
                    return true;
                }
                sudoku[i][j] = 0;
            }
        }
        return false;
    }

    public static boolean issafe(int k, int i, int j, int sudoku[][]){
        for(int ia = 0 ; ia< 9 ;ia++){ // For Col
            if(sudoku[ia][j] == k){
                return false;
            }
        }

        for(int ja= 0 ; ja < 9 ;ja++){ // For Row
            if(sudoku[i][ja] == k){
                return false;
            }
        }
        int sr = (i / 3) * 3, sc = (j / 3) * 3; //getting 1st element's index of 3x3 sub matirx.

        for (int row =sr; row < (sr + 3); row++) { // Checking 3x3 sub matrix.
            for (int col = sc ; col < (sc + 3); col++) {
                if (sudoku[row][col] == k) { 
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void PrintSudoku(int sudoku[][]){
        for(int i = 0 ; i < 9 ; i++){
            for(int u = 0 ; u < 9; u++){
                System.out.print(sudoku[i][u] + " ");
                if((u + 1) % 3 == 0 ){
                    System.out.print("| ");
                }
            }
            if((i + 1) % 3 == 0){
                    System.out.print("\n-----------------------\n");
            }else {
                System.out.println();
            }
        }
    }

    public static void main(String args[]){
        int sudoku[][] = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };
    if(Sukodusolver(sudoku, 0, 0)){
        System.out.println("Solution Exist.");
        
    PrintSudoku(sudoku);
    }else {
        System.out.println("Solution doesn't Exist.");
    }
    }
}
