# Hash tables

---

Las tablas hash son una estructura de datos que permite implementar operaciones similares a las que tendria un diccionario de manera optima.
Definimos a la tabla hash como un tipo de dato abstracto (ADT) que contiene las siguientes operaciones (al menos):  
1. Insert
2. Search
3. Delete  

Dada la naturaleza de la tabla hash, es una estructura de datos que puede llegar a proporcionar un running time
O(1) para la busqueda, en funcion de que tan buena sea la funcion utilizada para calcular el hash.  

Las tablas hash son una generalizacion de los arreglos y sus metodos de acceso directo a los elementos. En una tabla hash,
en lugar de asociar una key directamente a un indice en el arreglo, computamos el indice a partir de la llave haciendo
uso de una funcion hash.  
Si el arreglo base de la tabla fuera lo suficientemente grande en comparacion con la cantidad de elementos a almacenar,
podriamos llegara tener un indice en el arreglo para cada entrada (Direct addressing).  

## Direct address table

--- 

Supongamos que tenemos una lista de llaves de tamaño n de un universo mucho mayor y finito denominado U = {0, 1, ..., m-1}, donde m no es muy grande.
Podriamos tener un arreglo con m entradas donde cada entrada representa uno de los elementos en este universo T[0, 1, ..., m-1].  
Si en esta tabla quisieramos almacenar n elementos contenidos en U, bastaria con mapear la llave de cada uno de estos elementos
a una entrada en el array.

Con esta implementacion, logramos O(1) para cada una de las operaciones, asignando un valor 
nulo a aquellos elementos no contenidos en el conjunto S que queremos almacenar.  

![Direct addressing image](https://www.kindsonthegenius.com/wp-content/uploads/2020/09/Direct-Address-Table-1.jpg)

La desventaja es obvia, es impractico tratar de almacenar conjuntos S relativamente pequeños comparados con el
tamaño de U dado al desperdicio de espacio, y, si U es muy grande, puede que no contemos con la memoria
suficiente para crear un arreglo del tamaño de U.

##  Hash table

---

Supongamos que tenemos un universo U={0, 1, ..., m-1} de datos y un subconjunto S que deseamos almacenar
de tamaño mucho menor. Usando una tabla hash, podemos reducir el espacio necesario de 
O(|U|) hasta O(|S|).
Esto es posible si en lugar de mapear una llave directamente a una entrada en la tabla T[0, 1, ..., m-1]
utilizamos una funcion denominada **hash** que se encargue de mapear las llaves, hacia los indices en la tabla T, la cual
ahora podria contener solo |S| elementos.  
Es decir, el indice de una entrada en T cualquiera estara dado por la funcion ***h(key)***.
![Hash table image](https://khalilstemmler.com/img/blog/data-structures/hash-tables/hash-table.png)

Aunque hay un problema, multiples keys pueden llegar a producir el mismo hash en funcion de dicha funcion de hash y apuntar al mismo indice. Esto se conocen como colisiones y hay distintas tecnicas para resolverlas, siendo una de ellas 
el encadenamiento o **chaining**, donde en cada entrada de la tabla existe un apuntador hacia una lista enlazada donde
se almacenan los elementos que poseen el mismo hash
![Hash table chaining](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Hash_table_5_0_1_1_1_1_1_LL.svg/450px-Hash_table_5_0_1_1_1_1_1_LL.svg.png)

### Hashing con divisiones
Una de las maneras de implementar una funcion hash de forma sencilla es a traves de divisiones, mas concretamente haciendo uso del residuo de una division.  
Supongamos que queremos mapear un universo U que contiene una llave k entera hacia una tabla T con m espacios. Podemos hacer dicho mapeo realizando  

**h(k) = k mod m**  
 
Para esta implementacion debemos evitar valores de m que sean potencias de 2, prefiriendo numeros primos alejados de cualquier potencia de dos.
Por ejemplo, si |U| = 2000 podemos tomar un numero primo por arriba, o por debajo de este numero. Si tomamos un numero por encima, tendremos cierto espacio desperdiciado, mientras
que si tomamos un numero por debajo, tendremos algunas colisiones.
Si tomamos el numero 701, por ejemplo, tendremos en promedio 3 elementos en cada bucket de la tabla, lo cual podria ser una no tan mala idea.