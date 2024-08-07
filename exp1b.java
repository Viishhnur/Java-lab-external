/*
Write a java program to check whether the given number is gapful or not.
A number is gapful if it is at least 3 digits long and is divisible by the number formed by stringing the
first and last numbers together. The smallest number that fits this description is 100. First digit is 1, last
digit is 0, forming 10, which is a factor of 100. Therefore, 100 is gapful. Print “Yes” if it is gapful
otherwise “No”.
*/

import java.util.Scanner;

public class exp1b {
    private static boolean cond1(int n){
        return n>=100;
    }
    private static boolean cond2(int n){
        int m = n;
        int ld=0;
        while(m!=0){
            ld = m % 10;
            m /= 10;
        }
        int stringified_num = ld * 10 + n % 10;
        return (n % stringified_num == 0);
    }
    private static boolean isGapful(int n){

        return cond1(n) && cond2(n);
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number : ");
        int n = sc.nextInt();

        System.out.println((isGapful(n))? "Yes" : "No");
        sc.close();
    }
}
