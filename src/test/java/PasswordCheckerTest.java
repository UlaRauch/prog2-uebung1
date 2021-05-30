import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {

    @Test
    @DisplayName("Does password fulfill ALL requirements")
    public void testValidPW() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.isValid("P4$$w0rd"));
        assertFalse(password.isValid("password="));
    }

    @Test
    @DisplayName("Is password length valid")
    public void testPasswordLength() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkLength("Pw1234567?!"));
        assertFalse(password.checkLength("1234567"));
        assertFalse(password.checkLength("12345678901234567890123456"));
    }

    @Test
    @DisplayName("Does password contain both small and capital letters")
    public void testPasswordCase() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkSmallCapital("Pw1234567?!"));
    }

    @Test
    @DisplayName("Does password contain numbers")
    public void testPasswordNumbers() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkDigits("Pw1234567?!"));
        assertFalse(password.checkDigits("Password"));
    }

    @Test
    @DisplayName("Does password contain special characters")
    public void testPasswordSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertTrue(password.checkSpecialChars("P4$$w0rd"));
        assertFalse(password.checkSpecialChars("Password=&"));
    }

    @Test
    @DisplayName("Does not contain any other special characters")
    public void testPasswordOtherSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.noOtherSpecialChars("Pw=123567?&!"));
        assertTrue(password.noOtherSpecialChars("P4$$w0rd"));
    }

    @Test
    @DisplayName("max two continuing numbers")
    public void testNumberContinuation() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkNumberContinuation("123Password?"));
        assertTrue(password.checkNumberContinuation("245Password?"));
    }
/*
    @Test
    @DisplayName("max 3 occurences of same digit in a row")
    public void test3samedigitsmax() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.check3sameDigits("P4444ssword"));
        assertTrue(password.ch);
    }
*/
}
