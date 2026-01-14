package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackGeneratorTest {

    @BeforeEach
    public void setUp() {
        CriteriaChecker.evaluateCriteria("");
    }

    @Test
    public void testGenerateFeedbackEmpty() {
        String feedback = FeedbackGenerator.generateFeedback("");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }

    @Test
    public void testGenerateFeedbackShort() {
        String feedback = FeedbackGenerator.generateFeedback("short");
        assertEquals("Increase the length to at least 8 characters.", feedback);
    }

    @Test
    public void testGenerateFeedbackNoUppercase() {
        String feedback = FeedbackGenerator.generateFeedback("abcdefgh");
        assertEquals("Add at least one uppercase letter.", feedback);
    }

    @Test
    public void testGenerateFeedbackNoLowercase() {
        String feedback = FeedbackGenerator.generateFeedback("ABCDEFGH");
        assertEquals("Add at least one lowercase letter.", feedback);
    }

    @Test
    public void testGenerateFeedbackNoDigit() {
        String feedback = FeedbackGenerator.generateFeedback("Abcdefgh");
        assertEquals("Add at least one number.", feedback);
    }

    @Test
    public void testGenerateFeedbackNoSpecialChar() {
        String feedback = FeedbackGenerator.generateFeedback("Abcdefgh1");
        assertEquals("Include at least one special character.", feedback);
    }

    @Test
    public void testGenerateFeedbackValid1() {
        String feedback = FeedbackGenerator.generateFeedback("Password123!");
        assertEquals("Password is valid.", feedback);
    }

    @Test
    public void testGenerateFeedbackValid2() {
        String feedback = FeedbackGenerator.generateFeedback("MyP@ssw0rd");
        assertEquals("Password is valid.", feedback);
    }

    @Test
    public void testGenerateFeedbackValid3() {
        String feedback = FeedbackGenerator.generateFeedback("Secure!Pass99");
        assertEquals("Password is valid.", feedback);
    }

    @Test
    public void testGenerateFeedbackValidAll() {
        String feedback = FeedbackGenerator.generateFeedback("Test1@Abc");
        assertEquals("Password is valid.", feedback);
    }
}
