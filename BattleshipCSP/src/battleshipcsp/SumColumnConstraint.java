package battleshipcsp;

//https://github.com/aimacode/aima-java

/**
 *
 * @author Catalina Castro Arias
 */

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

public class SumColumnConstraint implements Constraint {

    ArrayList<Variable> scope = new ArrayList<Variable> ();
    ArrayList<Integer> assignColumn = new ArrayList<Integer> ();
    int[] sumColumn;
    int lengthBoard;
    
    public SumColumnConstraint (ArrayList<Variable> board, int[] sumColumn){
        this.scope = board;
        this.sumColumn = sumColumn;
        this.lengthBoard = sumColumn.length;
    }
    
    @Override
    public List<Variable> getScope() {
       return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment a) {
         for(int i = 0; i < scope.size(); i++){
            Integer value = (Integer)a.getAssignment(scope.get(i));
            assignColumn.add(i,value);
        }
        // {x1 x2 x3 x4  x5 x6 x7 x8  x9 x10 x11 x12  x13 x14 x15 x16}
  
        //  0  1  2  3   4  5  6  7   8   9  10  11   12  13  14  15
        /*
         {  x1  x2  x3  x4
            x5  x6  x7  x8
            x9  x10 x11 x12
            x13 x14 x15 x16
        */
        for(int i = 0; i < lengthBoard; i++){
            Integer cont = 0;
            for(int j = i; j < lengthBoard * lengthBoard; j = j + lengthBoard){
		if(assignColumn.get(j) == null) 
                    return true; 	
		else 
                    if(assignColumn.get(j) == 1) 
                        cont++;
            }
            if (cont != sumColumn[i]) return false; // si no cumple con la condición hasta este punto, retorne falso
        }
    return true;    
    }
}
