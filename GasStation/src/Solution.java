import javax.swing.table.TableModel;

/**
 * Created by xuyuanp on 5/31/14.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        for (int start = 0; start < gas.length; start++) {
            int sum = 0;
            int i = start;
            do {
                sum += gas[i];
                sum -= cost[i];
                if (sum >= 0) {
                    i++;
                    if (i == gas.length) {
                        i = 0;
                    }
                } else {
                    i = -1;
                    break;
                }
            } while (i != start);

            if (i == start) {
                return start;
            }
        }
        return -1;
    }
}
