package nr1.ausdrueckeerw;

import nr1.ausdrueckeerw.ArgOperation;
import nr1.ausdrueckeerw.Argument;
import nr1.ausdrueckeerw.Operand;

public class Logarithmus extends ArgOperation {

    public Logarithmus(Operand operand0, Argument operand1) {
        super(operand0, operand1);
    }

    public Logarithmus(){
        super();
    }

    @Override
    public double getErgebnis() {
        double ret = 0.0;
        if (this.getOperand(0) != null && this.getOperand(1) != null){
            ret = Math.log(this.getOperand(0).getErgebnis())/Math.log(this.getArgument().getErgebnis());
        }
        return ret;
    }

    public String toString() {
        String ret = null;
        ret = "log("+this.getArgument().toString()+" , "+this.getOperand(0).toString()+"="+this.getErgebnis()+")";
        return ret;
    }
}
