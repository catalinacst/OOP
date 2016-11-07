package battleshipcsp;

public class BattleshipCSP {

    public static void main(String[] args) {

        int lengthBoard = 8;
        int numShips = 5;
        int[] lengthShips = {1, 2, 4, 2, 1};
        
        // configuracion filas
        int[] constraintsRow = {1, 0, 8, 0, 3, 0, 3, 0};
        int[] constraintsColumn = {2, 2, 2, 1, 1, 2, 2, 3};
        
        CSP_Problem csp = new CSP_Problem(lengthBoard, numShips, lengthShips, constraintsRow, constraintsColumn); // tablero de n x n
    }
}
