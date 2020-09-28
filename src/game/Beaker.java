package game;

public class Beaker {

    // Variables
    int numberOfDie;

    Die[] die;
    int[] results;

    boolean hasRolled;

    // Constructor: Takes number of die in beaker as argument
    Beaker(int n) {

        // Set number of dice
        this.numberOfDie = n;

        // Make new instance of die for each number of dice
        for (int i = 0; i < this.numberOfDie; i++) {
            this.Die[i] = new Die();
        }
    }

    // Rolls each die in beaker using the roll function
    void roll() {

        // Roll each die
        for (int i = 0; i < this.die.length; i++) {
            results[i] = die[i].roll();
        }

        // Set hasRolled to true
        hasRolled = true;
    }

    // Returns the sum of all the face values if dice have been rolled, otherwise returns zero
    int getSum() {

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
