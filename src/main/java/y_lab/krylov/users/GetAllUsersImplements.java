package y_lab.krylov.users;

import y_lab.krylov.database.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * get all users in database*/
public class GetAllUsersImplements implements GetAllUsers{
    @Override
    public ResultSet getAllUsers() throws SQLException {
        Connection connection = GetConnection.getConnection();
        String allUsers = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(allUsers);
        return resultSet;
    }
}
