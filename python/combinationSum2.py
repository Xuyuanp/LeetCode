#! /usr/bin/env python

class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def combinationSum(self, candidates, target):
        candidates.sort()
        self.result = []
        items = []

        self.dfs(candidates, 0, target, items)

        return self.result

    def dfs(self, candidates, start, target, items):
        if target < 0:
            return
        if target == 0:
            self.result.append(items[:])
            return
        while start < len(candidates):
            items.append(candidates[start])
            self.dfs(candidates, start + 1, target - candidates[start], items)
            items.remove(items[-1])
            while start < len(candidates) - 1 and candidates[start] == candidates[start + 1]:
                start += 1
            start += 1


if __name__ == "__main__":
    # print Solution().combinationSum([92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73], 310)
    print Solution().combinationSum([10, 1, 2, 7, 6, 1, 5], 8)
    print Solution().combinationSum([1, 1], 1)
