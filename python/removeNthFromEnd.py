#! /usr/bin/env python

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        front = head
        for i in range(n):
            front = front.next
        if not front:
            return head.next
        node = head
        while front.next:
            node = node.next
            front = front.next
        node.next = node.next.next
        return head

if __name__ == "__main__":
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    node = Solution().removeNthFromEnd(head, 2)
    while node:
        print node.val
        node = node.next
