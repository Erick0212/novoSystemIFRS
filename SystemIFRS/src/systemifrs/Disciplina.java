/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

import java.util.Arrays;
import java.util.Objects;

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

    public Disciplina(String nome, int ano, Professor professor, Aluno[] alunos) {
        this.nome = nome;
        this.ano = ano;
        this.professor = professor;
        this.alunos = alunos;
    }

    public Disciplina(String nome, int ano, Professor professor) {
        this.nome = nome;
        this.ano = ano;
        this.professor = professor;
    }


    
    
    // toString
    
    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", ano=" + ano + ", professor=" + professor + ", alunos=" + alunos + ", notas=" + notas + '}';
    }
        
    //equals
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Arrays.deepEquals(this.alunos, other.alunos)) {
            return false;
        }
        if (!Arrays.equals(this.notas, other.notas)) {
            return false;
        }
        return true;
    }
        
}
