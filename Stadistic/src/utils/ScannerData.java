package utils;
import model.Trial;
import model.Date;
import model.TypeTrial;

import java.util.Scanner;

public class ScannerData {
    public static Trial askForData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("INGRESO DE PROCESO - SIGA LAS INSTRUCCIONES");
        System.out.println("============================================");
        System.out.println(" ");

        TypeTrial.optionType();
        System.out.print("Ingresar número de proceso: ");
        int idTrial = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingresar tipo de proceso: ");
        int option = Integer.parseInt(scanner.nextLine());
        String type = TypeTrial.assignType(option);

        System.out.print("Ingresar fecha de entrada (DD/MM/AAAA): ");
        String dateIncome = scanner.nextLine();

        System.out.print("Ingresar fecha de salida (DD/MM/AAAA): ");
        String dateOutcome = scanner.nextLine();

        System.out.print("ingresar descripción de salida: ");
        String reason = scanner.nextLine();

        return createNewTrial(idTrial, type, dateIncome, dateOutcome, reason);
    }

    private static Trial createNewTrial(
        Integer idTrial,
        String type,
        String dateIncome,
        String dateOutcome,
        String reason
    ) {
        return new Trial(
            idTrial,
            type,
            dateTransform(dateIncome),
            dateTransform(dateOutcome),
            reason
        );
    }

    public static Date dateTransform(String date) {
        String[] splitDate = date.split("/");

        return new Date(
            Integer.parseInt(splitDate[0]), // Day
            Integer.parseInt(splitDate[1]), // Month
            Integer.parseInt(splitDate[2]) // Year
        );
    }

    public static int askToSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar número de proceso: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
