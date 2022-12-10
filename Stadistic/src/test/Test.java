package test;

import model.Court;
import model.Trial;
import model.Type;
import utils.ControllerInterface;
import utils.ScannerData;
import utils.PrintData;

import java.util.Objects;
import java.util.Scanner;

public class Test {
    private final Court court;
    private final ScannerData scannerData;
    private final ControllerInterface controllerInterface;

    public Test() {
        court = new Court();
        scannerData = new ScannerData();
        controllerInterface = new ControllerInterface();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public void run() {
        final int EXIT_OPTION = 9;
        int optionSelected = interfaceUser();

        while (optionSelected != EXIT_OPTION) {
            menuOption(optionSelected);
            optionSelected = interfaceUser();
            controllerInterface.cleanInterface();
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
        System.out.println(" - Para ver los procesos ingresados por mes - marque 4");
        System.out.println(" - Para mostrar los procesos activos - marque 5");
        System.out.println(" - Para mostrar los procesos archivados - marque 6");
        System.out.println(" - Para imprimir los procesos - marque 7");
        System.out.println(" - Para salir - marque 8");
        System.out.println(" ");
        System.out.print("INGRESE NÚMERO: ");

        return scanner.nextInt();
    }

    public void menuOption(int option) {
        switch (option) {
            case 1:
                controllerInterface.cleanInterface();
                System.out.println(" ");
                System.out.println("INGRESO DE PROCESO - SIGA LAS INSTRUCCIONES");
                System.out.println("============================================");
                System.out.println(" ");
                controllerInterface.printOptionsType();
                Trial trial = scannerData.askForData();
                System.out.println(court.getLastTrial());
               boolean isExisted = court.existingTrial(trial.getIdTrial());
                if(!isExisted){
                    court.addTrial(trial);
                    controllerInterface.cleanInterface();
                    System.out.println("PROCESO INGRESADO: ");
                    System.out.println(court.getLastTrial());
                    controllerInterface.nextStep();
                } else {
                    System.out.println("\nEL PROCESO CON ESE ID YA EXISTE");
                    controllerInterface.nextStep();
                }
                break;
            case 2:
                System.out.println("==============================");
                System.out.println("BÚSQUEDA POR NÚMERO DE PROCESO:");
                System.out.println("==============================");
                System.out.println();
                int idTrial = scannerData.askToSearch();
                if (court.searchTrial(idTrial) == null) {
                    System.out.println("\nEl proceso no existe");
                }
                else if (court.searchTrial(idTrial) != null){
                    System.out.println(court.searchTrial(idTrial));
                    if(Objects.equals(court.searchTrial(idTrial).getStatus(), "Activo")){
                        boolean askingClose = controllerInterface.askingClose();
                        if(askingClose){
                            scannerData.askToCloseDate(court.searchTrial(idTrial));
                            scannerData.askToReason(court.searchTrial(idTrial));
                            court.searchTrial(idTrial).setStatus("Archivado");
                            System.out.println(court.searchTrial(idTrial));
                            controllerInterface.nextStep();
                        }
                        else{
                            controllerInterface.nextStep();
                        }
                    }
                    else if (Objects.equals(court.searchTrial(idTrial).getStatus(), "Archivado")){
                        controllerInterface.nextStep();
                    }
                }
                break;
            case 3:

                System.out.println("========================");
                System.out.println("ESTADÍSTICAS DE PROCESO");
                System.out.println("========================");
                System.out.println();
                controllerInterface.printOptionsType();
                String insertedType = Type.assignType(scannerData.askToStatistic());
                System.out.println("Procesos Ingresados: " + court.arrivalsTrials(insertedType));
                System.out.println("Procesos Salientes: " + court.closesTrials(insertedType));
                System.out.println("Procesos Activos: " + court.activesTrials(insertedType));
                controllerInterface.nextStep();
                break;
            case 4:
                System.out.println("=========================");
                System.out.println("POMEDIO DE PROCESOS X MES");
                System.out.println("=========================");
                int monthToSearch = scannerData.askMonth();
                System.out.println("Tus procesos del mes " + monthToSearch);
                System.out.println();
                PrintData.printTrials(court.getTrialsByMonth(monthToSearch));
                court.deleteTrialsByMonth();
                controllerInterface.nextStep();
                break;
            case 5:
                System.out.println("==================");
                System.out.println("lISTA DE PROCESOS ACTIVOS");
                System.out.println("==================");
                System.out.println();
                PrintData.printTrials(court.getTrialsByStatus("Activo"));
                court.deleteTrialsByStatus();
                controllerInterface.nextStep();
                break;
            case 6:
                System.out.println("==================");
                System.out.println("lISTA DE PROCESOS ARCHIVADOS");
                System.out.println("==================");
                System.out.println();
                PrintData.printTrials(court.getTrialsByStatus("Archivado"));
                court.deleteTrialsByStatus();
                controllerInterface.nextStep();
                break;
            case 7:
                System.out.println("======================");
                System.out.println("IMPRESIÓN DE PROCESOS");
                System.out.println("======================");
                System.out.println();
                System.out.println("La lista de sus procesos fue guardada en el archivo trials.txt");
                PrintData.printTrialsFile(court.getAllTrials());
                controllerInterface.nextStep();
                break;
            case 8:
                PrintData.printTrials(court.getAllTrials());
                controllerInterface.nextStep();
                break;
            default:
                System.out.println("NUMERO INCORRECTO");
                System.out.println("Ingrese una opción valida");
                interfaceUser();
                break;
        }
    }
}