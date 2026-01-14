package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CriteriaChecker utility class.
 * Tests password evaluation against various criteria including length, uppercase,
 * lowercase, digits, and special characters.
 */
class CriteriaCheckerTest {

    @BeforeEach
    void setUp() {
        // Reset static variables before each test
        CriteriaChecker.evaluateCriteria("");
    }

    // Tests for evaluateCriteria method
    @Test
    void testEvaluateCriteriaAllMet() {
        int score = CriteriaChecker.evaluateCriteria("Password123!");
        Assertions.assertEquals(5, score);
    }

    @Test
    void testEvaluateCriteriaNoRequirementsMet() {
        int score = CriteriaChecker.evaluateCriteria("abc");
        Assertions.assertEquals(0, score);
    }

    @Test
    void testEvaluateCriteriaOnlyLength() {
        int score = CriteriaChecker.evaluateCriteria("abcdefgh");
        Assertions.assertEquals(1, score);
    }

    @Test
    void testEvaluateCriteriaLengthAndUppercase() {
        int score = CriteriaChecker.evaluateCriteria("Abcdefgh");
        Assertions.assertEquals(2, score);
    }

    @Test
    void testEvaluateCriteriaLengthAndLowercase() {
        int score = CriteriaChecker.evaluateCriteria("ABCDEFGH");
        Assertions.assertEquals(1, score);
    }

    @Test
    void testEvaluateCriteriaLengthAndDigit() {
        int score = CriteriaChecker.evaluateCriteria("abcdefg1");
        Assertions.assertEquals(2, score);
    }

    @Test
    void testEvaluateCriteriaWithSpecialChar() {
        int score = CriteriaChecker.evaluateCriteria("abcdefgh!");
        Assertions.assertEquals(2, score);
    }

    @Test
    void testEvaluateCriteriaFourRequirementsMet() {
        int score = CriteriaChecker.evaluateCriteria("Abcdefgh1");
        Assertions.assertEquals(4, score);
    }

    // Tests for isMeetsLength method
    @Test
    void testMeetsLengthTrue() {
        CriteriaChecker.evaluateCriteria("12345678");
        assertTrue(CriteriaChecker.isMeetsLength());
    }

    @Test
    void testMeetsLengthFalseShorterThan8() {
        CriteriaChecker.evaluateCriteria("1234567");
        assertFalse(CriteriaChecker.isMeetsLength());
    }

    @Test
    void testMeetsLengthExactly8() {
        CriteriaChecker.evaluateCriteria("12345678");
        assertTrue(CriteriaChecker.isMeetsLength());
    }

    // Tests for isHasUpperCase method
    @Test
    void testHasUpperCaseTrue() {
        CriteriaChecker.evaluateCriteria("Abc");
        assertTrue(CriteriaChecker.isHasUpperCase());
    }

    @Test
    void testHasUpperCaseFalse() {
        CriteriaChecker.evaluateCriteria("abc");
        assertFalse(CriteriaChecker.isHasUpperCase());
    }

    @Test
    void testHasUpperCaseMultiple() {
        CriteriaChecker.evaluateCriteria("ABCdef");
        assertTrue(CriteriaChecker.isHasUpperCase());
    }

    // Tests for isHasLowerCase method
    @Test
    void testHasLowerCaseTrue() {
        CriteriaChecker.evaluateCriteria("aBc");
        assertTrue(CriteriaChecker.isHasLowerCase());
    }

    @Test
    void testHasLowerCaseFalse() {
        CriteriaChecker.evaluateCriteria("ABC");
        assertFalse(CriteriaChecker.isHasLowerCase());
    }

    @Test
    void testHasLowerCaseMultiple() {
        CriteriaChecker.evaluateCriteria("ABCdef");
        assertTrue(CriteriaChecker.isHasLowerCase());
    }

    // Tests for isHasDigit method
    @Test
    void testHasDigitTrue() {
        CriteriaChecker.evaluateCriteria("abc1");
        assertTrue(CriteriaChecker.isHasDigit());
    }

    @Test
    void testHasDigitFalse() {
        CriteriaChecker.evaluateCriteria("abcdef");
        assertFalse(CriteriaChecker.isHasDigit());
    }

    @Test
    void testHasDigitMultiple() {
        CriteriaChecker.evaluateCriteria("a1b2c3");
        assertTrue(CriteriaChecker.isHasDigit());
    }

    // Tests for isHasSpecialChar method
    @Test
    void testHasSpecialCharTrue() {
        CriteriaChecker.evaluateCriteria("abc!");
        assertTrue(CriteriaChecker.isHasSpecialChar());
    }

    @Test
    void testHasSpecialCharFalse() {
        CriteriaChecker.evaluateCriteria("abcdef");
        assertFalse(CriteriaChecker.isHasSpecialChar());
    }

    @Test
    void testHasSpecialCharMultiple() {
        CriteriaChecker.evaluateCriteria("a!b@c#");
        assertTrue(CriteriaChecker.isHasSpecialChar());
    }

    @Test
    void testHasSpecialCharAllValidChars() {
        CriteriaChecker.evaluateCriteria("!@#$%^&*()-+=");
        assertTrue(CriteriaChecker.isHasSpecialChar());
    }

    // Tests for determineStrength method
    @Test
    void testDetermineStrengthWeak0() {
        String strength = CriteriaChecker.determineStrength(0);
        Assertions.assertEquals("Weak", strength);
    }

    @Test
    void testDetermineStrengthWeak1() {
        String strength = CriteriaChecker.determineStrength(1);
        Assertions.assertEquals("Weak", strength);
    }

    @Test
    void testDetermineStrengthWeak2() {
        String strength = CriteriaChecker.determineStrength(2);
        Assertions.assertEquals("Weak", strength);
    }

    @Test
    void testDetermineStrengthModerate() {
        String strength = CriteriaChecker.determineStrength(3);
        Assertions.assertEquals("Moderate", strength);
    }

    @Test
    void testDetermineStrengthStrong4() {
        String strength = CriteriaChecker.determineStrength(4);
        Assertions.assertEquals("Strong", strength);
    }

    @Test
    void testDetermineStrengthStrong5() {
        String strength = CriteriaChecker.determineStrength(5);
        Assertions.assertEquals("Strong", strength);
    }

    @Test
    void testDetermineStrengthInvalid() {
        String strength = CriteriaChecker.determineStrength(6);
        Assertions.assertEquals("Invalid Score", strength);
    }
}
