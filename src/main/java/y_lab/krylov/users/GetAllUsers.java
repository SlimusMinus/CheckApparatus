package y_lab.krylov.users;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GetAllUsers {
    public ResultSet getAllUsers() throws SQLException;
}
