import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyuanp on 5/27/14.
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 0;

        for (int i = 0; i < points.length - 1; i++) {
            map.clear();
            map.put((double)Integer.MIN_VALUE, 1);
            int repeat = 0;
            for (int j = i + 1; j < points.length; j++) {
                double k = 0.0;
                if (points[j].x == points[i].x) {
                    if (points[j].y == points[i].y) {
                        repeat++;
                        continue;
                    } else {
                        k = Integer.MAX_VALUE;
                    }
                } else {
                    k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                }

                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
            }

            for (int count : map.values()) {
                if (count + repeat > max) {
                    max = count + repeat;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(0, 0),
                new Point(-1, -1),
                new Point(2, 2)
        };
        System.out.println(new Solution().maxPoints(points));
    }
}
