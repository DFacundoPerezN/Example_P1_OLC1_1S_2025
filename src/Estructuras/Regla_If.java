/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Faxx
 */
public class Regla_If {
    //Condicion 
    public Node condicion; 
    public char accion;
    
    public Regla_If( Node c, String a){
        this.condicion = c;
        this.accion = a.charAt(0);
    }
    
    public boolean resolveCond(Contexto actual){
        try{
            return (Boolean) this.condicion.getValue(actual);
        } catch (Exception e){
            System.out.println("Error intentando validar condicion");
            return false;
        }
    }
}
