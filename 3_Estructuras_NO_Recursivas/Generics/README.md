# Generics

### ¿Por qué Generics?

- Generics permite que, al definir una clase, interfaz o método, se puedan utilizar tipos (clases o interfaces) como parámetros.  
- Busca independizar el proceso del tipo de datos sobre los que se aplica.  
- Definición de modelos generales.  

### ¿Y esto que acarrea?

* Al utilizar parámetros en la definición de clases, interfaces y métodos, se provee una nueva manera de reutilizar código.

### Beneficios de un código que usa Generics

- Chequeos de tipos más rigurosos en tiempo de compilación.  
- Eliminación de casts.  
- Implementación de algoritmos genéricos.  

```java
ArrayList lista = new ArrayList();
lista.add("Hola");
String cadena = (String) lista.get(0);

ArrayList<String> lista = new ArrayList<>();
lista.add("Hola");
String cadena = lista.get(0);
```

### ¿Se pueden utilizar tipos primitivos con Generics?

- No se pueden utilizar con primitivos pero sí con las clases que corresponden con ellos.
- No se puede hacer un genérico tipo `int`, pero sí un `Integer`.
- Autoboxing a las clases wrappers.

### Relación entre sobrecarga de métodos y Generics

- Si las operaciones realizadas por varios métodos sobrecargados son idénticas, pueden codificarse de manera compacta utilizando un método genérico.  
- Con base en los tipos de los argumentos que se pasan al método genérico, el compilador maneja cada llamada al método de manera apropiada.  
- Además de establecer las llamadas a los métodos, el compilador determina si las operaciones en el cuerpo del método se pueden aplicar a los elementos del tipo almacenado en el argumento de la clase genérica (arreglo, `ArrayList`).  

## Tipos Genéricos

```java
public class Caja {
  private Object objeto;

  public void modificar(Object objeto) {
    this.objeto = objeto;
  }

  public Object dar() {
    return objeto;
  }
}
```

### Problemas con una clase no genérica

- No se puede verificar en tiempo de compilación cómo se utiliza la clase.
- Una parte del código puede ubicar un tipo de objeto en la `Caja` y esperar que se retorne un objeto de ese mismo tipo, mientras que, por error, en otra parte del código se le puede pasar otro tipo de objeto, generando un error en tiempo de ejecución.  

### ¿Qué es mejor, un error en tiempo de compilación o en tiempo de ejecución?

- Un error en tiempo de compilación.  
- Errores en tiempo de compilación son más fáciles de encontrar.  

### Declaración de una clase genérica

- Al momento de declarar la clase, luego del nombre de ésta, se especifican los parámetros de tipos delimitados por `< >`.  
- Los objetos a ser utilizados dentro de la clase se reemplazan por el tipo de parámetro de entrada.  
- Estas variables de tipo pueden ser de cualquier tipo no primitivo.  
- El mismo procedimiento puede utilizarse para declarar interfaces genéricas.  

```java
public class Caja<T> {
  private T tipo;

  public void modificar(T tipo) {
    this.tipo = tipo;
  }

  public T dar() {
    return tipo;
  }
}
```

### Declaración de una variable de tipo genérica

```java
Caja<Integer> cajaEnteros;
Caja<Double> cajaReales;
Caja<String> cajaString;
Caja<Caja<String>> cajaCajaString;
```

### Creación de un objeto de tipo genérico

```java
Caja<Integer> cajaEnteros = new Caja<Integer>();
Caja<Integer> cajaEnteros = new Caja<>();
```

### ¿Por qué es válido `Caja<Integer> cajaEnteros = new Caja<>();`?

- Al invocar el constructor de una clase genérica se pueden reemplazar los argumentos de tipo con un conjunto vacío siempre y cuando el compilador pueda determinarlos o inferirlos a partir del contexto.  
- Como este conjunto vacío se denota como `< >` se denomina notación diamante.  

### Clase con múltiples parámetros de tipos

```java
Terna<T1, T2, T3> terna;
```

```java
public class Terna<T1, T2, T3> implements ITerna<T1, T2, T3> {
  private T1 primero;
  private T2 segundo;
  private T3 tercero;

  public Terna(T1 primero, T2 segundo, T3 tercero) {
    this.primero = primero;
    this.segundo = segundo;
    this.tercero = tercero;
  }
  
  public T1 obtenerPrimero() {
    return primero;
  }

  public T2 obtenerSegundo() {
    return segundo;
  }

  public T3 obtenerTercero() {
    return tercero;
  }
}
```

### ¿Se pueden restringir los tipos genéricos?

- Se pueden restringir los tipos genéricos de tal manera que se pueda trabajar con un tipo específico y sus subtipos.  
- Para establecer el límite superior, se coloca después del nombre del parámetro de tipo la palabra clave `extends` y el nombre de la clase o interfaz que representa dicha restricción.  

```java
public class CajaNumeros<T extends Number> {
  private T dato;

  public T darElemento() {
    return dato;
  }

  public void modificarDato(T dato) {
    this.dato = dato;
  }
}
```

### Tipos Raw

- Es el nombre de una clase o interfaz genérica cuando no se le pasa ningún argumento de tipo.  
- `Caja cajaCruda = new Caja();`  
- En este caso, `Caja` es un tipo raw de `Caja<T>`.  
- Un tipo de clase o interfaz no genérica no es un tipo raw.  

### Wildcards

- El signo de interrogación `?`, también denominado comodín o wildcard representa un tipo no conocido.  
- Ejemplos: `Collection<?>`, `List<? extends Number>`, `Pair<String,?>`.  
- Los comodines pueden utilizarse en gran variedad de situaciones, como tipo del parámetro, campo o variable local.  
