/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemifrs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Erick_Nagoski
 */
public class SistemaIFRS {
    
     public static int menu(String opcoes, BufferedReader br) throws IOException {
        System.out.println(opcoes);
        String texto = br.readLine();

        int opcao = Integer.parseInt(texto);
        return opcao;
    }
    
}
