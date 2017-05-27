import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sam on 27/05/17.
 */
public class SampleTest {

    @Test
    public void myTest() {
        assertTrue(Sample.sampleMethod() == 1);
    }

    @Test
    public void myOtherTest() {
        assertTrue(Sample.sampleMethod() == 1);
    }
}