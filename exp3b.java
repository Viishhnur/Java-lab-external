/* 
b. Write a Java program to fill the below pattern into a square matrix:
The matrix has to be filled with numbers starting from 1. It has to start fill first
row last column, last row (reverse), first column (reverse) and so on. Please
refer the following example
input = 5
output =
1 2 3 4 5
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9
*/
import java.util.Scanner;
public class exp3b {
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        // int num = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while(left <= right && top <= bottom){

            for(int i=left;i<=right;i++){
                mat[top][i] = sc.nextInt();
                // num++;
            }
            top++;

            for(int i=top;i<=bottom;i++){
                mat[i][right] = sc.nextInt();
                // num++;
            }
            right--;

            if(top <= bottom){
                for(int i=right;i>=left;i--){
                    mat[bottom][i] = sc.nextInt();
                    // num++;
                }
            }
            bottom--;

            if(left<=right){

                for(int i=bottom;i>=top;i--){
                    mat[i][left] = sc.nextInt();
                    // num++;
                }
            }
            left++;

        }

        // print the matrix
        System.out.println("Spiral matrix is : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
