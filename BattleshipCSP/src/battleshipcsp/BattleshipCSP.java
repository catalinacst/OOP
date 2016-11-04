package battleshipcsp;

public class BattleshipCSP {

    public static void main(String[] args) {

        int lengthBoard = 4;
        int numShips = 3;
        int[] lengthShips = {1, 2, 3};
        
        // configuracion filas
        int[] constraintsRow = {2, 1, 3, 0};
        
        CSP_Problem csp = new CSP_Problem(lengthBoard, numShips, lengthShips, constraintsRow); // tablero de n x n
    }
}
