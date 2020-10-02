package test;

import java.lang.*;

import game.Beaker;

public class test1 {

    public static void main(String[] args) {
    }

    Beaker beaker = new game.Beaker(2);

    /*
     * Method intended to simulate 1008 dice rolls.
     * Outputs an array with counted rolls - including number of rolls with identical face values.
     * Measures an upper bound on average time for 1008 rolls.
     */

    public int[] simDice() {
        // Make an array for counting 11 outcomes of getSum(), and 2 outcomes of isIdentical.
        int[] obs = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int a;
        // Get time in milliseconds before the for loop.
        long time = System.currentTimeMillis();
        // Roll the dice 1008 times and store data in the array.
        for (int i = 0; i < 1008; i++) {
            beaker.roll();
            a = beaker.getSum();
            // Adds 1 to the specific outcome in the array.
            obs[a - 2]++;
            // Counts both true and false outcomes of isIdentical (needed for chiSquare)
            if (beaker.isIdentical()) {
                obs[11]++;
            } else {
                obs[12]++;
            }
        }
        // Calculate how long it took to run the for loop.
        time = System.currentTimeMillis() - time;
        // Divide it by the number of rolls, to have an estimate on how long each roll took.
        double perRoll = (double) (time) / 1008.;
        System.out.println("Upper bound on average time per roll: " + perRoll);
        // Return the array of observations.
        return obs;
    }

    /*
     *  Calculates a chiSquare sample size to try against the chiSquare distribution with 11 degrees of freedom.
     *  The chiSquare test concludes if the observed experiment falls within 95% of the possible outcomes.
     *  For more specifics of this, refer to the project report.
     *  In other words, the test can be used to measure if the random number generation for the dice is credible.
     *  Take note, that far most of the calculations are using int.
     */

    public void chiSquare() {
        // Define an array of evenly distributed outcomes.
        int[] exp = new int[]{28, 56, 84, 112, 140, 168, 140, 112, 84, 56, 28, 168, 840};
        // Get an array for testing.
        int[] obs = simDice();
        int a;
        // Variable for calculating the chiSquare sample.
        double chSq = 0.;
        // Calculate $\sum_{i=0}^{10} \frac{(exp_i - obs_i)^2}{(exp_i)}$ - see report.
        for (int i = 0; i < 11; i++) {
            a = (exp[i] - obs[i]);
            a = a * a;
            chSq += (double) (a) / (double) (exp[i]);
        }
        System.out.println("ChiSquared sample = " + chSq);
        // threshold is the solution x to the equation P_dice(X>x)=0.95, with 10 DoF. See report.
        double threshold = 21.0261;
        // Print a conclusion of the statistical test. The test should fail about 5% of the time.
        if (threshold > chSq) {
            System.out.println("The test confirms the dice as credible with a significance level of 5%.");
        } else {
            System.out.println("The test rejects the dice as credible with a significance level of 5%.");
        }
        // Repeat the process for the isIdentical data.
        for (int i = 0; i < 2; i++) {
            a = exp[i + 12] - obs[i + 12];
            a = a * a;
            chSq += (double) (a) / (double) (exp[i + 12]);
        }
        // threshold here is different, because we change to 1 DoF, down from 10. See report.
        threshold = 3.8415;

        if (threshold > chSq) {
            System.out.println("The test confirms double rolls credible with a significance level of 5%.");
        } else {
            System.out.println("The test rejects double rolls credible with a significance level of 5%.");
        }
    }
}