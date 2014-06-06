#! /usr/bin/env python

class Solution:
    # @return a list of lists of length 3, [[val1, val2, val3]]
    def threeNum(self, num):
        num.sort()
        result = []
        i = 0
        while i < len(num) - 2:
            if i and num[i] == num[i - 1]:
                i = i + 1
                continue
            j = i + 1
            k = len(num) - 1
            while j < k:
                s = num[j] + num[k]
                if s == -num[i]:
                    n = [num[i], num[j], num[k]]
                    result.append(n)
                    while j < k:
                        j += 1
                        k -= 1
                        if num[k] != num[k + 1] or num[j] != num[j - 1]:
                            break
                else:
                    if s < -num[i]:
                        while j < k:
                            j += 1
                            if num[j] != num[j - 1]:
                                break
                    else:
                        while j < k:
                            k -= 1
                            if num[k] != num[k + 1]:
                                break
            i = i + 1

        return result

    def twoNum(self, num, start, end,  target):
        result = []
        i = start
        j = end - 1
        while i < j:
            s = num[i] + num[j]
            if s == target:
                result.append([num[i], num[j]])
                i = i + 1
                j = j - 1
            else:
                if s < target:
                    i = i + 1
                else:
                    j = j - 1

        return result

if __name__ == '__main__':
    s = Solution()
    l = [7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6]
    print s.threeNum(l)
    print s.threeNum([-1, 0, 1, 2, -1, -4])
    print s.threeNum([0, 0, 0])
