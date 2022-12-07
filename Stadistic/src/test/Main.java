package test;

import model.Date;
import model.Trial;
import utils.ScannerData;

public class Main {
    public static void main(String[] args) {
        // Create contract object
        /* Date dateIncomeObject = new Date(12, 4, 21);
        Date dateOutcomeObject = new Date(4, 9, 22);
        Trial trial = new Trial("010", "judicial", dateIncomeObject, dateOutcomeObject,"Cualquier cosa");
        System.out.print(trial);
         */
        System.out.println(ScannerData.askForData());
    }
}