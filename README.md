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
comparativa que pide el taller ver Wiki.
