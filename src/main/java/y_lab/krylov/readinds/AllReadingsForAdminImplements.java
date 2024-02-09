package y_lab.krylov.readinds;

import y_lab.krylov.database.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * get all readings for admin*/
public class AllReadingsForAdminImplements implements AllReadingsForAdmin{
    @Override
    public void getAllReadings() {
        Connection connection = GetConnection.getConnection();
        String allUsers = "select * from readings join users on readings.id_user = users.id";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(allUsers);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("hot_water") + " " +
                        resultSet.getString("cold_water") + " " +
                        resultSet.getString("heating"));
            }
        }
        catch (SQLException exception){
            exception.getMessage();
        }
    }
}
