package y_lab.krylov.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * database connection
 */

public class GetConnection {

    private static Connection connection;
    private static String URL;
    private static  String LOGIN;
    private static String PASSWORD;

    public static Connection getConnection() {

        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/application.properties");
            properties.load(fis);
            URL = properties.getProperty("URL");
            LOGIN = properties.getProperty("LOGIN");
            PASSWORD = properties.getProperty("PASSWORD");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }
        catch (SQLException exception){
            System.out.println("SQL got exception " + exception.getMessage());
        }
        catch (IOException exception){
            System.out.println("IOEXception " + exception.getMessage());
        }
        return connection;
    }
}
