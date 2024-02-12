package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

   public class UserRegistration {
    public static void registerUser(String url, String username, String password, String usernameToRegister, String passwordToRegister, String emailToRegister) {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO usercredentials (username, password, email) VALUES (?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usernameToRegister);
                statement.setString(2, passwordToRegister);
                statement.setString(3, emailToRegister);

                statement.executeUpdate();
            }
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
