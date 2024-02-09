package y_lab.krylov.login_to_app;

import y_lab.krylov.database.GetConnection;
import y_lab.krylov.users.GetAllUsers;
import y_lab.krylov.users.GetAllUsersImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * check authorization user*/
public class AuthorizationImplements implements Authorization {

    /**
     * login - login user */
    private String login;
    /**
     * password - login password */
    private String password;
    /**
     * user id from database*/
    private static int user_id;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getUser_id() {
        return user_id;
    }

    private Scanner in = new Scanner(System.in);
    private GetAllUsers getAllUsers = new GetAllUsersImplements();

    @Override
    public void input_data() {
        System.out.println("Input login");
        login = in.next();
        System.out.println("Input password");
        password = in.next();
    }

    @Override
    public boolean IsAuthorization() {

        try {
            ResultSet resultSet = getAllUsers.getAllUsers();
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login) && resultSet.getString("password").equals(password)) {
                    System.out.println("Welcome in app " + resultSet.getString("name"));
                    user_id = resultSet.getInt("id");
                    return true;
                }
            }
        } catch (SQLException exception) {
            exception.getMessage();
        }
        System.out.println("Data is incorrect");
        return false;
    }

}
