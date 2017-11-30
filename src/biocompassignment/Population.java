
package biocompassignment;

public class Population {
        
    RuleSet[] population;
    private final int ruleSetSize = BioCompAssignment.rulesetSize;
    
     public Population(int populationSize, boolean init){
        population = new RuleSet[populationSize];
        if(init){
            for (int i=0;i<population.length; i++){
                RuleSet newRuleSet = new RuleSet(ruleSetSize, true);
                saveRuleSet(i,newRuleSet);
            }
        }
    }
     
     public RuleSet getRuleSet(int index){
         return population[index];
     }
     
     public void saveRuleSet(int index, RuleSet ruleSet){
        population[index] = ruleSet;
    }
     
     public RuleSet getFittest(){
        RuleSet fittest = population[0];
        for(int i=0; i<population.length; i++){
            if(fittest.getFitness() <= getRuleSet(i).getFitness()){
                fittest = getRuleSet(i);
            }
        }
        return fittest;
    }
     
    public int size(){
        return population.length;
    }
    
}

