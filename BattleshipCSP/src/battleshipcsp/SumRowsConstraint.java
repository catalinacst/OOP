package battleshipcsp;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catalina
 */

public class SumRowsConstraint implements Constraint {
    
    ArrayList<Variable> scope = new ArrayList<Variable> ();
    //public ArrayList<Variable> scope;
    Integer sumRow;
    Object value1 = new Object();
    Object value2 = new Object();
    
    
    // constructor
    public SumRowsConstraint(ArrayList<Variable> row, Integer sumRow){
        this.scope = row;
        this.sumRow = sumRow;
    }
    
    @Override
    public ArrayList<Variable> getScope() {
        return scope;
    }
    
    /*
    Object value1 = assignment.getAssignment(var1);
	return value1 == null || !value1.equals(assignment.getAssignment(var2));
    */

    // en assignedRows se estan añadiendo todas las asignaciones que se le dieron a cada una de 
    // las variables, las cuales estaban en row 
    /*
    @Override
    public boolean isSatisfiedWith(Assignment a) {
        System.out.println("h");
        for(int i = 0; i < scope.size(); i++){
            assignedRows.add(a.getAssignment(scope.get(i)));
        }
        int sumRowTotal = 0;
        Integer aux = 0;
        
        for(int i = 0; i < assignedRows.size(); i++){
            if ( (Integer) assignedRows.get(i) != aux)
                sumRowTotal++;
        }
        for(int i = 0; i < assignedRows.size(); i++){
            System.out.println(assignedRows.get(i));

        
        return sumRowTotal == sumRow;
    }*/
    
    
    @Override
    public boolean isSatisfiedWith(Assignment a) {
                
        value1 = a.getAssignment(scope.get(0));
        value2 = a.getAssignment(scope.get(1));
        //System.out.println(value1);
        //System.out.println(value2);
        //Object value3 = a.getAssignment(scope.get(4));
        
        //return !value1.equals(value2);
        //int num = (int)value1 + (int) value2;
        //System.out.println(num);
        return !value1.equals(value2);
        
    }
    
    
}
