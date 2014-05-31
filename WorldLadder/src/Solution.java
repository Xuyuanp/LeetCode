import java.util.*;

/**
 * Created by xuyuanp on 5/31/14.
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0)
            return 0;
        dict.add(end);

        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> length = new LinkedList<Integer>();

        queue.add(start);
        length.add(1);

        int result = 0;

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int len = length.poll();

            if (end.equals(word)) {
                if (result == 0 || len < result)
                    result = len;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == chars[i])
                        continue;

                    chars[i] = c;
                    String tmp = String.valueOf(chars);
                    if (dict.contains(tmp)) {
                        queue.add(tmp);
                        length.add(len + 1);
                        dict.remove(tmp);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(new Solution().ladderLength("hit", "cog", dict));
    }
}
