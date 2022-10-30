package br.com.quebec;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

    public class ordenacaoSet {
        public static void main(String[] args) {
            System.out.println("Ordem Aleatória");
            Set<Serie> minhaSerie = new HashSet<>(){{
                add(new Serie("La Casa de Papel", "Suspense", 41));
                add(new Serie("Vikings", "Ação", 45));
                add(new Serie("See", "Drama", 50));
            }};

            System.out.println("-----------------------");

            for (Serie serie : minhaSerie) {
                System.out.println(serie.getNome() + " - " + serie.getGenero() +
                        " - " + serie.getTempoEpisodio());
            }
            System.out.println("Ordem de Inserção");
            Set<Serie> minhaSerie1 = new LinkedHashSet<>(){{
                add(new Serie("La Casa de Papel", "Suspense", 41));
                add(new Serie("Vikings", "Ação", 45));
                add(new Serie("See", "Drama", 50));
            }};
            for (Serie serie : minhaSerie1) {
                System.out.println(serie.getNome() + " - " + serie.getGenero() +
                        " - " + serie.getTempoEpisodio());
            }

            System.out.println("-----------------------");

            System.out.println("Ordem Natural (Tempo Episódio)");
            Set<Serie> minhaSerie2 = new TreeSet<>(minhaSerie1);
            for (Serie serie : minhaSerie2) {
                System.out.println(serie.getNome() + " - " + serie.getGenero() +
                        " - " + serie.getTempoEpisodio());
            }

            System.out.println("-----------------------");

            System.out.println("Ordem Natural (Nome/Genero/Tempo Episodio");
            Set<Serie> minhaSerie3 = new TreeSet<>(new comparatorNomeGeneroTempoEpisodio());
            minhaSerie3.addAll(minhaSerie);
            for (Serie serie : minhaSerie3) {
                System.out.println(serie.getNome() + " - " + serie.getGenero() +
                        " - " + serie.getTempoEpisodio());
            }
        }

    }


    class Serie implements Comparable<Serie>{
        private String nome;
        private String genero;
        private Integer tempoEpisodio;

        public Serie(String nome,String genero,Integer tempoEpisodio){
            this.nome = nome;
            this.genero = genero;
            this.tempoEpisodio = tempoEpisodio;
        }

        public String getNome(){
            return nome;
        }
        public String getGenero(){
            return genero;
        }
        public Integer getTempoEpisodio(){
            return tempoEpisodio;
        }

        @Override
        public String toString(){
            return "{" + "nome = '" + nome + '\''+
                    ", genero = '" + genero + '\'' +
                    ", tempoEpisodio = '" + tempoEpisodio + '\'' +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Serie serie = (Serie) o;
            return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, genero, tempoEpisodio);
        }

        @Override
        public int compareTo(Serie o) {
            // TODO Auto-generated method stub
            int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), o.getTempoEpisodio());
            if(tempoEpisodio != 0){
                return tempoEpisodio;
            }
            return this.getGenero().compareTo(o.getGenero());
        }
    }
    class comparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

        @Override
        public int compare(Serie o1, Serie o2) {
            // TODO Auto-generated method stub
            int nome = o1.getNome().compareTo(o2.getNome());
            if (nome != 0) return nome;

            int genero = o1.getGenero().compareTo(o2.getGenero());
            if (genero != 0) return genero;

            return Integer.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
        }
    }


