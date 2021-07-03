package org.renm.leetcode.maxUncrossedLines;

public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int count = 0;
        int bCurrent = 0;

        for (int i = 0; i < A.length; i++){
            for(int j = bCurrent; j < B.length; j++){
                if(A[i] == B[j]){
                    count ++;
                    bCurrent = j;
                    break;
                }
            }
            if(bCurrent >= B.length){
                break;
            }
        }
        return count;
    }
}
