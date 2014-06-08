#! /usr/bin/env python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def sortedArrayToBST(self, num):
        if not num:
            return None
        mid = len(num) / 2
        root = TreeNode(num[mid])
        root.left = self.sortedArrayToBST(num[:mid])
        root.right = self.sortedArrayToBST(num[mid + 1:])
        return root

    def sortedListToBST(self, head):
        array = []
        length = 0
        node = head
        self.head = head
        while node:
            length += 1
            node = node.next
        return self.__sortedListToBST(0, length - 1)

    def __sortedListToBST(self, start, end):
        if start > end:
            return None
        mid = (end + start) / 2
        left = self.__sortedListToBST(start, mid - 1)
        root = TreeNode(self.head.val)
        self.head = self.head.next
        right = self.__sortedListToBST(mid + 1, end)
        root.left = left
        root.right = right
        return root
