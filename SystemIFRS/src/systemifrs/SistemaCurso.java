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
public class SistemaCurso {
   static Curso cadastra_curso(SetorEnsino ensino, BufferedReader br) throws IOException {
        Curso c;

        c = cria_curso(ensino, br);
        if (ensino.novoCurso(c)) {
            System.out.println("Curso " + c.getNome());
        } else {
            System.out.println("O limite de cursos foi alcanÃ§ado.");
        }
        return c;
    }
    
    static Curso cria_curso(SetorEnsino ensino, BufferedReader br) throws IOException {
        System.out.println("Nome:");
        String nome = (br.readLine());
        
        System.out.println("PPC:");
        String Ppc = (br.readLine());
        Curso a = new Curso(nome, Ppc);
        Disciplina[] disciplinas = SistemaDisciplina.recebe_disciplinas(ensino, br);

        a.setDisciplinas(disciplinas);
        return a;
    }
    
    static Curso encontra_curso(SetorEnsino ensino, String nome) throws IOException {
        if (ensino.getCursos() != null) {
            for (Curso curso : ensino.getCursos()) {
                if (curso != null && curso.getNome().equals(nome)) {
                    return curso;
                }
            }
        }
        return null;
    }
    
    static void ver_cursos(SetorEnsino ensino) {
        Curso cursos[] = ensino.getCursos();

        if (cursos != null) {
            for (Curso curso : cursos) {
                if (curso != null) {
                    System.out.println("Curso " + curso.getNome());
                    System.out.println("PPC: " + curso.getPpc());
                    System.out.println("Disciplinas: ");
                    if (curso.getDisciplinas() != null) {
                        for (Disciplina d : curso.getDisciplinas()) {
                            if (d != null) {
                                System.out.println(d.getNome());
                            }
                        }
                    }
                }
            }
        } else {
            System.err.println("NÃ£o existem cursos cadastrados.");
        }
    }
    
    static void ver_notas(SetorEnsino ensino, Aluno alunos[], long matricula) {
        boolean aluno_nao_encontrado = true;

        if (alunos != null) {
            for (Aluno aluno : alunos) {
                if (aluno != null && aluno.getMatricula() == matricula) {//aluno matriculado
                    aluno_nao_encontrado = false;
                    Curso cursos[] = ensino.getCursos();

                    for (Curso curso : cursos) {
                        Disciplina disciplinas[] = curso.getDisciplinas();

                        for (Disciplina disciplina : disciplinas) {
                            Aluno a[] = disciplina.getAlunos();
                            int i = 0;

                            while (i != a.length && a[i].getMatricula() != matricula) {
                                i++;
                            }
                            float nota = disciplina.getNotas()[i];

                            System.out.println("A nota do aluno " + a[i].getNome() + " Ã© de " + nota + " na disciplina " + disciplina.getNome());
                            break;
                        }
                    }
                }
            }
            if (aluno_nao_encontrado) {
                System.err.println("Aluno nÃ£o matriculado no sistema.");
            }
        } else {
            System.err.println("Ainda nÃ£o existem alunos no sistema.");
        }
    }
    
    
    /*
    static void ver_cursos(SetorEnsino ensino){ 
        Curso cursos[] = ensino.getCursos();
        
        if(cursos != null){
            for (Curso curso : cursos) {
                if (curso != null){
                    System.out.println("Curso" + curso.getNome()
                                     + "\nPPC: " + curso.getPpc()
                                     + "\nDisciplinas: ");
                    if (curso.getDisciplinas()!= null) {
                        for (Disciplina d : curso.getDisciplinas()) {
                            if (d != null){
                                System.out.println(d.getNome());
                            }   
                        }
                    }
                }
            }
        }else{
            System.out.println("Não existem cursos cadastrados!");
        }
    }

    static void ver_notas(SetorEnsino ensino, Aluno[] alunos, long matricula) {
        boolean aluno_nao_encontrado =  true;
        
        if (alunos != null){
            for (Aluno aluno : alunos) {
                if (aluno != null && aluno.getMatricula() == matricula){
                    aluno_nao_encontrado = false;
                    Curso cursos[] = ensino.getCursos();
                    
                    for (Curso curso : cursos) {
                        Disciplina disciplinas[] = curso.getDisciplinas();
                        
                        for (Disciplina disciplina : disciplinas) {
                            Aluno a[] = disciplina.getAlunos();
                            int i = 0;
                            
                            while (i != a.length && a[i].getMatricula() != matricula){
                                i++;
                            }
                            float nota = disciplina.getNotas()[i];
                            
                            System.out.println("Nota do aluno " + a[i].getNome() + " é de " +nota+"na disciplina " + disciplina.getNome());
                            break;
                        }
                    }
                }
            }if (aluno_nao_encontrado){
            System.err.println("Aluno não matriculado no sistema!");
            }
        }else{
            System.err.println("Ainda não existem alunosno sistema!");
        }
    }*/
}
