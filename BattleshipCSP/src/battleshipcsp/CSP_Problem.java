package battleshipcsp;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;

import java.util.ArrayList;

public class CSP_Problem {
    
    private final CSP csp;
    
    // cantidad de barcos 
    int numShipsInit;
    
    // tamaños de los barcos
    int[] lengthShips;  
    // configuracion filas
    int[] constraintsRow;
    
    // configuracion columnas
    int[] constraintsColumn;
    
    // tamaño tablero 
    public int lengthBoard;
    
    public Domain ships;
    
    // Arreglo de variascopebles
    public ArrayList<Variable> board = new ArrayList<Variable> ();
    
    // Arreglo de posibles dominios
    public ArrayList<Integer> listDomain = new ArrayList<Integer> ();
    
        
    // Arreglo de variables auxiliares
    public ArrayList<Variable> subBoard = new ArrayList<Variable> ();
    
    
    // creación de variables var = {x1, x2, ... xn}, siendo n = tamaño tablero * tamaño tablero
    public CSP_Problem(int lengthBoard, int numShipsInit, int[] lengthShips, int[] constraintsRow, int[] constraintsColumn){ 
        
        // creacion de variables 
        for(int i = 0; i < lengthBoard * lengthBoard; i++){
            Variable Xi = new Variable("X"+i);
            board.add(Xi);
        }
        
        this.lengthBoard = lengthBoard;
        this.numShipsInit = numShipsInit;
        this.lengthShips = lengthShips;
        this.constraintsRow = constraintsRow;
        this.constraintsColumn = constraintsColumn;
        
        csp = new CSP(board);
        
        int[] setShips = new int[lengthBoard];
        
        // lo inicializo de ceros
        for(int i = 0; i < lengthBoard; i++){
            setShips[i] = 0;
        }
        
        // creación de un counting sort con el tamaño de los barcos y la cantidad que existen
        // siendo la posición su tamaño y el contenido la cantidad de barcos que hay de ese tamaño
        for(int i = 0; i < numShipsInit; i++){
            setShips[lengthShips[i]] = setShips[lengthShips[i]] + 1;
        }
        
        // asigna según la cantidad de barcos, los posibles dominios que podra tener la solución
        for(int i = 0; i < 2; i++){
            listDomain.add(i);
        }
        ships = new Domain(listDomain);
        
        // asigna a cada variable sus posibles dominios
        for(int i = 0; i < board.size(); i++){
            csp.setDomain(board.get(i), ships);
        }
        
        // asignacion restricciones
        //csp.addConstraint(C1);
        csp.addConstraint(new SumRowsConstraint(board, constraintsRow));
        csp.addConstraint(new SumColumnConstraint(board, constraintsColumn));
        csp.addConstraint(new AllShipsConstraint(board, setShips, lengthBoard, numShipsInit));
        
        solver();
    } 
    
    public void solver(){
        Assignment results = new BacktrackingStrategy().solve(csp);
        for(int i = 0; i < board.size(); i++){
            System.out.print(results.getAssignment(board.get(i)));
            if((i+1)%lengthBoard == 0)
                System.out.println("");
        }
        //  System.out.println("\n"+results.getVariables());        
    }

}
