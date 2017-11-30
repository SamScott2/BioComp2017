
package biocompassignment;


import java.io.FileNotFoundException;

public class BioCompAssignment {

    public final static int DATA = 2;         // which data set you use 1 or 2;

    //GA VARIABLES
    final static int P = 10;                  // population size
    final static double UR = 0.5;             // uniform rate
    final static double MR = 0.015;           // mutation rate
    final static int TS = 5;                  // tournament size
    final static boolean elitism = true;      //true;//false;   // keep the fittest individual of each generation

    //Global Variables
    public static int rulesetSize;
    public static int ruleSize;
    public static int conditionSize;

    public static void main(String[] args) throws FileNotFoundException {
        initVariables();
        Fitness fitness = new Fitness();
        fitness.getData();
        //fitness.printDataSet();

        //initial population
        Population pop = new Population(P, true);

        int generationCount = 0;

        while (pop.getFittest().getFitness() < Fitness.getFITNESS_GOAL() && generationCount < 100) {
            generationCount++;
            // System.out.println("Generation: " + generationCount + "  Fittest: " + pop.getFittest().getFitness());
            pop = GA.evolvePopulation(pop);
            System.out.println(pop.getFittest().getFitness());

        }
        System.out.println("GA Ended");
        System.out.println("Generation: " + generationCount);
        System.out.println("Fitness: " + pop.getFittest().getFitness());
        System.out.println("Populaion: ");
//        for (int i = 0; i < P; i++) {
//            System.out.println("individual "+(i+1));
//            for (int j = 0; j < rulesetSize; j++) {
//                System.out.println(pop.getRuleSet(i).getRule(j).getRuleString());
//            }
//            System.out.println("");
//        }

    }

    public static void initVariables() {
        if (DATA == 1) {
            rulesetSize = 32;
            ruleSize = 6;
            conditionSize = 5;
        } else if (DATA == 2) {
            rulesetSize = 64;
            ruleSize = 7;
            conditionSize = 6;
        }
    }

    //INITIALISE GENETIC ALGORITHM VARIABLES
}
