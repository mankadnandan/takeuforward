import java.util.Scanner;

public class IfElseAdultTeen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        isAdult(sc.nextInt());
    }

    public static void isAdult(int age) {
        if (age >= 18) {
            System.out.print("Adult");
        } else {
            System.out.print("Teen");
        }
    }
}