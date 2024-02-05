package y_lab.krylov.users;

import y_lab.krylov.database.DataBase;
import y_lab.krylov.database.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * add new user in our database*/
public class AddNewUserImplements implements AddNewUser{
    private Scanner in = new Scanner(System.in);
    @Override
    public void addNewUser(){
        System.out.println("Hello new user!!!!!");
        System.out.println("Input your data");
        String insertNewUser = "INSERT INTO users (login, password, name, age, city) values(?,?,?,?,?)";
        Connection connection = GetConnection.getConnection();
        try{
        PreparedStatement statement = connection.prepareStatement(insertNewUser);
        System.out.println("Input login");
        String login = in.next();
        statement.setString(1, login);
        System.out.println("Input password");
        String password = in.next();
        statement.setString(2, password);
        System.out.println("Input name");
        String name = in.next();
        statement.setString(3, name);
        System.out.println("Input age");
        int age = in.nextInt();
        statement.setInt(4, age);
        System.out.println("Input city");
        String city = in.next();
        statement.setString(5, city);
        statement.executeUpdate();}
        catch (SQLException exception){
            System.out.println("SQL got exception " + exception.getMessage());
        }
        catch (InputMismatchException exception){
            System.out.println("Incorrect input data" + exception.getMessage());
        }
    }
}
