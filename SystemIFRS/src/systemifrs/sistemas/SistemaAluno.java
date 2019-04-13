/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs.sistemas;

import systemifrs.sistemas.SistemaIFRS;
import java.io.BufferedReader;
import java.io.IOException;
import systemifrs.Aluno;
import systemifrs.Curso;
import systemifrs.SetorEnsino;

/**
 *
 * @author Erick_Nagoski
 */
public class SistemaAluno {
    
    public static void menu_alunos(String opcoes, SetorEnsino ensino, Aluno alunos[], BufferedReader br) throws IOException{
        int opcao = SistemaIFRS.menu(opcoes, br);
        
        switch (opcao){
            case 1:SistemaCurso.ver_cursos(ensino);
                break;
            case 2:
                System.out.print("Informe o número de matricula: ");
                long matricula = Long.parseLong(br.readLine());
                
                SistemaCurso.ver_notas(ensino, alunos, matricula);
                break;
        }
        
    }
    
    public static void novo_aluno(SetorEnsino ensino, Aluno[] alunos, BufferedReader br) throws IOException{
        Aluno a = cadastra_aluno(ensino, br, alunos);

        SistemaDisciplina.cadastra_disciplinas_aluno(br, ensino, a);
    }
    
    public static Aluno cadastra_aluno(SetorEnsino ensino, BufferedReader br, Aluno[] alunos) throws IOException {
        Aluno a = cria_aluno(ensino, br);

        for (int i = 0; i < alunos.length; i++) {
            Aluno aluno = alunos[i];

            if (aluno == null) {
                alunos[i] = a;
            }
        }
        return a;
    }

    public static Aluno cria_aluno(SetorEnsino ensino, BufferedReader br) throws IOException {
        
        System.out.println("Curso:");
        String nome_curso = br.readLine();
        Curso c = SistemaCurso.encontra_curso(ensino, nome_curso);

        Aluno a = new Aluno();
        
        a.setCurso(c);
        System.out.println("Matricula:");
        a.setMatricula(Long.parseLong(br.readLine()));
        System.out.println("Ingresso:");
        a.setAnoIngresso(Integer.parseInt(br.readLine()));
        a.setEhFormado(false);
        return a;
    }   
    
}
