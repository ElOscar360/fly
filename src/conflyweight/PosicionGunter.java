package conflyweight;

/**
 * CONTEXTO.
 * Guarda el estado EXTRÍNSECO (x, y), que es único para cada "pingüino"
 * simulado, más una referencia al Flyweight (Gunter) que reutiliza.
 * Es la clase que se instancia 100.000 veces, pero como es muy liviana
 * (dos enteros + una referencia) no representa un problema de memoria.
 */
public class PosicionGunter {

    private final int x;
    private final int y;
    private final Gunter gunter; // referencia compartida al Flyweight

    public PosicionGunter(int x, int y, Gunter gunter) {
        this.x = x;
        this.y = y;
        this.gunter = gunter;
    }

    public void activar() {
        gunter.hacerSonido(x, y);
    }
}
