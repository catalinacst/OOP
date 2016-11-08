package battleshipcsp;

/**
 *
 * @author Catalina Castro Arias
 */

interface Input {
    
    public int getlengthBoard();
    
    public int getnumShipsInit();
    
    public int[] getlengthShips();
    
    public int[] getconstraintsRow();
    
    public int[] getconstraintsColumn();
}
