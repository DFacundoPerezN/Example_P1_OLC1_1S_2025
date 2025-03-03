/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faxx
 */
public class Contexto {
    public int ronda;
    public int rondasTotales;
    public byte jugadorActual;
    public ArrayList<Character> historialJ1 ;
    public ArrayList<Character> historialJ2;
    
    public int seed;
    
    public Contexto(int rondas, int seed){
        this.ronda = 0;
        this.rondasTotales = rondas;
        this.seed = seed;
        this.historialJ1 = new ArrayList<>();
        this.historialJ2 = new ArrayList<>();
    }
    public void imprimirInfo(){
        System.out.println("Numero de ronda: "+ this.ronda
                            + "\n historial J1: "+ historialJ1
                            + "\n historial J2:"+ historialJ2
                            + "\n Total de rondas: "+ this.rondasTotales);
    }
}   
