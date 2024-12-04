package main;

/**
 * This class handles the leaderboard times
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeManager {
    private static final String BINARY_FILE_NAME = "fastest_times.dat";
    private static final String LEADERBOARD_FILE_NAME = "leaderboard.csv";
    public ArrayList<Long> fastestTimes = new ArrayList<>();

    public TimeManager() {
        loadTimes();
        loadLeaderboard();
    }

    public ArrayList<Long> getFastestTimes() {
        return new ArrayList<>(fastestTimes);
    }

    public List<String> getFormattedFastestTimes() {
        ArrayList<String> formattedTimes = new ArrayList<>();
        for (Long time : fastestTimes) {
            formattedTimes.add(TimeUtils.formatTime(time));
        }
        return formattedTimes;
    }

    public void addTime(long time) {
        fastestTimes.add(time);
        Collections.sort(fastestTimes);
        if (fastestTimes.size() > 10) {
            fastestTimes.remove(fastestTimes.size() - 1);
        }
        saveTimes();
        saveLeaderboard(); // Save to leaderboard file as well
    }

    void saveTimes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_NAME))) {
            oos.writeObject(fastestTimes);
        } catch (IOException e) {
            System.err.println("Error saving times: " + e.getMessage());
        }
    }

    void loadTimes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BINARY_FILE_NAME))) {
            fastestTimes = (ArrayList<Long>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, no action needed
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading times: " + e.getMessage());
        }
    }

    void saveLeaderboard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LEADERBOARD_FILE_NAME))) {
            writer.write("Rank,Time (mm:ss)");
            writer.newLine();
            List<String> formattedTimes = getFormattedFastestTimes();
            for (int i = 0; i < formattedTimes.size(); i++) {
                writer.write((i + 1) + "," + formattedTimes.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving leaderboard: " + e.getMessage());
        }
    }

    void loadLeaderboard() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LEADERBOARD_FILE_NAME))) {
            fastestTimes.clear();
            String line = reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String timeString = parts[1];
                    long millis = TimeUtils.parseFormattedTime(timeString); // Parse back to milliseconds
                    fastestTimes.add(millis);
                }
            }
            Collections.sort(fastestTimes); // Ensure the list is sorted
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, no action needed
        } catch (IOException e) {
            System.err.println("Error loading leaderboard: " + e.getMessage());
        }
    }
    public class TimeUtils {
        public static String formatTime(long millis) {
            long seconds = millis / 1000;
            long minutes = seconds / 60;
            seconds %= 60;
            return String.format("%02d:%02d", minutes, seconds);
        }

        public static long parseFormattedTime(String formattedTime) {
            String[] parts = formattedTime.split(":");
            long minutes = Long.parseLong(parts[0]);
            long seconds = Long.parseLong(parts[1]);
            return (minutes * 60 + seconds) * 1000; // Convert to milliseconds
        }
    }
}
