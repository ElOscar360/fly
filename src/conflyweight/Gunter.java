package conflyweight;

/**
 * FLYWEIGHT.
 * Guarda únicamente el estado INTRÍNSECO: el tipo de Gunter y su sonido.
 * Este estado es compartido por miles de pingüinos, por lo que solo
 * existen 2 instancias de esta clase en toda la aplicación
 * ("Normal" y "Con sombrero").
 */
public class Gunter {

    private final String tipo;          // intrínseco: "Normal" o "Con sombrero"
    private final String sonido = "Wenk"; // intrínseco: compartido por todos

    public Gunter(String tipo) {
        this.tipo = tipo;
    }

    /**
     * El estado EXTRÍNSECO (x, y) no se guarda aquí: se recibe como
     * parámetro en el momento de usarlo, tal como exige el patrón Flyweight.
     */
    public void hacerSonido(int x, int y) {
        System.out.println(sonido + "! Gunter " + tipo + " en posición (" + x + ", " + y + ")");
    }

    public String getTipo() {
        return tipo;
    }
}
