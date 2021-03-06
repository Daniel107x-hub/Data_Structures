# Lists

---

Las listas son un ADT que tiene la siguientes propiedades:
1) Almacenar en elementos de cierto tipo
2) Capacidad de modificar o eliminar un elemento en una posicion dada
3) Leer elementos en una posicion determinada

Los arrays, son una DS que tiene esta capacidad, sin embargo, recordemos que los arrays tienen un tamaño determinado aunque
aun asi es posible implementar una lista con arrays haciendo uso de arrays dinamicos.
Una lista puede ser implementada de las siguientes maneras:

1) Lista basada en arrays (ArrayList)
2) Lista enlazada (LinkedList)
3) Lista doblemente enlazada (Doubly LinkedList)

La lista debera de tener la capacidad de ejecutar las siguientes operaciones:
1) Insercion
2) Lectura
3) Eliminacion
4) Modificacion

---

### ArrayList
- Java: ArrayList

La implementacion basada en arreglos hace uso de arreglos dinamicos para solventar el problema de que los arreglos tienen una capacidad inmutable,
para hacer esto, una vez que el arreglo llegue a cierta capacidad, se crea un nuevo arreglo con una nueva capacidad mayor
y todos los elementos del arreglo original se copian a este nuevo arreglo.
Algo similar es posible durante la eliminacion de datos, donde una vez que solo se este usando cierto
porcentaje de la capacidad total del array, podemos redimensionarlo a uno mas pequeño.

Pros:
1) Acceso inmediato: Al hacer uso de arreglos, tenemos un tiempo de acceso O(1) para lectura, escritura y modificacion
2) No se hace uso de memoria adicional para almacenar apuntadores, o referencias a otros objetos, como en el caso
   de las listas enlazadas

Contras:
1) Cierto desperdicio de espacio ya que el tamaño del arreglo se define con anterioridad, lo cual puede implicar que no todo
   el espacio dedicado al arreglo este siendo utilizado
2) A pesar de que en promedio la insercion tomara un tiempo constante, en los casos donde el arreglo alcance su maxima capacidad sera
   necesario mover los elementos a otro arreglo. En dichos casos, la insercion o eliminacion pueden tomar un tiempo O(n), aunque
   el costo amortizado sigue siendo O(1)
   
|   Operacion   |   Running time    |   Comentarios |
|---            |---                |---            |
|   Insercion   |   O(1)            |Tiempo amortizado debido a que requiere resizing, en el peor caso toma O(n)    |
|   Acceso      |   O(1)            |Debido a que la base es un array, el tiempo de acceso es constante|   
|   Eliminacion |   O(n)            |Debido a reubicacion de elementos contiguos|
|   Edicion     |   O(1)            |Debido a acceso aleatorio constante|

---

### Singly Linked List
Para tratar de solventar el problema con el uso de espacio de la implementacion basada en arreglos, en lugar de
hacer uso de arreglos buscaremos hacer un uso dinamico de la memoria. Para ellos, haremos uso de un nuevo
elemento llamado Nodo, donde cada nodo correspondera con uno de los elementos en la lista y a su vez, almacenara
informacion sobre el siguiente elemento en la lista.
Es decir, crearemos nodos a medida que vayamos agregando elementos a la lista, en lugar de tener un espacio
predeterminado para la misma.

Pros:
1) Tiempo de insercion constante O(1), siempre podemos mantener una referencia al ultimo/primer elemento de la lista e insertar nuevos elementos ahi.
2) Mejor manejo de memoria, aunque ahora debemos almacenar una referencia al siguiente elemento

Contras:
1) Tiempo de acceso a datos ahora es lineal O(n), ya que debemos de recorrer la lista para encontrar un elemento en particular

|   Operacion   |   Running time    |   Comentarios |
|---            |---                |---            |
|   Insercion   |   O(1)            |Insercion en el head de la lista|
|   Acceso      |   O(n)            |Es necesario buscar el elemento en la lista|   
|   Eliminacion |   O(n)            |Es necesario buscar el elemento en la lista|
|   Edicion     |   O(n)            |Es necesario buscar el elemento en la lista|

---

### Doubly linked list
-  Java: LinkedList

Esta es una variante de la lista enlazada simple donde ademas de apuntar al elemento siguiente de la lista, existe un
apuntador a la cola de la lista y de cada elemento, a su elemento previo. Esto facilita las operaciones de remover elementos, asi
como de insertarlos en una posicion dada

1) Tiempo de insercion O(1)
2) Lectura O(n)
3) Eliminacion O(n)
4) Modificacion O(n)

|   Operacion   |   Running time    |   Comentarios |
|---            |---                |---            |
|   Insercion   |   O(1)            |Insercion en el head de la lista|
|   Acceso      |   O(n)            |Es necesario buscar el elemento en la lista|   
|   Eliminacion |   O(n)            |Es necesario buscar el elemento en la lista|
|   Edicion     |   O(n)            |Es necesario buscar el elemento en la lista|

##  Interfaz en lenguajes
|   Lenguaje    |   Interfaz    |
|---            |---            |
|Java           |<ol><li>ArrayList</li><li>LinkedList(Doubly linked list)</li></ol>|
