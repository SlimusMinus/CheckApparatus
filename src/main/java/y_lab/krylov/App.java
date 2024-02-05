package y_lab.krylov;

import y_lab.krylov.database.DataBase;
import y_lab.krylov.login_to_app.Authorization;
import y_lab.krylov.login_to_app.AuthorizationImplements;
import y_lab.krylov.readinds.*;
import y_lab.krylov.startApp.StartUp;
import y_lab.krylov.users.AddNewUser;
import y_lab.krylov.users.AddNewUserImplements;

import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * the main class is where all the work happens
 * @author Alexandr Krylov
 * @version 1.0*/
public class App {
    public static void main(String[] args) {
        //DataBase.startDatabase();
        Scanner in = new Scanner(System.in);
        ShowReadings showReadings = new ShowReadingsImplemets();
        int exit = 0;
        int choice;
        do {
            choice = StartUp.getChoice();
            if (choice == 1) {
                Authorization authorization = new AuthorizationImplements();
                authorization.input_data();
                if (authorization.IsAuthorization()) {
                    System.out.println("Input your choice");
                    System.out.println("1 - obtaining current meter readings");
                    System.out.println("2 - set readings");
                    System.out.println("3 - for viewing readings for a specific month");
                    System.out.println("4 - viewing the history of testimony submission");
                    System.out.println("5 - viewing the history of testimony of all users");
                    choice = in.nextInt();
                    switch (choice) {
                        case (1): {
                            ActualReadings actualReadings = new ActualReadingsImplements();
                            ResultSet actualReadings1 = actualReadings.getActualReadings();
                            showReadings.printActualReadings(actualReadings1);
                        }
                        break;
                        case (2): {
                            SetReadings setReadings = new SetReadingsImplements();
                            setReadings.setReadings();
                        }
                        break;
                        case (3): {
                            System.out.println("Input month for show yo are readings");
                            int month = in.nextInt();
                            ReadingsInMonth readingsInMonth = new ReadingsInMonthImplements();
                            ResultSet readingsInMonth1 = readingsInMonth.getReadingsInMonth(month);
                            showReadings.printActualReadings(readingsInMonth1);
                        }
                        break;
                        case (4): {
                            AllReadings readings = new AllReadingsImplements();
                            ResultSet allReadings = readings.getAllReadings();
                            showReadings.printActualReadings(allReadings);
                        }
                        break;
                        case (5): {
                            AllReadingsForAdmin readingsForAdmin = new AllReadingsForAdminImplements();
                            readingsForAdmin.getAllReadings();
                        }
                        break;
                        default:
                            System.out.println("This endpoint is missing");
                    }
                }

            } else if (choice == 2) {
                AddNewUser addNewUser = new AddNewUserImplements();
                addNewUser.addNewUser();
            }
            System.out.println("Input your next choice 0 try again, 1 - exit");
            try {
                exit = in.nextInt();
            }
            catch (InputMismatchException exception){
                System.out.println("Incorrect input data" + exception.getMessage());
            }
        } while (exit == 0);

    }


}
