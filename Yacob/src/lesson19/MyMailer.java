package lesson19;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyMailer {

    //Разблокировать небезопасные приложения для своего google-аккаунта
    //https://myaccount.google.com/lesssecureapps

    private Session session = null;
    private static String emailSenderAddress = "prulovpr@outlook.com";
    private static String emailSubject = "Happy Birthday!!!";
    private String emailText = "Happy Birthday, my dear Friend!!!";

    private List<String> friends = new ArrayList<>();

    public MyMailer(){

        Properties sessionProperties = new Properties();
        sessionProperties.put("mail.smtp.starttls.enable", "true");
        //sessionProperties.put("mail.smtp.host", "smtp.gmail.com");
        sessionProperties.put("mail.smtp.host", "smtp.outlook.com");
        sessionProperties.put("mail.smtp.user", emailSenderAddress);
        sessionProperties.put("mail.smtp.port", "587");
        sessionProperties.put("mail.smtp.auth", "true");

        MyMailAuthenticator authenticator = new MyMailAuthenticator();
        session = Session.getInstance(sessionProperties, authenticator);
    }

    private void setPropsAndSendEmail(String emailRecipient, String emailText){
        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(emailSenderAddress));
            emailMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRecipient, false));
            emailMessage.setSubject(emailSubject);
            emailMessage.setSentDate(new Date());
            emailMessage.setText(emailText);
            Transport.send(emailMessage);
            System.out.println("Yout e-mail to " + emailRecipient + " has been sent successfully");
        } catch (Exception e) {
            System.out.println("Your e-mail to " + emailRecipient + " has not been send: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void readTheBirthdaysFile() throws IOException{
        FileInputStream birthdaysFile = new FileInputStream("resources/birthdays.txt");
        BufferedReader birthdaysFileReader = new BufferedReader(new InputStreamReader(birthdaysFile));
        String friendInfo;
        while((friendInfo = birthdaysFileReader.readLine()) != null){
            friends.add(friendInfo);
        }
        birthdaysFileReader.close();
        birthdaysFile.close();
    }

    private void iterateThroughBirhtdays(){
        Iterator<String> iterator = friends.iterator();
        while(iterator.hasNext()){
            scanForManInfoAndSendEmail(iterator.next());
        }
    }

    private void scanForManInfoAndSendEmail(String next) {
        Scanner scannerOfLines = new Scanner(next).useDelimiter("[, \n]");
        if(scannerOfLines.next().equals(getCurrentDateMMMd())){
            String emailAddressee = scannerOfLines.next();
            String emailAddress = scannerOfLines.next();
            setPropsAndSendEmail(emailAddress, String.format(emailText, emailAddressee));
        }
    }

    private String getCurrentDateMMMd() {
        return new SimpleDateFormat("MMM-d", Locale.GERMANY).format(new GregorianCalendar().getTime());
    }

    public static void main(String[] args) {
        MyMailer mm = new MyMailer();
        try{
            mm.readTheBirthdaysFile();
            mm.iterateThroughBirhtdays();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
