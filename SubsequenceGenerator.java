import java.util.ArrayList;
import java.util.List;
public class SubsequenceGenerator {
    public static void getSubSequences(String s,int idx,String curr,List<String> subsequences){

        if(idx == s.length()){
            subsequences.add(curr);
            return;
        }
        // once take the character 
        getSubSequences(s, idx+1, curr + s.charAt(idx), subsequences);
        // once exclude the charater 
        getSubSequences(s, idx+1, curr, subsequences);
    }
    public static void main(String[] args){
        
        String s = "abc";
        List<String> subsequences = new ArrayList<>();

        getSubSequences(s,0,"",subsequences);

        for(String sub : subsequences){
            System.out.println(sub);
        }

    
    }   
}
