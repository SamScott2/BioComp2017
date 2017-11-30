
package biocompassignment;

public class GA {

    static int ruleSetSize = BioCompAssignment.rulesetSize;

    
    private static final double uniformRate = BioCompAssignment.UR;
    private static final double mutationRate = BioCompAssignment.MR;
    private static final int tournamentSize = BioCompAssignment.TS;
    private static final boolean elitism = BioCompAssignment.elitism;

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);
        //Keep best individual
        if (elitism) {
            newPopulation.saveRuleSet(0, pop.getFittest());
        }        
        int elitismOffset = (elitism)? 1:0; 

        //Crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            RuleSet ruleSet1 = selection(pop);
            RuleSet ruleSet2 = selection(pop);
            RuleSet newRuleSet = crossover(ruleSet1, ruleSet2);
            newPopulation.saveRuleSet(i, newRuleSet);
        }

        //Mutate 
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            newPopulation.population[i] = mutate(newPopulation.getRuleSet(i));
        }
        return newPopulation;
    }

    //Crossover
    private static RuleSet crossover(RuleSet ruleSet1, RuleSet ruleSet2) {
        RuleSet newSol = new RuleSet(ruleSetSize, false);
        for (int i = 0; i < ruleSet1.size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.saveRule(i, ruleSet1.getRule(i)); 
            } else {
                newSol.saveRule(i, ruleSet2.getRule(i));
            }
        }
        return newSol;
    }

    
    private static RuleSet mutate(RuleSet ruleSet) {
        for (int i = 0; i < ruleSet.size(); i++) {
            if (Math.random() <= mutationRate) {
                Rule mutant = new Rule();
                mutant.generateRule();
                ruleSet.saveRule(i, mutant);
            }
        }
        return ruleSet;
    }

    private static RuleSet selection(Population pop) {
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomID = (int) (Math.random() * pop.size());
            tournament.saveRuleSet(i, pop.getRuleSet(randomID));
        }
        RuleSet fittest = tournament.getFittest();
        return fittest;
    }

}

