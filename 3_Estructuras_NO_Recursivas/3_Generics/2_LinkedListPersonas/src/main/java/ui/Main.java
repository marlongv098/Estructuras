package ui;

import persona.Persona;
import persona.Entidad;
import estructuras.ListaEnlazada;

public class Main {
    public static void main(String[] args) {

        // ─────────────────────────────────────────────────────────────
        // PASO 1: La misma clase ListaEnlazada funciona para tres tipos
        // ─────────────────────────────────────────────────────────────
        System.out.println("=== PASO 1: Una clase, tres tipos distintos ===\n");

        ListaEnlazada<Persona>  personas = new ListaEnlazada<>();
        ListaEnlazada<String>   palabras = new ListaEnlazada<>();
        ListaEnlazada<Integer>  numeros  = new ListaEnlazada<>();

        personas.agregar(new Persona("Ana",   22));
        personas.agregar(new Persona("Luis",  25));
        personas.agregar(new Persona("María", 19));

        palabras.agregar("Java");
        palabras.agregar("Generics");
        palabras.agregar("Estructuras");

        numeros.agregar(10);
        numeros.agregar(20);
        numeros.agregar(30);

        System.out.println("Personas : " + personas);
        System.out.println("Palabras : " + palabras);
        System.out.println("Números  : " + numeros);

        // ─────────────────────────────────────────────────────────────
        // PASO 2: obtener() devuelve el tipo correcto — sin casting
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n=== PASO 2: obtener() sin casting ===\n");

        Persona persona = personas.obtener(0);
        String  palabra = palabras.obtener(1);
        Integer numero  = numeros.obtener(2);

        System.out.println("Persona en [0] : " + persona);
        System.out.println("Palabra en [1] : " + palabra);
        System.out.println("Número  en [2] : " + numero);

        // ─────────────────────────────────────────────────────────────
        // PASO 3: eliminar() retorna el elemento con su tipo exacto
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n=== PASO 3: eliminar() retorna T ===\n");

        Persona eliminada = personas.eliminar(1);
        System.out.println("Persona eliminada    : " + eliminada);
        System.out.println("Lista tras eliminar  : " + personas);

        // ─────────────────────────────────────────────────────────────
        // PASO 4: buscar() usa equals() del tipo T
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n=== PASO 4: buscar() con equals() ===\n");

        System.out.println("Índice de 'Generics'          : " + palabras.buscar("Generics"));
        System.out.println("Índice de 20                  : " + numeros.buscar(20));
        System.out.println("Índice de Ana(22)             : " + personas.buscar(new Persona("Ana", 22)));
        System.out.println("Índice de Pedro (no existe)   : " + personas.buscar(new Persona("Pedro", 40)));

        // ─────────────────────────────────────────────────────────────
        // PASO 5: Entidad<T> — generics con sentido en el modelo
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n=== PASO 5: Entidad<T> — el id varía según el contexto ===\n");

        // El identificador puede ser String (cédula) o Integer (código)
        ListaEnlazada<Entidad<String>>  ciudadanos  = new ListaEnlazada<>();
        ListaEnlazada<Entidad<Integer>> estudiantes = new ListaEnlazada<>();

        ciudadanos.agregar(new Entidad<>("1020304050", "Ana López"));
        ciudadanos.agregar(new Entidad<>("9876543210", "Luis Gómez"));

        estudiantes.agregar(new Entidad<>(20231001, "María Ruiz"));
        estudiantes.agregar(new Entidad<>(20231045, "Carlos Vera"));

        System.out.println("Ciudadanos  : " + ciudadanos);
        System.out.println("Estudiantes : " + estudiantes);

        // Acceso directo al tipo del id — sin casting
        String  cedula = ciudadanos.obtener(0).getId();
        Integer codigo = estudiantes.obtener(1).getId();

        System.out.println("\nCédula  de ciudadano[0]  : " + cedula);
        System.out.println("Código  de estudiante[1] : " + codigo);

        // ─────────────────────────────────────────────────────────────
        // PASO 6: Manejo de errores con mensaje claro
        // ─────────────────────────────────────────────────────────────
        System.out.println("\n=== PASO 6: Manejo de IndexOutOfBoundsException ===\n");

        try {
            numeros.obtener(99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
    }
}

