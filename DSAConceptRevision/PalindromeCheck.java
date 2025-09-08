public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(palindromeCheck("hannah"));
        System.out.println(palindromeCheck("aabbaaa"));
        System.out.println(palindromeCheck("aabbccbbaa"));
    }

    private static boolean palindromeCheck(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
