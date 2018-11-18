package nr1.ausdrueckeerw;

import nr1.ausdrueckeerw.Konstante;

public class Argument extends Konstante {

    private int arg;

    public Argument(double ergebnis) {
        setErgebnis(ergebnis);
    }
    public Argument() {
        super();
    }

    @Override
    public void setErgebnis(double ergebnis) {
        int er = (int) ergebnis;

        if(er < 1){
            if(er == 0){

            }
            er*=-1;
        }
        arg = er;
    }

    @Override
    public double getErgebnis() {
        return arg;
    }


    public String toString(){
        return arg+"";
    }
}
