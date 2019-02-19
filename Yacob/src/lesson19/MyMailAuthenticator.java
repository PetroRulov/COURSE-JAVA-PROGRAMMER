package lesson19;

import javax.mail.*;

public class MyMailAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("prulovpr@outlook.com", "MS89082d6PR@");
    }
}
