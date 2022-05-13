# Data Structures
Las estructuras de datos son una manera de almacenar y estructurar datos en una computadora, tal que el uso de dichos
datos se puede realizar de manera eficiente.
Dependiendo los tipos de datos, asi como de la aplicacion que estos vayan a tener, elegimos una estructura de datos.  

Las estructuras de datos se pueden definir de 2 maneras:
1. Modelos matematicos/logicos o ADT
   Con esto, describimos el comportamiento de la DS, en un tipo de dato abstracto definimos atributos y operaciones,
   pero no implementaciones
2. Implementacion o tipo de dato concreto

## Linked List
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

### ArrayList
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
   

## Stack

## Queue

## Hash Map

### Hashing

# Tree

### Binary Tree

### Binary Search Tree

### Trie

### Fenwick Tree

### Segment Tree

### Heap

## Graphs
