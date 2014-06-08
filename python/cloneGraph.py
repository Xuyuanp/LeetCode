#! /usr/bin/env python

# Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution:
    # @param node, an undirected graph node
    # @return an undirected graph node
    def cloneGraph(self, node):
        self.m = {}
        if not node:
            return None
        newNode = UndirectedGraphNode(node.label)
        self.m[node.label] = newNode
        self.copy(node, newNode)
        return newNode

    def copy(self, node, newNode):
        for neighbor in node.neighbors:
            n = self.m.get(neighbor.label)
            if not n:
                n = UndirectedGraphNode(neighbor.label)
                self.m[neighbor.label] = n
                newNode.neighbors.append(n)
                self.copy(neighbor, n)
            else:
                newNode.neighbors.append(n)
