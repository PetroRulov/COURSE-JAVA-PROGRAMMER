package lesson7.feedcat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertFalse;

@RunWith(JUnit4.class)
public class HouseWifeTests {

    private Cat[]cats;
    private HouseWife hW;

    @Before
    public void init(){

        hW = new HouseWife();
        cats = new Cat[3];

        cats[0] = new Cat();
        cats[0].setName("Tom");

        cats[1] = new Cat();
        cats[1].setName("Vaska");

        cats[2] = new Cat();
        cats[2].setName("Boris");
        cats[2].setHungry(false);
    }

    @Test
    public void testFeedCats(){

        hW.feed(cats);

        for(Cat c : cats){
            assertFalse(c.isHungry());
        }
    }

    @Test(expected = CatNotHungryException.class)
    public void testCatNotHungryException(){

        hW.feed(cats);

        for(Cat c : cats){
            assertFalse(c.isHungry());
        }
    }
}
