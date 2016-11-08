package battleshipcsp;

/**
 *
 * @author Catalina Castro Arias
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile implements Input {
    
    private final Scanner input;
    
    int lengthBoard;
    int numShipsInit;
    int[] lengthShips;    
    // configuracion filas
    int[] constraintsRow;        
    // configuracion columnas
    int[] constraintsColumn;
    
    
    public InputFile(String file) throws FileNotFoundException {
        input = new Scanner((new File(file)));
        lengthBoard = input.nextInt();
        numShipsInit = input.nextInt();
        //System.out.println(numShipsInit);
        lengthShips = new int[numShipsInit]; 
        for(int i = 0; i < numShipsInit; i++)
            lengthShips[i] = input.nextInt();
        
        constraintsRow = new int[lengthBoard]; 
        for(int i = 0; i < lengthBoard; i++)
            constraintsRow[i] = input.nextInt();
        
        constraintsColumn = new int[lengthBoard];
        for(int i = 0; i < lengthBoard; i++)
            constraintsColumn[i] = input.nextInt();
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
