package org.renm.leetcode.setMismatch;

import java.util.Arrays;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int duplicate = 0;
        int missed = 0;
        int expect;

        if (nums[0] != 1) {
            missed = 1;
            if (nums[0] != 2) {
//                throw new Exception("Does not meet the rules");
                return null;
            }
            expect = 3;
        } else {
            expect = 2;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != expect) {
                if (nums[i] == nums[i - 1]) {
                    if (duplicate != 0) {
//                        throw new Exception("Does not meet the rules");
                        return null;
                    }
                    duplicate = nums[i];
                    continue;
                }
                if (missed != 0) {
//                    throw new Exception("Does not meet the rules");
                    return null;
                }
                missed = expect;
                expect++;
                if (nums[i] != expect) {
//                    throw new Exception("Does not meet the rules");
                    return null;
                }
                expect++;
            } else {
                expect++;
            }
        }
        if (missed == 0) {
            missed = nums.length;
        }
        return new int[]{duplicate, missed};
    }
}
