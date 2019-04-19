/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs.sistemas;

import java.io.BufferedReader;
import java.io.IOException;
import systemifrs.Aluno;
import systemifrs.Curso;
import systemifrs.Disciplina;
import systemifrs.Professor;
import systemifrs.SetorEnsino;

/**
 *
 * @author Erick_Nagoski
 */
public class SistemaDisciplina {
    static boolean cadastra_disciplina(SetorEnsino ensino, Curso c, Professor p, BufferedReader br) throws IOException {
        Disciplina d = cria_disciplina(br, p);

        return ensino.novaDisciplina(d);
    }

    public static Disciplina cria_disciplina(BufferedReader br, Professor p) throws IOException, NumberFormatException {
        System.out.println("Quantos alunos tem na turma?");
        int quantAlunos = Integer.parseInt(br.readLine());

        System.out.println("Qual o nome da disciplina?");
        String nome_disciplina = br.readLine();
        System.out.println("Qual o ano/semestre da disciplina?");
        int ano = Integer.parseInt(br.readLine());
        Disciplina d = new Disciplina(nome_disciplina, ano, p);

        return d;
    }
    
    public static void cadastra_disciplinas_aluno(BufferedReader br, SetorEnsino ensino, Aluno a) throws IOException {
        System.out.print("Informe o nome do curso: ");
        String nome_curso = br.readLine();
        if (ensino.matricularAluno(nome_curso,a)) {
            System.out.println("Aluno matriculado nas disciplinas do curso.");
        } else {
            System.err.println("Curso nÃ£o encontrado. Cadastre-o.");
            Curso c = SistemaCurso.cadastra_curso(ensino, br);

            a.setCurso(c);
        }
    }
    
    public static Disciplina[] recebe_disciplinas(SetorEnsino ensino, BufferedReader br) throws IOException {
        Disciplina[] disciplinas = new Disciplina[40];

        System.out.println("Digite [1] para terminar e [2] para cadastrar disciplina");
        int op = Integer.parseInt(br.readLine());

        for (int i = 0; op != 1 && i < disciplinas.length; i++) {
            System.out.println("Qual o nome do professor da disciplina?");
            String nome_professor = br.readLine();
            Professor professor = SistemaProfessor.encontra_professor(ensino, nome_professor);

            if (professor == null) {
                System.err.println("O professor ainda nÃ£o foi cadastrado. Informe seus dados.");
                professor = SistemaProfessor.cria_professor(br);
                ensino.novoProfessor(professor);
            }
            disciplinas[i] = cria_disciplina(br, professor);
            System.out.println("\n Digite [1] para terminar e [2] para cadastrar disciplina");
            op = Integer.parseInt(br.readLine());
        }
        return disciplinas;
    }

    public static Disciplina encontra_disciplina(Curso curso, String disciplina) throws IOException {
        if (curso != null && curso.getDisciplinas() != null) {
            for (Disciplina c : curso.getDisciplinas()) {
                if (c != null && c.getNome().equals(disciplina)) {
                    return c;
                }
            }
        }
        return null;
    }

    
}
