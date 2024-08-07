/*4a. Given two strings text1 and text2, return the length of their longest common
subsequence. A subsequence of a string is a new string generated from the
original string with some characters (can be none) deleted without changing the
relative order of the remaining characters. (eg, "ace" is a subsequence of
"abcde" while "aec" is not). A common subsequence of two strings is a
subsequence that is common to both strings. If there is no common
subsequence, return 0.
*/
import java.util.Scanner;
public class exp4a {

    private static int f(String s1,String s2,int i,int j,int[][] dp){

        if(i < 0 || j < 0) return 0; // base case

        // add memoization check
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + f(s1,s2,i-1,j-1,dp);
        }

        // If doesnt match
        return dp[i][j] = Math.max(f(s1,s2,i,j-1,dp),f(s1,s2,i-1,j,dp));


    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string 1 : ");
        String s1 = sc.next();

        System.out.print("Enter string 2 : ");
        String s2 = sc.next();

        int m = s1.length();
        int n = s2.length();

        
        // int[][] dp = new int[m][n];
        // for(int i=0;i<m;i++){
            //     for(int j=0;j<n;j++){
                //         dp[i][j] = -1;
                //     }
                // }
                
                
        int[][] dp = new int[m+1][n+1];
        // Now do with tabulation
        
        // start filling the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Adjust indices for character comparison
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        System.out.println("Longest subsequence length is : "+dp[m][n]);

        // System.out.println("Longest subsequence length is : "+f(s1,s2,m-1,n-1,dp));

        sc.close();
    
    }
}
