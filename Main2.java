import java.sql.*;
import java.util.Scanner;
public class Main2 {
    private static final String url = "jdbc:mysql://localhost:3306/college";
    private static final String username = "viishhnu";
    private static final String password = "1234";

    private static void loadDrivers(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }
    }
    private static void retrieveData(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

    
            ResultSet rs = preparedStatement.executeQuery(query);
            
            // Print the result with formatting
            System.out.println(String.format("%-10s %-20s %-10s", "Student ID", "Name", "Marks"));
            System.out.println("----------------------------------------------------");
            while (rs.next()) {
                int sid = rs.getInt("student_id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                System.out.println(String.format("%-10d %-20s %-10d", sid, name, marks));
            }
    
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        
    }

    private static void insertData(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO student(student_id,name,marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query); // this gets compiled 
            
            // Now set the values
            preparedStatement.setInt(1,15);
            preparedStatement.setString(2, "Ankita");
            preparedStatement.setInt(3, 54);
            int rowsAffected = preparedStatement.executeUpdate(); //
    
            if(rowsAffected > 0){
                System.out.println("\nData successfully inserted into table\n");
            }            
    
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        
    }
    private static void updateData(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
    
            String query = String.format("UPDATE student SET name = '%s',marks = %d WHERE student_id = %d","Viishhnu",98,14); 
            int rowsAffected = statement.executeUpdate(query); // since it is a crud operation we get noOf rows affected
    
            if(rowsAffected > 0){
                System.out.println("\nData successfully updated\n");
            }            
    
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        
    }
    private static void DeleteRow(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
    
            String query = String.format("DELETE FROM student WHERE student_id = %d",12); 
            int rowsAffected = statement.executeUpdate(query); // since it is a crud operation we get noOf rows affected
    
            if(rowsAffected > 0){
                System.out.println("\nData successfully deleted\n");
            }            
    
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        
    }
    private static void insertTakeInput(){
        try(Connection connection = DriverManager.getConnection(url, username, password)){

            String query = "INSERT INTO student (student_id,name,marks) VALUES (?,?,?)";

            // create a prepare statement 
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            Scanner sc = new Scanner(System.in);

            while(true){

                System.out.print("Enter student id : ");
                int sid = sc.nextInt();

                System.out.print("Enter student name : ");
                sc.nextLine(); // consume the newline character
                String name = sc.nextLine();

                System.out.print("Enter student marks : ");
                int marks = sc.nextInt();
                
                // Set the parameters
                preparedStatement.setInt(1, sid);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, marks);

                // add this record to batch
                preparedStatement.addBatch();
                // now take choice  whether to continue further or not
                System.out.print("Enter your choice y/n : ");
                String choice = sc.next();

                if(choice.toUpperCase().equals("N")) break;
            }
            int[] arr = preparedStatement.executeBatch();
            // it returns a binary array
            for(int i=0;i<arr.length;++i){
                if(arr[i] == 0){
                    System.out.println("Query "+(i+1)+" failed to execute");
                }
            }

        }

        catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        } 
    }   
    public static void main(String[] args) {
        // Step 1: Load the drivers
        loadDrivers();

        // Step 2: Establish the connection
        retrieveData();

        // take user input 
        insertTakeInput();

        retrieveData();


    }
    
}
