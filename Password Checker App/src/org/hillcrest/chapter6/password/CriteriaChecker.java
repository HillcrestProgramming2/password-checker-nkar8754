package org.hillcrest.chapter6.password;

/**
 * Utility class that evaluates password strength based on multiple criteria.
 * Checks for minimum length, uppercase/lowercase letters, digits, and special characters.
 */
public class CriteriaChecker {
    private static boolean meetsLength;
    private static boolean hasUpperCase;
    private static boolean hasLowerCase;
    private static boolean hasDigit;
    private static boolean hasSpecialChar;

    /**
     * Evaluates a password against all criteria and counts how many criteria are met.
     * The results of each individual check are stored in static variables for later retrieval.
     * @param password the password string to evaluate
     * @return the number of criteria met (0-5), where higher values indicate stronger passwords
     */
    public static int evaluateCriteria(String password) {
        int criteriaCounter = 0;
        meetsLength = false;
        hasUpperCase = false;
        hasLowerCase = false;
        hasDigit = false;
        String validSpecialChar = "!@#$%^&*()-+=";
        hasSpecialChar = false;

        if (password.length() >= 8) {
            meetsLength = true;
            criteriaCounter++;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
        }

        if (hasUpperCase) {
            criteriaCounter++;
        }

        if (hasLowerCase) {
            criteriaCounter++;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (hasDigit) {
            criteriaCounter++;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            for (int j = 0; j < validSpecialChar.length(); j++) {
                char ch2 = validSpecialChar.charAt(j);
                if (ch == ch2) {
                    hasSpecialChar = true;
                    break;
                }
            }
        }

        if (hasSpecialChar) {
            criteriaCounter++;
        }

        return criteriaCounter;
    }

    /**
     * Determines the overall strength level of a password based on the criteria score.
     * Strength levels: 0-2 = "Weak", 3 = "Moderate", 4-5 = "Strong"
     *
     * @param score the number of criteria met (typically 0-5)
     * @return a string describing the password strength
     */
    public static String determineStrength(int score) {
        return switch (score) {
            case 0, 1, 2 -> "Weak";
            case 3 -> "Moderate";
            case 4, 5 -> "Strong";
            default -> "Invalid Score";
        };
    }

    /**
     * Checks whether the password meets the minimum length requirement.
     *
     * @return true if the password has at least 8 characters; false otherwise
     */
    public static boolean isMeetsLength() {
        return meetsLength;
    }

    /**
     * Checks whether the password contains at least one uppercase letter.
     *
     * @return true if the password contains an uppercase letter; false otherwise
     */
    public static boolean isHasUpperCase() {
        return hasUpperCase;
    }

    /**
     * Checks whether the password contains at least one lowercase letter.
     *
     * @return true if the password contains a lowercase letter; false otherwise
     */
    public static boolean isHasLowerCase() {
        return hasLowerCase;
    }

    /**
     * Checks whether the password contains at least one digit.
     *
     * @return true if the password contains a digit (0-9); false otherwise
     */
    public static boolean isHasDigit() {
        return hasDigit;
    }

    /**
     * Checks whether the password contains at least one special character.
     * Valid special characters are: !@#$%^&*()-+=
     *
     * @return true if the password contains a special character; false otherwise
     */
    public static boolean isHasSpecialChar() {
        return hasSpecialChar;
    }
}
