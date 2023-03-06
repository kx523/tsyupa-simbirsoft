package homework02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 0 до 127:");
        byte num = scanner.nextByte();
        byte n7, n6, n5, n4, n3, n2, n1;
        n1 = (byte) (num % 2);
        num /= 2;
        n2 = (byte) (num % 2);
        num /= 2;
        n3 = (byte) (num % 2);
        num /= 2;
        n4 = (byte) (num % 2);
        num /= 2;
        n5 = (byte) (num % 2);
        num /= 2;
        n6 = (byte) (num % 2);
        num /= 2;
        n7 = (byte) (num % 2);
        System.out.println("0" + n7 + n6 + n5 + n4 + n3 + n2 + n1);
    }
}
