import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test for contract
 */
public class ContractTest {
    
    private Contract contract;

    /**
     * test contract declaration
     */
    @Before
    public void setUp() {
        contract = new Contract(60, 62, 40, 4, 32);
    }

    /**
     * computation test using example values
     */
    @Test
    public void testGetCallPrice() {
        assertEquals(contract.getContractPrice("p"), 1.46, 0.1);
        assertEquals(contract.getContractPrice("c"), 3.72, 0.1);
    }

    /**
     * normal distribution fetching, tests HashMap
     */
    @Test
    public void testGetNormalDistribution() {
        assertEquals(contract.getNormalDistribution(-2.8), 0.0026, 0.1);
        assertEquals(contract.getNormalDistribution(-1.74), 0.0409, 0.1);
        assertEquals(contract.getNormalDistribution(-0.71), 0.2389, 0.1);
        assertEquals(contract.getNormalDistribution(2.15), 0.9842, 0.1);
    }

}
