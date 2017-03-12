Solución al problema de batalla naval por dos métodos.

Se implementó la libreria aima https://github.com/aimacode/aima-java

Y se le dió solución por medio del modelamiento por restricciones (CSP) https://github.com/aimacode/aima-java/tree/AIMA3e/aima-core/src/main/java/aima/core/search/csp

Después de modelar el problema por restricciones (CSP)
El proceso para modelarlo por restricciones fue el siguiente:
  - Se procede a crear un número N de variables con la que contará el problema, siendo N el tamaño del tablero * tamaño de tablero
    Ejemplo, si se tiene un tablero 4 * 4, se crearan 16 variables.

  - Después se crea el dominio, el cual para este caso en particular sera de {0, 1}
    Siendo 0 el identificador de agua
    Siendo 1 el identificador de barco

  - Paso siguiente se le asiga a cada variables el dominio
    setDomain(Variable, Dominio);

  - Y por último, se procede a crear las restricciones
    - Primera restricción (La suma de las filas)
      Se recibe una configuración inicial de tablero en la cual se recibe la condición que debe tener cada una de las filas para obtener una solución correcta
      Ejemplo, se da un tablero como el siguiente
               0 1 0 0   1
               0 0 0 1   1
               0 0 0 1   1
               1 1 0 0   2

               Siendo los últimos números las condiciones de la cantidad de casillas ocupadas por barcos
               (desconociendo su ubicación)
               La entrada seria rowsConstraint {1, 1, 1, 2}

    - Segunda restricciones (La suma de las columnas)
      Se recibe una configuración inicial de tablero en la cual se recibe la condición que debe tener cada una de las columnas para obtener una solución correcta
      Ejemplo, se da un tablero como el siguiente
                0 1 0 0   1
                0 0 0 1   1
                0 0 0 1   1
                1 1 0 0   2

                1 2 0 2

                Siendo la última fila las condiciones de la cantidad de casillas ocupadas por barcos
                (desconociendo su ubicación)
                La entrada seria ColumnConstraint {1, 2, 0, 2}

    - Tercera y última restricción (Todos los barcos con sus respectivos tamaños deben ser usados)
      Conociendo que las soluciones pueden generar muchas veces tableros equivocados solo con cumplir las condiciones de filas y columnas, se hace una tercera restricción en la cual se verifica que todos los barcos con sus respectivos tamaños fueron usados
      Ejemplo,  se da un tablero como el siguiente
                0 1 0 1   2
                0 0 0 1   1
                0 0 0 1   1
                1 1 0 0   2

                1 2 0 3

                Siendo la lista de barcos la siguiente
                NumBarcos = 3
                Tamaños = {1, 2, 3}

                Lo cual indica, hay 3 barcos.
                1 de tamaño uno, 1 de tamaño dos y 1 de tamaño tres.

Como último paso se procede a solucionarlo por medio de la implementación BacktrackingStrategy.java de la misma libreria como primer método
y como segundo método se le da solución por medio de la implementacion ImprovedBacktrackingStrategy.java de la misma liberia.


