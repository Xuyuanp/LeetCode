#! /usr/bin/env python

class Solution:
    # @param n, an integer
    # @return aan integer
    def climbStairs(self, n):
        if n < 3:
            return n
        steps = [0 for i in range(n + 1)]
        steps[1] = 1
        steps[2] = 2
        i = 3
        while i <= n:
            steps[i] = steps[i - 1] + steps[i - 2]
            i += 1
        return steps[n]

if __name__ == "__main__":
    print Solution().climbStairs(0)
    print Solution().climbStairs(1)
    print Solution().climbStairs(2)
    print Solution().climbStairs(3)
    print Solution().climbStairs(4)
    print Solution().climbStairs(5)
    print Solution().climbStairs(6)
    print Solution().climbStairs(7)
    print Solution().climbStairs(8)
    print Solution().climbStairs(9)
