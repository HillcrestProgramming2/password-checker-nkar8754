package org.hillcrest.chapter6.password;

public class FeedbackGenerator {
    //utility class for generating feedback based on password
    public static String generateFeedback(String password) {
        CriteriaChecker.evaluateCriteria(password);

        if (!CriteriaChecker.isMeetsLength()) {
            return "Increase the length to at least 8 characters.";
        }
        if (!CriteriaChecker.isHasUpperCase()) {
            return "Add at least one uppercase letter.";
        }
        if (!CriteriaChecker.isHasLowerCase()) {
            return "Add at least one lowercase letter.";
        }
        if (!CriteriaChecker.isHasDigit()) {
            return "Add at least one number.";
        }
        if (!CriteriaChecker.isHasSpecialChar()) {
            return "Include at least one special characters.";
        }
        else {
            return "Password is valid.";
        }
    }
}
