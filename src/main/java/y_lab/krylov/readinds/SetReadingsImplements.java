package y_lab.krylov.readinds;

import y_lab.krylov.database.GetConnection;
import y_lab.krylov.login_to_app.AuthorizationImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * set readings for specific user
 * check date specific month
 * check date on now and latter date*/

public class SetReadingsImplements implements SetReadings{
    private Scanner in = new Scanner(System.in);
    @Override
    public void setReadings() {
        String insertNewUser = "INSERT INTO readings (id_user, hot_water, cold_water, heating, date_readings) " +
                "values(?,?,?,?,?)";
        Connection connection = GetConnection.getConnection();
        CheckMonth checkMonth = new CheckMonthImplementation();
        int userId = AuthorizationImplements.getUser_id();
        try {
            PreparedStatement statement = connection.prepareStatement(insertNewUser);
            statement.setInt(1, userId);
            int hot_waters = in.nextInt();
            statement.setInt(2, hot_waters);
            int cold_waters = in.nextInt();
            statement.setInt(3, cold_waters);
            int heating = in.nextInt();
            statement.setInt(4, heating);
            int day = in.nextInt();
            int month = in.nextInt();
            int year = in.nextInt();
            LocalDate date = LocalDate.of(year, month, day);

            if(LocalDate.now().isBefore(date)){
                System.out.println("Incorrect input data");
            }
            else if(!checkMonth.checkMonth(month, year)){
                statement.setObject(5, date);
                statement.executeUpdate();
                System.out.println("Readings successfully transmitted");
            }
            else
                System.out.println("This month the data was transferred");

        }
        catch (SQLException exception){
            System.out.println("SQL exception " + exception.getMessage());
        }
        catch (InputMismatchException exception){
            System.out.println("Incorrect input data" + exception.getMessage());
        }
    }
}
