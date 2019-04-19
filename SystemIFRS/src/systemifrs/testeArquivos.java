/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author 05200245
 */
public class testeArquivos{
    
    public static void salvaArquivo(){
        Aluno teste = new Aluno("Erick", 23, false, 232);
        
        try {
            File f = new File("arquivo.bin");
            if (!f.exists()){
                f.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(teste);
                        
                    }
                    System.out.println("dados salvos");
                
            
        }catch (IOException e){
                System.err.println(e);
        }
        
    }
    
    public static void leArquivo() throws ClassNotFoundException{
        Aluno alunoTeste = new Aluno();
        try {
            File f = new File ("arquivo.bin");
            if (f.exists()){
                try (FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis)){
                    alunoTeste = (Aluno) ois.readObject();
                    System.out.println("Dados lidos");
                    System.out.println(alunoTeste.toString());
                }
            }
        }catch(IOException e){
            System.out.println("Erro na leitura");   
        }        
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
         salvaArquivo();
         leArquivo();
        
    }
}
