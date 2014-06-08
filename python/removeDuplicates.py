#! /usr/bin/env python

class Solution:
    # @param a list of integer
    # @return an integer
    def removeDuplicates(self, A):
        if not A:
            return 0
        length = 1
        current = 1
        while current < len(A):
            if A[current] == A[current - 1]:
                if not length:
                    length = current
                while current < len(A) and A[current] == A[current - 1]:
                    current += 1
            if current == len(A):
                break
            A[length] = A[current]
            length += 1
            current += 1

        return length


if __name__ == "__main__":
    A = [1, 2, 3, 3, 4]
    print Solution().removeDuplicates(A)
    print A
