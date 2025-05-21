import java.util.Scanner;

public class PrintLastCharacterOfString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char lastChar = lastChar(in.nextLine());
        System.out.println(lastChar);
    }

    public static char lastChar(String s) {
        return s.charAt(s.length() - 1);
    }
}
