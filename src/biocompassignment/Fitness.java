
package biocompassignment;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fitness {

    public static Rule[] DataSet = new Rule[BioCompAssignment.rulesetSize];
    private static final int FITNESS_GOAL = BioCompAssignment.rulesetSize;
    private static final String DATA = "data" + BioCompAssignment.DATA + ".txt";

    public static int getFITNESS_GOAL() {
        return FITNESS_GOAL;
    }

    public Rule getRule(int index) {
        return DataSet[index];
    }

    public static int getFitness(RuleSet ruleSet) {
        int fitness = 0;
        for (int i = 0; i < BioCompAssignment.rulesetSize; i++) {
            for (int j = 0; j < BioCompAssignment.rulesetSize; j++) {
                if (matchesCondition(DataSet[j], ruleSet.getRule(j))) {
                    if (matchesOutput(DataSet[i], ruleSet.getRule(i))) {
                        fitness++;
                    }
                    break;
                }
            }
        }
        return fitness;
    }

    public static boolean matchesCondition(Rule dataExample, Rule ruleBase) {
        return (dataExample.getCond().equals(ruleBase.getCond()));
    }

    public static boolean matchesOutput(Rule dataExample, Rule ruleBase) {
        return (dataExample.getOutput().equals(ruleBase.getOutput()));
    }

    public void printDataSet() {
        System.out.println("Data file:");
        for (int i = 0; i < BioCompAssignment.rulesetSize; i++) {
            System.out.println("Rule" + (i + 1) + ": " + getRule(i).getRuleString());
        }
    }

    public void getData() throws FileNotFoundException {

        Scanner sc = new Scanner(Fitness.class.getResourceAsStream(DATA));
        int i = 0;
        while (sc.hasNext() && i < DataSet.length) {
            String nextRule = sc.nextLine();
            Rule newRule = new Rule();
            newRule.inputRule(nextRule);
            DataSet[i] = newRule;     
            i++;
        }
    }
}

