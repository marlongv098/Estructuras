package main;

import gestor.Gestor;
import modelos.Ciudadano;
import modelos.Estudiante;
import modelos.Producto;

public class Main {
    public static void main(String[] args) {
        Gestor<Ciudadano> ciudadanos = new Gestor<>();
        ciudadanos.agregar(new Ciudadano("1001", "Ana", "Pérez"));
        ciudadanos.agregar(new Ciudadano("1002", "Luis", "Gómez"));
        System.out.println("Ciudadanos: " + ciudadanos);
        System.out.println("Índice de cédula 1002: " + ciudadanos.buscar(new Ciudadano("1002", "", "")));

        Gestor<Estudiante> estudiantes = new Gestor<>();
        estudiantes.agregar(new Estudiante(2024001, "Marlon", "Gómez", "Ingeniería de Sistemas"));
        estudiantes.agregar(new Estudiante(2024002, "Sara", "Ruiz", "Matemáticas"));
        System.out.println("\nEstudiantes: " + estudiantes);
        System.out.println("Eliminado: " + estudiantes.eliminar(0));
        System.out.println("Estudiantes tras eliminar: " + estudiantes);

        Gestor<Producto> productos = new Gestor<>();
        productos.agregar(new Producto("P01", "Teclado", 120000));
        productos.agregar(new Producto("P02", "Mouse", 45000));
        System.out.println("\nProductos: " + productos);
        System.out.println("Tamaño: " + productos.size());
    }
}
