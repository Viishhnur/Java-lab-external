/*  Given a number, check if the number (N) can be written as the form
(k+1)*k. Write a java program to print those numbers in the given range 
*/

import java.util.Scanner;
class exp1a{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i == j*(j+1)){
                    System.out.print(i+" ");
                }
            }
        }
        
        sc.close();
    }
}