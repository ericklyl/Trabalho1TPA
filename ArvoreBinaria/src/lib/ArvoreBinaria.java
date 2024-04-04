/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * COMENTÁRIO TESTE KDOSKFSDKFSDKFSDKFSDKAFKSDFKSADFKSADKF
 */
package lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author Erick Loyola
 */
public class ArvoreBinariaExemplo<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    protected No<T> atual = null;
    private Stack<NoExemplo<T>> pilha = new Stack<>();
  
    public ArvoreBinariaExemplo(Comparator<T> comp) {

        comparador = comp;
    }
    
    @Override
    public void adicionar(T novoValor) {
        raiz = adicionarRecursivo(raiz,novoValor);
    }

    private No<T> adicionarRecursivo(No<T> no, T novoValor) {
    if (no == null) {
        return new No<>(novoValor);
    }
    if (comparador.compare(novoValor, no.getValor()) < 0) {
        no.setFilhoEsquerda(adicionarRecursivo(no.getFilhoEsquerda(), novoValor));
    } else if (comparador.compare(novoValor, no.getValor()) > 0) {
        no.setFilhoDireita(adicionarRecursivo(no.getFilhoDireita(), novoValor));
    }
    return no;
    }

    @Override
    public T pesquisar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public T pesquisar(T valor, Comparator comparador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
        
}
