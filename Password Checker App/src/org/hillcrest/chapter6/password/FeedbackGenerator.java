package org.hillcrest.chapter6.password;

/**
 * Utility class that generates password feedback based on evaluation criteria.
 */
public class FeedbackGenerator {

    /**
     * Generates feedback for a password based on which criteria it fails to meet.
     * @param password the password string to generate feedback for
     * @return a feedback message describing what needs to be improved, or "Password is valid." if all criteria are met
     */
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
            return "Include at least one special character.";
        }

        return "Password is valid.";
    }
}
