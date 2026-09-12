package util;

/**
 * Utilidad para medir y mostrar el uso de memoria de la JVM en un instante dado.
 * Fuerza al recolector de basura (System.gc()) antes de medir para que la
 * comparación entre "antes" y "después" sea lo más justa posible.
 */
public class MemoryDisplay {

    public static void mostrarMemoria(String etiqueta) {
        Runtime runtime = Runtime.getRuntime();

        // Sugerimos al recolector de basura que limpie objetos no usados
        // antes de medir, para que la lectura sea más estable y comparable.
        runtime.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;

        double memoriaUsadaMB = memoriaUsada / (1024.0 * 1024.0);

        System.out.printf("[%s] Memoria usada: %.2f MB%n", etiqueta, memoriaUsadaMB);
    }

    /**
     * Devuelve la memoria usada en MB (útil si se quiere calcular la diferencia
     * antes/después de forma programática, no solo imprimirla).
     */
    public static double obtenerMemoriaUsadaMB() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaUsada = runtime.totalMemory() - runtime.freeMemory();
        return memoriaUsada / (1024.0 * 1024.0);
    }
}
