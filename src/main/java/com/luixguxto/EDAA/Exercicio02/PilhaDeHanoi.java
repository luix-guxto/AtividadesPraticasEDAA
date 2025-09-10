package com.luixguxto.EDAA.Exercicio02;

public class PilhaDeHanoi {
    private final int[] stack;
    private int top;
    private final int size;

    public PilhaDeHanoi(int size){
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int getTop() {
        if(isEmpty())
            return -1;
        return stack[top];
    }

    public void push(int item){
        if(!isEmpty()){
            if(top == size-1){
                System.out.println("Erro, pilha cheia");
                return;
            }
            else if (item > getTop()) {
                System.out.println("Erro, não pode empilhar um disco maior que o topo");
                return;
            }
            else
                stack[++top] = item;
        }
        else
            stack[++top] = item;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Erro, pilha vazia");
            return -1;
        }
        return stack[top--];
    }

    public int getLength(){
        return top + 1;
    }

    public int getSize(){
        return size;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < getLength(); i++) {
            sb.append(stack[i]);
            if(i != getLength() - 1)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}