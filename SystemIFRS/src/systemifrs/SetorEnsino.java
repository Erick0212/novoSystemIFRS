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
public class SetorEnsino {
    
    private Curso cursos[];
    private Professor professores[];
    private String diretor[];
    private String coordenador[];

    public boolean novoProfessor(Professor professor){
        for (int i = 0; i < professores.length; i++) {
            if(professores[i] == null){
                professores[i] = professor;
                return true;
            }
        }
        return false;
    }
    
    public boolean demitirProfessor(long siape){
        for (int i = 0; i < professores.length; i++) {
            if(professores[i] != null && professores[i].getSiape() == siape){
                professores[i] = null;
                return true;                
            }
        }
        return false;
    }
    
    public boolean novoCurso(Curso curso){
        for (int i = 0; i < cursos.length; i++) {
            if(cursos[i] == null){
                cursos[i] = curso;
                return true;
            }
        }
        return false;
    }
    
    public boolean removeCurso(String nome){
        for (int i = 0; i < cursos.length; i++) {
            if(cursos[i] != null && cursos[i].getNome().equalsIgnoreCase(nome)){
                cursos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public Professor[] getProfessores() {
        return professores;
    }

    public void setProfessores(Professor[] professores) {
        this.professores = professores;
    }

    public String[] getDiretor() {
        return diretor;
    }

    public void setDiretor(String[] diretor) {
        this.diretor = diretor;
    }

    public String[] getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String[] coordenador) {
        this.coordenador = coordenador;
    }

    public SetorEnsino(Curso[] cursos, Professor[] professores, String[] diretor, String[] coordenador) {
        this.cursos = cursos;
        this.professores = professores;
        this.diretor = diretor;
        this.coordenador = coordenador;
    }
}
