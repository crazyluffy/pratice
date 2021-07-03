package org.renm.leetcode.informationTransfer;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> edges = pretreat(n, relation);
        return 0;
    }

    private List<List<Integer>> pretreat(int n, int[][] relation) {
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.set(i, new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0];
            int dest = edge[1];
            List<Integer> destList = list.get(src);
            destList.add(dest);
        }
        return list;
    }
}
