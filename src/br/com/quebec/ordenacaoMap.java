package br.com.quebec;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ordenacaoMap {
    public static void main(String[] args) {
    System.out.println("Ordem Aleatória");
    Map<String,Musica> minhasMusicas = new HashMap<>(){{
          put("Leonardo",new Musica("Esse alguém sou eu",3.10));
          put("Eduardo Costa",new Musica("Amor de violeiro",3.50));
          put("Gusttavo Lima",new Musica("Fala comigo bebê",2.30));
        }};
    for(Map.Entry<String,Musica> musica:minhasMusicas.entrySet())   {
        System.out.println(musica.getKey() +" "+ musica.getValue().getNome());
    }
        System.out.println("-----");
    System.out.println("Ordem de Inserção");

    Map<String,Musica> minhasMusicas1 = new LinkedHashMap<>(){{
          put("Leonardo",new Musica("Esse alguém sou eu",3.10));
          put("Eduardo Costa",new Musica("Amor de violeiro",3.50));
          put("Gusttavo Lima",new Musica("Fala comigo bebê",2.30));
        }};
    for(Map.Entry<String,Musica> musica:minhasMusicas1.entrySet())   {
        System.out.println(musica.getKey() +" "+ musica.getValue().getNome());
    }
        System.out.println("------");
    System.out.println("Ordem Alfabetica Autores");
    Map<String,Musica> minhasMusicas2 = new TreeMap<>(minhasMusicas1);
     for(Map.Entry<String,Musica> musica:minhasMusicas2.entrySet())   {
         System.out.println(musica.getKey() + " "+musica.getValue().getNome());
     }

        System.out.println("------");
        System.out.println("Ordem Aleatória Nomes das Músicas");
     Set<Map.Entry<String,Musica>> minhasMusicas3 = new TreeSet<>(new ComparatorNome());
     minhasMusicas3.addAll(minhasMusicas.entrySet());

     for(Map.Entry<String,Musica> musica:minhasMusicas3)   {
         System.out.println(musica.getKey() + " "+musica.getValue().getNome());
     }                                                                       

    System.out.println("Ordem Número da Página");
    }
}
class Musica{
    private String nome;
    private Double tempo;

    public Musica(String nome, Double tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public Double getTempo() {
        return tempo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return nome.equals(musica.nome) && tempo.equals(musica.tempo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tempo);
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nome='" + nome + '\'' +
                ", tempo=" + tempo +
                '}';
    }
}
class ComparatorNome implements Comparator<Map.Entry<String,Musica>> {

    @Override
    public int compare(Map.Entry<String, Musica> o1, Map.Entry<String, Musica> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

class ComparatorIdade implements Comparator<Musica> {
    @Override
    public int compare(Musica o1, Musica o2) {
          return Double.compare(o1.getTempo(), o2.getTempo());
    }
}