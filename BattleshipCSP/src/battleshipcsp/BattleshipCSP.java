package battleshipcsp;

import java.util.ArrayList;

public class BattleshipCSP {

    public static void main(String[] args) {

        int lengthBoard = 5;
        int numShipsInit = 3;
        int[] lengthShips = {2, 2, 3};
        
        // configuracion filas
        int[] constraintsRow = {2, 1, 1, 2, 1};
        int[] constraintsColumn = {0, 3, 1, 0, 3};
        
        CSP_Problem csp = new CSP_Problem(lengthBoard, numShipsInit, lengthShips, constraintsRow, constraintsColumn); // tablero de n x n
        /*
        int[] board = {1, 0, 1, 1, 1,
                       0, 0, 0, 0, 0,
                       0, 0, 0, 0, 1,
                       1, 1, 1, 0, 1,
                       0, 0, 0, 0, 0};
        
        
        int[] setShips = {0, 1, 2, 1, 0, 0};
        
        AllShipsConstraint proof = new AllShipsConstraint(board, setShips, lengthBoard, numShipsInit);
        proof.PathIdentifier();
        // ArrayList<Integer> board, int [] setShips, int lengthBoard)
        */
    }
}
