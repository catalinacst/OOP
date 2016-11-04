package battleshipcsp;

public class BattleshipCSP {

    public static void main(String[] args) {

        int lengthBoard = 10;
        int numShips = 5;
        int[] lengthShips = {1, 2, 4, 2, 1};
        
        // configuracion filas
        int[] constraintsRow = {0, 1, 2, 1, 1, 3, 4, 5, 8, 1};
        
        CSP_Problem csp = new CSP_Problem(lengthBoard, numShips, lengthShips, constraintsRow); // tablero de n x n
    }
}
