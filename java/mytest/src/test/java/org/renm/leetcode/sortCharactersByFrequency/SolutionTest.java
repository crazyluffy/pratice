package org.renm.leetcode.sortCharactersByFrequency;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testFrequencySort() {
        Solution solution = new Solution();
        String s = solution.frequencySort("tree");
        System.out.println(s);
    }
}
