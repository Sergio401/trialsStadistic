package utils;
import model.Trial;
import model.Date;

import java.util.Scanner;

public class ScannerData {
    public static Trial askForData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresar nombre: ");
        String name = scanner.nextLine();

        System.out.print("Ingresar tipo de proceso: ");
        String type = scanner.nextLine();

        System.out.print("Ingresar fecha de entrada: ");
        String dateIncome = scanner.nextLine();

        System.out.print("Ingresar fecha de salida: ");
        String dateOutcome = scanner.nextLine();

        System.out.print("ingresar descripción de salida: ");
        String reason = scanner.nextLine();

        return createNewTrial(name, type, dateIncome, dateOutcome, reason);
    }

    private static Trial createNewTrial(
        String name,
        String type,
        String dateIncome,
        String dateOutcome,
        String reason
    ) {

        Date dateIncomeObject = new Date(12, 4, 21);
        Date dateOutcomeObject = new Date(4, 9, 22);

        return new Trial(name, type, dateIncomeObject, dateOutcomeObject, reason);
    }

}



/*
 "CONTRATO 1"
         + "\nNombre: " + name
         + "\nTipo de contrato: " + type
         + "\nDía de Entrada: " + dateIncome
         + "\nDía de Salida: " + dateOutcome
         + "\nRazón de salida: " + reason;

 */