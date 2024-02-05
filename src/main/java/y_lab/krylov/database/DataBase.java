package y_lab.krylov.database;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 *
 * database replenishment from liquibase*/
public class DataBase {

    public static void startDatabase() {
        try {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(GetConnection.getConnection()));
            Liquibase liquibase = new Liquibase("dp.changelog/changelog.xml", new ClassLoaderResourceAccessor(), database);
           //liquibase.clearCheckSums();
           liquibase.update();
            System.out.println("Migration is successfully");

        } catch (LiquibaseException exception) {
            System.out.println("SQL got exception " + exception.getMessage());
        }
    }

}
