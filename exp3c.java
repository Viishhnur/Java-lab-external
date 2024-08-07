// traping rain water
import java.util.Scanner;
public class exp3c {
    private static int trap(int[] heights,int n){

        // create a leftprefix and right prefix array 
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // now fill them
        leftMax[0] = heights[0];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],heights[i]);
        }

        // now fill the right maximum array
        rightMax[n-1] = heights[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], heights[i]);
        }

        // caluclate the trapped water
        int trappedWater = 0;

        for(int i=0;i<n;i++){
            trappedWater += Math.min(leftMax[i],rightMax[i]) - heights[i];
        }
    
        
        return trappedWater;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of buildings : ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.print("Enter height of each building : ");
        for(int i=0;i<n;i++) {
            heights[i] = sc.nextInt();
        }
        
        System.out.println("Trapped rain water = " + trap(heights,n));
        sc.close();



    
    }
}
