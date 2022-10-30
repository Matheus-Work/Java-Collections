package br.com.quebec;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class exemploSet {

        public static void main(String[] args) {
            //Não segue a ordem de inserção
            //Nâo permite elementos duplicados
            //Não possui índice
            System.out.println("Crie um conjunto e adicione as notas");
            Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,7d,5d,0d,3.6));
            System.out.println(notas.toString());

            System.out.println("-------------------------");

            System.out.println("Confira se a nota 5 esta no conjunto: " + notas.contains(5d));

            System.out.println("-------------------------");

            System.out.println("Exiba a menor nota: " + Collections.min(notas));

            System.out.println("-------------------------");

            System.out.println("Exiba a maior nota: " + Collections.max(notas));

            System.out.println("-------------------------");

            Iterator<Double> iterator = notas.iterator();
            Double soma = 0.0;
            while(iterator.hasNext()){
                Double next = iterator.next();
                soma += next;
            }
            System.out.printf("Exiba as somas das notas: %.2f %n", soma);

            System.out.println("-------------------------");

            Double media = soma/notas.size();
            System.out.printf("Exiba a média das notas: %.2f %n", media);

            System.out.println("-------------------------");

            System.out.println("Remova a nota 0 e exiba  nova lista: ");
            notas.remove(0d);
            System.out.println(notas.toString());

            System.out.println("-------------------------");

            System.out.println("Remova as notas menores que 7 e exiba a lista: ");
            Iterator<Double> iterator1 = notas.iterator();
            while(iterator1.hasNext()){
                Double next = iterator1.next();
                if(next<7){
                    iterator1.remove();
                }
            }
            System.out.println(notas.toString());

            System.out.println("-------------------------");

            System.out.println("Exiba todas as notas na ordem em que foram informados");
            Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d,8.5,9.3,7d,5d,0d,3.6));
            System.out.println(notas2.toString());

            System.out.println("-------------------------");

            System.out.println("Exiba todas as notas na ordem crescente");
            Set<Double> notas3 = new TreeSet<>(notas2);
            System.out.println(notas3.toString());

            System.out.println("-------------------------");

            System.out.println("Apague tudo dos conjuntos 1 e 2 e confira se eles estão vazios");
            notas.clear();
            notas2.clear();
            System.out.println("Confira se o conjunto 1 esta vazio: " + notas.isEmpty());
            System.out.println("Confira se o conjunto 2 esta vazio: " + notas2.isEmpty());
            System.out.println("Confira se o conjunto 3 esta vazio: " + notas3.isEmpty());
        }
    }

