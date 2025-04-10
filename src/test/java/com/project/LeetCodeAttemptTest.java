package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void minimumTimeToRepairCarsTest() {

        int[] nums1 = { 4, 2, 3, 1 };
        assertEquals(16, LeetCodeAttempt.minimumTimeToRepairCars(nums1, 10));

        int[] nums2 = { 5, 1, 8 };
        assertEquals(16, LeetCodeAttempt.minimumTimeToRepairCars(nums2, 6));

    }

}
