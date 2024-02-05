package y_lab.krylov.users;

import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import y_lab.krylov.database.GetConnection;
import static org.assertj.db.api.Assertions.assertThat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class AddNewUserImplementsTest {
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
        table = new Table(source, "users");
        size = table.getRowsList().size();
        insertNewUser = "INSERT INTO users (login, password, name, age, city) values(?,?,?,?,?)";
        connection = GetConnection.getConnection();
        statement = connection.prepareStatement(insertNewUser);
        statement.setString(1, "Logan");
        statement.setString(2, "password");
        statement.setString(3, "name");
        statement.setInt(4, 85);
        statement.setString(5, "city");
        statement.executeUpdate();
    }

    @Test
    void addNewUser() {
        assertThat(table).column().hasNumberOfRows(size++);
    }

    @AfterEach
    @DisplayName("delete new user in database")
    void delTestUser() throws SQLException{
        insertNewUser = "delete from users where login='Logan'";
        connection = GetConnection.getConnection();
        statement = connection.prepareStatement(insertNewUser);
        statement.executeUpdate();
    }
}