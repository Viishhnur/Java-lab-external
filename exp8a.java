/*Write a java program to store the employee details in an ArrayList and display the employee
details in ascending order of their experience. Create 'Employee' class with two instance variables
Employee name and Employee experience (no. of years).*/

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
public class exp8a {

    public static void main(String[] args){
    
        ArrayList<Employee> al = new ArrayList<>();
        al.add(new Employee("John", 5));
        al.add(new Employee("Nic", 3));
        al.add(new Employee("Roma", 9));

        System.out.print("Unosorted list is : ");
        for (int i=0 ; i<al.size() ; i++) {
            System.out.println(al.get(i).toString());
        }

        // Now sort the array list 
        Collections.sort(al,new Comparator<Employee>() {
            public int compare(Employee a,Employee b){
                return a.empExp - b.empExp;
            }
        });

        System.out.println("Sorted list by experience is: ");
        for (int i=0 ; i<al.size() ; i++) {
            System.out.println(al.get(i).toString());
        }

    }
}

class Employee{
    String empName;
    int empExp;

    Employee(String empName,int empExp){
        this.empName = empName;
        this.empExp = empExp;
    }

    public String toString(){
        return "Name: "+ this.empName +", Experience: "+ this.empExp;
    }
}

// class SortBy implements Comparator<Employee>{
//     public int compare(Employee a , Employee b){
//         return a.empExp - b.empExp;
//     }
// }
