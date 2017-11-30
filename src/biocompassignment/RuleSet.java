
package biocompassignment;

public class RuleSet {

    Rule[] ruleSet;
    int fitness;

    public RuleSet(int ruleSetSize, boolean init) {
        ruleSet = new Rule[ruleSetSize];
        fitness = 0;
        if (init) {
            for (int i = 0; i < ruleSet.length; i++) {
                Rule newRule = new Rule();
                newRule.generateRule();
                ruleSet[i] = newRule;
            }
        }
    }

    public Rule getRule(int index) {
        return ruleSet[index];
    }

    public void saveRule(int index, Rule rule) {
        ruleSet[index] = rule;
    }

    public int size() {
        return ruleSet.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = Fitness.getFitness(this);
        }
        return fitness;
    }
}

