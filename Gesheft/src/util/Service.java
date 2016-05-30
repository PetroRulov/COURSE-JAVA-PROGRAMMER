package util;

import domain.Client;
import domain.Sale;
import enumerations.*;
import main.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by prulov on 26.05.2016.
 */
public class Service {

    private Badigan bad;
    private Sale sale;

    public Service(){

        this.bad = new Badigan();
        this.sale = sale;
    }

    public Badigan getBad() {
        return bad;
    }

    /**-d i s p l a y i n g     P R I C E      L I S T-*/
    public void printPriceList() {

        System.out.println();
        System.out.println("----------------------" + "\"BADIGAN\" PRICE LIST" + "------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%n", "#", "| Type", "| Name", "| Tare", "| Volume", "| Price |");
        System.out.println("------------------------------------------------------------------");
        int j = 0;
        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterPriceList();
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
        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.BRENDY)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("BEER:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.BEER)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("BURBON:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.BURBON)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("JUICE:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.JUICE)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("TEQUILA:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.TEQUILA)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("VINES:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.VINE)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("VODKA:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.VODKA)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("WATER:");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < bad.getStk().getWat().length; i++) {
            if (bad.getStk().getWat()[i] != null && bad.getStk().getWat()[i].getDrink().equals(Drink.WATER)) {
                j++;
                System.out.print(j);
                bad.getStk().getWat()[i].waterCatalogue();
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
            for (int i = 0; i < bad.getSales().size(); i++) {
                if (bad.getSales().get(i) != null && bad.getSales().get(i).getDate() == date) {
                    j++;
                    System.out.print(j);
                    bad.getSales().get(i).saleInfoShow();
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
        for (int i = 0; i < bad.getSales().size(); i++) {
            if (bad.getSales().get(i) != null && bad.getSales().get(i).getDate() == d) {
                quant += bad.getSales().get(i).getQuant();
                amount += bad.getSales().get(i).getIncome();
            }
        }
        return "At all " + quant + " items sold of " + amount + " hrvn.";
    }

    private int getIndex(int d) {

        int x = 0;
        for (int i = 0; i < bad.getSales().size(); i++) {
            if (bad.getSales().get(i) != null && bad.getSales().get(i).getDate() == d) {
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
                for (int i = g; i < bad.getSales().size(); i++) {
                    if (bad.getSales().get(i) != null){
                        j++;
                        System.out.print(j);
                        bad.getSales().get(i).saleInfoShow();
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
        for (int i = g; i < bad.getSales().size(); i++) {
            if (bad.getSales().get(i) != null){
                quant += bad.getSales().get(i).getQuant();
                amount += bad.getSales().get(i).getIncome();
                if (i == k - 1){
                    break;
                }
            }
        }
        return "At all " + quant + " items sold of " + amount + " hrvn.";
    }

    public void printClientsBase(List<Client> guest) {

        System.out.println("THE LIST OF \"BADIGAN\" CLIENTS");
        System.out.println("-----------------------------------------------------------------------------|");
        System.out.printf("%-15s%-12s%-10s%-10s%-10s%n", " |  Surname", "  | Name", "| Age", "| Sex", "| E-mail");
        System.out.println("-----------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < guest.size(); i++) {
            j++;
            if (guest.get(i) != null) {
                System.out.print(j);
                guest.get(i).clientInfoShow();
            }
        }
        System.out.println("-----------------------------------------------------------------------------|");
    }

    public void printSalesJournal(List<Sale> sales) {

        System.out.println("SALES JOURNAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%-10s%-15s%-35s%-10s%-10s%-6s%-10s%-10s%n", "| Date", "| Clients surname and name ", "| Type and name of drink ",
                "| Volume ", "| Price ", "|Quantity ", "| Income", "|");
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < sales.size(); i++) {
            j++;
            if (sales.get(i) != null) {
                System.out.print(j);
                sales.get(i).saleInfoShow();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
    }

}

