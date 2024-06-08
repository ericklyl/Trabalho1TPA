package app;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Disciplina> preRequisitos;

    public Disciplina(String nome) {
        this.nome = nome;
        this.preRequisitos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public void addPreRequisito(Disciplina disciplina) {
        preRequisitos.add(disciplina);
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome;
    }

    public void listarPreRequisitos() {
        System.out.println("Pré-requisitos para " + nome + ":");
        if (preRequisitos.isEmpty()) {
            System.out.println("Nenhum");
        } else {
            for (Disciplina d : preRequisitos) {
                System.out.println(d);
            }
        }
    }
}
