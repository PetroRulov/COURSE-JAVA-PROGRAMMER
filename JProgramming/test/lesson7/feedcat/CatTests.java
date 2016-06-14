package lesson7.feedcat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CatTests {

    private Cat cat;

    @Before
    public void init(){
        cat = new Cat();
    }

    @Test
    public void checkCatNameDefaulValue(){

        assertNull("Default name of cat should be null.", cat.getName());
    }

    @Test
    public void checkCatWeightDefaulValue(){

        assertTrue("Default weight of cat should be 0.0.", cat.getWeight() == 0.0);
    }

    @Test
    public void checkCatIsHungryDefaulValue(){

        assertTrue("Cat should be hungry by default.", cat.isHungry());
    }

    @Test
    public void checkCatSetName(){

        String name = "Tom";
        cat.setName(name);
        assertEquals(name, cat.getName());
    }

    @Test
    public void checkCatSetWeight(){

        double weight = 3.7;
        cat.setWeight(weight);
        assertEquals(weight, cat.getWeight(), - 1.1); // expected - actual < epsylon
    }
}
