# Queue

---

Las queues o colas son un tipo de datos abstracto (ADT) que mantiene los elementos en el orden en que fueron ingresados.
Esta DS permite las siguientes operaciones:

|   Operacion   |   Running time    |
|------         |------             |
|   Enqueue     |   O(1)            |
|   Dequeue     |   O(1)            |
|   Peek        |   O(1)            |

Durante una operacion de enqueue, se agrega un nuevo elemento al final se la lista o coleccion, mientras que una operacion de 
dequeue extrae el primer elemento de la coleccion, lo cual hace que esta estructura de datos sea del tipo FIFO (FIrst In, First Out).
La operacion peek devuelve el elementyo al inicio de la cola sin extraerlo de la cola.

**Estructura de datos lineal**

##  Interfaz en lenguajes
|   Lenguaje    |   Interfaz    |
|---            |---            |
|Java           |Queue          |

