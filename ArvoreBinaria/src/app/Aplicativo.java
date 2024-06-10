package app;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;

import java.util.Scanner;
public class Aplicativo {
    ArvoreBinaria<Aluno> alunos = new ArvoreBinaria<Aluno>(new ComparadorAlunoPorMatricula());
    ArvoreBinaria<Disciplina> disciplinas = new ArvoreBinaria<>(new ComparadorDisciplina());

    public void CadastrarAluno() {
        Scanner cadAluno = new Scanner(System.in);

        try {
            System.out.println("Digite o nome do aluno: ");
            String nomeAluno = cadAluno.nextLine();
            System.out.println("Digite a matrícula do aluno: ");
            int matriculaAluno = cadAluno.nextInt();
            Aluno aluno = new Aluno(matriculaAluno, nomeAluno);
            alunos.adicionar(aluno);
            System.out.println("Aluno " + nomeAluno + " cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno!");
        }
    }

    public void CadastrarDisciplina() {
        Scanner cadDisciplina = new Scanner(System.in);

        try {
            System.out.println("Digite o nome da disciplina:");
            String nomeDisciplina = cadDisciplina.nextLine();
            System.out.println("Digite a carga horária da disciplina:");
            int horaDisciplina = cadDisciplina.nextInt();
            System.out.println("Digite o código da disciplina:");
            int codigoDisciplina = cadDisciplina.nextInt();
            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, horaDisciplina);
            disciplinas.adicionar(disciplina);
            System.out.println("Disciplina " + nomeDisciplina + " cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao preencher os dados.");
        }
    }

    public void CadastrarPreRequisito() {
        System.out.println("Disciplinas cadastradas: \n");
        System.out.println(disciplinas.caminharEmOrdem());

        Scanner disciplina = new Scanner(System.in);
        try {
            System.out.println("Digite o código da disciplina que deseja adicionar um novo pré-requisito: ");
            int codDisciplina = disciplina.nextInt();
            System.out.println("Digite o código da disciplina que deseja adicionar como pré-requisito: ");
            int codPreRequisito = disciplina.nextInt();

            if (codDisciplina != codPreRequisito) {
                Disciplina disciplinaEscolhida = disciplinas.pesquisar(new Disciplina(codDisciplina, "", 0));
                Disciplina preRequisito = disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0));
                if (disciplinaEscolhida.getPreRequisitos().contains(preRequisito)) {
                    System.out.println("A disciplina escolhida já possui esse pré-requisito!");
                } else {
                    System.out.println("Pré-requisito cadastrado com sucesso");
                    disciplinaEscolhida.addPreRequisito(preRequisito);
                }
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("As disciplinas são iguais!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar pré-requisito");
        }
    }
}