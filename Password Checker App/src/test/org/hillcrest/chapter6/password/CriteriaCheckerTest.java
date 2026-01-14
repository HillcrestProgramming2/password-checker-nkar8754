package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CriteriaCheckerTest {

    @BeforeEach
    public void setUp() {
        CriteriaChecker.evaluateCriteria("");
    }

    // evaluateCriteria tests
    @Test
    public void testEvaluateCriteriaAllMet() {
        int score = CriteriaChecker.evaluateCriteria("Password123!");
        assertEquals(5, score);
    }

    @Test
    public void testEvaluateCriteriaNone() {
        int score = CriteriaChecker.evaluateCriteria("abc");
        assertEquals(0, score);
    }

    @Test
    public void testEvaluateCriteriaLength() {
        int score = CriteriaChecker.evaluateCriteria("abcdefgh");
        assertEquals(1, score);
    }

    @Test
    public void testEvaluateCriteriaLengthUppercase() {
        int score = CriteriaChecker.evaluateCriteria("Abcdefgh");
        assertEquals(2, score);
    }

    @Test
    public void testEvaluateCriteriaLengthDigit() {
        int score = CriteriaChecker.evaluateCriteria("abcdefg1");
        assertEquals(2, score);
    }

    @Test
    public void testEvaluateCriteriaLengthSpecial() {
        int score = CriteriaChecker.evaluateCriteria("abcdefgh!");
        assertEquals(2, score);
    }

    @Test
    public void testEvaluateCriteriaThreeCriteria() {
        int score = CriteriaChecker.evaluateCriteria("Abcdefg1");
        assertEquals(3, score);
    }

    @Test
    public void testEvaluateCriteriaFourCriteria() {
        int score = CriteriaChecker.evaluateCriteria("Abcdefgh1");
        assertEquals(4, score);
    }

    @Test
    public void testEvaluateCriteriaFiveCriteria() {
        int score = CriteriaChecker.evaluateCriteria("Abcdefgh1!");
        assertEquals(5, score);
    }

    // isMeetsLength tests
    @Test
    public void testMeetsLengthTrue() {
        CriteriaChecker.evaluateCriteria("12345678");
        assertTrue(CriteriaChecker.isMeetsLength());
    }

    @Test
    public void testMeetsLengthFalse() {
        CriteriaChecker.evaluateCriteria("1234567");
        assertFalse(CriteriaChecker.isMeetsLength());
    }

    // isHasUpperCase tests
    @Test
    public void testHasUpperCaseTrue() {
        CriteriaChecker.evaluateCriteria("Abc");
        assertTrue(CriteriaChecker.isHasUpperCase());
    }

    @Test
    public void testHasUpperCaseFalse() {
        CriteriaChecker.evaluateCriteria("abc");
        assertFalse(CriteriaChecker.isHasUpperCase());
    }

    // isHasLowerCase tests
    @Test
    public void testHasLowerCaseTrue() {
        CriteriaChecker.evaluateCriteria("aBc");
        assertTrue(CriteriaChecker.isHasLowerCase());
    }

    @Test
    public void testHasLowerCaseFalse() {
        CriteriaChecker.evaluateCriteria("ABC");
        assertFalse(CriteriaChecker.isHasLowerCase());
    }

    // isHasDigit tests
    @Test
    public void testHasDigitTrue() {
        CriteriaChecker.evaluateCriteria("abc1");
        assertTrue(CriteriaChecker.isHasDigit());
    }

    @Test
    public void testHasDigitFalse() {
        CriteriaChecker.evaluateCriteria("abcdef");
        assertFalse(CriteriaChecker.isHasDigit());
    }

    // isHasSpecialChar tests
    @Test
    public void testHasSpecialCharTrue() {
        CriteriaChecker.evaluateCriteria("abc!");
        assertTrue(CriteriaChecker.isHasSpecialChar());
    }

    @Test
    public void testHasSpecialCharFalse() {
        CriteriaChecker.evaluateCriteria("abcdef");
        assertFalse(CriteriaChecker.isHasSpecialChar());
    }

    @Test
    public void testHasSpecialCharAllTypes() {
        CriteriaChecker.evaluateCriteria("!@#$%^&*()-+=");
        assertTrue(CriteriaChecker.isHasSpecialChar());
    }

    // determineStrength tests
    @Test
    public void testDetermineStrengthWeak0() {
        assertEquals("Weak", CriteriaChecker.determineStrength(0));
    }

    @Test
    public void testDetermineStrengthWeak1() {
        assertEquals("Weak", CriteriaChecker.determineStrength(1));
    }

    @Test
    public void testDetermineStrengthWeak2() {
        assertEquals("Weak", CriteriaChecker.determineStrength(2));
    }

    @Test
    public void testDetermineStrengthModerate3() {
        assertEquals("Moderate", CriteriaChecker.determineStrength(3));
    }

    @Test
    public void testDetermineStrengthStrong4() {
        assertEquals("Strong", CriteriaChecker.determineStrength(4));
    }

    @Test
    public void testDetermineStrengthStrong5() {
        assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }

    @Test
    public void testDetermineStrengthInvalid() {
        assertEquals("Invalid Score", CriteriaChecker.determineStrength(6));
    }
}
