package battleshipcsp;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;
import aima.core.search.csp.CSP;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SolveBattleshipCSP {
    
    private CSP csp;
    int lengthBoard = 4;
    int numShips = 3;
    int[] lengthShips = {1, 2, 3};
    // configuracion filas
    int[] constraintsRow = {2, 1, 3, 0};

	@Before
	public void setUp() {
        /*
            CSP_Problem csp1 = new CSP_Problem(lengthBoard); // tablero de n x n

            csp1.createIdShips(numShips, lengthShips);

            // asigna dominios
            csp1.assignsDomain(numShips);

            // asigna variables
            csp1.assignsVariables();

            // variables con dominios
            csp1.variablesAndDomains();

            // restricciones
            csp1.Constraints(lengthBoard, constraintsRow);

            csp = csp1;
        */
        }

	@Test
	public void testBackTrackingSearch() {
		Assignment results = new BacktrackingStrategy().solve(csp);
		Assert.assertNotNull(results);
	}

}
