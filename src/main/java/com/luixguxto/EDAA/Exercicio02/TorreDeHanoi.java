package com.luixguxto.EDAA.Exercicio02;

public class TorreDeHanoi {
    private final PilhaDeHanoi origem, auxiliar, destino;
    private int numeroDeDiscos;
    private int numeroDePassos;
    public TorreDeHanoi(int numeroDeDiscos){
        this.numeroDeDiscos = numeroDeDiscos;
        origem = new PilhaDeHanoi(numeroDeDiscos);
        auxiliar = new PilhaDeHanoi(numeroDeDiscos);
        destino = new PilhaDeHanoi(numeroDeDiscos);
        iniciarTorreOrigem();
    }

    private void iniciarTorreOrigem() {
        for(int i = numeroDeDiscos; i > 0; i--)
            origem.push(i);
    }

    public void resolver(){
        System.out.print("Iniciando Resolução\nOrigem: ");
        origem.print();
        System.out.print("Auxiliar: ");
        auxiliar.print();
        System.out.print("Destino: ");
        destino.print();
        numeroDePassos = 0;
        mover(numeroDeDiscos, origem, destino, auxiliar, "origem", "destino", "auxiliar");
        System.out.print("Resolvido, total de Passos Necessários: "+numeroDePassos+"\nOrigem: ");
        origem.print();
        System.out.print("Auxiliar: ");
        auxiliar.print();
        System.out.print("Destino: ");
        destino.print();
    }
    private void mover(int numeroDeDiscos, PilhaDeHanoi origem, PilhaDeHanoi destino, PilhaDeHanoi auxiliar, String Sorigem, String Sdestino, String Sauxiliar){
        if(numeroDeDiscos > 0){
            numeroDePassos++;
            mover(numeroDeDiscos - 1, origem, auxiliar, destino, Sorigem,Sauxiliar,Sdestino);
            int disco = origem.pop();
            destino.push(disco);
            System.out.println("Moveu disco " + disco + " de " + Sorigem + " para " + Sdestino);
            mover(numeroDeDiscos - 1, auxiliar, destino, origem, Sauxiliar,Sdestino,Sorigem);
        }
    }
}
