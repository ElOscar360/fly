# El Ejército de Gunters del Rey Helado — Patrón Flyweight

## Estado intrínseco vs. extrínseco

| Estado | Dato | Dónde vive |
|---|---|---|
| **Intrínseco** (compartido, no cambia entre instancias) | `tipo` ("Normal" / "Con sombrero"), `sonido` ("Wenk") | Dentro de la clase `Gunter` (el Flyweight) |
| **Extrínseco** (único por cada Gunter simulado) | `x`, `y` (posición en el iceberg) | Dentro de la clase `PosicionGunter` (el Contexto), y se pasa como parámetro a `hacerSonido(x, y)` |

La clave del patrón es que **solo hay 2 combinaciones posibles de estado intrínseco** (Normal / Con sombrero), así que sin importar si simulamos 500 o 100.000 pingüinos, nunca necesitamos más de 2 objetos `Gunter` en memoria. Todo lo demás (la posición) se guarda en objetos `PosicionGunter`, que son mucho más livianos.

## Las cuatro piezas del patrón

- **Flyweight — `Gunter`**: guarda el estado intrínseco y expone `hacerSonido(int x, int y)`, que recibe el estado extrínseco como parámetro en vez de guardarlo.
- **Contexto — `PosicionGunter`**: guarda `x`, `y` y una referencia al `Gunter` compartido. Su método `activar()` delega en `gunter.hacerSonido(x, y)`.
- **Fábrica — `FabricaGunter`**: mantiene un `HashMap<String, Gunter>` como pool. Si el tipo ya existe lo reutiliza; si no, lo crea una única vez.
- **Cliente — `Main`**: genera el ejército de `PosicionGunter`, los activa, y reporta cuántos objetos `Gunter` se crearon en total frente al total de pingüinos simulados.

## Comparación con la versión sin Flyweight

La versión sin el patrón (`GunterCompleto`) guarda tipo, sonido, x e y en cada instancia, sin ningún tipo de reutilización: se crean 100.000 objetos completos en vez de 2 objetos compartidos + 100.000 contextos livianos.

| | Con Flyweight | Sin Flyweight |
|---|---|---|
| Objetos "grandes" (con estado intrínseco completo) creados | **2** | **100 000** |
| Objetos de contexto/posición creados | 100 000 (`PosicionGunter`, muy livianos: 2 int + 1 referencia) | 0 (todo va en el mismo objeto) |
| Memoria usada — antes de crear el ejército | 1.86 MB | 1.86 MB |
| Memoria usada — después de crear el ejército | 4.07 MB | 4.83 MB |

> Los valores de memoria son de una ejecución de referencia (JVM 21, heap 512 MB) y **van a variar** según tu máquina y tu JVM — hay que correr `MemoryDisplay` en tu propio equipo y reportar esos números. Es normal que la diferencia de MB no sea enorme en este ejercicio: el estado intrínseco aquí son solo dos `String` pequeños ("tipo" y "sonido"), así que cada objeto —con o sin Flyweight— pesa poco. **La demostración contundente del patrón no es el ahorro de MB sino el ahorro de objetos**: 2 Flyweights compartidos en vez de 100.000 objetos completos. Ese ahorro se vuelve dramático en memoria real cuando el estado intrínseco es pesado (texturas, sprites, bitmaps), que es el escenario clásico donde se usa Flyweight en motores gráficos.

## Diagrama de clases

Ver `diagrama_uml.png` / la imagen adjunta: `Main` usa `FabricaGunter` para obtener Gunters y crea los `PosicionGunter`; cada `PosicionGunter` mantiene una referencia al `Gunter` compartido.
