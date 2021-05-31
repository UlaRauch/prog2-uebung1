import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

    //true, if all requirements are fulfilled
    public boolean isValid(String pw) {
        return checkLength(pw)
                && checkLowerCase(pw)
                && checkUpperCase(pw)
                && checkDigits(pw)
                && checkSpecialChars(pw)
                && noOtherSpecialChars(pw)
                && checkNumberContinuation(pw)
                && check3sameNumbersMax(pw);
    }

    //true, if password has not less than 8 and not more than 25 characters
    public boolean checkLength(String password) {
        return password.matches("^.{8,25}$");
    }

    //true, if lower case is present
    public boolean checkLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    //true, if upper case is present
    public boolean checkUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    //true, if at least two digits are present (Zahlen im Plural)
    public boolean checkDigits(String password) {
        return password.matches(".*\\d.*");
    }

    //true, if at least one of the required special chars is present
    public boolean checkSpecialChars(String password) {
        return password.matches(".*[()#$?!%/@].*");
        //why does this not work? return password.matches("[()#$?!%/@]+");
    }

    //true, if no other special chars than those allowed are present
    public boolean noOtherSpecialChars(String password) {
        boolean noOtherSpecialCharsPresent = false;
        int otherSpecials = 0;
        String[] splitPW = password.split("");

        for (String s : splitPW) {
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

    //false, if more than two consecutive numbers differ in +1
    public boolean checkNumberContinuation(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (String.valueOf(password.charAt(i)).matches("[0-9]")) {
                if ((password.charAt(i) + 1 == password.charAt(i + 1))
                        && (password.charAt(i) + 2 == password.charAt(i + 2))) {
                    return false;
                }
            }
        }
        return true;
    }

    //false, if more than three digits in a row are the same
    public boolean check3sameNumbersMax(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (String.valueOf(password.charAt(i)).matches("\\d")) {
                for (int j = i; j < i+4; j++) {
                    if (password.charAt(j) != password.charAt(j + 1)) {
                        break;
                    } else if (j-i == 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
    Garage (not currently in use)
    /*
     /*
    returns true, if both, upper case and lower case characters are present
     */
    /*
    public boolean checkSmallCapital(String password) {
        Pattern regexLC = Pattern.compile(".*[A-Z].*");
        Pattern regexUC = Pattern.compile(".*[a-z].*");
        boolean lc = regexLC.matcher(password).matches();
        boolean uc = regexUC.matcher(password).matches();
        return  lc && uc;
        // why does this not work? return password.matches("(?=.*[a-z])(?=.*[A-Z])");
    }
    */

}
