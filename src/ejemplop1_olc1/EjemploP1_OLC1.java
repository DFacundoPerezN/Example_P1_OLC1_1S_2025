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
        String texto = "if true AND false || ! false then D , if false then C";
        Analizadores.Scanner lexico  = new Analizadores.Scanner(new BufferedReader( new StringReader(texto)));
        Parser sintactico =new Parser(lexico);
        
        String consola;
        try {
            sintactico.parse();
        }catch (Exception ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error fatal en compilación de entrada.");
            consola = "//Error sintactico no deja compilar el archivo";
        }
    }
    
}
