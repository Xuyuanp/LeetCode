import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xuyuanp on 5/26/14.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            int v = numbers[i];
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<Integer>());
            }
            map.get(v).add(i + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            int one = numbers[i];
            int two = target - one;
            if (map.containsKey(two)) {
                ArrayList<Integer> list = map.get(two);
                if (one == two) {
                    if (list.size() >= 2) {
                        res[0] = list.get(0);
                        res[1] = list.get(1);
                        return res;
                    }
                } else {
                    res[0] = i + 1;
                    res[1] = list.get(0);
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
