package y_lab.krylov.readinds;

import y_lab.krylov.database.GetConnection;
import y_lab.krylov.login_to_app.AuthorizationImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * get all readings for a specific user*/
public class AllReadingsImplements implements AllReadings {
    @Override
    public ResultSet getAllReadings() {
        int userId = AuthorizationImplements.getUser_id();
        Connection connection = GetConnection.getConnection();
        String allUsers = "SELECT * FROM readings where id_user = " + userId;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(allUsers);
            return resultSet;
        }
        catch (SQLException exception){
            exception.getMessage();
        }
        return null;
    }
}
