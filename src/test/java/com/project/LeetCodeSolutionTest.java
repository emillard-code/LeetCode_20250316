package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void repairCarsTest() {

        int[] nums1 = { 4, 2, 3, 1 };
        assertEquals(16, LeetCodeSolution.repairCars(nums1, 10));

        int[] nums2 = { 5, 1, 8 };
        assertEquals(16, LeetCodeSolution.repairCars(nums2, 6));

    }

}
