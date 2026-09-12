package conflyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FÁBRICA FLYWEIGHT.
 * Controla el "pool" de Gunters ya creados. Si el tipo solicitado ya existe,
 * devuelve la instancia existente en vez de crear una nueva; solo crea un
 * objeto Gunter la primera vez que se pide un tipo nuevo.
 */
public class FabricaGunter {

    private final Map<String, Gunter> pool = new HashMap<>();

    public Gunter obtenerGunter(String tipo) {
        Gunter gunter = pool.get(tipo);
        if (gunter == null) {
            gunter = new Gunter(tipo);
            pool.put(tipo, gunter);
            System.out.println(">> Creando NUEVO objeto Flyweight para el tipo: " + tipo);
        }
        return gunter;
    }

    public int getCantidadGuntersCreados() {
        return pool.size();
    }
}
