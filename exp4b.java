/*Given two strings s1 and s2, your task is to merge those strings to form a
new merged string. A merge operation on two strings is described as follows:
Append alternating characters from s1 and s2, respectively, to mergedString.
Once all of the characters in one of the strings have been merged, append the
remaining characters in the other string to mergedString.*/

import java.util.*;

public class exp4b {
    private static String getMergedStr(String s1,String s2){

        int ptr1 = 0;
        int ptr2 = 0;

        int m = s1.length(), n = s2.length();
        StringBuilder ans = new StringBuilder();

        while(ptr1 < m && ptr2 < n){
            ans.append(s1.charAt(ptr1++));
            ans.append(s2.charAt(ptr2++));
        }

        // Check if anything is left pver
        while(ptr1 < m){
            ans.append(s1.charAt(ptr1++));
        }

        while(ptr2 < n){
            ans.append(s2.charAt(ptr2++));
        }

        return ans.toString(); // converts string builder to string

    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string 1 : ");
        String s1 = sc.next();
        System.out.print("Enter string 2 : ");
        String s2 = sc.next();
        
        System.out.println("The merged string is : " + getMergedStr(s1,s2));
        
        sc.close();
    }
}
