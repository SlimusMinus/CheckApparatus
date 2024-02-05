package y_lab.krylov.readinds;

import org.assertj.db.type.DateValue;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import y_lab.krylov.database.GetConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SetReadingsImplementsTest {

    Table table;
    Source source;
    String insertNewUser;
    Connection connection;
    PreparedStatement statement;
    int size;
    @BeforeEach
    @DisplayName("add new user in database")
    void setUp() throws SQLException {
        source = new Source("jdbc:postgresql://localhost:777/postgres", "username", "password");
        table = new Table(source, "readings");
        size = table.getRowsList().size();
        insertNewUser = "INSERT INTO readings (id_user, hot_water, cold_water, heating, date_readings) values(?,?,?,?,?)";
        connection = GetConnection.getConnection();
        statement = connection.prepareStatement(insertNewUser);
        statement.setInt(1, 1);
        statement.setInt(2, 1);
        statement.setInt(3, 1);
        statement.setInt(4, 1);
        LocalDate date = LocalDate.of(2021,9,9);
        statement.setObject(5, date);
        statement.executeUpdate();
    }
    @Test
    void setReadings() {
        assertThat(table).row(38).hasValues(75,1,DateValue.of(2021, 9, 9),1,1,1);
    }
}