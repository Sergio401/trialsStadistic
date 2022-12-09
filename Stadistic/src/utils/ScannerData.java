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

        TypeTrial.printOptionsType();

        System.out.print("TIPO DE PROCESO - Ingresar tipo de proceso: ");
        int option = Integer.parseInt(scanner.nextLine());
        String type = TypeTrial.assignType(option);

        System.out.print("NÚMERO DE PROCESO - Ingresar número de proceso: ");
        int idTrial = Integer.parseInt(scanner.nextLine());

        System.out.print("FECHA DE ENTRADA - Ingresar fecha de entrada (DD/MM/AAAA): ");
        String dateIncome = scanner.nextLine();

        System.out.print("FECHA DE SALIDA - Ingresar fecha de salida (DD/MM/AAAA): ");
        String dateOutcome = scanner.nextLine();

        System.out.print("RAZÓN DE SALIDA - ingresar descripción de salida: ");
        String reason = scanner.nextLine();

        String status = "Activo";

        return createNewTrial(idTrial, type, dateIncome, dateOutcome, reason,status);
    }

    private static Trial createNewTrial(
            Integer idTrial,
            String type,
            String dateIncome,
            String dateOutcome,
            String reason,
            String status
    ) {
        return new Trial(
                idTrial,
                type,
                dateTransform(dateIncome),
                dateTransform(dateOutcome),
                reason,
                status
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

    public static String askToStatistic() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar el TIPO del proceso por el que desea buscar: ");
        int option = Integer.parseInt(scanner.nextLine());
        return TypeTrial.assignType(option);
    }
}