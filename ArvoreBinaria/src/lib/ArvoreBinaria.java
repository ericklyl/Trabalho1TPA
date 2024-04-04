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
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    protected No<T> atual = null;
    private Stack<No<T>> pilha = new Stack<>();

    private ArrayList<No<T>> pilhaNavegadora = null;
    private boolean primeiraChamada = true;
  
    public ArvoreBinaria(Comparator<T> comp) {

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
        return pesquisarRecursivo(raiz, valor);
    }

    private T pesquisarRecursivo(No<T> no, T valor) {
        if (no == null) {
            return null; // Valor não encontrado na árvore
        }

        int comparacao = comparador.compare(valor, no.getValor());
        if (comparacao == 0) {
            return no.getValor(); // Valor encontrado
        } else if (comparacao < 0) {
            return pesquisarRecursivo(no.getFilhoEsquerda(), valor); // Busca na subárvore esquerda
        } else {
            return pesquisarRecursivo(no.getFilhoDireita(), valor); // Busca na subárvore direita
        }
    }

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        return pesquisarRecursivo(raiz, valor, comparador);
    }

    private T pesquisarRecursivo(No<T> no, T valor, Comparator comparador) {
        if (no == null) {
            return null; // Valor não encontrado na árvore
        }

        int comparacao = comparador.compare(valor, no.getValor());
        if (comparacao == 0) {
            return no.getValor(); // Valor encontrado
        } else {
            // Como o comparador não é o mesmo da árvore, é necessário buscar em ambos os lados
            T encontradoEsquerda = pesquisarRecursivo(no.getFilhoEsquerda(), valor, comparador);
            T encontradoDireita = pesquisarRecursivo(no.getFilhoDireita(), valor, comparador);
            if (encontradoEsquerda != null) {
                return encontradoEsquerda; // Valor encontrado na subárvore esquerda
            } else {
                return encontradoDireita; // Valor encontrado na subárvore direita (ou não encontrado)
            }
        }
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
