package utils;
import java.util.Scanner;

public class ScannerData {
    public static String askForData() {
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

        return
            "CONTRATO 1"
            + "\nNombre: " + name
            + "\nTipo de contrato: " + type
            + "\nDía de Entrada: " + dateIncome
            + "\nDía de Salida: " + dateOutcome
            + "\nRazón de salida: " + reason;
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