package y_lab.krylov.readinds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * check readings*/
public class CheckMonthImplementation implements CheckMonth{
    @Override
    public boolean checkMonth(int month, int year) {
        AllReadings allReadings = new AllReadingsImplements();
        try {
            ResultSet resultSet = allReadings.getAllReadings();
            while (resultSet.next()) {
                LocalDate dt = LocalDate.parse(resultSet.getString(3));
                if (dt.getMonth().getValue() == month && dt.getYear() == year)
                    return true;
            }
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return false;
    }
}
