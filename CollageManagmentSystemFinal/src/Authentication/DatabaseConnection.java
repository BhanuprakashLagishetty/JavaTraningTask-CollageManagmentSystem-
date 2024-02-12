package Authentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Authentication.UserRegistration.registerUser;

class DatabaseConnection {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/collagemanagmentsystem";


        String username = "root";
        String password = "";


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database!");
            registerUser(url,username,password,"bhanuprakash","123","bhanu@gmail.com");


            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            // Handle any SQL errors
            System.out.println(e);
        }
            }
        }


