#! /usr/bin/env python

class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
        if len(s1 + s2) != len(s3):
            return False
        l1, l2 = len(s1), len(s2)
        match = [[False for col in range(l2 + 1)] for row in range(l1 + 1)]
        i1, i2 = 1, 1
        match[0][0] = True
        while i1 <= l1:
            if s1[i1 - 1] == s3[i1 - 1]:
                match[i1][0] = True
                i1 += 1
            else:
                break
        while i2 <= l2:
            if s2[i2 - 1] == s3[i2 - 1]:
                match[0][i2] = True
                i2 += 1
            else:
                break
        i1, i2 = 1, 1
        while i1 <= l1:
            i2 = 1
            while i2 <= l2:
                match[i1][i2] = (match[i1 - 1][i2] and s1[i1 - 1] == s3[i1 + i2 - 1]) \
                                or (match[i1][i2 - 1] and s2[i2 - 1] == s3[i1 + i2 - 1])
                i2 += 1
            i1 += 1
        return match[l1][l2]

if __name__ == "__main__":
    print Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac")
    print Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc")
