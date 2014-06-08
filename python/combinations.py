#! /usr/bin/env python

class Solution:
    # @return a list of lists of integers
    def combine(self, n, k):
        if k == 1:
            result = []
            for i in range(n):
                result.append([i + 1])
            return result
        if n == k:
            return [[i + 1 for i in range(n)]]
        tmp = self.combine(n - 1, k - 1)
        for l in tmp:
            l.append(n)
        return self.combine(n - 1, k) + tmp


if __name__ == "__main__":
    print Solution().combine(7, 4)
