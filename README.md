# Ejército de Gunters — Patrón Flyweight

Estructura del repositorio (tal como la pide el taller: un package con Flyweight y otro sin él):

```
src/
  util/
    MemoryDisplay.java        # mide memoria de la JVM antes/después
  conflyweight/
    Gunter.java                # Flyweight (estado intrínseco)
    PosicionGunter.java        # Contexto (estado extrínseco)
    FabricaGunter.java         # Fábrica Flyweight (pool)
    Main.java                  # Cliente, versión CON el patrón
  sinflyweight/
    GunterCompleto.java        # Todo el estado en una sola clase
    Main.java                  # Cliente, versión SIN el patrón
```

## Compilar

```bash
javac -d bin src/util/*.java src/conflyweight/*.java src/sinflyweight/*.java
```

## Ejecutar

```bash
# Versión con Flyweight
java -cp bin conflyweight.Main

# Versión sin Flyweight
java -cp bin sinflyweight.Main
```

Ambas imprimen la memoria usada antes/después de crear el ejército y, al final,
cuántos objetos se crearon en total. Usa esos números para llenar la tabla
comparativa que pide el taller (ver `EXPLICACION_WIKI.md`).

## Nota sobre la cantidad de Gunters

El enunciado menciona en un punto "generar 500 PosicionGunter" y en otro
"simular 100000 Gunters" (y la salida esperada del taller muestra
`Total de pingüinos simulados: 100000`). Se dejó `TOTAL_GUNTERS = 100_000`
en ambos `Main` porque coincide con la consigna principal y con la salida
esperada. Si tu profesor exige literalmente 500, solo cambia esa constante
al inicio de cada clase `Main`.

## Diagrama UML

El diagrama de clases de la solución (Main, FabricaGunter, PosicionGunter,
Gunter y sus relaciones) está en la conversación de Claude; expórtalo como
imagen para subirlo al entregable 1 (Diagrama de Clases UML).
