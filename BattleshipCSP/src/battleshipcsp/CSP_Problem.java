package battleshipcsp;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import java.util.ArrayList;

import org.junit.Assert;

public class CSP_Problem {
    
    private final CSP csp;
    
    int numShips;
    int[] lengthShips;
    // configuracion filas
    int[] constraintsRow;
    
    // tamaño tablero 
    public int lengthBoard;
    
    public Domain ships;
    
    // Arreglo de variascopebles
    public ArrayList<Variable> board = new ArrayList<Variable> ();
    
    // Arreglo de posibles dominios
    public ArrayList<Integer> listDomain = new ArrayList<Integer> ();
    
        
    // Arreglo de variables auxiliares
    public ArrayList<Variable> subBoard = new ArrayList<Variable> ();
    
    // Arreglo de id de barcos
    public ArrayList<Integer> idShips = new ArrayList<Integer> ();
            
    // creación de variables var = {x1, x2, ... xn}, siendo n = tamaño tablero * tamaño tablero
    public CSP_Problem(int lengthBoard, int numShips, int[] lengthShips, int[] constraintsRow){
        
        for(int i = 0; i < lengthBoard * lengthBoard; i++){
            Variable Xi = new Variable("X"+i);
            board.add(Xi);
        }
        
        this.lengthBoard = lengthBoard;
        this.numShips = numShips;
        this.lengthShips = lengthShips;
        this.constraintsRow = constraintsRow;
        
        csp = new CSP(board);
        
        // creacion del arreglo que tendra el id del barco con su respectivo tamaño
        // siendo el index su id y el contenido su tamaño
        for(int i = 0; i < numShips; i++){
            idShips.add(lengthShips[i]);
        }
        
        // asigna según la cantidad de barcos, los posibles dominios que podra tener la solución
        for(int i = 0; i < numShips; i++){
            listDomain.add(i);
        }
        ships = new Domain(listDomain);
        
        // asigna a cada variable sus posibles dominios
        for(int i = 0; i < board.size(); i++){
            csp.setDomain(board.get(i), ships);
        }
        
        // asignacion restricciones
        //csp.addConstraint(C1);
        /*
        for(int i = 0; i < 4; i++){
            subBoard.add(board.get(i));
        }
        
        for(int i = 0; i < 4; i++){
            System.out.println(subBoard.get(i));
        }*/
        
        csp.addConstraint(new SumRowsConstraint(board, 3));
        //System.out.println(csp.getConstraints());

        
        // ArrayList<Variable> constraintsRow =  es la configuracion del tablero de filas 
        //ConstraintSumRows(lengthBoard, 0, constraintsRow, 0); 
        
        solver();
    } 
    
    public void solver(){
        Assignment results = new BacktrackingStrategy().solve(csp);
        Assert.assertNotNull(results);
        for(int i = 0; i < board.size(); i++)
            System.out.println(results.getAssignment(board.get(i)));
        System.out.println(results.getVariables());        
    }
    
    // restriccion de filas 
    public void ConstraintSumRows(int lengthBoardAUX, int indice, int[] sumRow, int contCons){
            for(int i = indice; i < lengthBoardAUX; i++, indice++){
                subBoard.add(board.get(i));
            }
            if(indice <  lengthBoard * lengthBoard){
                SumRowsConstraint pri = new SumRowsConstraint(subBoard, sumRow[contCons]);
                csp.addConstraint(pri);
                ConstraintSumRows(lengthBoardAUX + 4, indice, sumRow, contCons + 1);
            }
    }
    
    // muestra tablero (variables)
    public void showBoard(){
        for(int i = 0; i < board.size(); i++){
            System.out.println(board.get(i));
        }
    }
    
    // muestra cantidad de barcos (dominios)
    public void showShips(){
        for(int i = 0; i < ships.size(); i++){
            System.out.println(ships.get(i));
        }
    }
}
