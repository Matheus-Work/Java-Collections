package br.com.quebec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class desafiosList {
        public static void main(String[] args) {
            Scanner scan = new Scanner (System.in);
            double temperatura;
            List<Double> temperaturas = new ArrayList<>();
            for(int i = 0; i<6;i++)
            {
                System.out.printf("Informe a %oº temperatura ",i+1);
                temperatura = scan.nextDouble();

                temperaturas.add(temperatura);
            }
            System.out.println("-----------------");

            //exibindo todas as temperaturas:
            System.out.print("Todas as temperaturas: ");
            temperaturas.forEach(t -> System.out.print(t + " "));

            //calculando e exibindo a média das temperaturas:
            double media = temperaturas.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0d);
            System.out.printf("\nMédia das temperaturas: %.1f\n", media);

            //exibindo as temperaturas acima da média
            System.out.print("Temperaturas acima da média: ");
            temperaturas.stream()
                    .filter(t -> t > media)
                    .forEach(t -> System.out.printf("%.1f ", t));

            //exibindo o mês das temperaturas acima da média por extenso:
            System.out.println("\n\nMeses das temperaturas acima da média: ");
            Iterator<Double> iterator = temperaturas.iterator();
        }
    }


