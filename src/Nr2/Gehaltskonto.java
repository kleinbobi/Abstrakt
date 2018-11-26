package Nr2;

public class Gehaltskonto extends Konto{

    protected static double startueberziehung;
    protected  double ueberziehung;

    public Gehaltskonto() {
        super();
        ueberziehung=startueberziehung;

    }

    /**
     *
     * @param startueberziehung
     * @throws KontoException
     */
    public static void setStartueberziehung(double startueberziehung) throws KontoException{
        if(startueberziehung<=0){
            Gehaltskonto.startueberziehung=startueberziehung;
        }else {
            throw new KontoException("Überzihungsramen > 0");
        }
    }


    public static double getStartueberziehung(){
        return startueberziehung;
    }

    public void setUeberziehung(double ueberziehung) throws KontoException{
        if(ueberziehung<=0){
            this.ueberziehung=ueberziehung;
        }else {
            throw new KontoException("Überzihungsramen > 0");
        }
    }

    public double getUeberziehung(){


        return ueberziehung;
    }



    @Override
    public double getZinsen() {
        double ret=0.0;

        //fertigmachennnnnnnnn

        return ret;
    }

    @Override
    public double getSpesen() {
        double ret=0.0;
        if(kontostand<0){
            ret=50;
        }
        return ret;
    }

    @Override
    public void buchen(double betrag) throws KontoException {
        if(kontostand+betrag<ueberziehung){
            throw new KontoException("Überschreiten der Überzihungsgernze");
        }
        kontostand+=betrag;
    }

    @Override
    public String toString() {
        return "Gehaltskonto{" +
                "kontonummer=" + kontonummer +
                ", ueberziehung=" + ueberziehung +

                ", kontostand=" + kontostand +
                ", zinssatz=" + zinssatz +
                '}';
    }
}
