package com.luixguxto.EDAA.Exercicio02;

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        int tamanhoTorre = 0;
        try{
            System.out.println("Qual o tamanho da torre que gostaria de testar?");
            tamanhoTorre = new Scanner(System.in).nextInt();
        }catch (Exception e){
            System.out.println("Numero Invalido, tente novamente");
            System.exit(520);
        }
        if(tamanhoTorre > 22) {
            System.out.println("Numero muito grande, demoraria mais de 1 minuto pra resolver");
            System.exit(404);
        }
        TorreDeHanoi hanoi = new TorreDeHanoi(tamanhoTorre);
        hanoi.resolver();
    }
}