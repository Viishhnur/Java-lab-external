/*9. a. Write a java Program to write a method fCount which takes a string as a parameter. The
Method fCount should return the Map which has the frequency count of the given word. For
example if the string passed is “hello” the map should return {h-1,e-1,l-2,o-1}. The order of the
characters should be same as in the string.*/
import java.util.*;
public class exp9a {
    private static Map<Character,Integer> fCount(String word){
        Map<Character,Integer> freq = new LinkedHashMap();

        for(int i=0;i<word.length();i++){
            freq.put(word.charAt(i),freq.getOrDefault(word.charAt(i), 0)+1);
        }

        return freq;

    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        Map<Character,Integer> res = new HashMap<>();

        res = fCount(s);
        // res.forEach((ch,f)-> System.out.println(ch + " -> " + f));
        System.out.println(res);
        sc.close();
    }
}
