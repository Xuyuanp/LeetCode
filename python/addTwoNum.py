#! /usr/bin/env python

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        if not l1 and not l2:
            return ListNode(0)
        if not l1:
            return l2
        if not l2:
            return l1

        carry = 0
        result = ListNode(0)
        node = result
        while l1 and l2:
            v = l1.val + l2.val + carry
            if v > 9:
                v = v - 10
                carry = 1
            else:
                carry = 0

            node.next = ListNode(v)
            node = node.next

            l1 = l1.next
            l2 = l2.next

        while l1:
            v = l1.val + carry
            if v > 9:
                v = v - 10
                carry = 1
            else:
                carry = 0

            node.next = ListNode(v)
            node = node.next
            l1 = l1.next

        while l2:
            v = l2.val + carry
            if v > 9:
                v = v - 10
                carry = 1
            else:
                carry = 0

            node.next = ListNode(v)
            node = node.next

            l2 = l2.next

        if carry:
            node.next = ListNode(carry)

        return result.next



if __name__ == '__main__':
    s = Solution()
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)

    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)

    r = s.addTwoNumbers(l1, l2)
    res = ''
    while r:
        res = res + str(r.val)
        r = r.next

    if res == '708':
        print 'Success'
    else:
        print "Fail"
