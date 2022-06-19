import java.sql.SQLOutput;
import java.util.Scanner;

public class E02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number > max) {
                max = number;
            }
        }

//        System.out.println(Integer.MIN_VALUE); -2147483648
//        System.out.println(Integer.MAX_VALUE);  2147483648

        int lastSum = sum - max;
        int diff = Math.abs(lastSum - max);
        if (lastSum == max) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", lastSum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d",diff);
        }
    }
}
