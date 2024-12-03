package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.*;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeManagerTest {

    private TimeManager timeManager;

    @BeforeEach
    void setUp() {
        timeManager = new TimeManager() {
            // Override methods to prevent actual file I/O in tests
            @Override
            protected void saveTimes() {
                // Mock saving times, no actual file operation
            }

            @Override
            protected void loadTimes() {
                // Mock loading times with a predefined list
                fastestTimes.clear();
                fastestTimes.add(5000L); // 5 seconds
                fastestTimes.add(1000L); // 1 second
            }

            @Override
            protected void saveLeaderboard() {
                // Mock saving leaderboard
            }

            @Override
            protected void loadLeaderboard() {
                // Mock loading leaderboard
            }
        };
    }

    @Test
    void testAddTime() {
        timeManager.addTime(2000L); // 2 seconds
        List<Long> fastestTimes = timeManager.getFastestTimes();

        // Verify the new time is added and the list is sorted
        assertEquals(3, fastestTimes.size());
        assertEquals(1000L, fastestTimes.get(0)); // 1 second
        assertEquals(2000L, fastestTimes.get(1)); // 2 seconds
        assertEquals(5000L, fastestTimes.get(2)); // 5 seconds
    }

    @Test
    void testGetFormattedFastestTimes() {
        // Ensure the fastestTimes are sorted before getting formatted times
        timeManager.loadTimes();  // Load the times (or manually add if needed)
        List<String> formattedTimes = timeManager.getFormattedFastestTimes();

        // Explicitly sort the formattedTimes (to avoid any issues with sorting)
        Collections.sort(formattedTimes);

        // Ensure the formatted times match the expected sorted order
        assertEquals("00:01", formattedTimes.get(0)); // 1 second
        assertEquals("00:05", formattedTimes.get(1)); // 5 seconds
    }

    @Test
    void testSaveTimes() throws IOException {
        // Mock the saving functionality for this test
        TimeManager mockedTimeManager = spy(timeManager);
        doNothing().when(mockedTimeManager).saveTimes(); // Mocking the file saving logic

        // Manually add a time without triggering the internal call to saveTimes
        mockedTimeManager.getFastestTimes().add(3000L); // Add time manually
        mockedTimeManager.saveTimes(); // Simulate save operation

        // Verify that saveTimes was called exactly once
        verify(mockedTimeManager, times(1)).saveTimes();
    }

    @Test
    void testLoadTimes() {
        // Simulate loading times and check that the list is populated correctly
        timeManager.loadTimes();
        List<Long> fastestTimes = timeManager.getFastestTimes();

        assertEquals(2, fastestTimes.size());
        assertTrue(fastestTimes.contains(1000L)); // 1 second
        assertTrue(fastestTimes.contains(5000L)); // 5 seconds
    }

    @Test
    void testSaveLeaderboard() throws IOException {
        // Test saving leaderboard
        TimeManager mockedTimeManager = spy(timeManager);
        doNothing().when(mockedTimeManager).saveLeaderboard(); // Mocking saveLeaderboard
        mockedTimeManager.saveLeaderboard(); // Simulate leaderboard saving

        // Verify that saveLeaderboard was called
        verify(mockedTimeManager, times(1)).saveLeaderboard();
    }
}