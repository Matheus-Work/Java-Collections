package br.com.quebec;
import java.util.Scanner;
public class Desafio1000 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int vetor[] = new int[1000];
        int pos = 0;
        while(pos<vetor.length-1){
            for(int j=0;j<t;j++) {
                vetor[pos] = j;
                pos++;
            }
        }
        for (int i = 0;i<vetor.length;i++){
            System.out.println("N[" + i + "] = " + vetor[i]);
        }
    }
}
