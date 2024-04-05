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
    if (raiz == null) {
        // Se a árvore estiver vazia, inicializa a pilha navegadora para métodos auxiliares da árvore.
        pilhaNavegadora = new ArrayList<>();
        raiz = new No<>(novoValor); // Define o novo valor como a raiz da árvore.
        return;
    }

    noAtual = raiz;

    while (true) {
        // Compara o novo valor com o valor do nó atual.
        int comparacao = comparador.compare(novoValor, noAtual.getValor());

        if (comparacao < 0) {
            if (noAtual.getNoEsquerda() == null) {
                // Se não houver filho esquerdo do nó atual, adiciona o novo valor como filho esquerdo.
                noAtual.setNoEsquerda(new No<>(novoValor));
                return; // Encerra o método após adicionar o novo valor.
            }
            noAtual = noAtual.getNoEsquerda(); // Avança para o filho esquerdo.
        } else if (comparacao > 0) {
            if (noAtual.getNoDireita() == null) {
                // Se não houver filho direito do nó atual, adiciona o novo valor como filho direito.
                noAtual.setNoDireita(new No<>(novoValor));
                return; // Encerra o método após adicionar o novo valor.
            }
            noAtual = noAtual.getNoDireita(); // Avança para o filho direito.
        } else {
            // Se o comparador retornar 0, significa que o valor já existe na árvore, então não faz nada.
            return;
        }
    }
}

    @Override
    public T pesquisar(T valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    private T pesquisarRecursivo(No<T> no, T valor) {
        if (no == null) {
            return null;
        }

        int comparacao = comparador.compare(valor, no.getValor());
        if (comparacao == 0) {
            return no.getValor();
        } else if (comparacao < 0) {
            return pesquisarRecursivo(no.getFilhoEsquerda(), valor);
        } else {
            return pesquisarRecursivo(no.getFilhoDireita(), valor);
        }
    }

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        return pesquisarRecursivo(raiz, valor, comparador);
    }

    private T pesquisarRecursivo(No<T> no, T valor, Comparator comparador) {
        if (no == null) {
            return null;
        }

        int comparacao = comparador.compare(valor, no.getValor());
        if (comparacao == 0) {
            return no.getValor();
        } else {
            
            T encontradoEsquerda = pesquisarRecursivo(no.getFilhoEsquerda(), valor, comparador);
            T encontradoDireita = pesquisarRecursivo(no.getFilhoDireita(), valor, comparador);
            if (encontradoEsquerda != null) {
                return encontradoEsquerda;
            } else {
                return encontradoDireita;
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
