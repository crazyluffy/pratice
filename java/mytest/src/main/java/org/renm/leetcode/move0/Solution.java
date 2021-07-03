package org.renm.leetcode.move0;

public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int current = nums.length - 1; current >= 0; current--) {
            if (nums[current] == 0) {
                moveZero(nums, current, nums.length - 1 - count);
                count ++;
            }
        }
    }

    private void moveZero(int[] src, int from, int to) {
        while (from < to) {
            swapWithNext(src, from);
            from ++;
        }
    }

    private void swapWithNext(int[] src, int from) {
        int tmp = src[from];
        src[from] = src[from + 1];
        src[from + 1] = tmp;
    }
}