package lesson19;

import javax.mail.*;

public class MyMailAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("prulov.pr@gmail.com", "89082d6PR@");
    }
}
