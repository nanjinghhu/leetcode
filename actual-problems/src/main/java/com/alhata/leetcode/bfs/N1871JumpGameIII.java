package com.alhata.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class N1871JumpGameIII {

    public static void main(String[] args) {
        System.out.println(canReach("00111010",3,5));
    }
    //find activity space for next step
    public static boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) != '0')  return false;
        Queue<Integer> nextDecisionSet = new LinkedList<>();
        nextDecisionSet.add(0);
        int nextStart = minJump;
        while(!nextDecisionSet.isEmpty()) {
            int cur = nextDecisionSet.poll();
            if(cur == s.length() - 1) return true;
            int low = cur + minJump;
            int high = cur + maxJump;
            for(int i= Math.max(nextStart, low); i <= Math.min(high, s.length() - 1); i++) {
                if(s.charAt(i) == '0') {
                    nextDecisionSet.add(i);
                }
            }

            nextStart = Math.min(high+1, s.length() - 1);
        }

        return false;
    }
}
