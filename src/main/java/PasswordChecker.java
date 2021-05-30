import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    /*
returns true, if password has not less than 8 and not more than 25 characters
 */
    public boolean checkLength(String password) {
        return password.matches("^.{8,25}$");
    }

    /*
    returns true, if both, upper case and lower case characters are present
     */
    public boolean checkSmallCapital(String password) {
        Pattern regexLC = Pattern.compile(".*[A-Z].*");
        Pattern regexUC = Pattern.compile(".*[a-z].*");
        boolean lc = regexLC.matcher(password).matches();
        boolean uc = regexUC.matcher(password).matches();
        return  lc && uc;
        // why does this not work? return password.matches("(?=.*[a-z])(?=.*[A-Z])");
    }

    /*
    true, if there at least one digit is present
     */
    public boolean checkDigits(String password) {
        return password.matches("[\\d]+");
    }

    /*
    true, if at least one of the required special chars is present
     */
    public boolean checkSpecialChars(String password) {
        Pattern regexSpecialC = Pattern.compile(".*[()#$?!%/@].*");
        return regexSpecialC.matcher(password).matches();
        //why does this not work? return password.matches("[()#$?!%/@]+");
    }

    /*
    true, if no other special chars than those allowed are present
    => requirement fulfilled
     */
    public boolean noOtherSpecialChars(String password) {
        boolean noOtherSpecialCharsPresent = false;
        int otherSpecials = 0;
        String[] splitPW = password.split("");

        for (String s: splitPW) {
            //add count, if special char is present
            if (s.matches("[\\W]")) {
                otherSpecials++;
                //remove last count, if special char matches allowed chars
                if (s.matches("[()#$?!%/@]")) {
                    otherSpecials--;
                }
            }
        }
        noOtherSpecialCharsPresent = otherSpecials == 0;
        return noOtherSpecialCharsPresent;
    }

/*
    public boolean checkNumberContinuation(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i).
        }
    }
*/
}