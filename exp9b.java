import java.util.*;

public class exp9b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        HashMap<String, String> mapOne = new HashMap<>();
        HashMap<String, String> mapTwo = new HashMap<>();
        
        System.out.print("Enter how many pairs in HashMap 1: ");
        int mapOneSize = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter your " + mapOneSize + " pairs of strings (format: key value):");
        for (int i = 0; i < mapOneSize; i++) {
            String[] pairs = sc.nextLine().split(" ");
            mapOne.put(pairs[0], pairs[1]);
        }
        
        System.out.print("Enter how many pairs in HashMap 2: ");
        int mapTwoSize = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter your " + mapTwoSize + " pairs of strings (format: key value):");
        for (int i = 0; i < mapTwoSize; i++) {
            String[] pairs = sc.nextLine().split(" ");
            mapTwo.put(pairs[0], pairs[1]);
        }
        
        final int[] count = {0}; // using array to allow modification inside lambda

        mapOne.forEach((key, value) -> {
            if (mapTwo.containsKey(key) && mapTwo.get(key).equals(value)) {
                count[0]++;
            }
        });
        
        System.out.println("The number of key/value pairs in common: " + count[0]);
        sc.close();
    }
}
