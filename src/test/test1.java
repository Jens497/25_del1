package test;

import java.lang.*;
import game.Beaker;

public class test1 {

    public static void main(String[] args) {
        game.game1 game = new game.game1();
        System.out.println(game.add(1, 4));
    }

    Beaker beaker = new game.Beaker(2);

    /*
     * Method intended to simulate 1008 dice rolls.
     * Outputs an array with counted rolls - including number of rolls with identical face values.
     * Measures an upper bound on average time for 1008 rolls.
     */

    public int[] simDice() {
        int[] obs = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int a;
        double time = (double) (System.currentTimeMillis());
        for (int i = 1; i < 1009; i++) {
            beaker.roll();
            a = beaker.getSum();
            obs[a - 2]++;
            if (beaker.isIdentical()){obs[11]++;}
            else {obs[12]++;}
        }
        time = (double) (System.currentTimeMillis()) - time;
        double perRoll = time/1008.;
        System.out.println("Upper bound on average time per roll: " + perRoll);
        return obs;
    }

    /*
     *  Calculates a chiSquare sample size to try against the chiSquare distribution with 11 degrees of freedom.
     *  The chiSquare test concludes if the observed experiment falls within 95% of the possible outcomes.
     *  For more specifics of this, refer to the project report.
     *  In other words, the test can be used to measure if the random number generation for the dice is credible.
     */

    public void chiSquare() {
        int[] exp = new int[]{28, 56, 84, 112, 140, 168, 140, 112, 84, 56, 28, 168, 840};
        int[] obs = simDice();
        int a;
        double chSq = 0.;
        for (int i = 0; i < 13; i++) {
            a = (exp[i] - obs[i]);
            a = a * a;
            chSq += (double) (a)/(double) (exp[i]);
        }
        System.out.println("ChiSquared sample = " + chSq);

        double threshold = 21.0261;

        if (threshold > chSq){
            System.out.println("The test confirms the dice as credible with a significance level of 5%.");
        }
        else {
            System.out.println("The test rejects the dice as credible with a significance level of 5%.");
        }
    }
}