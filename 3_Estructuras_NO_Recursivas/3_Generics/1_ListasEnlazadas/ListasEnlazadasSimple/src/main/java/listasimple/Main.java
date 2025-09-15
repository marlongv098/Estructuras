package listasimple;

import listasimple.Generica.ListG;

public class Main {
    public static void main(String[] args) {


        // Using ListG with Integer
        ListG<Integer> intList = new ListG<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        
        System.out.println("Integer List size: " + intList.size());
        intList.remove(20);
        System.out.println("Integer List size after removing 20: " + intList.size());

        // Using ListG with String
        ListG<String> stringList = new ListG<>();
        stringList.add("Hello");
        stringList.add("World");

        System.out.println("\nString List size: " + stringList.size());
        stringList.remove("Hello");
        System.out.println("String List size after removing \"Hello\": " + stringList.size());
    }
}
