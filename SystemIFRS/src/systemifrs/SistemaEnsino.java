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
public class SistemaEnsino {
    private static void menu_ensino(String opcoes, SetorEnsino ensino, Aluno[] alunos, BufferedReader br) throws IOException {
        int opcao = SistemaIFRS.menu(opcoes, br);

        switch (opcao) {
            case 1:
                System.out.println("Qual o curso?");
                String nome_curso = br.readLine();
                Curso c = SistemaCurso.encontra_curso(ensino, nome_curso);

                if (c == null) {
                    System.err.println("Curso nÃ£o encontrado. Cadastre-o.");
                    c = SistemaCurso.cadastra_curso(ensino, br);
                }
                System.out.println("Qual o professor?");
                String nome_professor = br.readLine();
                Professor p = SistemaProfessor.encontra_professor(ensino, nome_professor);

                if (p == null) {
                    System.err.println("Professor nÃ£o encontrado. Cadastre-o.");
                    p = SistemaProfessor.cadastra_professor(br, ensino);
                }
                if (SistemaDisciplina.cadastra_disciplina(ensino, c, p, br)) {
                    System.out.println("Disciplina cadastrada com sucesso.");
                } else {
                    System.err.println("O limite de disciplinas foi excedido.");
                }
                break;
            case 2:
                SistemaAluno.novo_aluno(ensino, alunos, br);
                break;
            case 3:
                SistemaCurso.cadastra_curso(ensino, br);
                break;
            case 4:
                SistemaProfessor.cadastra_professor(br, ensino);
                break;
        }
    }


    
    
}
