package y_lab.krylov.database;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * database replenishment from liquibase
 */
public class DataBase {

    public static void startDatabase() {
        try (JdbcConnection jdbcConnection = new JdbcConnection(GetConnection.getConnection())) {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);
            Liquibase liquibase = new Liquibase("dp.changelog/changelog.xml", new ClassLoaderResourceAccessor(), database);
            //liquibase.clearCheckSums();
            liquibase.update();
            System.out.println("Migration is successfully");

        } catch (LiquibaseException exception) {
            System.out.println("SQL got exception " + exception.getMessage());
        }
    }

}
