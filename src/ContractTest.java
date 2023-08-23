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
        contract = new Contract(1, 1, 1, 1, 1);
    }

    /**
     * computation test using example values
     */
    @Test
    public void testGetCallPrice() {
        assertEquals(1, 1);
        assertEquals(contract.getCallPrice(), 0, 0.1);
    }

    /**
     * normal distribution fetching, tests HashMap
     */
    @Test
    public void testGetNormalDistribution() {
        assertEquals(1, 1);
        assertEquals(contract.getNormalDistribution(0), 0, 0.1);
    }

}
