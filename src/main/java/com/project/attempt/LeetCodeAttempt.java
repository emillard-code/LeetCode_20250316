package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[] nums1 = { 4, 2, 3, 1 };
        System.out.println(minimumTimeToRepairCars(nums1, 10));

        int[] nums2 = { 5, 1, 8 };
        System.out.println(minimumTimeToRepairCars(nums2, 6));

    }

    // This method will return the minimum time needed to repair all cars.
    public static int minimumTimeToRepairCars(int[] ranks, int cars) {

        // int[] assignedCars is an array that will indicate how many cars are assigned
        // to each mechanic in int[] ranks. Each index in int[] cars corresponds to the
        // mechanic of the same index in int[] ranks.
        int[] assignedCars = new int[ranks.length];

        // We will then call a recursive method that will test all possible combinations
        // of how many cars are assigned to each mechanic in int[] ranks.
        return repairCars(ranks, cars, assignedCars);
        
    }

    // A recursive method that tests all possible combinations of mechanics and how many
    // cars each one is assigned to repair. In each recursive call of the method, we reduce
    // int car by 1 and increment one of the indexes in int[] assignedCars by 1, to indicate
    // that a car has been assigned to one of the mechanics.
    private static int repairCars(int[] ranks, int cars, int[] assignedCars) {

        // If int cars becomes 0, it means all cars have been assigned to one of the mechanics.
        if (cars == 0) {

            // The total time taken to repair all cars will be stored in int totalTimeTaken.
            int totalTimeTaken = 0;

            // We then loop through int[] assignedCars, and apply the appropriate formula from
            // the challenge specifications, based on the rank of each mechanic and how many
            // cars they are assigned to work on.
            for (int i = 0; i < assignedCars.length; i++) {

                int timeTaken = ranks[i] * assignedCars[i] * assignedCars[i];

                // We then record the time taken for this particular mechanic to finish
                // repairing all their assigned cars. Since all the mechanics are working
                // simultaneously and started at the same time, we only need the time taken
                // of the mechanic that took the longest in order to tell when they have all
                // finished. As such, we compare the current mechanic's time taken with
                // int totalTimeTaken, and if it is longer than int totalTimeTaken we overwrite
                // it with the new value from the current mechanic. By the end of all the loops,
                // int totalTimeTaken should contain the longest time taken by a mechanic.
                if (timeTaken > totalTimeTaken) {
                    totalTimeTaken = timeTaken;
                }

            }

            // We then return this value once we are done looping.
            return totalTimeTaken;

        }

        // If int cars has not become 0 yet, we proceed with the rest of our logic.
        // We create a new copy of int[] assignedCars to avoid any potential issues
        // arising from the recursive calls of this method.
        int[] assignedCarsNew = new int[assignedCars.length];

        for (int i = 0; i < assignedCars.length; i++) {

            assignedCarsNew[i] = assignedCars[i];

        }

        // int minimumTime will be used to record the shortest
        // time possible needed to repair all the cars. We set it
        // to a default of a number that's large enough that it won't
        // interrupt with our logic in the rest of the method.
        int minimumTime = Integer.MAX_VALUE;

        // We loop through int[] assignedCars and perform a recursive call for each
        // mechanic that exists. We test adding the next car to each of the mechanics,
        // and then see which of them leads to the least amount of time taken for
        // the repair of all cars to be completed.
        for (int i = 0; i < assignedCars.length; i++) {

            // We assign the 'current' car to the mechanic corresponding to the current index.
            assignedCarsNew[i] = assignedCarsNew[i] + 1;

            // We then perform a recursive call with the updated array and int cars decremented by 1.
            int timeTaken = repairCars(ranks, cars - 1, assignedCarsNew);

            // We revert the array back to its original state
            // before the next iteration of the loop begins.
            assignedCarsNew[i] = assignedCarsNew[i] - 1;

            // As we loop through testing the car being assigned to each of the mechanics,
            // we record the least amount of time it would take for all the cars to be repaired
            // if we assigned the current car to the mechanic corresponding to the current index.
            // We update int minimumTime as we go along as we test each mechanic, to see which
            // of them gives the most optimal results.
            if (timeTaken < minimumTime) {
                minimumTime = timeTaken;
            }

        }

        // Finally, we return int minimumTime once all our logic has been performed, and we
        // have obtained the least amount of time it would take for all the mechanics to
        // finish repairing all the cars.
        return minimumTime;

    }

}
