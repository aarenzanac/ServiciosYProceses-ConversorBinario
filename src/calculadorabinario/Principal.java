/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorabinario;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import pideDatos.PideDatos;
/**
 *
 * @author USUARIO
 */
public class Principal {

    private static final String rutaProyecto = System.getProperty("user.dir");
    private static final String separador = File.separator;
    private static final String directorioInterno = "src" + separador + "calculadorabinario";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String binario = "";

            try {

		Process conversor = new ProcessBuilder("java", "-jar",rutaProyecto + separador + directorioInterno + separador + "Conversor.jar").start();

		BufferedReader br = new BufferedReader(new InputStreamReader(conversor.getInputStream()));

		PrintStream ps = new PrintStream(conversor.getOutputStream(), true);

		int num = PideDatos.pideEntero("¿qué número quiere transformar a binario?");

		ps.println(Math.abs(num));

		binario = br.readLine();

		if (num >= 0) {

			System.out.println("En binario es:\n"+binario);

		} else {

			System.out.println("En binario es:\n- " + binario);/*por no complicar el programa, 

				añado un signo, pero habría que hacer un complemento a 1 o 2 y limitar el orden

				 de los números enteros a transformar*/

		}

	} catch (IOException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

	}   
    }
}
