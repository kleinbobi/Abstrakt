package nr1.ausdrueckeerw;

import nr1.ausdrueckeerw.ArgOperation;
import nr1.ausdrueckeerw.Argument;
import nr1.ausdrueckeerw.Operand;

public class Wurzel extends ArgOperation {


    public Wurzel(Operand operand0, Argument operand1) {
        super(operand0, operand1);
    }

    public Wurzel() {
        super();
    }

    @Override
    public double getErgebnis() {
        double ret = 0.0;
        if (this.getOperand(0) != null && this.getOperand(1) != null){
            ret =Math.pow(this.getOperand(0).getErgebnis(),(1/this.getArgument().getErgebnis()));
        }else {
            throw new NullPointerException();
        }
        return ret;
    }



    public String toString() {
        String ret = null;
        ret = this.getArgument().toString()+"√("+this.getOperand(0).toString()+") = "+this.getErgebnis();
        return ret;
    }

}
