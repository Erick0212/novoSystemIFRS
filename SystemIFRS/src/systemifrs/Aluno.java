/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

import java.util.Objects;

/**
 *
 * @author erick
 */
public class Aluno {
    
    private String nome;
    private Curso curso;
    private int anoIngresso;
    private boolean ehFormado;
    private long matricula;

    public Aluno() {
        
    }

    public String verificaStatus(){
        if(! ehFormado){
            return ("O aluno não completou os dréditos! ");
        }
        return "O aluno entrou no ano" + anoIngresso + "e já se formou.";
    }
    
    long obtemMatricula(){
        return matricula;
    }
    
    public Aluno(String nome, Curso curso, int anoIngressp, boolean ehFormado, long matricula) {
        this.nome = nome;
        this.curso = curso;
        this.anoIngresso = anoIngressp;
        this.ehFormado = ehFormado;
        this.matricula = matricula;
    }

    public Aluno(String nome, int anoIngresso, boolean ehFormado, long matricula) {
        this.nome = nome;
        this.anoIngresso = anoIngresso;
        this.ehFormado = ehFormado;
        this.matricula = matricula;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngressp) {
        this.anoIngresso = anoIngressp;
    }

    public boolean isEhFormado() {
        return ehFormado;
    }

    public void setEhFormado(boolean ehFormado) {
        this.ehFormado = ehFormado;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    
    // ToString

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", curso=" + curso + ", anoIngresso=" + anoIngresso + ", ehFormado=" + ehFormado + ", matricula=" + matricula + '}';
    }
    
    // Equals

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
        final Aluno other = (Aluno) obj;
        if (this.anoIngresso != other.anoIngresso) {
            return false;
        }
        if (this.ehFormado != other.ehFormado) {
            return false;
        }
        if (this.matricula != other.matricula) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
