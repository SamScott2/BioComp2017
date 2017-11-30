
package biocompassignment;

public class Rule {

    //Rules are the baseline of the system, the lowest class.
    //Made up of 5 condition bits, and 1 output bits.
    //These are tested against the data set rules.
    private byte[] rule = new byte[BioCompAssignment.ruleSize];
    private byte[] cond = new byte[BioCompAssignment.conditionSize];
    private byte output;

    public void generateRule() {
        for (int i = 0; i < cond.length; i++) {
            cond[i] = (byte) Math.round(Math.random());
            rule[i] = cond[i];
        }
        this.output = (byte) Math.round(Math.random());
        rule[rule.length - 1] = output;
    }

    public void inputRule(String input) {
        input = input.trim();
        for (int i = 0; i < BioCompAssignment.ruleSize; i++) {
            if (i == BioCompAssignment.ruleSize-1) { //data1 = 5, data2 = 6
                output = Byte.parseByte("" + input.charAt(i));
            } else {
                cond[i] = Byte.parseByte("" + input.charAt(i));
            }
        }
        System.arraycopy(cond, 0, rule, 0, cond.length);
        rule[rule.length - 1] = output;
    }

    public String getCond() {
        String temp = "";
        for (int k = 0; k < cond.length; k++) {
            temp += "" + cond[k];
        }
        return temp;
    }

    public String getRuleString() {
        String temp = "";
        for (int k = 0; k < rule.length; k++) {
            temp += "" + rule[k];
        }
        return temp;
    }

    public String getOutput() {
        return Integer.toString(output);
    }

    public byte[] getRule() {
        return rule;
    }

}
