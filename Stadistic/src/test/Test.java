package test;

import model.Court;
import model.Trial;
import model.TypeTrial;
import utils.ControllerInterface;
import utils.ScannerData;
import utils.PrintData;

import java.util.Objects;
import java.util.Scanner;

public class Test {
    private final Court court;

    public Test() {
        court = new Court();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public void run() {
        final int EXIT_OPTION = 7;
        int optionSelected = interfaceUser();

        while (optionSelected != EXIT_OPTION) {
            menuOption(optionSelected);
            optionSelected = interfaceUser();
            ControllerInterface.cleanInterface();
        }
    }

    public int interfaceUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("===================================================");
        System.out.println("BIENVENIDO A SU SISTEMA DE ESTADISTICAS DEL JUZGADO");
        System.out.println("===================================================");
        System.out.println(" ");
        System.out.println("Por favor ingrese la opción que quiere usar: ");
        System.out.println(" - Para ingresar proceso - marque 1");
        System.out.println(" - Para buscar un proceso - marque 2");
        System.out.println(" - Para buscar las estadísticas de un tipo de proceso - marque 3");
        System.out.println(" - Para ver el promedio de procesos por mes - marque 4");
        System.out.println(" - Para mostrar todos los procesos - marque 5");
        System.out.println(" - Para imprimir procesos - marque 6");
        System.out.println(" - Para salir - marque 7");
        System.out.println(" ");
        System.out.print("INGRESE NÚMERO: ");

        return scanner.nextInt();
    }

    public void menuOption(int option) {
        switch (option) {
            case 1:
                ControllerInterface.cleanInterface();
                Trial trial = ScannerData.askForData();
                boolean isExisted = court.existingTrial(trial.getIdTrial());
                if(!isExisted){
                    court.addTrial(trial);
                    ControllerInterface.cleanInterface();
                    System.out.println("PROCESO INGRESADO: ");
                    System.out.println(court.getLastTrial());
                    ControllerInterface.nextStep();
                } else {
                    System.out.println("\nEL PROCESO CON ESE ID YA EXISTE");
                    ControllerInterface.nextStep();
                }
                break;
            case 2:
                System.out.println("==============================");
                System.out.println("BÚSQUEDA POR NÚMERO DE PROCESO:");
                System.out.println("==============================");
                System.out.println();
                int idTrial = ScannerData.askToSearch();
                if (court.searchTrial(idTrial) == null) {
                    System.out.println("\nEl proceso no existe");
                }
                else if (court.searchTrial(idTrial) != null){
                    System.out.println(court.searchTrial(idTrial));
                    if(Objects.equals(court.searchTrial(idTrial).getStatus(), "Activo")){
                        boolean askingClose = ControllerInterface.askingClose();
                        if(askingClose){
                            ScannerData.askToCloseDate(court.searchTrial(idTrial));
                            ScannerData.askToReason(court.searchTrial(idTrial));
                            court.searchTrial(idTrial).setStatus("Archivado");
                            System.out.println(court.searchTrial(idTrial));
                            ControllerInterface.nextStep();
                        }
                        else{
                            ControllerInterface.nextStep();
                        }
                    }
                    else if (Objects.equals(court.searchTrial(idTrial).getStatus(), "Archivado")){
                        ControllerInterface.nextStep();
                    }
                }
                break;
            case 3:
                System.out.println("========================");
                System.out.println("ESTADÍSTICAS DE PROCESO");
                System.out.println("========================");
                System.out.println();
                TypeTrial.printOptionsType();
                String insertedType = ScannerData.askToStatistic();
                System.out.println("Procesos Ingresados: " + court.arrivalsTrials(insertedType));
                System.out.println("Procesos Salientes: " + court.closesTrials(insertedType));
                System.out.println("Procesos Activos: " + court.activesTrials(insertedType));
                ControllerInterface.nextStep();
                break;
            case 4:
                System.out.println("=========================");
                System.out.println("POMEDIO DE PROCESOS X MES");
                System.out.println("=========================");
                int monthToSearch = ScannerData.askMonth();
                System.out.println("Tus procesos del mes " + monthToSearch);
                System.out.println();
                PrintData.printTrials(court.getTrialsByMonth(monthToSearch));
                ControllerInterface.nextStep();
                break;
            case 5:
                System.out.println("==================");
                System.out.println("lISTA DE PROCESOS");
                System.out.println("==================");
                System.out.println();
                PrintData.printTrials(court.getAllTrials());
                ControllerInterface.nextStep();
                break;
            case 6:
                System.out.println("======================");
                System.out.println("IMPRESIÓN DE PROCESOS");
                System.out.println("======================");
                System.out.println();
                System.out.println("La lista de sus procesos fue guardada en el archivo trials.txt");
                PrintData.printTrialsFile(court.getAllTrials());
                ControllerInterface.nextStep();
                break;
            case 7:
                break;
            default:
                System.out.println("NUMERO INCORRECTO");
                System.out.println("Ingrese una opción valida");
                interfaceUser();
                break;
        }
    }
}