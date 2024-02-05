package y_lab.krylov.users;

import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import y_lab.krylov.database.GetConnection;
import static org.assertj.db.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


class AddNewUserImplementsTest {
    Table table;
    Source source;
    String insertNewUser;
    Connection connection;
    PreparedStatement statement;
    static String URL;
    static  String LOGIN;
    static String PASSWORD;
    Properties properties;

    int size;
    @BeforeEach
    @DisplayName("add new user in database")
    void setUp() throws SQLException {
        try( FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            properties = new Properties();
            properties.load(fis);
            URL = properties.getProperty("URL");
            LOGIN = properties.getProperty("LOGIN");
            PASSWORD = properties.getProperty("PASSWORD");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        source = new Source(URL, LOGIN, PASSWORD);
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