/*ENUNCIADO:
 * 
 * Crearemos un programa principal que preguntar· un n˙mero por el teclado.

- Crear· el proceso hijo al que va enviar el n˙mero.

- El proceso hijo recibe el n˙mero, lo convierte a binario y lo reenvia al proceso padre.

- El proceso padre recibe el n˙mero convertido y lo visualiza por la pantalla.

Los programas se pueden llamar Principal y conversor.
*/


/* To change this license header, choose License Headers in Project Properties.
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
        System.out.println(rutaProyecto + separador + directorioInterno + separador + "CalculadoraBinario.jar");
        System.out.println("Prueba de github");

            try {

		Process conversor = new ProcessBuilder("java", "-jar",rutaProyecto + separador + directorioInterno + separador + "CalculadoraBinario.jar").start();

		BufferedReader br = new BufferedReader(new InputStreamReader(conversor.getInputStream()));

		PrintStream ps = new PrintStream(conversor.getOutputStream(), true);

		int num = PideDatos.pideEntero("øQuÈ n˙mero quiere transformar a binario?");

		ps.println(Math.abs(num));

		binario = br.readLine();

		if (num >= 0) {

			System.out.println("En binario es:\n"+binario);

		} else {

			System.out.println("En binario es:\n- " + binario);/*por no complicar el programa, 

				a√±ado un signo, pero habr√≠a que hacer un complemento a 1 o 2 y limitar el orden

				 de los n√∫meros enteros a transformar*/

		}

	} catch (IOException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

	}   
    }
}
