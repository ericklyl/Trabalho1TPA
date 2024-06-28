/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author victoriocarvalho
 */
public class No<T> {
    //int altura foi adicionado posteriormente na etapa 4
    
    private T valor;
    private No<T> filhoDireita;
    private No<T> filhoEsquerda;
    private int altura;

    public No(T valor){
        this.valor = valor;
        // this.filhoDireita = null;
        // this.filhoEsquerda = null;
        this.altura = 1;            // vamos inicializar a altura como -1
    }
    
    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the filhoDireita
     */
    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param filhoDireita the filhoDireita to set
     */
    public void setFilhoDireita(No<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    /**
     * @return the filhoEsquerda
     */
    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param filhoEsquerda the filhoEsquerda to set
     */
    public void setFilhoEsquerda(No<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public int getAltura(){ // adicionado posteriormente para realizar o AppRelatorioArvoreBinaria e AppRelatorioAVL
        return altura;
    }

    public int obterAltura(){
        return obterAltura(this);
    }

    private int obterAltura(No<T> raiz) {
        if (raiz == null) {
            return -1;
        }
        else {
            int alturaDireita = obterAltura(raiz.getFilhoDireita());
            int alturaEsquerda = obterAltura(raiz.getFilhoEsquerda());
            return Math.max(alturaDireita,alturaEsquerda) + 1; //Retorne o maior entre as alturas + 1
        }
    }

    public void setAltura(int altura){ // adicionado posteriormente para realizar o AppRelatorioArvoreBinaria e AppRelatorioAVL
        this.altura = altura;
    }


}
