/*8b. Write a program to find the most common words in the list of words given in sorted order based
on occurrence from largest to smallest. If any of words are having same occurrence then consider
the smallest character order comes first.
Input format: First line contains the list of words and next line contains a number (k) which
represent the top most words to display.
Output format: display the k top most words.*/
import java.util.*;

class WordFreq{
    String word;
    int fre;

    WordFreq(String w , int f){
        word = w;
        fre = f;
    }
}
public class exp8b {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String s = sc.nextLine();
        String words[] = s.split(" ");
        System.out.print("Enter k : ");
        int k = sc.nextInt();

        

        Map<String,Integer> freq = new HashMap<>();
        for(String word : words){
            freq.put(word , freq.getOrDefault(word,0 )+1);
        }

        PriorityQueue<WordFreq> pq = new PriorityQueue<>(
            (a,b)->(a.fre == b.fre)? a.word.compareTo(b.word) : b.fre - a.fre
            
            
        );

        // Now add the pairs from map to priority queue

        freq.forEach((word,f) -> pq.add(new WordFreq(word, f)));

        // Now print the top k members
        for (int i=0 ; i<k && !pq.isEmpty() ; i++) {
            System.out.print(pq.poll().word + " ");
        }

        sc.close();
    
    }
    
}
