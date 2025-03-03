/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Faxx
 */
public class Partida {
    public String idEstrategia1;
    
    public String idEstrategia2;
    
    public int rondastotales;
    public int tentacion;
    public int recompensa;
    public int castigo;
    public int tonto;
    
    public Partida (String idEstrategia1, String idEstrategia2, int rondastotales, int tent, int recom, int cast, int tonto){
        this.idEstrategia1 = idEstrategia1;
        this.idEstrategia2 = idEstrategia2;
        this.rondastotales = rondastotales;
        this.tentacion = tent;
        this.recompensa = recom;
        this.castigo = cast;
        this.tonto = tonto;        
    }
    
    public void imprimirInfo(){
        System.out.println("-------------------------"+ 
                            "\n rondas: "+this.rondastotales+                            
                            "\n Estrategias: "+this.idEstrategia1+ " vs "+ this.idEstrategia2+
                            "\n mutual cop: "+this.recompensa+
                            "\n mutual defect: "+this.castigo+                            
                            "\n betray reward: "+this.tentacion+
                            "\n betray punishment: "+this.tonto);
    }
    
    
    public void jugar(int semilla, Estrategia jugador1,Estrategia jugador2){
        System.out.println("jugando con estrategias: "+ this.idEstrategia1 + this.idEstrategia2);
        Contexto contexto = new Contexto(this.rondastotales, semilla);
        
        while(contexto.ronda < contexto.rondasTotales){
            System.out.println("Jugando ronda");
            contexto.jugadorActual = 1;
            char accionJ1 = jugador1.getAccion(contexto);
            System.out.println(this.idEstrategia1+"("+accionJ1+")");
            contexto.jugadorActual = 2;
            char accionJ2 = jugador2.getAccion(contexto);
            
            //Espacio para guardar la puntuacion de la ronda
            
            contexto.historialJ1.add(accionJ1);
            contexto.historialJ2.add(accionJ2);
            
            contexto.ronda++;
            contexto.imprimirInfo();
        }
    }
}
