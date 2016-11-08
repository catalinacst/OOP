package battleshipcsp;

/**
 *
 * @author Catalina Castro Arias
 */

import java.util.Scanner;

public class InputKeyboard implements Input {
    
    int lengthBoard;
    int numShipsInit;
    int[] lengthShips;        
    // configuracion filas
    int[] constraintsRow;        
    // configuracion columnas
    int[] constraintsColumn;
    
    Scanner sc = new Scanner(System.in);

    public InputKeyboard(){
            System.out.println("Ingrese el tamaño del tablero: ");
            lengthBoard = sc.nextInt();
            
            System.out.println("Ingrese el número de barcos: ");
            numShipsInit = sc.nextInt();
            
            System.out.println("Ingrese sus respectivos tamaños: ");
            lengthShips = new int[numShipsInit]; 
            for(int i = 0; i < numShipsInit; i++)
                lengthShips[i] = sc.nextInt();
            
            System.out.println("Ingrese las restricciones de fila: ");
            constraintsRow = new int[lengthBoard]; 
            for(int i = 0; i < lengthBoard; i++)
                constraintsRow[i] = sc.nextInt();
            
            System.out.println("Ingrese las restricciones de columna: ");
            constraintsColumn = new int[lengthBoard];
            for(int i = 0; i < lengthBoard; i++)
                constraintsColumn[i] = sc.nextInt();
    }

    @Override
    public int getlengthBoard() {
        return lengthBoard;
    }

    @Override
    public int getnumShipsInit() {
        return numShipsInit;
    }

    @Override
    public int[] getlengthShips() {
       return lengthShips;
    }

    @Override
    public int[] getconstraintsRow() {
       return constraintsRow;
    }

    @Override
    public int[] getconstraintsColumn() {
        return constraintsColumn;
    }
    
}