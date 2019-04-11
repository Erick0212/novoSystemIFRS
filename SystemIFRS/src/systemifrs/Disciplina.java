/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

/**
 *
 * @author erick
 */
public class Disciplina {
    
    private String nome;
    private int ano;
    private Professor professor;
    private Aluno alunos[];
    private float notas[];
    
    public boolean novoAluno(Aluno newAluno){
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null){
                alunos[i] = newAluno;
                return true;
            }
        }
        return false;
    }
    
    public boolean removeAluno(long matricula){
        for (int i = 0; i < alunos.length; i++) {
            if(alunos[i] != null && alunos[i].getMatricula() == matricula){
                alunos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean registrarNota(float nota, long matricula){
        for (int i = 0; i < notas.length; i++) {
            if(alunos[i].getMatricula() == matricula){
                notas[i] = nota;
                return true;
            }
        }
        return false;
    }
    
    public boolean alterarNota(long matricula, float newNota ){
        return registrarNota(newNota, matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    public Disciplina(String nome, int ano, Professor professor, Aluno[] alunos, float[] notas) {
        this.nome = nome;
        this.ano = ano;
        this.professor = professor;
        this.alunos = alunos;
        this.notas = notas;
    }
       
}
