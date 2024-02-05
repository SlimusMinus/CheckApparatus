package y_lab.krylov.readinds;

import y_lab.krylov.database.GetConnection;
import y_lab.krylov.login_to_app.AuthorizationImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * get readings in specific month*/
public class ReadingsInMonthImplements implements ReadingsInMonth{

    @Override
    public ResultSet getReadingsInMonth(int month){
        int userId = AuthorizationImplements.getUser_id();
        Connection connection = GetConnection.getConnection();
        String allUsers = "SELECT * FROM readings where id_user = " + userId +
                " AND extract(month from date_readings) = " + month;
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
