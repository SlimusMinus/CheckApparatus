package y_lab.krylov.startApp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * start this App*/
public class StartUp {
    static int choice = 0;
    public static int getChoice(){
        Scanner in = new Scanner(System.in);
        System.out.println("Hello dear user");
        System.out.println("Input 1 if you are want authorization, 2 if you are want authentication");

        try{
            choice = in.nextInt();
        }
        catch (InputMismatchException exception){
            exception.getMessage();
        }
        return choice;
    }
}
