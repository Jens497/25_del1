package game;

public class Beaker {

    // Variables
    private Die[] dice;
    private int[] results;

    private boolean hasRolled = false;

    // Constructor: Takes number of die in beaker as argument
    public Beaker(int n) {

        // Assign arrays with right length
        this.dice = new Die[n];
        this.results = new int[n];

        // Make new instance of die for each number of dice
        for (int i = 0; i < n; i++) {
            this.dice[i] = new Die();
        }
    }

    // Rolls each die in beaker using the roll function
    public void roll() {

        // Roll each die
        for (int i = 0; i < this.dice.length; i++) {
            this.results[i] = this.dice[i].roll();
        }

        // Set hasRolled to true
        this.hasRolled = true;
    }

    // Returns true if all the rolled results are identical, otherwise return false
    public boolean isIdentical() {

        // Return false if dice hasn't been rolled
        if (!hasRolled) {
            return false;
        }

        // Go over each result starting at #2 and compare it to the one before it
        for (int i = 1; i < this.results.length; i++) {

            // If the two are not equal, return false
            if (this.results[i] != this.results[i - 1]) {
                return false;
            }
        }

        // If we have gotten to this point, all the results must be identical; return true
        return true;
    }

    // Returns the sum of all the face values if dice have been rolled, otherwise returns zero
    public int getSum() {

        // Return zero if dice hasn't been rolled
        if (!hasRolled) {
            return 0;
        }

        // Sum up all face values
        int sum = 0;
        for (int result : this.results) {
            sum += result;
        }

        // Return sum of face values
        return sum;
    }
}
