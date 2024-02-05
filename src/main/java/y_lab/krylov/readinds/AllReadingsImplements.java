package y_lab.krylov.readinds;

import y_lab.krylov.database.GetConnection;
import y_lab.krylov.login_to_app.AuthorizationImplements;

import java.sql.*;

/**
 * get all readings for a specific user*/
public class AllReadingsImplements implements AllReadings {
    @Override
    public ResultSet getAllReadings() {
        int userId = AuthorizationImplements.getUser_id();
        String allUsers = "SELECT * FROM readings where id_user = " + userId;
        try(Connection connection = GetConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(allUsers);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        }
        catch (SQLException exception){
            exception.getMessage();
        }
        return null;
    }
}
