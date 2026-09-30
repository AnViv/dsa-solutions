//Question Details - Check question1.md file in this folder for question details(Asked on HackerRank platform)
//Used binary search

package companies.agoda.onlineassessments;

import java.util.Arrays;

public class MaximumThroughputPossible {
    public static void main(String[] args) {
        int[] throughput = {4, 2, 7};
        int[] scalingCost = {3, 5, 6};
        int budget = 32;

        int[] throughput2 = {3, 2, 5};
        int[] scalingCost2 = {2, 5, 10};
        int budget2 = 28;
        System.out.println(getMaximumThroughputPossible(throughput, scalingCost, budget));

    }
    private static int getMaximumThroughputPossible(int[] throughput, int[] scalingCost, int budget) {
        int currentMinTP = Arrays.stream(throughput).min().getAsInt();
        //int currentMaxTP = Arrays.stream(throughput).max().getAsInt();
        int currentMinSC = Arrays.stream(scalingCost).min().getAsInt();
        int currentMaxSC = Arrays.stream(scalingCost).min().getAsInt();
        //int currentMinTPMultiplier = budget/currentMaxSC;
        int currentMaxTPMultiplier = budget/currentMinSC;
        long minTPRange = (long) currentMinTP;
        long maxTPRange = (long) currentMinTP * currentMaxTPMultiplier;
        long result = 0;

        while(minTPRange<=maxTPRange) {
            long midTP = minTPRange + (maxTPRange-minTPRange)/2;
            if(isTargetRPPossible(throughput, scalingCost, budget, midTP)) {
                result = Math.max(midTP, result);
                minTPRange = midTP+1;
            } else {
                maxTPRange = midTP-1;
            }
        }
        return (int) result;
    }

    private static boolean isTargetRPPossible(int[] throughput, int[] scalingCost, int budget, long targetTP) {
        int n = throughput.length;
        long currentCost = 0;
        for(int i=0; i<n; i++) {
            currentCost += scalingCost[i] * (Math.ceilDiv(targetTP,throughput[i])-1);
        }
        if(currentCost<=budget) {
            return true;
        }
        return false;
    }
}
