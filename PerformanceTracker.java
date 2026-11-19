import java.util.Scanner;

public class PerformanceTracker {

    public static void displayScores(int[] scores) {
        System.out.print("Scores: ");

        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static double getAverage(int[] scores) {
        int sum = 0;

        for (int s : scores) {
            sum += s;
        }

        return (double) sum / scores.length;
    }

    public static int getHighest(int[] scores) {
        int highest = scores[0];

        for (int s : scores) {
            if (s > highest) {
                highest = s;
            }
        }

        return highest;
    }

    public static int countPassed(int[] scores) {
        int passingMark = 60;
        int count = 0;

        for (int s : scores) {
            if (s >= passingMark) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] scores = new int[8];

        System.out.println("Enter 8 scores: ");

        for (int i = 0; i < scores.length; i++) {
            System.out.print("[" + (i + 1) + "] - ");
            scores[i] = input.nextInt();
        }

        displayScores(scores);

        System.out.printf("Average: %.2f%n", getAverage(scores));
        System.out.println("Highest Score: " + getHighest(scores));
        System.out.println("Passed: " + countPassed(scores));

        input.close();
    }
}