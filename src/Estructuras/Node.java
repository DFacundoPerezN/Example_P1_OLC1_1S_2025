/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Faxx
 */
public class Node {
    public String dato;
    public String tipo; //Entero, decimal, accion, booleano
    public Node hijoDer;
    public Node hijoIzq;
    
    public Node (String dato){
        this.dato = dato;
    }
    
    public Object getValue(Contexto actual){
        Object value = false;
        int numIzq, numDer;
        boolean boolIzq, boolDer;
        //char charizq, charDer;
        
        
        if(this.tipo.equals("boolean")){
            switch (this.dato){
                case "==":
                    value = hijoIzq.getValue(actual) ==  hijoDer.getValue(actual);
                    break;
                //> < !=
                case "&&":
                    boolIzq = (Boolean) hijoIzq.getValue(actual);
                    boolDer = (Boolean) hijoDer.getValue(actual);
                    value = boolIzq && boolDer;
                    break;
                case "||":
                    boolIzq = (Boolean) hijoIzq.getValue(actual);
                    boolDer = (Boolean) hijoDer.getValue(actual);
                    value = (Boolean) hijoIzq.getValue(actual) || boolDer;
                    break;
                case "false": 
                case "true": 
                    value = dato;
                    break;
            }
        } else if (this.tipo.equals("entero")){  
            switch(this.dato){
                case "round_number":
                    value = actual.ronda;
                    break;
                case "total_rounds":
                    value = actual.rondasTotales;
                    break;
                default:
                    value = (Object) Integer.valueOf(this.dato); 
                break;                   
            }
        } else if(this.dato.equals("accion")){
            switch (this.dato){
                case "get_move":
                    if(this.hijoIzq.dato.contains("opponent")){
                        int index = Integer.valueOf(this.hijoDer.dato);
                        if(actual.jugadorActual == 1){
                            value = actual.historialJ2.get(index);
                        } else {
                            value = actual.historialJ1.get(index);                            
                        }
                    }
                case "D":
                case "C":
                    value = (Object) this.dato.charAt(0);
                    break;
            }
        }
        
        
        
        return value;
    }
}
