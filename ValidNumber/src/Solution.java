/**
 * Created by xuyuanp on 5/28/14.
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        String reg = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if (s.trim().matches(reg)) {
            return true;
        }
        return false;
    }
}
