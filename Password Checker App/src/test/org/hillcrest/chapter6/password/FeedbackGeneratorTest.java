package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for FeedbackGenerator utility class.
 * Tests password feedback generation based on which criteria are not met.
 */
class FeedbackGeneratorTest {

    @BeforeEach
    void setUp() {
        // Reset static variables before each test
        CriteriaChecker.evaluateCriteria("");
    }

    // Tests for generateFeedback method
    @Test
    void testGenerateFeedbackShortPassword() {
        String feedback = FeedbackGenerator.generateFeedback("abc");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }

    @Test
    void testGenerateFeedbackNoUppercase() {
        String feedback = FeedbackGenerator.generateFeedback("abcdefgh");
        assertEquals("Add at least one uppercase letter.", feedback);
    }

    @Test
    void testGenerateFeedbackNoLowercase() {
        String feedback = FeedbackGenerator.generateFeedback("ABCDEFGH");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }

    @Test
    void testGenerateFeedbackLengthAndLowercaseButNoUppercase() {
        String feedback = FeedbackGenerator.generateFeedback("abcdefgh");
        assertEquals("Add at least one uppercase letter.", feedback);
    }

    @Test
    void testGenerateFeedbackLengthAndUppercaseButNoLowercase() {
        String feedback = FeedbackGenerator.generateFeedback("ABCDEFGH");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }

    @Test
    void testGenerateFeedbackNoDigit() {
        String feedback = FeedbackGenerator.generateFeedback("Abcdefgh");
        assertEquals("Add at least one number.", feedback);
    }

    @Test
    void testGenerateFeedbackNoSpecialChar() {
        String feedback = FeedbackGenerator.generateFeedback("Abcdefgh1");
        assertEquals("Include at least one special character.", feedback);
    }

    @Test
    void testGenerateFeedbackValidPassword() {
        String feedback = FeedbackGenerator.generateFeedback("Password123!");
        assertEquals("Password is valid.", feedback);
    }

    @Test
    void testGenerateFeedbackValidPasswordDifferent() {
        String feedback = FeedbackGenerator.generateFeedback("MyP@ssw0rd");
        assertEquals("Password is valid.", feedback);
    }

    @Test
    void testGenerateFeedbackValidPasswordWithMultipleSpecialChars() {
        String feedback = FeedbackGenerator.generateFeedback("Test@1234#");
        assertEquals("Password is valid.", feedback);
    }

    @Test
    void testGenerateFeedbackShortPasswordPriority() {
        String feedback = FeedbackGenerator.generateFeedback("Abc1!");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }

    @Test
    void testGenerateFeedbackLengthMetButNoUppercase() {
        String feedback = FeedbackGenerator.generateFeedback("password123!");
        assertEquals("Add at least one uppercase letter.", feedback);
    }

    @Test
    void testGenerateFeedbackLengthAndUppercaseMetButNoLowercase() {
        String feedback = FeedbackGenerator.generateFeedback("PASSWORD1234!");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }
}
