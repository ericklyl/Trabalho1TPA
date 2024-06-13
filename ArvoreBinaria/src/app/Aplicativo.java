package app;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;

import java.util.Scanner;
import java.util.Stack;

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
        Scanner disciplinaScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Disciplinas cadastradas: \n");
            System.out.println(disciplinas.caminharEmOrdem());
            try {
                Disciplina disciplinaEscolhida = null;
                while (disciplinaEscolhida == null) {
                    System.out.println("Digite o código da disciplina que deseja adicionar um novo pré-requisito (ou 0 para voltar ao menu): ");
                    int codDisciplina = disciplinaScanner.nextInt();
                    if (codDisciplina == 0) {
                        return;
                    }
                    disciplinaEscolhida = disciplinas.pesquisar(new Disciplina(codDisciplina, "", 0));
                    if (disciplinaEscolhida == null) {
                        System.out.println("A disciplina escolhida não foi encontrada. Por favor, insira um código válido.");
                    }
                }
                Disciplina preRequisito = null;
                while (preRequisito == null) {
                    System.out.println("Digite o código da disciplina que deseja adicionar como pré-requisito (ou 0 para voltar ao menu): ");
                    int codPreRequisito = disciplinaScanner.nextInt();
                    if (codPreRequisito == 0) {
                        return;
                    }
                    preRequisito = disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0));
                    if (preRequisito == null) {
                        System.out.println("A disciplina pré-requisito não foi encontrada. Por favor, insira um código válido.");
                    }
                }
                if (disciplinaEscolhida != null && preRequisito != null) {
                    if (disciplinaEscolhida.getPreRequisitos().contains(preRequisito)) {
                        System.out.println("A disciplina escolhida já possui esse pré-requisito!");
                    } else {
                        disciplinaEscolhida.addPreRequisito(preRequisito);
                        System.out.println("Pré-requisito cadastrado com sucesso");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao adicionar pré-requisito. Deseja tentar novamente? (s/n)");
                if (disciplinaScanner.next().equalsIgnoreCase("n")) {
                    return;
                }
            }
        }
    }

    //public void disciplinasCursadas() {}

    //public void consultarAlunoPorNome() {}

    //public void consultarAlunoPorMatricula() {}

    //public void removerAluno() {}

    public void menu() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Disciplina");
            System.out.println("3 - Cadastrar pré-requisito");
            System.out.println("4 - Verificar disciplinas cursadas por aluno");
            System.out.println("5 - Consultar aluno por nome");
            System.out.println("6 - Consultar aluno por matrícula");
            System.out.println("7 - Excluir aluno por matrícula");
            System.out.println("0 - Sair");
            System.out.println("Digite sua opção:");
            String opcao = s.nextLine();
            if (opcao.equals("1")) {
                CadastrarAluno();
            } else if (opcao.equals("2")) {
                CadastrarDisciplina();
            } else if (opcao.equals("3")) {
                CadastrarPreRequisito();
            } else if (opcao.equals("4")) {
                //disciplinasCursadas();
            } else if (opcao.equals("5")) {
                //consultarAlunoPorNome();
            } else if (opcao.equals("6")) {
               // consultarAlunoPorMatricula();
            } else if (opcao.equals("7")) {
                //removerAluno();
            } else if (opcao.equals("0")) {
                System.out.println("Obrigado por usar o sistema!");
                return;
            } else {
                System.out.println("Opção inválida, por favor digite novamente.");
            }
        }
    }

    public static void main(String[] args) {
        Aplicativo app = new Aplicativo();
        app.menu();
    }
}
