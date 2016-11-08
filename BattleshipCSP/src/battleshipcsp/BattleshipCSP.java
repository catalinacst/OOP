package battleshipcsp;

public class BattleshipCSP {

    public static void main(String[] args) {

        
        
        int lengthBoard = 5;
        int numShipsInit = 3;
        int[] lengthShips = {2, 2, 3};
        
        // configuracion filas
        int[] constraintsRow = {2, 1, 1, 2, 1};
        
        // configuracion columnas
        int[] constraintsColumn = {0, 3, 1, 0, 3};
            
        CSP_Problem csp = new CSP_Problem(lengthBoard, numShipsInit, lengthShips, constraintsRow, constraintsColumn); // tablero de n x n
    }
}
