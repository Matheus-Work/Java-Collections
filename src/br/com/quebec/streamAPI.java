package br.com.quebec;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class streamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1","6","8","2","5","3");

        System.out.println("Imprima todos os Elementos dessa Lista de String");
        /*
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
       /* numerosAleatorios.stream().forEach(s -> System.out.println(s));*/
        numerosAleatorios.forEach(System.out::println);

        System.out.println("------------");

        System.out.println("Pegue os 5 primeros números e coloque dentro de uma Set");
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("------------");

        System.out.println("Transformar todos os elementos dessa Lista de String para uma Lista de Inteiros");
        numerosAleatorios.stream().map(Integer::parseInt). //stream<String>
                                        collect(Collectors.toList()). //stream<Integer>
                                        forEach(System.out::println); //List<Integer>

        System.out.println("------------");

        System.out.println("Liste todos os números pares maiores que 2");
        /*List<Integer> NumerosParesMaioresQue2 =numerosAleatorios.stream().map(Integer::parseInt) //transformar essa lista de string em uma lista de inteiros
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if(i%2==0 && i>2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());*/
        List<Integer> NumerosParesMaioresQue2 =numerosAleatorios.stream().map(Integer::parseInt) //transformar essa lista de string em uma lista de inteiros
                .filter(i -> (i % 2 == 0 && i>2))
                .collect(Collectors.toList());

        System.out.println(NumerosParesMaioresQue2);

        System.out.println("--------");

        System.out.println("Mostre a média dos números");
        numerosAleatorios.stream().mapToInt(Integer::parseInt)
                .average().ifPresent(System.out::println);

        System.out.println("----------");

        System.out.println("Remova os números ímpares");
        List<Integer> NumerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        NumerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(NumerosAleatoriosInteger);
    }
}
