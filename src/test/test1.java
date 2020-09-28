package test;


import game.Beaker;

public class test1 {

    public static void main(String[] args) {
        game.game1 game = new game.game1();
        System.out.println(game.add(1, 4));
    }

    /*
     * Method intended to simulate 1008 dice rolls.
     * Outputs an array with counted rolls.
     * beaker is a placeholder for the class in game.
     */
    Beaker beaker = new game.Beaker(2);

    public int[] simDice() {
        int[] obs = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int a;
        for (int i = 1; i < 1009; i++) {
            beaker.roll();
            a = beaker.getSum();
            obs[a - 2]++;
        }
        return obs;

    }

    public void chiSquare() {
        int[] exp = new int[]{28, 56, 84, 112, 140, 168, 140, 112, 84, 56, 28};
        int[] obs = simDice();
        int a;
        int chSq = 0;
        for (int i = 0; i < 12; i++) {
            a = (exp[i] - obs[i]);
            chSq += a * a;
        }
        System.out.println("ChiSquared sample = " + chSq);
        /* Calculate P(X<=chSq), with (2-1)*(11-1)=10 DoF.
         * Creates a chiSquare sample value to test against the cumulativeProbability
         * function of the ChiSquare distribution, with 10 degrees of freedom. The
         * method is intended to determine if the simulation gives a set of outcomes
         * that is within reason - i.e. that the sample value is in the interval that
         * represents 95% of outcomes. It is possible that the test determines the
         * simulation outside this range - this should happen in roughly 5% of cases.
         */

        /* org.apache.commons.math3.distribution.ChiSquaredDistribution
        ChiSquaredDistribution chi2 = new ChiSquaredDistribution(10);
        double prob = chi2.cumulativeProbability(chSq);
        if (prob >= 0.95){
            System.out.println("The test concludes that the dice are true with
            a significance level of 5%.")
            }
        else {
            System.out.println("The test concludes that the dice are not true with
            a significance level of 5%."
        }
         */
    }
}