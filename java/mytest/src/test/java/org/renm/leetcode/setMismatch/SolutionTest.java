package org.renm.leetcode.setMismatch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testFindErrorNums() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 4};
        int[] errorNums = solution.findErrorNums(nums);
//        System.out.println(Arrays.toString(errorNums));
        assertArrayEquals(errorNums,new int[]{2, 3});

        int[] errorNums1 = solution.findErrorNums(new int[]{1, 1});
        System.out.println(Arrays.toString(errorNums1));

        int[] errorNums2 = solution.findErrorNums(new int[]{1, 3, 3});
        System.out.println(Arrays.toString(errorNums2));

    }
}