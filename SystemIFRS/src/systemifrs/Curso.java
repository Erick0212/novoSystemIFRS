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
}
