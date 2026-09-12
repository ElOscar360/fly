package sinflyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import util.MemoryDisplay;

/**
 * CLIENTE de la versión SIN Flyweight. Mismas condiciones que la versión
 * con Flyweight (misma cantidad de Gunters) para que la comparación de
 * memoria sea justa.
 */
public class Main {

    private static final int TOTAL_GUNTERS = 100_000;
    private static final String[] TIPOS = {"Normal", "Con sombrero"};

    public static void main(String[] args) {
        Random random = new Random();
        List<GunterCompleto> ejercito = new ArrayList<>(TOTAL_GUNTERS);

        MemoryDisplay.mostrarMemoria("ANTES de crear el ejército (SIN Flyweight)");

        for (int i = 0; i < TOTAL_GUNTERS; i++) {
            String tipo = TIPOS[i % 2];
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            ejercito.add(new GunterCompleto(tipo, x, y));
        }

        MemoryDisplay.mostrarMemoria("DESPUÉS de crear el ejército (SIN Flyweight)");

        int muestra = 5;
        for (int i = 0; i < ejercito.size(); i++) {
            if (i < muestra || i >= ejercito.size() - muestra) {
                ejercito.get(i).hacerSonido();
            }
            if (i == muestra) {
                System.out.println("... (" + (ejercito.size() - 2 * muestra) + " Gunters más activados en silencio) ...");
            }
        }

        System.out.println();
        System.out.println("Total de pingüinos simulados: " + ejercito.size());
        System.out.println("Total de objetos GunterCompleto creados: " + ejercito.size());
    }
}
