package nr1.ausdrueckeerw;

import nr1.ausdrueckeerw.*;

public class testadd {


    public static void main(String[] atgs){
        Operand p = new Potenz(new Division( new Multiplikation(new Konstante(3),new Potenz( new Addition( new Konstante(6),new Konstante(7)), new Konstante(5))), new Logarithmus( new Wurzel( new Addition(new Division(new Konstante(70),new Konstante(4)),new Division(new Konstante(990),new Konstante(8))) , new Argument(2)),new Argument(10))),new Konstante(4));
        System.out.println(p.toString());



    }





}
