/**
 * Main class to run the program.
 * Authors: Alex Ceithamer, Alden Sprackling
 */
public class Main {
    

    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        Problem2 p2 = new Problem2();

        
        //----------------- Problem 1 -----------------
        //read file | if sum of degrees is odd, then no graph possible.
        try {
            p1.readDegrees("input1.txt");
            boolean result = p1.isGraphPossible();
            System.out.println(result ? "yes" : "no");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //----------------- Problem 2 -----------------
        try {
            p2.ConferenceRoomScheduler("input2.txt");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
