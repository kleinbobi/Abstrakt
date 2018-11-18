package nr1.ausdrueckeerw;

import nr1.ausdrueckeerw.Operand;
import nr1.ausdrueckeerw.Operation;

public class Potenz extends Operation {

    public Potenz(Operand operand0, Operand operand1) {
        super(operand0, operand1);
    }

    public Potenz() {
        super();
    }

    @Override
    public double getErgebnis() {
        double ret = 0.0;
        if (this.getOperand(0) != null && this.getOperand(1) != null){
            ret=Math.pow(this.getOperand(0).getErgebnis(),this.getOperand(1).getErgebnis());
        }else {
            ret=0;
        }
        return ret;
    }

    public String toString() {
        String ret = null;
        ret = "("+this.getOperand(0).toString()+"^"+this.getOperand(1).toString()+"="+this.getErgebnis()+")";
        return ret;
    }
}
