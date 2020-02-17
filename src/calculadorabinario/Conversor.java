/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorabinario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author USUARIO
 */
public class Conversor {
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String entrada;

	String binario = "", binario2 = "";

	int numint, resto;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	try {

            entrada = br.readLine();

            numint = Integer.parseInt(entrada);

            while (numint >= 2) {
		resto = numint % 2;
		binario2 += resto;
		numint /= 2;

            }

            binario2 += numint;

            char[] binlist = binario2.toCharArray();

            for (int i = binlist.length-1; i >= 0; i--) {

                binario += binlist[i];
            }

            System.out.println(binario);
	} catch (IOException e) {

            e.printStackTrace();

	}

    }

}
