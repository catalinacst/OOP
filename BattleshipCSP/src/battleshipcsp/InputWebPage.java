package battleshipcsp;

/**
 *
 * @author Catalina Castro Arias
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InputWebPage implements Input {
        
    private Scanner input; 
    
    int lengthBoard;
    int numShipsInit;
    int[] lengthShips;    
    // configuracion filas
    int[] constraintsRow;        
    // configuracion columnas
    int[] constraintsColumn;
    
    public InputWeb(URL url){
        // desde web
        if(url == null) throw new NullPointerException();
        try{
            URLConnection site = url.openConnection();
            InputStream is = site.getInputStream();
            Scanner input = new Scanner (new BufferedInputStream(is));
            lengthBoard = input.nextInt();
            numShipsInit = input.nextInt();
            lengthShips = new int[numShipsInit]; 
            for(int i = 0; i < numShipsInit; i++)
                lengthShips[i] = input.nextInt();
            constraintsRow = new int[lengthBoard]; 
            for(int i = 0; i < lengthBoard; i++)
                constraintsRow[i] = input.nextInt();
            constraintsColumn = new int[lengthBoard];
            for(int i = 0; i < lengthBoard; i++)
                constraintsColumn[i] = input.nextInt();
        }catch (IOException ex){
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            System.out.println(url);
        }
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
