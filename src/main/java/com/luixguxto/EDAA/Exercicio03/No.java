package com.luixguxto.EDAA.Exercicio03;

public class No <T> {

    private final T elemento;
    private No<T> proximo;
    private No<T> anterior;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public T getElemento() {
        return this.elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
}
