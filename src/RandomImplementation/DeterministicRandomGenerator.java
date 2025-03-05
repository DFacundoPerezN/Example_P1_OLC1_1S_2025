/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RandomImplementation;

import java.util.Random;

/**
* Implementación concreta de un generador de números aleatorios
determinista.
* Diseñado para ser simple y predecible, ideal para entornos educativos.
*/
public class DeterministicRandomGenerator implements RandomGenerator {
    // Semilla original
    private final long originalSeed;
    // Generador de números aleatorios
    private Random random;
    /**
    * Constructor privado para control estricto de creación.
    * @param seed Semilla para el generador
    */
    private DeterministicRandomGenerator(long seed) {
        this.originalSeed = seed;
        this.random = new Random(seed);
    }
    /**
    * Método de fábrica para crear generadores.
    * @param seed Semilla para el generador
    * @return Nuevo generador de números aleatorios
    */
    public static RandomGenerator create(long seed) {
        return new DeterministicRandomGenerator(seed);
    }

    @Override
    public double nextDouble() {
        return random.nextDouble();
    }
}