import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printNumber(sc);
    }

    public static void printNumber(Scanner sc) {
        System.out.print(sc.nextInt());
    }
}