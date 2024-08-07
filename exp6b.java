/*  6b. You have created a web-based survey of favorite programming languages and are capturing the 
results into a text file named “logfile”. The structure of the text file is:
For example, here is a sample logfile of six entries:
The logfile is ordered by increasing timestamp. You are concerned that some people are voting 
multiple times for the same item. To somewhat address this problem, throw out any new votes for 
the same item that come from the same IP address within 20 seconds.
In the above example, the second and last votes for PHP would be thrown out because they are for 
the same item from the same IP address and occur within 20 seconds of other PHP votes from the 
same IP address. However, the PHP vote from 128.120.56.214 would be retained since there is not 
another PHP vote from this IP address.
Write a Java program to count the votes from the logfile, throwing out duplicate votes using the 
rules above. Display the votes in a table, as shown below for the example:
PHP 2 
C# 1
Prolog 1
*/

import java.util.*;
import java.io.*;

class Data{
    String lang,ip,timestamp;
    Data(String lang,String ip,String timestamp){
        this.lang = lang;
        this.ip = ip;
        this.timestamp = timestamp;
    }
}

public class exp6b {
    public static void main(String[] args)throws Exception{
    
       // read the file and store the data in a list of objects
         
        try(BufferedReader br = new BufferedReader(new FileReader("logfile.txt"))){
            String line;
            String[] data;

            List<Data> lst = new ArrayList<>();
            while((line = br.readLine()) != null){
                data = line.split("\s");
                lst.add(new Data(data[0], data[1], data[2]));
            }

            // print the data

            for(Data d : lst){
                System.out.println(d.lang + " , " + d.ip + " , " + d.timestamp);
            }

            int n = lst.size();

            for(int i = 0 ; i < n - 1 ;i++){
                for(int j = i + 1 ; j < n ; j++){
                    // lst[i].lang  == lst[j].lang && lst[j].ip == lst[j].ip

                    if(lst.get(i).lang.equals(lst.get(j).lang) && lst.get(i).ip.equals(lst.get(j).ip)){
                        int t1 = Integer.parseInt(lst.get(i).timestamp);
                        int t2 = Integer.parseInt(lst.get(j).timestamp);

                        // Now check there differece 
                        if(t1 - t2 <= 20){
                            lst.remove(j);
                            n--;
                        }
                    }
                }
            }


            HashMap<String,Integer> votes = new HashMap<>();

            for(Data d : lst){
                int x = votes.getOrDefault(d.lang, 0) + 1;
                votes.put(d.lang,x);
            }

            // Now print the results
            votes.forEach((key,val)-> System.out.println(key + " " + val));
        }
    
    }
}
