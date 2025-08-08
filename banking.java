import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    } 
}

public class banking {

    public static void validatePassword(String password) throws WeakPasswordException {
        String regex = "^(?=.*\\d)(?=.*[!@#$%^&])[A-Za-z\\d!@#$%^&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new WeakPasswordException("Password is weak");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Set password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
            System.out.println("Strong password set successfully.");
        } catch (WeakPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
