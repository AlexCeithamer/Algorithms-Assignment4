package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem2 {
    int maxDay = 0;

    private List<Request> ReadFile(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        List<Request> requests = new ArrayList<>();

        while (sc.hasNextInt()) {
            int id = sc.nextInt();
            int amount = sc.nextInt();
            int latestDay = sc.nextInt();
            if (latestDay > maxDay) {
                maxDay = latestDay;
            }
            requests.add(new Request(id, amount, latestDay));
        }
        return requests;
    }

    public void ConferenceRoomScheduler(String filename) throws FileNotFoundException {
        // Read the input file
        List<Request> requests = ReadFile(filename);

        // Sort the requests by amount (descending) and latestDay (ascending)
        Collections.sort(requests, (a, b) -> {
            if (a.amount == b.amount) {
                return a.latestDay - b.latestDay;
            }
            return b.amount - a.amount;
        });

        // Track allocated days and their corresponding request IDs
        TreeMap<Integer, Integer> allocatedDays = new TreeMap<>();
        int totalEarnings = 0;

        for (Request req : requests) {
            for (int day = req.latestDay; day >= 1; day--) {
                if (!allocatedDays.containsKey(day)) {
                    allocatedDays.put(day, req.id);
                    totalEarnings += req.amount;
                    break;
                }
            }
        }

        // Output the results in the order of days
        System.out.println("Fulfilled Requests: " + new ArrayList<>(allocatedDays.values()));
        System.out.println("Total Earnings: " + totalEarnings);
    }
}
