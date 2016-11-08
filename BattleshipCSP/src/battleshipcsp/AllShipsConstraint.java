package battleshipcsp;

// https://github.com/aimacode/aima-java

/**
 *
 * @author Catalina Castro Arias
 */

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

public class AllShipsConstraint implements Constraint {
    
    public ArrayList<Integer> visited = new ArrayList<Integer> ();
    
    public ArrayList<Variable> scope = new ArrayList<Variable> ();
    
    int lengthBoard; // si el tablero es 4*4 se le asigna el 4
    int tamBoardAux;
    int ship = 0;
    int numShips = 0;
    int[] setShips2;
    int numShipsInit;
    
    ArrayList<Integer> board = new ArrayList<Integer> ();
        
    public AllShipsConstraint(ArrayList<Variable> boardInit, int[] setShips1, int lengthBoard, int numShipsInit){
        this.scope = boardInit;
        this.setShips2 = setShips1;
        this.lengthBoard = lengthBoard;
        this.tamBoardAux = lengthBoard;
        this.numShipsInit = numShipsInit;
    }
    
    @Override
    public List<Variable> getScope() {
        return scope;
    }
    
    // retorna true si ese indice ya fue visitado, falso si todavi no
    public boolean posVisited(int i){
        for(int k = 0; k < visited.size(); k++){
            if(visited.get(k) == i)
                return true;
        }
        return false;
    }
    
    // mira la cantidad de barcos que hay horizontalmente 
    public int Horizontal(int i, int tamBoardAux){
        int cont = 0;
        for(int k = i; k < tamBoardAux; k++){
            if(board.get(k) == 1){
                cont++;
                visited.add(k);
            }
            else
              return cont;
        }
        return cont;
    }
    
    // mira la cantidad de barcos que hay verticalmente
    public int Vertical(int i){
        int cont = 0;
        for(int k = i; k < board.size(); k = k + lengthBoard){
            if(board.get(k) == 1){
                cont++;
                visited.add(k);
            }
            else
              return cont;
        }
        return cont;
    }
    
    public boolean FindShips(int ship, int[] setShips){
        if(setShips[ship - 1] != 0){
            setShips[ship - 1] = setShips[ship - 1] - 1;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean isSatisfiedWith(Assignment a) {
        
        ship = 0;
        numShips = 0;
        tamBoardAux = lengthBoard;
        visited = new ArrayList();
        board = new ArrayList();
        
        int[] setShips = new int[lengthBoard];
        for (int i = 0; i < lengthBoard; i++) 
            setShips[i] = setShips2[i];
        
        for(int i = 0; i < scope.size(); i++){
            Integer value = (Integer)a.getAssignment(scope.get(i));
            if (value == null) return true;
            board.add(value);
        }
        
        for(int i = 0; i < scope.size(); i++){
                if(board.get(i) == 1){
                    if(!(posVisited(i))){
                        visited.add(i);
                        if(i < (tamBoardAux - 1)){
                            if(board.get(i + 1) == 1)
                                ship = Horizontal(i,tamBoardAux);
                            else{
                                if((i + lengthBoard) < board.size() && board.get(i + lengthBoard) == 1)
                                    ship = Vertical(i);
                                else
                                    ship = 1;
                            }                       
                        }
                        else{
                            if(i + lengthBoard < board.size() && board.get(i + lengthBoard) == 1)
                                ship = Vertical(i);
                            else
                                ship = 1;
                        }
                        if(FindShips(ship, setShips))
                            numShips++;
                        else
                            return false;
                            //System.out.println("Hay un barco demás");
                    }
                }
                ship = 0;
                if(i == tamBoardAux - 1)
                    tamBoardAux = tamBoardAux + lengthBoard;
        }
        if (numShips != numShipsInit)
            return false;
        else
            return true;
    }
}