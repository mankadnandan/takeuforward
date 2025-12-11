import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BraceExpansion {
    public static void main(String[] args) {

        String[] options = expand("{b,a}c{d,e}f");
        for (String str : options) {
            System.out.println(str);
        }
        System.out.println();

        options = expand("abcd");
        for (String str : options) {
            System.out.println(str);
        }
        System.out.println();

        options = expand("a{b,c}d");
        for (String str : options) {
            System.out.println(str);
        }
        System.out.println();

        options = expand("{x,f,r}hb");
        for (String str : options) {
            System.out.println(str);
        }
        System.out.println();
    }

    private static String[] expand(String s) {
        char[] charArr = s.toCharArray();
        List<List<Character>> groups = new ArrayList<>();
        List<Character> currList = new ArrayList<>();
        boolean isCurlyStart = false;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '}') {
                isCurlyStart = false;
                if (!currList.isEmpty()) {
                    groups.add(currList);
                    currList = new ArrayList<>();
                }
            } else if (charArr[i] == '{') {
                isCurlyStart = true;
                if (!currList.isEmpty()) {
                    groups.add(currList);
                    currList = new ArrayList<>();
                }
            } else if (charArr[i] == ',') {
                continue;
            } else {
                if (isCurlyStart) {
                    currList.add(charArr[i]);
                } else {
                    List<Character> grp = new ArrayList<>();
                    grp.add(charArr[i]);
                    groups.add(grp);
                }
            }
        }
        if (!currList.isEmpty()) {
            groups.add(currList);
        }
        for (List<Character> chList : groups) {
            Collections.sort(chList);
        }
        List<String> options = new ArrayList<>();
        backtrack(groups, 0, 0, new Stack<>(), options);

        String[] result = new String[options.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = options.get(i);
        }

        return result;
    }

    private static void backtrack(List<List<Character>> groups, int i, int j, Stack<Character> currWord,
            List<String> options) {
        if (i >= groups.size()) {
            return;
        }
        for (int k = 0; k < groups.get(i).size(); k++) {
            currWord.push(groups.get(i).get(k));
            if (i == groups.size() - 1) {
                StringBuilder sb = new StringBuilder();
                for (char c : currWord) {
                    sb.append(c);
                }
                options.add(sb.toString());
            }
            backtrack(groups, i + 1, k, currWord, options);
            currWord.pop();
        }
    }
}