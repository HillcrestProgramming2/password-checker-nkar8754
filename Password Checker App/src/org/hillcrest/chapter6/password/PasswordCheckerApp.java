package org.hillcrest.chapter6.password;
import java.util.Scanner;

/**
 * App Class that runs the main program
 */
public class PasswordCheckerApp {
    //main method goes here
    //prompt user for password
    //Check strength
    //Provide user feedback based on the strength
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the password: ");

        String password = input.nextLine();

        int criteria = CriteriaChecker.evaluateCriteria(password);
        String strength = CriteriaChecker.determineStrength(criteria);
        String feedback = FeedbackGenerator.generateFeedback(password);

        System.out.println("Password Strength: " + strength);
        System.out.println(feedback);

    }
}
