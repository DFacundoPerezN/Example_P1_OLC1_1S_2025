/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplop1_olc1;
import Analizadores.Parser;
import java.io.BufferedReader;
import java.io.StringReader;


import Analizadores.Parser;
/**
 *
 * @author Faxx
 */
public class EjemploP1_OLC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String exp = "true || false AND 2 == 1 ";
        String ifs = "if "+exp+" then D, if false then C";
        String else_rule = "else C";
        String rules = "rules : ["+ifs + "," + else_rule +"]";
        String strat = "{ initial: D " + rules ;
        String def_strat = "strategy strat" +strat+"}";
        String scoring = "scoring: {";
        String mc = "  mutual cooperation: 8\n" ;
        String md = "mutual defection: 4\n" ;
        String br = "betrayal reward: 4\n" ;
        String bp = "betrayal punishment: 2";
        String ps = "players strategies: [";
        String rs = " rounds:";
        String match = ps + "estrategia1 , estrategia2 ]"+ rs +"10" + scoring + 
                mc +"," + md  +"," + br  +"," + bp  + "}";
        String def_match = "match juego {"+match ; 
        
        Analizadores.Scanner lexico  = new Analizadores.Scanner(new BufferedReader( new StringReader(match)));
        Parser sintactico =new Parser(lexico);
        
        String consola;
        try {
            sintactico.parse();
        }catch (Exception ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error fatal en compilacion de entrada.");
            consola = "//Error sintactico no deja compilar el archivo";
        }
    }
    
}
