import java.util.*;

public class SetExample {
    public static void main(String[] args) {

        //CREAR OBJETO CONJUNTO:
        /*
        Set<Integer> intSet = new HashSet<>();
        Set<String> vSet = new HashSet<>();
        Set mySet = new LinkedHashSet();
        HashSet<String> myHashset = new HashSet<>();
        */

        String [] friends =  {"Stuart", "Ivy", "Johnny", "Alex", "Igor", "Tanya"};
        String [] friends1 =  {"Stuart1", "Ivy1", "Johnny1", "Alex1", "Igor1", "Tanya1"};
        Integer[] integers1 = { 1, 3, 2, 4, 8, 9, 0 };
        Integer[] integers2 = {1, 3, 7, 5, 4, 0, 7, 5};


        Set<String> mySet1 = new HashSet<>(Arrays.asList(friends));
        System.out.println(mySet1);

        Set<Integer> mySet2 = new HashSet<>(Arrays.asList(integers1));
        System.out.println(mySet2);

        LinkedHashSet<String> mySet3 = new LinkedHashSet<>(Arrays.asList(friends));
        System.out.println(mySet3);

        HashSet<Integer> mySet4 = new HashSet<>(Arrays.asList(integers2));
        System.out.println(mySet4);

        Set<Integer> mySet5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8, 3));
        System.out.println(mySet5);

        Set<String> mySet6 = new HashSet<>(Arrays.asList(friends1));
        System.out.println(mySet6);

        // OPERACIONES
        Set<Integer> union = new HashSet<>(mySet2);
        union.addAll(mySet5);
        System.out.print("Union de los conjuntos ");
        System.out.println(union);

        Set<String> union1 = new HashSet<>(mySet1);
        union1.addAll(mySet6);
        System.out.print("Union de los conjuntos ");
        System.out.println(union1);

        Set<String> union2 = new HashSet<String>(mySet2);
        union2.addAll(mySet6);
        System.out.print("Union de los conjuntos ");
        System.out.println(union2);

        boolean b;
        b = union.containsAll(mySet5);
        System.out.print("El conjunto contiene los elementos: ");
        System.out.println(b);

        Set<Integer> interseccion = new HashSet<>(mySet2);
        interseccion.retainAll(mySet5);
        System.out.print("Interseccion de los conjuntos ");
        System.out.println(interseccion);

        Set<Integer> diferencia = new HashSet<>(mySet2);
        diferencia.removeAll(mySet5);
        System.out.print("Diferencia de los conjuntos ");
        System.out.println(diferencia);


        //PALABRAS UNICAS

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa una oración:");
        String oracion = scanner.nextLine();

        // Crear una instancia de la clase PalabrasUnicas
        PalabrasUnicas palabrasUnicas = new PalabrasUnicas();
        palabrasUnicas.agregarDesdeOracion(oracion);

        // Mostrar las palabras únicas
        palabrasUnicas.mostrarPalabras();

        scanner.close();
        */

        /*
        //PALABRAS UNICAS .TXT

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta del archivo de texto: ");
        String rutaArchivo = scanner.nextLine();

        // Crear instancia y procesar el archivo
        PalabrasUnicasT palabrasUnicasT = new PalabrasUnicasT();
        palabrasUnicasT.leerDesdeArchivo(rutaArchivo);

        // Mostrar el resultado
        palabrasUnicasT.mostrarPalabras();

        scanner.close();
        */


        /*
        // PALABRAS UNICAS ORDENADAS ALFABATICAMENTE .TXT

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta del archivo de texto: ");
        String rutaArchivo = scanner.nextLine();

        // Crear instancia y procesar el archivo
        PalabrasUnicasOrdenadas palabrasUnicas = new PalabrasUnicasOrdenadas();
        palabrasUnicas.leerDesdeArchivo(rutaArchivo);

        // Mostrar las palabras ordenadas
        palabrasUnicas.mostrarPalabrasOrdenadas();

        scanner.close();
        */


    }


}