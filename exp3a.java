/*Given an array arr[] of N integers, the task is to find the maximum 
difference between any two elements of the array.*/

import java.util.Scanner;
public class exp3a {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements : ");
        int N = sc.nextInt();

        int[] arr = new int[N];
        
        System.out.print("Enter array elements : ");
        // Take input and fill in array
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int maxi = arr[0];
        int mini = arr[0];
        // find maximum and minimum element
        for(int i=1;i<N;i++){
            maxi = Math.max(maxi,arr[i]);
            mini = Math.min(mini,arr[i]);
        }

        System.out.println("The maximum difference between any two elements of the array is: " + (maxi-mini));
        sc.close();
    
    }
}


