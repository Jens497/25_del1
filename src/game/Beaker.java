package game;

public class Beaker {

    // Variables
    private Die[] die;
    private int[] results;

    private boolean hasRolled;

    // Constructor: Takes number of die in beaker as argument
    public Beaker(int n) {

        // Assign arrays with right length
        this.die = new Die[n];
        this.results = new int[n];

        // Make new instance of die for each number of dice
        for (int i = 0; i < n; i++) {
            this.die[i] = new Die();
        }
    }

    // Rolls each die in beaker using the roll function
    public void roll() {

        // Roll each die
        for (int i = 0; i < this.die.length; i++) {
            this.results[i] = die[i].roll();
        }

        // Set hasRolled to true
        hasRolled = true;
    }

    // Returns the sum of all the face values if dice have been rolled, otherwise returns zero
    public int getSum() {

        // Return zero if dice hasn't been rolled
        if (!hasRolled) {
            return 0;
        }

        // Sum up all face values
        int sum = 0;
        for (int result : results) {
            sum += result;
        }

        // Return sum of face values
        return sum;
    }
}
