import java.util.Scanner;

public class PrintXNNumberOfTimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printX(in.nextInt(), in.nextInt());
    }

    public static void printX(int X, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(X + " ");
        }
        System.out.println(sb.toString().trim());
    }
}