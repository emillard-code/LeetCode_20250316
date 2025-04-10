package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[] nums1 = { 4, 2, 3, 1 };
        System.out.println(minimumTimeToRepairCars(nums1, 10));

        int[] nums2 = { 5, 1, 8 };
        System.out.println(minimumTimeToRepairCars(nums2, 6));

    }
    
    public static int minimumTimeToRepairCars(int[] ranks, int cars) {

        int[] assignedCars = new int[ranks.length];

        return repairCars(ranks, cars, assignedCars);
        
    }

    private static int repairCars(int[] ranks, int cars, int[] assignedCars) {

        if (cars == 0) {

            int totalTimeTaken = 0;

            for (int i = 0; i < assignedCars.length; i++) {

                int timeTaken = ranks[i] * assignedCars[i] * assignedCars[i];

                if (timeTaken > totalTimeTaken) {
                    totalTimeTaken = timeTaken;
                }

            }

            return totalTimeTaken;

        }

        int[] assignedCarsNew = new int[assignedCars.length];

        for (int i = 0; i < assignedCars.length; i++) {

            assignedCarsNew[i] = assignedCars[i];

        }

        int minimumTime = Integer.MAX_VALUE;

        for (int i = 0; i < assignedCars.length; i++) {

            assignedCarsNew[i] = assignedCarsNew[i] + 1;
            int timeTaken = repairCars(ranks, cars - 1, assignedCarsNew);
            assignedCarsNew[i] = assignedCarsNew[i] - 1;

            if (timeTaken < minimumTime) {
                minimumTime = timeTaken;
            }

        }

        return minimumTime;

    }

}
