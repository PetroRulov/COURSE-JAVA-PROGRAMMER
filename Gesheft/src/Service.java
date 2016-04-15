import domain.Client;
import domain.Sale;
import domain.Stock;
import enumerations.*;

import java.util.Scanner;

public class Service {

    private Stock stk;
    private Sale[] sal = new Sale[100];
    private Client[] clt = new Client[12];

    public Service(){

        this.stk = new Stock();
        this.sal = sal;
        this.clt = clt;
        initClientsBase();
        initSalesJournal();


    }

    public Client[] getClt() {
        return clt;
    }

    public Sale[] getSales() {
        return sal;
    }

    public Stock getStk() {
        return stk;
    }

    /**-d i s p l a y i n g     P R I C E      L I S T-*/
    public void printPriceList() {

        System.out.println();
        System.out.println("----------------------" + "\"BADIGAN\" PRICE LIST" + "------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%n", "#", "| Type", "| Name", "| Tare", "| Volume", "| Price |");
        System.out.println("------------------------------------------------------------------");
        int j = 0;
        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterPriceList();
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

    /**-d i s p l a y i n g     C A T A L O G U E-*/

    public void printCatalogue() {
        System.out.println();
        System.out.println("------------------" + "\"BADIGAN\" CATALOGUE" + "--------------------|");
        System.out.println("---------------------------------------------------------|");
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%n", "# ", "| Type", "| Name", "| Tare", "| Volume  |");
        System.out.println("---------------------------------------------------------|");
        System.out.println("BRENDY:");
        System.out.println("---------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.BRENDY)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("BURBON:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.BURBON)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("JUICE:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.JUICE)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("TEQUILA:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.TEQUILA)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("VINES:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.VINE)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("VODKA:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.VODKA)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("WATER:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < stk.getWat().length; i++) {
            if (stk.getWat()[i] != null && stk.getWat()[i].getDrink().equals(Drink.WATER)) {
                j++;
                System.out.print(j);
                stk.getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

    /**-d i s p l a y i n g     d a i l y     r e p o r t-*/
    public void dailyReport() {

        int date;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input date:");
        if (scan.hasNextInt()) {
            date = Math.abs(scan.nextInt());
            System.out.println();
            System.out.println("DAILY REPORT ABOUT SALES FOR " + convertDateFormat(date));
            System.out.println("---------------------------------------------------------------------------------------------------------------|");
            System.out.printf("%-11s%-26s%-35s%-10s%-10s%-10s%-10s%-10s%n", "#| Date", "| Surname, name", "| Item", "| Volume", "| Price",
                    "| Quantity", "| Income", "|");
            System.out.println("---------------------------------------------------------------------------------------------------------------|");
            int j = 0;
            for (int i = 0; i < sal.length; i++) {
                if (sal[i] != null && sal[i].getDate() == date) {
                    j++;
                    System.out.print(j);
                    sal[i].saleInfoShow();
                }
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------|");
            System.out.println(calculatorForDailyReport(date));
            System.out.println("---------------------------------------------------------------------------------------------------------------|");
        } else {
            System.out.println("!!!Invalid request!");
            System.out.println("Please, insert the correct date and try again!");
        }
    }

    private String calculatorForDailyReport(int d) {

        int quant = 0, amount = 0;
        for (int i = 0; i < sal.length; i++) {
            if (sal[i] != null && sal[i].getDate() == d) {
                quant += sal[i].getQuant();
                amount += sal[i].getIncome();
            }
        }
        return "At all " + quant + " items sold of " + amount + " hrvn.";
    }

    private int getIndex(int d) {

        int x = 0;
        for (int i = 0; i < sal.length; i++) {
            if (sal[i] != null && sal[i].getDate() == d) {
                x = i;
                break;
            }
        }
        return x;
    }

    private String convertDateFormat(int a) {

        String str = "";
        String res = String.valueOf(a);
        if (res.length() % 2 != 0) {
            str = res.substring(0, 1) + "/" + res.substring(1, 3) + "/" + res.substring(3, res.length());
        } else {
            str = res.substring(0, 2) + "/" + res.substring(2, 4) + "/" + res.substring(4, res.length());
        }
        return str;
    }


    /**-d i s p l a y i n g     S a l e s    R e p o r t     w i t h i n     a d j u s t e d    p e r i o d-*/
    public void periodReport() {

        int initDate, endDate;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input first date:");
        if (scan.hasNextInt()) {
            initDate = Math.abs(scan.nextInt());
            System.out.println("Please, input end date:");
            if (scan.hasNextInt()) {
                endDate = Math.abs(scan.nextInt());
                System.out.println();
                System.out.println("REPORT ABOUT SALES FOR THE PERIOD SINCE " + convertDateFormat(initDate) + " TILL "
                        + convertDateFormat(endDate) + " (latter not included in report}");
                System.out.println("---------------------------------------------------------------------------------------------------------------|");
                System.out.printf("%-11s%-26s%-35s%-10s%-10s%-10s%-10s%-10s%n", "#| Date", "| Surname, name", "| Item", "| Volume", "| Price",
                        "| Quantity", "| Income", "|");
                System.out.println("---------------------------------------------------------------------------------------------------------------|");
                int j = 0, g = getIndex(initDate), k = getIndex(endDate);
                for (int i = g; i < sal.length; i++) {
                    if (sal[i] != null){
                        j++;
                        System.out.print(j);
                        sal[i].saleInfoShow();
                        if (i == k - 1){
                            break;
                        }
                    }
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------|");
                System.out.println(calcPeriodReport(initDate, endDate));
                System.out.println("---------------------------------------------------------------------------------------------------------------|");

            } else {
                System.out.println("!!!Invalid request!");
                System.out.println("Please, insert the correct date and try again!");
                return;
            }
        } else {
            System.out.println("!!!Invalid request!");
            System.out.println("Please, insert the correct date and try again!");
        }
    }

    private String calcPeriodReport(int a, int b) {

        int quant = 0, amount = 0;
        int g = getIndex(a), k = getIndex(b);
        for (int i = g; i < sal.length; i++) {
            if (sal[i] != null){
                quant += sal[i].getQuant();
                amount += sal[i].getIncome();
                if (i == k - 1){
                    break;
                }
            }
        }
        return "At all " + quant + " items sold of " + amount + " hrvn.";
    }



    private void initSalesJournal(){

        sal[0] = new Sale(9032016, clt[0], stk.getWat()[5], 3);
        sal[1] = new Sale(9032016, clt[7], stk.getWat()[4], 1);
        sal[2] = new Sale(9032016, clt[3], stk.getWat()[1], 5);
        sal[3] = new Sale(9032016, clt[9], stk.getWat()[0], 2);
        sal[4] = new Sale(9032016, clt[4], stk.getWat()[2], 3);
        sal[5] = new Sale(9032016, clt[0], stk.getWat()[3], 5);
        sal[6] = new Sale(10032016, clt[1], stk.getWat()[9], 1);
        sal[7] = new Sale(10032016, clt[11], stk.getWat()[17], 4);
        sal[8] = new Sale(10032016, clt[2], stk.getWat()[34], 8);
        sal[9] = new Sale(11032016, clt[10], stk.getWat()[45], 6);
        sal[10] = new Sale(11032016, clt[3], stk.getWat()[61], 5);
        sal[11] = new Sale(11032016, clt[9], stk.getWat()[66], 4);
        sal[12] = new Sale(11032016, clt[4], stk.getWat()[62], 2);
        sal[13] = new Sale(11032016, clt[8], stk.getWat()[59], 1);
        sal[14] = new Sale(12032016, clt[5], stk.getWat()[9], 1);
        sal[15] = new Sale(12032016, clt[7], stk.getWat()[36], 3);
        sal[16] = new Sale(12032016, clt[6], stk.getWat()[30], 4);
        sal[17] = new Sale(12032016, clt[11], stk.getWat()[38], 3);
        sal[18] = new Sale(12032016, clt[0], stk.getWat()[27], 5);
        sal[19] = new Sale(13032016, clt[1], stk.getWat()[41], 4);
        sal[20] = new Sale(13032016, clt[10], stk.getWat()[23], 3);
        sal[21] = new Sale(13032016, clt[2], stk.getWat()[45], 2);
        sal[22] = new Sale(13032016, clt[9], stk.getWat()[19], 1);
        sal[23] = new Sale(13032016, clt[3], stk.getWat()[48], 3);
        sal[24] = new Sale(13032016, clt[8], stk.getWat()[17], 3);
        sal[25] = new Sale(14032016, clt[4], stk.getWat()[50], 4);
        sal[26] = new Sale(14032016, clt[7], stk.getWat()[9], 6);
        sal[27] = new Sale(14032016, clt[5], stk.getWat()[14], 3);
        sal[28] = new Sale(14032016, clt[6], stk.getWat()[52], 7);
        sal[29] = new Sale(15032016, clt[1], stk.getWat()[12], 3);
        sal[30] = new Sale(15032016, clt[11], stk.getWat()[55], 2);
        sal[31] = new Sale(15032016, clt[0], stk.getWat()[9], 1);
        sal[32] = new Sale(15032016, clt[10], stk.getWat()[58], 1);
        sal[33] = new Sale(16032016, clt[2], stk.getWat()[7], 1);
        sal[34] = new Sale(16032016, clt[9], stk.getWat()[60], 8);
        sal[35] = new Sale(16032016, clt[3], stk.getWat()[5], 5);
        sal[36] = new Sale(16032016, clt[8], stk.getWat()[62], 3);
        sal[37] = new Sale(17032016, clt[4], stk.getWat()[3], 2);
        sal[38] = new Sale(17032016, clt[7], stk.getWat()[0], 3);
        sal[39] = new Sale(17032016, clt[5], stk.getWat()[65], 1);

    }

    private void initClientsBase(){

        clt[0] = new Client("Kennedy", "John", 46, "male", "president@usa.com");
        clt[1] = new Client("Rulov", "Petro", 38, "male", "prulov.pr@gmail.com");
        clt[2] = new Client("Borkeyev", "Sergiy", 39, "male", "s.borkeyev@sap.com");
        clt[3] = new Client("Rulova", "Mariia", 37, "female", "rulyova.ml@gmail.com");
        clt[4] = new Client("Borkeyeva", "Irina", 33, "female", "i.borkeyeva@gmail.com");
        clt[5] = new Client("Judd", "Ashley", 46, "female", "ajudd@yahoo.com");
        clt[6] = new Client("Law", "Jude", 42, "male", "jude.law@gb.com");
        clt[7] = new Client("Bardem", "Javier", 50, "male", "jb@fb.com.sp");
        clt[8] = new Client("Theron", "Charlize", 36, "female", "chther@yahoo.com");
        clt[9] = new Client("Theilor", "Elizabeth", 76, "female", "none");
        clt[10] = new Client("Schwarznegger", "Arnold", 65, "male", "mr.universe8times@yahoo.com");
        clt[11] = new Client("Zapoyniy", "Alkash", 52, "male", "bomzh@ulitsa.ua");

    }

    public void printClientsBase(Client[] guest) {

        System.out.println("THE LIST OF \"BADIGAN\" CLIENTS");
        System.out.println("-----------------------------------------------------------------------------|");
        System.out.printf("%-15s%-12s%-10s%-10s%-10s%n", "| Surname", "| Name", "| Age", "| Sex", "| E-mail");
        System.out.println("-----------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < guest.length; i++) {
            j++;
            if (guest[i] != null) {
                System.out.print(j);
                guest[i].clientInfoShow();
            }
        }
        System.out.println("-----------------------------------------------------------------------------|");
    }

    public void printSalesJournal(Sale[] sal) {

        System.out.println("SALES JOURNAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%-10s%-15s%-35s%-10s%-10s%-6s%-10s%-10s%n", "| Date", "| Clients surname and name ", "| Type and name of drink ",
                "| Volume ", "| Price ", "|Quantity ", "| Income", "|");
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < sal.length; i++) {
            j++;
            if (sal[i] != null) {

                System.out.print(j);
                sal[i].saleInfoShow();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
    }
}

