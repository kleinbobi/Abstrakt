package Nr2;

public class Sparkonto extends Konto{


    protected  double 	sparrate;


    public Sparkonto(double ersteZahlung, double sparrate) throws KontoException{
        super();
        if(ersteZahlung > 0 && sparrate > 0){

            kontostand = ersteZahlung;
            this.sparrate = sparrate;
        }else {
            Konto.naechsteKontonummer = Konto.naechsteKontonummer - 1;
            throw new KontoException("Sparrate oder ersteZahlung dürfen nicht 0 sein");
        }
    }

    public double getSparrate(){
        return sparrate;
    }

    /**
     * setzt die Sparrate sie darf nicht kleiner gleich 0 sein
     * @param sparrate
     * @throws KontoException
     */
    public void setSparrate(double sparrate) throws KontoException{
        if(sparrate <= 0){
            throw new KontoException("Sparrate darf nicht 0 sein");
        }
        this.sparrate = sparrate;
    }

    @Override
    public double getZinsen() {
        return 0;
    }

    @Override
    public double getSpesen() {
        return kontostand * 0.1;
    }

    @Override
    public void buchen(double betrag) throws KontoException {
        if(betrag >= -3000){
            if(kontostand + betrag >= 0) {
                kontostand += betrag;
            }else {
                throw new KontoException("Kontostand darf nicht kleiner 0 sein");
            }
        }else {
            if(betrag + kontostand !=0){
                throw new KontoException("Bei einer Buchung über -3000 muss der Kontostand 0 werden");
            }else {
                kontostand += betrag;
            }
        }
    }

    public void buchenSparrate(){
        kontostand += sparrate;
    }

    @Override
    public String toString() {
        return "Sparkonto{" +
                "kontonummer=" + this.kontonummer +
                ", sparrate=" + sparrate +

                ", kontostand=" + kontostand +
                ", zinssatz=" + zinssatz +
                '}';
    }
}
