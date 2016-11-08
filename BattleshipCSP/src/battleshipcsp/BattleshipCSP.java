package battleshipcsp;

/**
 *
 * @author Catalina Castro Arias
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;

public class BattleshipCSP {

    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, IOException {
        
        int lengthBoard = 0;
        int numShipsInit = 0;
        int[] lengthShips = null;        
        // configuracion filas
        int[] constraintsRow = null;        
        // configuracion columnas
        int[] constraintsColumn = null;
                         
        System.out.println("Digite el método de entrada: ");
        System.out.println("1. Teclado");
        System.out.println("2. Archivo");
        System.out.println("3. URl");
        
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        
        // Patrón Factory
        if(entrada == 1){
            InputKeyboard input = new InputKeyboard();        
            lengthBoard = input.lengthBoard;
            numShipsInit = input.numShipsInit;
            lengthShips = input.lengthShips;
            constraintsRow = input.constraintsRow;
            constraintsColumn = input.constraintsColumn;
        }else
            if(entrada == 2){
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                String file = teclado.readLine();
                //String file = "/home/catalina/NetBeansProjects/BattleshipCSP/src/battleshipcsp/input.txt";
                try{
                    InputFile input = new InputFile(file);
                    lengthBoard = input.lengthBoard;
                    numShipsInit = input.numShipsInit;
                    lengthShips = input.lengthShips;
                    constraintsRow = input.constraintsRow;
                    constraintsColumn = input.constraintsColumn;
                }catch(IOException e){
                    System.out.println("El archivo no existe");
                }
            }
            /*
            else
                if(entrada == 3){
                    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                    String url = teclado.readLine();
                    URL baseURL = new URL(url);
                    InputWeb input = new InputWeb(baseURL);
                    lengthBoard = input.lengthBoard;
                    numShipsInit = input.numShipsInit;
                    lengthShips = input.lengthShips;
                    constraintsRow = input.constraintsRow;
                    constraintsColumn = input.constraintsColumn;
                }
        */
        /*
        Posibles casos de prueba
        Para comprobarlos seria comentar la parte de arriba de las entradas 
        y descomentar las siguientes asignaciones
        */
        
        /*

        int lengthBoard = 4;
        int numShipsInit = 3;
        int[] lengthShips = {4, 2, 2};
        
        // configuracion filas
        int[] constraintsRow = {4, 0, 2, 2};
        
        // configuracion columnas
        int[] constraintsColumn = {2, 2, 2, 2};
        */
        
        CSP_Problem csp = new CSP_Problem(lengthBoard, numShipsInit, lengthShips, constraintsRow, constraintsColumn);
        
        
        System.out.println("");
        System.out.println("Primer Método de Solución: ");
        System.out.println("El tablero solución es: ");
        csp.solverBacktrackingStrategy();
        
        
        System.out.println("");
        System.out.println("Segundo Método de Solución: ");
        System.out.println("El tablero solución es: ");
        csp.solverImprovedBacktrackingStrategy();
        
    }
}
