/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

import java.util.Scanner;

/**
 *
 * @author erick
 */
public class SystemIFRS {

    public static Scanner s = new Scanner (System.in);
    
    public static void verificaUser(){
        while(true){
            System.out.println("\nVocê é Professor [1] ou Aluno [2]?");
            int opc = s.nextInt();
            
            switch (opc){
                case 1:
                    mainProfessor();
                case 2:
                    mainAluno();
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }    
        }
    }
    
    public static void mainAluno(){
        int opc = 20;
        while(opc != 0){
            
            System.out.println("\nDeseja realizar qual operação? "
                    + "\n[1] Consultar estado de concusão de curso;"
                    + "\n[2] Informaçãoes sobre o curso;"
                    + "\n[3] Informações sobre disciplinas do curso;"
                    + "\n[0] Sair");
            
            opc = s.nextByte();
            switch (opc){
                case 1:
                    verificaConclusao();
                case 2:
                    infoCurso();
                case 3:
                    infoDisciplina();
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tent novamente!");
                
            }
        }
    }
    
    public static void mainProfessor(){
        int opc = 20;
        while (opc != 0){
            System.out.println("\nDeseja realizar qual operação?"
                    + "\n[1] Consultar Disciplinas;"
                    + "\n[2] Consultar Aluno;"
                    + "\n[0] Sair");
            opc = s.nextByte();
            switch (opc){
                case 1:
                    consultaDisciplina();
                case 2:
                    consultaAluno();
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tent novamente!");
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        verificaUser();
    }

    private static void infoDisciplina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void infoCurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void verificaConclusao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void consultaDisciplina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void consultaAluno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
