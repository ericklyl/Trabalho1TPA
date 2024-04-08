package lib;

import java.util.Comparator;
import java.util.Stack;


/**
 *
 * @author Erick Loyola
 * @author Renzo Avance
 * @author Bruno Mian
 * @author Rodolfo Luiz
 * @author Thalisson
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    protected No<T> atual = null;
    private Stack<No<T>> pilha = new Stack<>();

    // private ArrayList<No<T>> pilhaNavegadora = null;
    // private boolean primeiraChamada = true;

    public ArvoreBinaria(Comparator<T> comp) {

        comparador = comp;
    }
    
    @Override
    public void adicionar(T novoValor) {
    if (raiz == null) {
        // Se a árvore estiver vazia, inicializa a pilha navegadora para métodos auxiliares da árvore.
        // pilhaNavegadora = new ArrayList<>();
        raiz = new No<>(novoValor); // Define o novo valor como a raiz da árvore.
        return;
    }

    atual = raiz;

    while (true) {
        // Compara o novo valor com o valor do nó atual.
        int comparacao = comparador.compare(novoValor, atual.getValor());

        if (comparacao < 0) {
            if (atual.getFilhoEsquerda() == null) {
                // Se não houver filho esquerdo do nó atual, adiciona o novo valor como filho esquerdo.
                atual.setFilhoEsquerda(new No<>(novoValor));
                return; // Encerra o método após adicionar o novo valor.
            }
            atual = atual.getFilhoEsquerda(); // Avança para o filho esquerdo.
        } else if (comparacao > 0) {
            if (atual.getFilhoDireita() == null) {
                // Se não houver filho direito do nó atual, adiciona o novo valor como filho direito.
                atual.setFilhoDireita(new No<>(novoValor));
                return; // Encerra o método após adicionar o novo valor.
            }
            atual = atual.getFilhoDireita(); // Avança para o filho direito.
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
        this.raiz = removerRecursivo(this.raiz, valor);
        return valor;
    }

    public No<T> removerRecursivo(No <T> no, T valor){
        // caso não tenha nenhum nó na arvore, importante fazer essa verificação
        if (no == null){
            return no;
        }

        if (this.comparador.compare(valor, no.getValor()) < 0) {
            no.setFilhoEsquerda(removerRecursivo(no.getFilhoEsquerda(), valor));
        } else if (this.comparador.compare(valor, no.getValor()) > 0) {
            no.setFilhoDireita(removerRecursivo(no.getFilhoDireita(), valor));
        } else {
            // nesse caso verificaremos se o nó não tem filhos, ou se ele tem apenas 1 filho
            if (no.getFilhoEsquerda() == null) {
                return no.getFilhoDireita();
            } else if (no.getFilhoDireita() == null) {
                return no.getFilhoEsquerda();
            }

            // agora nesse caso verificaremos se o nó tem 2 filhos (se chegou até aqui, é porque tem)
            no.setValor(acharMinimo(no.getFilhoDireita()).getValor());
            no.setFilhoDireita(removerRecursivo(no.getFilhoDireita(), no.getValor()));
        }

        return no;
    }

    

    public No<T> acharMinimo(No<T> no) {
        // lógica pra encontrar o minímo
        No<T> atual = no;
        while (atual.getFilhoEsquerda() != null) {
            atual = atual.getFilhoEsquerda();
        }
        return atual;
    }

    @Override
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(No<T> no){
        if (no == null) {
            return -1;
        }

        if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
            return 0;
        }

        int esquerda = alturaRecursiva(no.getFilhoEsquerda());
        int direita = alturaRecursiva(no.getFilhoDireita());

        return Math.max(esquerda, direita) + 1;
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
