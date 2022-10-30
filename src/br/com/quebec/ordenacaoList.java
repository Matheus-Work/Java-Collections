package br.com.quebec;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ordenacaoList {

        public static void main(String[] args) {
            List<gato> meusGatos = new ArrayList<>(){{
                add(new gato("Jon",18,"preto"));
                add(new gato("Jon",4,"zebra"));
                add(new gato("Joao",6,"cinza"));
            }};
            System.out.println("--Ordem de Inserção--");
            System.out.println(meusGatos);

            System.out.println("--Ordem Aleatória--");
            Collections.shuffle(meusGatos);
            System.out.println(meusGatos);

            System.out.println("--Ordem Natural (Nome)--");
            Collections.sort(meusGatos);
            System.out.println(meusGatos);

            System.out.println("--Ordem Natural (Idade)--");
            Collections.sort(meusGatos, new comparatorIdade());
            System.out.println(meusGatos);

            System.out.println("--Ordem Natural (Cor)--");
            Collections.sort(meusGatos, new comparatorCor());
            System.out.println(meusGatos);

            System.out.println("--Ordem Natural (Nome/Cor/Idade)--");
            Collections.sort(meusGatos, new comparatorNomeCorIdade());
            System.out.println(meusGatos);
        }
    }

    class gato implements Comparable<gato>{
        private String nome;
        private Integer idade;
        private String cor;

        public gato (String nome, Integer idade, String cor) {
            this.nome = nome;
            this.idade = idade;
            this.cor = cor;
        }
        public String getNome(){
            return nome;
        }
        public Integer getIdade(){
            return idade;
        }
        public String getCor(){
            return cor;
        }
        @Override
        public String toString(){
            return "Gato {" + "Nome = '" + nome + '\''+
                    ", Idade = '" + idade + '\'' +
                    ", Cor = '" + cor + '\'' +
                    '}';
        }
        @Override
        public int compareTo(gato o) {
            // TODO Auto-generated method stub
            return getNome().compareToIgnoreCase(o.getNome());
        }
    }
    class comparatorIdade implements Comparator<gato>{
        @Override
        public int compare(gato o1, gato o2) {
            // TODO Auto-generated method stub
            return Integer.compare(o1.getIdade(), o2.getIdade());
        }
    }
    class comparatorCor implements Comparator<gato>{
        @Override
        public int compare(gato o1, gato o2) {
            // TODO Auto-generated method stub
            return o1.getCor().compareToIgnoreCase(o2.getCor());
        }
    }
    class comparatorNomeCorIdade implements Comparator<gato> {
        @Override
        public int compare(gato o1, gato o2) {
            int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
            if(nome != 0) {
                return nome;
            }
            int cor = o1.getCor().compareToIgnoreCase(o2.getCor());
            if(cor != 0){
                return cor;
            }
            return Integer.compare(o1.getIdade(), o2.getIdade());
        }
    }

