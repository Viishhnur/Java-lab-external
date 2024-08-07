/* 

1c. Cricketer's Pension Continuing our journey in mastering the conditional
statements & our interest with cricket.
Let us help the Indian cricket's governing body (BCCI) to automate its plan of
allotting pensions to former players.
The rules are given below:
If a player has played more than 10 test matches and 100 ODI's he receives
Rs.50,000.
If a player has played more than 10 test matches he receives Rs.25,000.
If a player has played more than 100 ODI's he receives Rs.15,000.
If a player has played for India he receives Rs.10,000.
The amount is incremented by 1/4th for every 'man of the match' award.
If a player has not played for India but played IPL he receives an amount of
Rs.8,000.
If a player has not played for India nor IPL he receives an amount of Rs.7,000
*/

import java.util.Scanner;
public class exp1c {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Has he played for India (y/n): ");

        char c1 = sc.next().charAt(0);

        System.out.print("Has he played IPL (y/n)");
        char c2 = sc.next().charAt(0);

        float amt  = 0;

        if(c1 == 'y'){
            System.out.print("Enter the number of test matches played: ");
            int test = sc.nextInt();

            System.out.print("Enter the number of ODI's played: ");
            int odis = sc.nextInt();

            System.out.print("Enter the number of Man of the Matches: ");
            int mom = sc.nextInt();

            if(test > 10 && odis > 100) amt += 50000;
            else if(test > 10) amt += 25000;
            else if(odis > 100) amt += 15000;
            else amt += 10000; // played for India

            amt += (mom * amt * 0.25); // for man of matches 
            System.out.println("Amount : " + amt);
            System.exit(100);

        }

        if(c2 == 'y'){
            amt += 8000; // for IPL played
            System.out.println("Enter the number of man of the matches: ");
            int mom = sc.nextInt();
            amt += (mom * 0.25 * amt);
            System.out.println("Amount: " + amt);
            System.exit(100);
        }
        else{
            amt += 7000; // neither for ipl nor for india
            System.out.println("Amount: " + amt);
            System.exit(100);
        }

        sc.close();
    }
    
}
