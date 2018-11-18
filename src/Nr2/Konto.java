package Nr2;

/** 
 * Abstrakte Klasse Konto welche zur Konstruktion von Gehalts- und Sparkonto
 * herangezogen wird
 * <ul>
 *	<li>
 *		Jedes Konto erh�lt eine eindeutige Kontonummer
 *	</li>
 *	<li>
 *		F�r alle Konten wird ein Startzinssatz vergeben, der beim Anlegen eines Kontos 
 *		f�r das Konto eingestellt wird
 *	</li>
 *	<li>
 *		Jedes Konto verf�gt �ber einen Kontostand
 *	</li>
 *	<li>
 *		Jedes Konto kann Zinsen abwerfen und kann Spesen verursachen. Wie diese berechnet 
 *		werden, wird in Gehalts- und Sparkonto definiert
 *	</li>
 *	<li>
 *		Auf das Konto bzw. vom Konto kann gebucht werden. Nach welchen Regeln dies erfolgen 
 *		muss wird erst in Gehalts- und Sparkonto festgelegt
 *	</li>
 *	<li>
 *		Vom Konto kann ein Betrag auf ein anderes Konto �berwiesen werden
 *	</li>
 * </ul>
 * @author Michael Wild
 */
public abstract class Konto
{
	/*
	 * Private Membervariablen
	 */
	/** 
	 * Gibt den Zinssatz vor, der jedem Konto beim Anlegen automatisch zugewiesen wird.
	 */
	protected static double startzinssatz = 0.0;
	/** 
	 * Dadurch wird die Kontonummer jedes neu anzulegenden Kontos ermittelt
	 */
	protected static int naechsteKontonummer = 0;
	
	/** 
	 * Speichert f�r jedes Konto die Kontonummer ab 
	 */
	protected final int kontonummer;
	/**
	 * Speichert f�r jedes Konto den momentanen Kontostand ab 
	 */
	protected double kontostand = 0.0;
	/**
	 * Speichert f�r jedes Konto den bei der Zinsberechnung verwendeten Zinssatz ab 
	 */
	protected double zinssatz = 0.0;
	
	/*
	 * Konstruktor
	 */
	/** 
	 * Beim Anlegen erh�lt das Konto eine eindeutige Kontonummern und der Zinssatz wird 
	 * �bernommen. Es wird jedem neuen Konto eine fortlaufende Kontonummer gegeben. Dabei 
	 * wird keine Kontonummer doppelt vergeben. Eine Kontonummer eines gel�schten Kontos 
	 * darf nicht mehr verwendet werden. Weiters wird f�r das Konto der Zinssatz gesetzt, 
	 * welcher durch setStartzinssatz f�r die gesamte Klasse gesetzt wurde. Der Kontostand 
	 * wird auf 0 initialisiert
	 */
	public Konto() {
		this.kontonummer = Konto.naechsteKontonummer;
		Konto.naechsteKontonummer = Konto.naechsteKontonummer + 1;
		this.zinssatz = Konto.startzinssatz;
	}
	
	/*
	 * Abstrakte Methoden
	 */
	/** 
	 * Ermittelt f�r das Konto den Zinsbetrag
	 * @return die Zinsen die f�r das Konto anfallen 
	 */
	public abstract double getZinsen();
	/**
	 * Ermittelt f�r das Konto die Spesen
	 * @return die Spesen des Kontos
	 */
	public abstract double getSpesen();
	
	/*
	 * Getter- und Settermethoden
	 */
	/** 
	 * Merkt sich f�r die Klasse den Startzinssatz. Wird ein Konto angelegt, so wird der 
	 * durch diese Methode eingestellte Startzinssatz dem Konto zugewiesen. Der Zinssatz 
	 * eines neu angelegtem Kontos wird durch den Startzinssatz initialisiert
	 * @param startzinssatz pstartZinssatz der zu setzende Startzinssatz
	 * @throws KontoException wird ausgel�st, wenn der Startzinssatz negativ ist
	 */
	public static void setStartzinssatz(double startzinssatz) throws KontoException {
		if (startzinssatz < 0)
			throw new KontoException("Zinssatz muss gr�sser oder gleich Null sein");
		else
			Konto.startzinssatz = startzinssatz;
	}
	
