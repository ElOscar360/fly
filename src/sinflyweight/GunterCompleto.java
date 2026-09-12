package sinflyweight;

/**
 * Versión SIN Flyweight: cada instancia guarda tanto el estado intrínseco
 * (tipo, sonido) como el extrínseco (x, y). No hay reutilización ni fábrica,
 * así que se crean 100.000 objetos completos en memoria.
 */
public class GunterCompleto {

    private final String tipo;
    private final String sonido = "Wenk";
    private final int x;
    private final int y;

    public GunterCompleto(String tipo, int x, int y) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    public void hacerSonido() {
        System.out.println(sonido + "! Gunter " + tipo + " en posición (" + x + ", " + y + ")");
    }
}
