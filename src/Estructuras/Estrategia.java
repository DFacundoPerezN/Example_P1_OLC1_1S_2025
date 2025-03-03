/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Faxx
 */
public class Estrategia {
    public char inicial;
    public char regla_else;
    //Lista de ifs
    public ArrayList<Regla_If> reglas_if;
    
    public Estrategia(String inicial, ArrayList<Regla_If> reglas_if, String r_else){
        this.inicial = inicial.charAt(0);
        this.reglas_if = reglas_if;
        this.regla_else = r_else.charAt(0);
    }
    
    public char getAccion(Contexto actual){
        if( actual.ronda < 1 ){
            return this.inicial;
        }
        //System.out.println("Ifs: "+ reglas_if);
        for(Regla_If if_actual: reglas_if){
            
            try{
                if( if_actual.resolveCond(actual)){
                    return if_actual.accion;
                }
            } catch (Exception e){
                System.out.println("Error intentando validar condicion");                
            }
        }
        //System.out.println("No se cumplio ningun if -> Devuelve else ");
        return this.regla_else;
        
    }
}
