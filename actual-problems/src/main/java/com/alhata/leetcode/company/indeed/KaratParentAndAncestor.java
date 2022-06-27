package com.alhata.leetcode.company.indeed;

import java.util.*;

/**
 * given a sequence of pairs, for example, {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}}, for each pairs, {a, b}, where a denotes
 * parent node and b denotes child node.
 * the nodes then constructs a graph:
 *
 *    1    2    3    8
 *  /  \  /      \  /
 * 4    5         6
 *                  \
 *                    7
 *
 * 1. find all the nodes with only one or zero parents.
 *
 * 2. given two nodes, find if they have a common ancestor.
 *
 * 3. find the farthest ancestor of a node
 */

public class KaratParentAndAncestor {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{1,4}, {1,5}, {2,5}, {3,6}, {6,7},{8,6}};
//        System.out.println(findNodesWithOneOrZeroParents(edges));

        System.out.println(commonAncestor(edges,7,3));
        System.out.println(farthestAncestor(edges, 7));
    }

    private static Set<Integer> findNodesWithOneOrZeroParents(int[][] edges){
        Set<Integer> nodeSet = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int child = edge[1], parent = edge[0];
            nodeSet.add(child);
            nodeSet.add(parent);
            if(graph.get(child) == null) {
                Set<Integer> parentSet = new HashSet<>();
                parentSet.add(parent);
                graph.put(child, parentSet);
            }else {
                graph.get(child).add(parent);
            }
        }

        for (Integer node : nodeSet) {
            if(graph.get(node) == null || graph.get(node).size() == 1){
                result.add(node);
            }
        }

        return result;
    }

    private static boolean commonAncestor(int[][] edges, int node1, int node2) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int child = edge[1], parent = edge[0];
            if(graph.get(child) == null) {
                Set<Integer> parentSet = new HashSet<>();
                parentSet.add(parent);
                graph.put(child, parentSet);
            }else {
                graph.get(child).add(parent);
            }
        }

        Set<Integer> allParent1 = findAllParent(graph, node1);
        Set<Integer> allParent2 = findAllParent(graph, node2);
        for (Integer p1 : allParent1) {
            if(allParent2.contains(p1)) return true;
        }
        return false;
    }

    private static Set<Integer> findAllParent(Map<Integer, Set<Integer>> graph, int node) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> result = new HashSet<>();
        stack.push(node);
        result.add(node);
        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            Set<Integer> parentSet = graph.get(top);
            if(parentSet == null) continue;
            for (Integer parent : parentSet) {
                if(result.contains(parent)){
                    continue;
                }
                result.add(parent);
                stack.push(parent);
            }
        }
        return result;
    }

    private static Integer farthestAncestor(int[][] edges, int node) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int child = edge[1], parent = edge[0];
            if(graph.get(child) == null) {
                Set<Integer> parentSet = new HashSet<>();
                parentSet.add(parent);
                graph.put(child, parentSet);
            }else {
                graph.get(child).add(parent);
            }
        }

        Queue<Integer> curLayer = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> preLayer = null;
        curLayer.add(node);
        while (!curLayer.isEmpty()) {
            preLayer = new LinkedList<>();
            int size = curLayer.size();
            for(int i=0; i<size; i++) {
                Integer head = curLayer.poll();
                preLayer.add(head);
                visited.add(head);
                Set<Integer> parentSet = graph.get(head);
                if(parentSet != null) {
                    for(int p : parentSet) {
                        if(visited.contains(p)) continue;
                        curLayer.offer(p);
                    }
                }
            }

        }
        return preLayer.poll();
    }
}
