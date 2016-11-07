package battleshipcsp;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;

public class SumRowsConstraint implements Constraint {
    
    ArrayList<Variable> scope = new ArrayList<Variable> ();
    ArrayList<Integer> assignRow = new ArrayList<Integer> ();
    int[] sumRow;
    int lengthBoard;
    
    // constructor
    public SumRowsConstraint(ArrayList<Variable> board, int[] sumRow){
        this.scope = board;
        this.sumRow = sumRow;
        this.lengthBoard = sumRow.length;
    }
    
    @Override
    public ArrayList<Variable> getScope() {
        return scope;
    }
    
    @Override
    public boolean isSatisfiedWith(Assignment a) {        
        for(int i = 0; i < scope.size(); i++){
            Integer value = (Integer)a.getAssignment(scope.get(i));
            assignRow.add(i,value);
        }
        // {x1 x2 x3 x4  x5 x6 x7 x8  x9 x10 x11 x12  x13 x14 x15 x16}
  
        //  0  1  2  3   4  5  6  7   8   9  10  11   12  13  14  15
        /*
         {  x1  x2  x3  x4
            x5  x6  x7  x8
            x9  x10 x11 x12
            x13 x14 x15 x16
        */
        int indice = 0;
        int aux = 0;
        int lengthBoardAUX = lengthBoard;
        for(int i = 0; i < lengthBoard; i++){
            Integer cont = 0;
            for(int j = aux; j < lengthBoardAUX; j++, indice++){
                if(assignRow.get(j) == null)
                    return true;
                else
                    if(assignRow.get(j) == 1)
                        cont++;
            }
            aux = indice;
            lengthBoardAUX = lengthBoardAUX + lengthBoard;
            if (cont != sumRow[i]) return false; // si no cumple con la condición hasta este punto, retorne falso
        }
        return true;
    }
}