import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void testRes()throws Exception {
        Calc calc = new Calc();
        assertEquals(50,calc.res(20,30,"+"),0.01);
    }
}