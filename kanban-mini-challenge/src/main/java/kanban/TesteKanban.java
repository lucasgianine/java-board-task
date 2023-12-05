package kanban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteKanban {
    public static void main(String[] args) {
        List<Tarefa> aFazer = new ArrayList<>();
        List<Tarefa> fazendo = new ArrayList<>();
        List<Tarefa> concluido = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        Integer opcao;

        do {
            System.out.println("""
                1 - Adicionar tarefa
                2 - Iniciar tarefa
                3 - Concluir tarefa
                4 - Exibir tarefas
                0 - Sair
                """);
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("""
                    ADICIONAR TAREFA
                    -----------------------
                    """);
                    System.out.println("Digite um id:");
                    Integer idTarefa = input.nextInt();

                    System.out.println("Digite o nome da tarefa:");
                    String nome = inputString.nextLine();

                    System.out.println("Digite a prioridade da tarefa:");
                    String prioridade = inputString.nextLine();
                    if (prioridade == null) {
                        System.out.println("Prioridade não pode ser nula!");
                        return;
                    }

                    System.out.println("Digite o responsável pela tarefa:");
                    String responsavel = inputString.nextLine();
                    if (responsavel == null) {
                        System.out.println("Responsável não pode ser nulo!");
                        return;
                    }

                    aFazer.add(new Tarefa(
                            idTarefa, nome, prioridade, responsavel)
                    );

                    System.out.println("Tarefa adicionada!");
                    break;
                case 2:
                    if (aFazer.size() < 1) {
                        System.out.println("Não há tarefas à fazer!");
                        break;
                    }

                    for (Tarefa tarefaAtual : aFazer) {
                        System.out.println("%d - %s".formatted(tarefaAtual.getId(), tarefaAtual.getNome()));
                    }

                    System.out.println("Digite o id da tarefa que deseja iniciar:");
                    Integer id = input.nextInt();

                    for (Tarefa tarefaAtual : aFazer) {
                        if (id.equals(tarefaAtual.getId())) {
                            fazendo.add(tarefaAtual);
                            aFazer.remove(tarefaAtual);
                            System.out.println("Tarefa iniciada!");
                            break;
                        }
                    }
                    break;
                case 3:
                    if (fazendo.size() < 1) {
                        System.out.println("Não há tarefas em andamento!");
                        break;
                    }

                    for (Tarefa tarefaAtual : fazendo) {
                        System.out.println("%d - %s".formatted(tarefaAtual.getId(), tarefaAtual.getNome()));
                    }

                    System.out.println("Digite o id da tarefa que deseja concluir:");
                    id = input.nextInt();

                    for (Tarefa tarefaAtual : fazendo) {
                        if (id.equals(tarefaAtual.getId())) {
                            concluido.add(tarefaAtual);
                            fazendo.remove(tarefaAtual);
                            System.out.println("Tarefa concluída!");
                            break;
                        }
                    }
                    break;
                case 4:
                    if (aFazer.size() < 1 && fazendo.size() < 1 && concluido.size() < 1) {
                        System.out.println("Não há tarefas no board!");
                        break;
                    }

                    System.out.println("""
                        A fazer
                        ---------------------------------------------
                        """);

                    for (Tarefa tarefaAtual : aFazer) {
                        System.out.println("""
                        Id %d
                        Nome: "%s"
                        Prioridade: "%s"
                        Responsável: "%s"
                        """.formatted(
                                tarefaAtual.getId(),
                                tarefaAtual.getNome(),
                                tarefaAtual.getPrioridade(),
                                tarefaAtual.getResponsavel()
                        ));
                    }

                    System.out.println("""
                        ---------------------------------------------
                        Em andamento
                        ---------------------------------------------
                        """);

                    for (Tarefa tarefaAtual : fazendo) {
                        System.out.println("""
                        Id %d
                        Nome: "%s"
                        Prioridade: "%s"
                        Responsável: "%s"
                        """.formatted(
                                tarefaAtual.getId(),
                                tarefaAtual.getNome(),
                                tarefaAtual.getPrioridade(),
                                tarefaAtual.getResponsavel()
                        ));
                    }

                    System.out.println("""
                        ---------------------------------------------
                        Concluída
                        ---------------------------------------------
                        """);

                    for (Tarefa tarefaAtual : concluido) {
                        System.out.println("""
                        Id %d
                        Nome: "%s"
                        Prioridade: "%s"
                        Responsável: "%s"
                        """.formatted(
                                tarefaAtual.getId(),
                                tarefaAtual.getNome(),
                                tarefaAtual.getPrioridade(),
                                tarefaAtual.getResponsavel()
                        ));
                    }

                    break;
                case 0:
                    System.out.println("Obrigado por utilizar!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
