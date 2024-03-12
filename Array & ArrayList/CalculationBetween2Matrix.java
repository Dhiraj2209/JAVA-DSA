import java.util.Scanner;

public class CalculationBetween2Matrix {
    
    public static void calBetweenMatrix(int matrix1[][], int matrix2[][], char c){
        int finalmatrix[][] = new int[matrix1.length][matrix1.length];

        if(c == '+'){ //If operator is addition
            for(int i = 0 ; i < finalmatrix.length ;i++){
                for(int j = 0 ; j < finalmatrix.length ;j++){
                    finalmatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                    System.out.print(finalmatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if(c == '-'){ // If operator is subtraction
            for(int i = 0 ; i < finalmatrix.length ;i++){
                for(int j = 0 ; j < finalmatrix.length ;j++){
                    finalmatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                    System.out.print(finalmatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if(c == '*'){ // If operator is multiplication
            for(int i = 0 ; i < finalmatrix.length ;i++){
                for(int j = 0 ; j < finalmatrix.length ;j++){
                    finalmatrix[i][j] = matrix1[i][j] * matrix2[i][j];
                    System.out.print(finalmatrix[i][j] + " ");
                }
                System.out.println();
            }
        }  
    }

    public static void main(String args[]){
        int matrix1[][]= new int[3][3];
        int matrix2[][]= new int[3][3];

        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < matrix1.length ;i++){ //Enter element of first matrix
            for(int j = 0 ; j < matrix1.length ;j++){
                System.out.print("Enter the " + i + ", " + j + " Element of matrix 1 : ");
                matrix1[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < matrix2.length ;i++){ // Enter element of Second matrix
            for(int j = 0 ; j < matrix2.length ;j++){
                System.out.print("Enter the " + i + ", " + j + " Element of matrix 2 : ");
                matrix2[i][j] = sc.nextInt();
            }
        }


        System.out.print("Enter Operator (+, - , *) : "); //Enter operator
        char c = sc.next().charAt(0);
        System.out.println(c);

        sc.close();

        System.out.println("Matrix 1 : "); //printing matix 1
        for(int i = 0 ; i < matrix1.length ;i++){
            for(int j  = 0 ; j < matrix1.length ;j++){
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix 2 : ");//printing matix 2
        for(int i = 0 ; i < matrix2.length ;i++){
            for(int j  = 0 ; j < matrix2.length ;j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        if(c == '+' || c == '-' || c == '*'){
            System.out.println("Answer Matrix : "); //printing final matrix
            calBetweenMatrix(matrix1, matrix2, c);
        }
        else {
            System.out.println("Unvalid operator");
        }
    }
}
