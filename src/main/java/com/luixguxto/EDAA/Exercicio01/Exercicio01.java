package com.luixguxto.EDAA.Exercicio01;

import java.util.Random;

public class Exercicio01 {

    static long inicio, fim, duracao;

    static int buscaSequencial(int[] arr, int alvo){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == alvo)
                return i;
        }
        return -1; //não encontrado
    }

    static int buscaBinaria(int[] arr, int alvo){
        int inicio = 0;
        int fim = arr.length -1;
        while (inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(arr[meio] == alvo)
                return meio;
            else if(arr[meio] < alvo)
                inicio = meio + 1;
            else
                fim = meio -1;
        }
        return -1; //não encontrado
    }

    static int[] gerarArray(int tamanho){
        int[] arr = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] vetorOrdenado = gerarArray(1_000_000);

        inicio = System.nanoTime();
        int testeSequencialInicio = buscaSequencial(vetorOrdenado, 0);
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Teste Sequencial inicio do Array, Tempo: "+duracao+" valor: "+testeSequencialInicio);

        inicio = System.nanoTime();
        int testeSequencialFim = buscaSequencial(vetorOrdenado, vetorOrdenado.length - 1);
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Teste Sequencial fim do Array, Tempo: "+duracao+" valor: "+testeSequencialFim);

        inicio = System.nanoTime();
        int testeSequencialAleatorio = buscaSequencial(vetorOrdenado, new Random().nextInt(vetorOrdenado.length));
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Teste Sequencial indice Aleatorio, Tempo: "+duracao+" valor: "+testeSequencialAleatorio);

        inicio = System.nanoTime();
        int testeBinarioInicio = buscaBinaria(vetorOrdenado, 0);
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Teste Binario inicio do Array, Tempo: "+duracao+" valor: "+testeBinarioInicio);

        inicio = System.nanoTime();
        int testeBinarioFim = buscaBinaria(vetorOrdenado, vetorOrdenado.length - 1);
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Teste Binario fim do Array, Tempo: "+duracao+" valor: "+testeBinarioFim);

        inicio = System.nanoTime();
        int testeBinarioAleatorio = buscaBinaria(vetorOrdenado, new Random().nextInt(vetorOrdenado.length));
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Teste Binario fim do Array, Tempo: "+duracao+" valor: "+testeBinarioAleatorio);

        System.out.println("\n\n--- EXPERIMENTOS ---\n");
        System.out.println("Teste Sequencial");
        int alvo = vetorOrdenado.length-1;
        inicio = System.nanoTime();
        int a = 0;
        for(int i = 0; i < 1000; i++){
             a = buscaSequencial(vetorOrdenado, alvo);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Tempo total busca Sequencial final array: "+duracao+" Media de tempo por busca: "+(duracao/1000)+" valor: "+a);

        System.out.println("\nTeste Binario");
        inicio = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            a = buscaBinaria(vetorOrdenado, alvo);
        }
        fim = System.nanoTime();
        duracao = fim - inicio;
        System.out.println("Tempo total busca Binaria final array: "+duracao+" Media de tempo por busca: "+(duracao/1000)+" valor: "+a);
    }
}
