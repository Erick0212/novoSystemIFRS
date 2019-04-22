/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Erick_Nagoski
 */
public class SistemaProfessor {
     private static void menu_professor(String opcoes, int posicao_professor, SetorEnsino ensino, BufferedReader br) throws IOException {
        int opcao = SistemaIFRS.menu(opcoes, br);

        switch (opcao) {
            case 1:
                System.out.println("Qual a nova Ã¡rea, professor?");
                String area = br.readLine();

                if (nova_area(posicao_professor, ensino, area)) {
                    System.out.println("Ã�rea " + area + " cadastrada para o professor " + ensino.getProfessores()[posicao_professor].getNome());
                } else {
                    System.err.println("O limite de Ã¡reas foi atingido para o professor com siape " + ensino.getProfessores()[posicao_professor].getSiape());
                }
                break;
            case 2:
                System.out.println("Qual a disciplina?");
                String disciplina = br.readLine();
                System.out.println("Qual o curso?");
                String curso = br.readLine();
                System.out.println("Qual o nome do aluno?");
                String nome_aluno = br.readLine();
                System.out.println("Qual a matricula do aluno?");
                long matricula = Integer.parseInt(br.readLine());
                System.out.println("Qual a sua nova nota?");
                float nova_nota = Float.parseFloat(br.readLine());

                if (alterar_nota(ensino, disciplina, curso, matricula, nova_nota)) {
                    System.out.println("Nota "
                            + nova_nota
                            + " alterada para o aluno "
                            + nome_aluno
                            + " na disciplina "
                            + disciplina
                            + " do curso "
                            + curso
                            + ".");
                } else {
                    System.err.println("Aluno "
                            + nome_aluno
                            + " do curso "
                            + curso
                            + " nÃ£o foi encontrado. Ele nÃ£o estÃ¡ matriculado na disciplina "
                            + disciplina);
                }
                break;
            case 3:
                System.out.println("Qual a disciplina?");
                disciplina = br.readLine();
                System.out.println("Qual o curso?");
                curso = br.readLine();
                dar_notas(ensino, disciplina, curso, br);
                break;
            case 4:
                System.out.println("Qual a nova Ã¡rea, professor?");
                area = br.readLine();

                if (remover_area(posicao_professor, ensino, area)) {
                    System.out.println("Ã�rea " + area + " foi removido com sucesso para o professor " + ensino.getProfessores()[posicao_professor].getNome());
                } else {
                    System.err.println("A Ã¡rea " + area + " nÃ£o estava cadastrada para o professor com siape " + ensino.getProfessores()[posicao_professor].getSiape());
                }
                break;
        }
    }

    static Professor cadastra_professor(BufferedReader br, SetorEnsino ensino) throws IOException {
        Professor p;

        p = cria_professor(br);
        if (ensino.novoProfessor(p)) {
            System.out.println("Professor " + p.getNome() + " cadastrado.");
        } else {
            System.err.println("O limite de professores foi alcanÃ§ado.");
        }
        return p;
    }

    static Professor encontra_professor(SetorEnsino ensino, String nome_professor) {
        if (ensino.getProfessores() != null) {
            for (Professor p : ensino.getProfessores()) {
                if (p != null && p.getNome().equals(nome_professor)) {
                    return p;
                }
            }
        }
        return null;
    }

    static Professor cria_professor(BufferedReader br) throws IOException {
        
        System.out.println("Nome:");
        String nome = (br.readLine());
        
        System.out.println("SIAPE:");
        long siape = (Long.parseLong(br.readLine()));
        System.out.println("Quantas Ã¡reas?");
        int quantAreas = Integer.parseInt(br.readLine());

        String[] areas = new String [quantAreas];
        System.out.println("Informe as Ã¡reas:");
        for (int i = 0; i < quantAreas; i++) { 
                areas[i] = br.readLine();
        }
        
        Professor p = new Professor(nome, siape, areas);
        return p;
    }

    static int login_professor(int siape, SetorEnsino ensino, BufferedReader br) {
        for (int i = 0; ensino.getProfessores() != null
                && i < ensino.getProfessores().length; i++) {
            if (ensino.getProfessores()[i] != null
                    && ensino.getProfessores()[i].getSiape() == siape) {
                return i;
            }
        }
        return -1;
    }

    static boolean nova_area(int pos_professor, SetorEnsino ensino, String area) {
        if (ensino.getProfessores() != null) {
            String areas[] = ensino.getProfessores()[pos_professor].getAreas();

            for (int i = 0; areas != null && i < areas.length; i++) {
                if (areas[i] == null) {
                    areas[i] = area;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean remover_area(int pos_professor, SetorEnsino ensino, String area) {
        if (ensino.getProfessores() != null) {
            String areas[] = ensino.getProfessores()[pos_professor].getAreas();

            for (int i = 0; areas != null && i < areas.length; i++) {
                if (areas[i] != null && areas[i].equals(area)) {
                    areas[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean alterar_nota(SetorEnsino ensino, String nome_disciplina, String nome_curso, long matricula, float nova_nota) {
        return ensino.alterarNota(nome_curso, nome_disciplina, matricula, nova_nota);
    }

    static void dar_notas(SetorEnsino ensino, String disciplina, String nome_curso, BufferedReader br) throws IOException {
        Curso curso = SistemaCurso.encontra_curso(ensino, nome_curso);

        if (curso == null) {
            System.err.println("Curso " + nome_curso + " nÃ£o encontrado.");
        } else {
            Disciplina d = SistemaDisciplina.encontra_disciplina(curso, disciplina);

            if (d == null) {
                System.err.println("Disciplina " + disciplina + " nÃ£o encontrada.");
            } else {
                if (d != null && d.getAlunos() != null) {
                    System.out.println("Informe as notas dos alunos: ");
                    float notas[] = new float[d.getAlunos().length];
                    int i = 0;

                    while (i < d.getAlunos().length) {
                        System.out.println("Nota do aluno " + d.getAlunos()[i].getNome());
                        notas[i] = Float.parseFloat(br.readLine());
                        i++;
                    }
                    ensino.salvaNotas(notas, curso, d);
                }
            }
        }
    }

    
}
