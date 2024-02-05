package y_lab.krylov.readinds;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * show readings*/
public class ShowReadingsImplemets implements ShowReadings{
    @Override
    public void printActualReadings(ResultSet resultSet)  {
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("hot_water") + " " +
                        resultSet.getString("cold_water") + " " +
                        resultSet.getString("heating"));
            }
        }
        catch (SQLException exception){
            exception.getMessage();
        }
    }
}
