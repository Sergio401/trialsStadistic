package utils;

import model.Court;
import model.Trial;
import model.Date;
/*import model.TypeTrial;*/
import java.util.Scanner;

public class ScannerData {

    public Trial askForData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("TIPO DE PROCESO - Ingresar tipo de proceso: ");
        int option = Integer.parseInt(scanner.nextLine());
        String type = Trial.assignType(option);

        System.out.print("NÚMERO DE PROCESO - Ingresar número de proceso: ");
        int idTrial = Integer.parseInt(scanner.nextLine());

        System.out.print("FECHA DE ENTRADA - Ingresar fecha de entrada (DD/MM/AAAA): ");
        String dateIncome = scanner.nextLine();

        return createNewTrial(idTrial, type, dateIncome);
    }



    private Trial createNewTrial(
            int idTrial,
            String type,
            String dateIncome
    ) {
        return new Trial(
                idTrial,
                type,
                dateTransform(dateIncome)
        );
    }
    public void askToCloseDate(Trial trial){
        Scanner scanner = new Scanner(System.in);
        System.out.print("FECHA DE SALIDA - Ingresar fecha de salida (DD/MM/AAAA): ");
        String dateIncome = scanner.nextLine();
        Date closeDate = dateTransform(dateIncome);
        trial.setCloseDate(closeDate);
    }

    public void askToReason(Trial trial){
        Scanner scanner = new Scanner(System.in);
        System.out.print("RAZON DE SALIDA - Ingresar la razón de salida: ");
        String reason = scanner.nextLine();
        trial.setReason(reason);
    }

    public Date dateTransform(String date) {
        String[] splitDate = date.split("/");

        return new Date(
                Integer.parseInt(splitDate[0]), // Day
                Integer.parseInt(splitDate[1]), // Month
                Integer.parseInt(splitDate[2]) // Year
        );
    }

    public int askToSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar número de proceso: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int askToStatistic() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar el TIPO del proceso por el que desea buscar: ");
        int option = Integer.parseInt(scanner.nextLine());
        return option;
    }
}