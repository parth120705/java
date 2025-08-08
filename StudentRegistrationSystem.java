import java.util.Scanner;
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private String email;

    public Student(String name, String email) throws InvalidEmailException {
        if (!email.endsWith("@chitkara.edu.in")) {
            throw new InvalidEmailException("Invalid email: must end with @university.edu");
        }
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println("Registration successful!");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter institutional email: ");
        String email = scanner.nextLine();

        try {
            Student student = new Student(name, email);
            student.display();
        } catch (InvalidEmailException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }

        scanner.close();
    }
}
