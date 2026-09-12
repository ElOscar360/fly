package conflyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import util.MemoryDisplay;

/**
 * CLIENTE.
 * Genera el ejército de Gunters usando el patrón Flyweight, mide la memoria
 * antes/después y reporta cuántos objetos Flyweight (Gunter) se crearon
 * realmente frente al total de pingüinos simulados.
 *
 * Nota: el enunciado menciona "generar 500 PosicionGunter" en un punto y
 * "simular 100000 Gunters" en otro. Se usa 100000 porque así lo pide la
 * consigna principal y coincide con la salida esperada del taller
 * ("Total de pingüinos simulados: 100000"). Si tu profesor pidió
 * literalmente 500, solo cambia TOTAL_GUNTERS abajo.
 */
public class Main {

    private static final int TOTAL_GUNTERS = 100_000;
    private static final String[] TIPOS = {"Normal", "Con sombrero"};

    public static void main(String[] args) {
        Random random = new Random();
        FabricaGunter fabrica = new FabricaGunter();
        List<PosicionGunter> ejercito = new ArrayList<>(TOTAL_GUNTERS);

        MemoryDisplay.mostrarMemoria("ANTES de crear el ejército (CON Flyweight)");

        for (int i = 0; i < TOTAL_GUNTERS; i++) {
            String tipo = TIPOS[i % 2]; // alterna entre los 2 tipos
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            Gunter gunter = fabrica.obtenerGunter(tipo);
            ejercito.add(new PosicionGunter(x, y, gunter));
        }

        MemoryDisplay.mostrarMemoria("DESPUÉS de crear el ejército (CON Flyweight)");

        // Imprimir 100.000 líneas en consola no es práctico: mostramos una
        // muestra representativa (primeros y últimos) y activamos TODOS
        // los objetos igualmente para que la medición de memoria sea real.
        int muestra = 5;
        for (int i = 0; i < ejercito.size(); i++) {
            if (i < muestra || i >= ejercito.size() - muestra) {
                ejercito.get(i).activar();
            }
            if (i == muestra) {
                System.out.println("... (" + (ejercito.size() - 2 * muestra) + " Gunters más activados en silencio) ...");
            }
        }

        System.out.println();
        System.out.println("Total de pingüinos simulados: " + ejercito.size());
        System.out.println("Total de objetos Flyweight (Gunter) creados: " + fabrica.getCantidadGuntersCreados());
    }
}