	/** 
	 * Gibt den gesetzten Startzinssatz zur�ck
	 */
	public static double getStartzinssatz() {
		return Konto.startzinssatz;
	}
	
	/** 
	 * Der Kontostand des Kontos wird gelesen. Auf den Kontostand kann nur lesend 
	 * zugegriffen werden. Buchungen im Konto werden durch die Methoden buchen und 
	 * ueberweisen durchgef�hrt
	 * @return double den Kontostand
	 */
	public double getKontostand() {
		return this.kontostand;
	}
	
	/** 
	 * Die Kontonummer des Kontos wird gelesen. Auf die Kontonummer kann nur lesend 
	 * zugegriffen werden
	 * @return int die Kontonummer 
	 */
	public int getKontoNummer() {
		return this.kontonummer;
	}
	
	/** 
	 * Der Zinssatz des Kontos wird gelesen
	 * @return double der Zinssatz
	 */
	public double getZinssatz() {
		return this.zinssatz;
	}
	
	/** 
	 * Der Zinssatz des Kontos wird neu gesetzt
	 * @param zinssatz ist der zu setzende Zinssatz
	 * @throws KontoException wird ausgel�st, wenn der Zinssatz kleiner Null ist
	 */
	public void setZinssatz(double zinssatz) throws KontoException {
	  if (zinssatz < 0)
	  	throw new KontoException("Zinssatz darf nicht kleiner als Null sein");
	  else
	  	this.zinssatz = zinssatz;
	}
	
	/*
	 * Methoden
	 */
	/** 
	 * Auf das Konto wird gebucht und damit der Kontostand ge�ndert. Wird ein negativer 
	 * Betrag angegeben, so bedeutet dies, dass vom Konto abgebucht wird. Positive Betr�ge 
	 * bedeuten eine Erh�hung des Kontostandes
	 * @param betrag der zu verbuchende positive oder negative Betrag
	 * @throws KontoException wird aus Kompatiblit�tsgr�nden zu �berlagernden Methoden eingef�hrt
	 */
	public abstract void buchen(double betrag) throws KontoException;
	
	/** 
	 * �berweist vom Konto auf ein anderes Konto. �berweist vom Konto auf das in der 
	 * Parameterliste angegebene Konto den angegebenen Betrag. Dabei wird der Betrag vom
	 * Konto abgebucht und zum �bergebenen Konto dazugebucht
	 * @param k jenes Konto auf welches �berwiesen wird
	 * @param betrag der �berwiesen wird
	 * @throws KontoException wird ausgel�st, wenn der zu �berweisende Betrag negativ ist
	 * oder wenn kein Konto �bergeben wurde
	 */
	public void ueberweisen(Konto k, double betrag) throws KontoException {
		if (k == null)
			throw new KontoException("Kein Konto wurde �bergeben");
		if (betrag <= 0)
			throw new KontoException("�berweisungsbetrag muss positiv sein");
		else {
			this.buchen(-betrag);
			k.buchen(betrag);
		}
	}
	
	/** 
	 * Ausgabe der Kontodaten. Es wird die Kontonummer, der Kontostand, der Zinssatz, die Zinsen 
	 * und die Spesen des Kontos ausgegeben 
	 * @return die Stringentsprechung des Kontos
	 */
	public String toString() {
		return "KontoNummer: " + this.kontonummer + " Kontostand: " + this.kontostand +
			" Zinssatz: " + this.zinssatz + " Zinsen: "  + this.getZinsen() + " Spesen: " + this.getSpesen();
	}
}