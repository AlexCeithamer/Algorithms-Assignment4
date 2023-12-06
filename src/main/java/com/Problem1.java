package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
    public List<Integer> degrees;

    public Boolean isGraphPossible() {
        while (true) {
            // Remove zeroes and sort the list
            degrees.removeIf(n -> n == 0);
            if (degrees.isEmpty()) {
                return true; // All degrees are zero, so graph is possible
            }
            Collections.sort(degrees, Collections.reverseOrder());
    
            // Remove the first element
            int d = degrees.remove(0);
            if (d > degrees.size()) {
                return false; // Not enough vertices to connect
            }
    
            // Subtract 1 from the next 'd' degrees
            for (int i = 0; i < d; i++) {
                int degree = degrees.get(i);
                if (degree - 1 < 0) {
                    return false; // Negative degree, no graph possible
                }
                degrees.set(i, degree - 1);
            }
        }
    }

    public void readDegrees(String filename) throws IOException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        //parse file into array split by spaces
        String[] input = scanner.nextLine().split(" ");
        scanner.close();

        //convert string array to List<Integer>
        int sumDegrees = 0;
        degrees = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            degrees.add(Integer.parseInt(input[i]));
            sumDegrees += degrees.get(i);
        }

        //if sum of degrees is odd, then no graph possible
        if (sumDegrees % 2 != 0) {
            System.out.println("no");
            System.exit(0);
        }
    }
}