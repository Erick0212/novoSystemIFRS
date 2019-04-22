
package systemifrs;

/**
 *
 * @author erick
 */
public class SetorEnsino {
    
    private Curso cursos[];
    private Professor professores[];
    private String diretor;
    private String coordenador;

    
     public boolean novaDisciplina(Disciplina newDisciplina){
         for (int i = 0; i < cursos.length; i++) {
            if( cursos[i].getDisciplinas() == null){
                 cursos[i].getDisciplinas()[i] = newDisciplina;
                return true;
            }
        }
        return false;
    }
    
    public boolean removeDisciplina(String nome){
        for (int i = 0; i < cursos.length; i++){
            if(cursos[i].getDisciplinas()[i] !=  null && cursos[i].getDisciplinas()[i].getNome().equalsIgnoreCase(nome) ){
                cursos[i].getDisciplinas()[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean novoProfessor(Professor newProfessor) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null) {
                professores[i] = newProfessor;
                return true;
            }
        }
        return false;
    }

    public boolean novoCurso(Curso newCurso) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null) {
                cursos[i] = newCurso;
                return true;
            }
        }
        return false;
    }

    public boolean ApagaCurso (String nome) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getNome().equalsIgnoreCase(nome)){
                cursos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean demitirProfessor(long siape) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null && professores[i].getSiape() == siape) {
                professores[i] = null;
                return true;
            }
        }
        return false;
    }

    static boolean salvaNotas(float[] notas, Curso curso, Disciplina d) {
                for (Disciplina disciplina : curso.getDisciplinas()) {
                    if (disciplina.equals(d)){
                        disciplina.setNotas(notas);
                        return true;
                    }
                }
        return false;
    }
    
    public boolean alterarNota(String nomeCurso, String nomeDisciplina, long matricula, float newNota){
        int contador = 0;
        for (Curso curso : cursos) {
            if(curso.getNome().equalsIgnoreCase(nomeCurso) ){
                for (Disciplina disciplina : curso.getDisciplinas()) {
                    if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)){
                        for (Aluno aluno : disciplina.getAlunos()) {
                            contador++;
                            if (aluno.getMatricula() == matricula){
                                disciplina.getNotas()[contador] = newNota;
                                return true;
                            }
                        }
                    }                      
                }
            }
        }
        return false;
    }
    
    boolean matricularAluno(String nome_curso, Aluno a){
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome_curso)){
                for (Disciplina d : curso.getDisciplinas()) {
                    for (int i = 0; i < d.getAlunos().length; i++) {
                        if (d.getAlunos()[i] == null){
                            d.getAlunos()[i] = a;
                            return true;
                        }
                    }
                }
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public SetorEnsino(Curso[] cursos, Professor[] professores, String diretor, String coordenador) {
        this.cursos = cursos;
        this.professores = professores;
        this.diretor = diretor;
        this.coordenador = coordenador;
    }

    public SetorEnsino(String diretor, String coordenador) {
        this.diretor = diretor;
        this.coordenador = coordenador;
        this.professores = new Professor[10];
        this.cursos = new Curso[10];
    }



}
