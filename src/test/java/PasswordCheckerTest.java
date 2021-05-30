import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {
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
        assertTrue(password.checkSpecialChars("Pw12345?!"));
        assertFalse(password.checkSpecialChars("Password=&"));
    }

    @Test
    @DisplayName("Does not contain any other special characters")
    public void testPasswordOtherSpecialChars() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.noOtherSpecialChars("Pw=123567?&!"));
        assertTrue(password.noOtherSpecialChars("Pw123456?"));
    }
/*
    @Test
    @DisplayName("max two numbers in continuation")
    public void testNumberContinuation() {
        PasswordChecker password = new PasswordChecker();
        assertFalse(password.checkNumberContinuation("123Password?"));
        assertTrue(password.checkNumberContinuation("45Password?"));
    }
*/

}
