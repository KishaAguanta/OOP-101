import java.util.Scanner;
import java.util.InputMismatchException;

class InvalidBorrowingHoursException extends Exception {
    public InvalidBorrowingHoursException(String message) {
        super(message);
    }
}

public class EquipmentChecker {

    public static String getEquipmentName(int code) {
        switch (code) {
            case 101:
                return "Camera";
            case 102:
                return "Tripod";
            case 103:
                return "Microphone";
            case 104:
                return "Projector";
            default:
                throw new IllegalArgumentException("Invalid equipment code.");
        }
    }

    public static void validateHours(int hours) throws InvalidBorrowingHoursException {
        if (hours >= 1 && hours <= 8) {
            System.out.println("Borrowing hours: " + hours);
        } else {
            throw new InvalidBorrowingHoursException("Invalid hours.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter equipment code: ");
            int code = input.nextInt();

            System.out.print("Enter borrowing hours: ");
            int hours = input.nextInt();

            String equi = getEquipmentName(code);
            System.out.println("Equipment: " + equi);

            validateHours(hours);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid equipment code.");
        } catch (InvalidBorrowingHoursException e) {
            System.out.println("Error: Borrowing hours must be between 1 and 8.");
        }

        input.close();
    }
}