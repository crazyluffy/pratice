package org.renm.leetcode.majorityElement;

public class Solution {
    public int majorityElement(int[] nums) {
        // read text answer first
        int count = 0;
        int candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                if (candidate != num) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        if (count * 2 > nums.length) {
            return candidate;
        }
        return -1;
    }
}
