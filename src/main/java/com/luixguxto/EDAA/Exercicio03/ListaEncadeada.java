package com.luixguxto.EDAA.Exercicio03;

public class ListaEncadeada<T> implements Lista <T> {

    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public T getPrimeiro() {
        if (primeiro == null) {
            return null;
        }
        return primeiro.getElemento();
    }

    @Override
    public T getUltimo() {
        if (ultimo == null) {
            return null;
        }
        return ultimo.getElemento();
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void inserir(T elemento) {
        No<T> novo = new No<>(elemento);
        if(estaVazia())
            primeiro = ultimo = novo;
        else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
        tamanho++;
    }

    public void inserir(T elemento, int index) {
        if(index == tamanho){
            inserir(elemento);
            return;
        }
        if(index == 0){
            No<T> novo = new No<>(elemento);
            novo.setProximo(primeiro);
            if(primeiro != null)
                primeiro.setAnterior(novo);
            primeiro = novo;
            if(tamanho == 0)
                ultimo = primeiro;
            tamanho++;
            return;
        }
        No<T> atual = getNo(index);
        No<T> anterior = atual.getAnterior();
        No<T> novo = new No<>(elemento);

        novo.setProximo(atual);
        atual.setAnterior(novo);
        novo.setAnterior(anterior);
        anterior.setProximo(novo);
        tamanho++;
    }

    private No<T> getNo(int index) {
        No<T> atual = primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public T obter(int index) {
        return getNo(index).getElemento();
    }

    public void remover(int index) {
        if (estaVazia())
            throw new IllegalStateException("ListaEncadeada está vazia");

        No<T> atual = getNo(index);
        No<T> anterior = atual.getAnterior();
        No<T> proximo = atual.getProximo();
        if(atual == primeiro) {
            primeiro = atual.getProximo();
            if (primeiro != null)
                primeiro.setAnterior(null);
        }else if(atual == ultimo){
            ultimo = ultimo.getAnterior();
            if(ultimo != null)
                ultimo.setProximo(null);
        }else{
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
        }
        tamanho--;
        if(tamanho == 0)
            primeiro = ultimo = null;
    }

    public void esvaziar() {
        primeiro = ultimo = null;
        tamanho = 0;
    }

    public boolean contem(T elemento) {
        for(No<T> atual = primeiro; atual != null; atual = atual.getProximo())
            if(atual.getElemento().equals(elemento))
                return true;
        return false;
    }

    public void imprimir() {
        StringBuilder out = new StringBuilder();
        for(No<T> atual = primeiro; atual != null; atual = atual.getProximo()){
            if(atual.getProximo() != null)
                out.append(atual.getElemento()).append(", ");
            else
                out.append(atual.getElemento()).append(";");
        }
        System.out.println(out);
    }
}
