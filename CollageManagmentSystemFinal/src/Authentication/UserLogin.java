package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
    public static boolean authenticateUser(String url, String username, String password, String usernameToCheck, String passwordToCheck) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM usercredentials WHERE username = ? AND password = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usernameToCheck);
                statement.setString(2, passwordToCheck);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful!");
                    return true;

                } else {
                    System.out.println("Invalid username or password!");
                    return  false;
                }
            }
        } catch (SQLException e) {
            // Handle SQL errors
            System.out.println(e);
        }
        return false;
    }
}
