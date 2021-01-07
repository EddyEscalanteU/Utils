package beans;

/*
    Created by IntelliJ IDEA.
    User: @EddyEscalanteU
    Date: 06/01/2021
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

public class lambda_01_01 {
    public static void main(String[] args) {
        Predicate<String> stringLeng = (s) -> s.length() < 10;
        System.out.println(stringLeng.test("Apples") + " - Apples is less than 10");

        //
        Consumer<String> consumerStr = (s) -> System.out.printf(s.toLowerCase());
        consumerStr.accept("CONsumer methOd aceptttsss");

        //
        Function<Integer, String> converter = (num) -> Integer.toString(num);
        System.out.println("length of 26" + converter.apply(26).length());

        //
        Supplier<String> s = () -> "Java is fun";
        System.out.println(s.get());

        //
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));

        //
        UnaryOperator<String> str = (msg) -> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
        ///--------------------------------------declarativo
        List<Integer> numeros = Arrays.asList(18, 6, 4, 15, 55, 78, 12, 9, 8);
        int contador = 0;
        for (int numero : numeros) {
            if (numero > 10) {
                contador++;
            }
        }
        System.out.println("Contador mayores de 10: " + contador);

        System.out.println("-----------------------------------");
        Predicate<Integer> isGreaterThan10 = number -> number > 10;
        Long result = numeros.stream()
                .peek(number -> System.out.println(number))//same
                .filter(isGreaterThan10)
                .peek(System.out::println)//same
                .count();
        System.out.println(result);
        System.out.println("-----------------------------------");
        Long result2 = numeros.stream().filter(num -> num > 10).count();
        System.out.println(result2);
        System.out.println("-----------------------------------");

        class Persona {
            private String id;
            private String nombre;

            public Persona() {
            }

            public Persona(String id, String nombre) {
                this.id = id;
                this.nombre = nombre;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            @Override
            public String toString() {
                return "Persona{" +
                        "id='" + id + '\'' +
                        ", nombre='" + nombre + '\'' +
                        '}';
            }
        }

        List<Persona> personas = Arrays.asList(
                new Persona("1", "Persona 1"),
                new Persona("2", "Persona 2"),
                new Persona("3", "Persona 3")
        );

        String uniqueNames = personas.stream()
                .map(persona -> persona.nombre)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(uniqueNames);

        System.out.println("----------------------------------------");

        Optional<String> nombre = personas.stream()
                .peek(System.out::println)
                .map(persona -> persona.nombre)
                .peek(System.out::println)
                .filter(name -> "Persona 3".equals(name))
                .peek(System.out::println)
                .distinct()
                .peek(System.out::println)
                .findFirst();

        if (nombre.isPresent()){
            System.out.println(nombre.get());
        }

    }
}
