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
public class Curso {
    
    private String nome;
    private String ppc;
    private Disciplina[] disciplinas;

    public boolean novaDisciplina(Disciplina newDisciplina){
        for (int i = 0; i < disciplinas.length; i++) {
            if(disciplinas[i] == null){
                disciplinas[i] = newDisciplina;
                return true;
            }
        }
        return false;
    }
    
    public boolean removeDisciplina(String nome){
        for (int i = 0; i < disciplinas.length; i++){
            if(disciplinas[i] !=  null && disciplinas[i].getNome().equalsIgnoreCase(nome) ){
                disciplinas[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean alterarPPC(String newPPC){
        this.ppc = newPPC;
        return true;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPpc() {
        return ppc;
    }

    public void setPpc(String ppc) {
        this.ppc = ppc;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Curso(String nome, String ppc, Disciplina[] disciplinas) {
        this.nome = nome;
        this.ppc = ppc;
        this.disciplinas = disciplinas;
    }
    
     public Curso(String nome, String ppc) {
        this.nome = nome;
        this.ppc = ppc;
        this.disciplinas = new Disciplina[10];
    }
     
     // toString

    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + ", ppc=" + ppc + ", disciplinas=" + disciplinas + '}';
    }
     
      // equals

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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.ppc, other.ppc)) {
            return false;
        }
        if (!Arrays.deepEquals(this.disciplinas, other.disciplinas)) {
            return false;
        }
        return true;
    }
    
    
}
