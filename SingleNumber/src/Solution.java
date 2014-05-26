import java.util.Arrays;

/**
 * Created by xuyuanp on 5/26/14.
 */
public class Solution {
    public int singleNumber(int[] A) {
        Arrays.sort(A);
        int i = 0;
        while (i < A.length - 1) {
            if (A[i + 1] != A[i]) {
                return A[i];
            }
            i = i + 2;
        }
        return A[A.length - 1];
    }
}
