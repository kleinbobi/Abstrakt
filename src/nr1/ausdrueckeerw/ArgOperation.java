package nr1.ausdrueckeerw;

import nr1.ausdrueckeerw.Operand;

public abstract class ArgOperation extends Operand {

    private Operand operand;
    private Argument argument;


    public ArgOperation(Operand operand, Argument argument) {
        this.add(operand);
        this.add(argument);
        this.setOperand(operand);
        this.setArgument(argument);
    }
    public ArgOperation() {
        super();
    }
    public void setOperand(Operand operand) {
        this.operand=operand;
    }

    public void setArgument(Argument argument) {
        this.argument = argument;
    }

    public Operand getOperand(int position) {
            return this.operand;
    }

    public Argument getArgument() {
        return this.argument;
    }

    public void loescheOperand(int position) {

        this.operand = this.operand;
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }
}
