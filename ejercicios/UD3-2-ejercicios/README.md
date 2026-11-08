# UD3-2 — Ejercicios de JDBC

Programas de la unidad 3 sobre las bases de datos `bdtareas` y `bdapps`.

## Requisitos

- JDK 21
- MariaDB o MySQL escuchando en `localhost:3306`
- Driver JDBC (Maven lo descarga): `org.mariadb.jdbc:mariadb-java-client:3.5.8`

## Configuración de la conexión

Edita `src/main/java/ud3/ejercicios/Conexion.java` y ajusta:

```java
private static final String USUARIO = "alan";
private static final String PASSWORD = "";
```

El resto de programas usan `Conexion.abrir("bdapps")` o
`Conexion.abrir("bdtareas")`.

## Orden de ejecución

1. `Ejer201` — SELECT de `bdtareas.tareas`.
2. `Ejer202` — crea `bdapps.ejecuciones` (ejecutar una sola vez).
3. `Ejer203` — añade `programas.ocupacion` (ejecutar una sola vez).
4. `Ejer204` — UPDATE de `programas` e INSERT de `ejecuciones`.
5. `Ejer205` — SELECT, mapeo a `ArrayList<Programa>` y salida JSON.
6. `Ejer206` — INSERT interactivo con control de código duplicado.
7. `Ejer207` — usa la función `nomprograma`.
8. `Ejer208` — usa la función `numejecuciones`.

`Ejer202` y `Ejer203` no son idempotentes: si se repiten, MariaDB devuelve
error de tabla o columna duplicada. Eso es lo esperado.

## Desde IntelliJ IDEA

1. Abre `UD3-2-ejercicios/pom.xml` como proyecto (o haz clic derecho sobre
   el `pom.xml` y elige **Add as Maven Project**).
2. Ejecuta cada clase con el botón **Run** de su método `main`.

## Desde terminal

```bash
JAR=~/.m2/repository/org/mariadb/jdbc/mariadb-java-client/3.5.8/mariadb-java-client-3.5.8.jar
javac -encoding UTF-8 -d out -cp "$JAR" $(find src -name '*.java')
java -cp "out:$JAR" ud3.ejercicios.Ejer201
```
