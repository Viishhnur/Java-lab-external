/*  6a) Write a java program that loads names and phone numbers from the text file into Hash Table 
where data is organized as one line per record and each field in record are separated by a tab(\t). 
It takes a name or phone number as input and prints the corresponding other value from hash 
table.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Scanner;

public class exp6a {
    public static void main(String[] args) throws Exception{

        Hashtable<String,String> ht = new Hashtable<>();

        try(BufferedReader br = new BufferedReader(new FileReader("phonenumbers.txt"))){
            String line;

            while((line = br.readLine()) != null){
                String[] data = line.split("\s");
                ht.put(data[0],data[1]); // name,number
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name or phone number: ");
        String input = sc.nextLine();

        if(ht.containsKey(input)){
            System.out.println("Name : " + input + "\nphone number : " + ht.get(input));
        }
        else if(ht.containsValue(input)){
            // Now traverse in hash table till you find this phone number
            ht.forEach((name,phonenumber)->{
                if(phonenumber.equals(input)){
                    System.out.println("Name : " + name + "\nphone number : " + input);

                }
            });
        }
        else{
            System.out.println("No such name or phone number found in the file.");
        }

        sc.close();
    
    }
}
