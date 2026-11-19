import java.util.Scanner;

public class PellNumber{

    public static int getPell(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return 2 * getPell(n - 1) + getPell(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = input.nextInt();

        if (n >= 0) {
            int pel = getPell(n);
            System.out.println("Pell number at position " + n + ": " + pel);
        } else {
            System.out.println("Invalid: n must be a non-negative number!");
        }

        input.close();
    }
}