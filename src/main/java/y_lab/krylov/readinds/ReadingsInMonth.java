package y_lab.krylov.readinds;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReadingsInMonth {
    public ResultSet getReadingsInMonth(int month);
}
