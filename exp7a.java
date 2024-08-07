/*7. a. Write a Java Class to implement a method Addition() that returns a new Array where each
array element at the index k corresponds to the sum of elements of the array (src) starting at
index 0 and including element at the index ‘k’. For example, for array [2,3,5], the method will
return array [2,5,10]. For an array of size ‘0’ or a null parameter, the method will throw
exception IllegalArgumentExceptionWith the message “Invalid Argument”.*/

import java.util.Arrays;
import java.util.Scanner;
public class exp7a {

    private static int[] addition(int[] arr,int n){
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + arr[i];
        }

        return preSum;

    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size : ");
        int n = sc.nextInt();
        
        if(n > 0){

            int[] arr = new int[n];
            System .out.print("Enter array elements ");
            for (int i=0 ; i<n ; i++) {
                arr[i] = sc.nextInt();
            }

            // calc and get prefix array
            int[] preSum = addition(arr,n);

            System.out.println(Arrays.toString(preSum)); // it formats and represents the array in [] notation
            
        }
                
        else{
            sc.close();
            throw new IllegalArgumentException("Invalid Argument");
        }       
        sc.close();

                
    
    }
}
                

            

