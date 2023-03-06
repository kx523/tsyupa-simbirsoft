package homework03;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int current = 0;
        int previous = 0;
        int next = 0;
        int count = 0;

        while (next != -1) {
            if (previous == 0) {
                previous = scanner.nextInt();
            }
            if (current == 0) {
                current = scanner.nextInt();
            }
            if (next == 0) {
                next = scanner.nextInt();
            }
            if (current < previous && current < next) {
                count++;
            }
            previous = current;
            current = next;
            next = scanner.nextInt();
        }
        System.out.println(count);
    }
}
