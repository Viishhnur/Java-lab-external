import java.sql.*;

public class Main {
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
            Statement statement = connection.createStatement();
    
            String query = "SELECT * FROM student";
            ResultSet rs = statement.executeQuery(query);
    
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

    @SuppressWarnings("unused")
    private static void insertData(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
    
            String query = String.format("INSERT INTO student (student_id,name,marks) VALUES (%d,'%s',%d)",12,"Ravi",100); 
            int rowsAffected = statement.executeUpdate(query); // since it is a crud operation we get noOf rows affected
    
            if(rowsAffected > 0){
                System.out.println("\nData successfully inserted into table\n");
            }            
    
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        
    }
    @SuppressWarnings("unused")
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
    public static void main(String[] args) {
        // Step 1: Load the drivers
        loadDrivers();

        // Step 2: Establish the connection
        retrieveData();

        // Step3: Insert some data into the table student
       
        // insertData();

        // updateData();

        DeleteRow();

        retrieveData();

    }
    
}
