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
}
