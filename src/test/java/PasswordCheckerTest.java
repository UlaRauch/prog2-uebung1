import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {

    @Test
    @DisplayName("Are all requirements checked")
    public void testValidPW() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.isValid("P4$$w0rd"));
    }

    @Test
    @DisplayName("Are all requirements checked")
    public void testNotValidPW() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.isValid("password=_"));
    }

    @Test
    @DisplayName("Is password length valid")
    public void testPasswordLengthOK() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkLength("Pw1234567?!"));
    }

    @Test
    @DisplayName("Is password too short")
    public void testPasswordTooShort() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkLength("1234567"));
    }

    @Test
    @DisplayName("Is password too long")
    public void testPasswordTooLong() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkLength("12345678901234567890123456"));
    }

    @Test
    @DisplayName("Does password contain lower case characters")
    public void testPasswordLowerCase() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkLowerCase("password"));
    }

    @Test
    @DisplayName("Does password contain no lower case characters")
    public void testPasswordNoLowerCase() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkLowerCase("P455W0RD"));
    }

    @Test
    @DisplayName("Does password contain upper case characters")
    public void testPasswordUpperCase() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkUpperCase("Password"));
    }

    @Test
    @DisplayName("Does password contain no upper case characters")
    public void testPasswordNoUpperCase() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkUpperCase("p455word"));
    }


    @Test
    @DisplayName("Does password contain numbers")
    public void testPasswordNumbers() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkDigits("Pw1234567?!"));
    }

    @Test
    @DisplayName("Does password contain no numbers")
    public void testPasswordNoNumbers() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkDigits("Password"));
    }

    @Test
    @DisplayName("Does password contain special characters")
    public void testPasswordSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkSpecialChars("P4$$w0rd"));
    }

    @Test
    @DisplayName("Does password contain no special characters")
    public void testPasswordNoSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkSpecialChars("Password"));
    }

    @Test
    @DisplayName("Does not contain any other special characters")
    public void testPasswordOtherSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.noOtherSpecialChars("Pw=123567?&!"));
    }

    @Test
    @DisplayName("Does not contain no other special characters")
    public void testPasswordNoOtherSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.noOtherSpecialChars("P4$$w0rd"));
    }

    @Test
    @DisplayName("more than two continuing numbers")
    public void testNumberContinuation() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkNumberContinuation("123Password?"));
    }

    @Test
    @DisplayName("max two continuing numbers")
    public void testNoNumberContinuation() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkNumberContinuation("245Password?"));
    }

    @Test
    @DisplayName("max 3 occurences of same digit in a row")
    public void test3samedigitsmax() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.check3sameNumbersMax("P444555w0rd?4"));
    }

    @Test
    @DisplayName("more than 3 occurences of same digit in a row")
    public void testOver3samedigitsmax() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.check3sameNumbersMax("P4444ssword"));
    }
}
