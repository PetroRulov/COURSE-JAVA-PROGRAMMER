package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by prulov on 14.06.2016.
 */
@RunWith(JUnit4.class)
public class ClientTests {

    private Client clt;

    @Before
    public void init(){

        clt = new Client(null, null, 0, null, null);
    }

    @Test
    public void checkClientSurNameDefaulValue(){

        assertNull("Default surname of the Client should be null.", clt.getSurName());
    }

    @Test
    public void checkClientNameDefaulValue(){

        assertNull("Default surname of the Client should be null.", clt.getName());
    }

    @Test
    public void checkClientAgeDefaulValue(){

        assertTrue("Default age of the Client should be 0", clt.getAge() == 0);
    }

    @Test
    public void checkClientSexDefaulValue(){

        assertNull("Default sex of the Client should be null.", clt.getSex());
    }

    @Test
    public void checkClientEMailDefaulValue(){

        assertNull("Default e-mail of the Client should be null.", clt.geteMail());
    }



}
