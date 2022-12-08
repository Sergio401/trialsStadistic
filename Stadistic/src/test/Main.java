package test;

import model.Court;
import model.Trial;
import utils.ControllerInterface;
import utils.ScannerData;
import utils.PrintData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int EXIT_OPTION = 6;
        int optionSelected = interfaceUser();

        while (optionSelected != EXIT_OPTION) {
            menuOption(optionSelected);
            optionSelected = interfaceUser();
        }
    }

    public static Integer interfaceUser() {
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
        System.out.println(" - Para mostrar todos los procesos - marque 4");
        System.out.println(" - Para imprimir procesos - marque 5");
        System.out.println(" - Para salir - marque 6");
        System.out.println(" ");
        System.out.print("INGRESE NÚMERO: ");

        return scanner.nextInt();
    }

    public static void menuOption(int option) {
        switch (option) {
            case 1:
                // Enter a trial
                ControllerInterface.cleanInterface();
                Trial trial = ScannerData.askForData();
                Court.addTrial(trial);
                ControllerInterface.cleanInterface();
                System.out.println("Proceso ingresado");
                System.out.println(Court.getLastTrial());
                ControllerInterface.nextStep();
                break;
            case 2:
                // Search a trial by id
                System.out.println("=====================");
                System.out.println("BÚSQUEDA DE PROCESO");
                System.out.println("=====================");
                System.out.println();
                int idTrial = ScannerData.askToSearch();
                System.out.println(Court.searchTrial(idTrial));
                ControllerInterface.nextStep();
                break;
            case 3:
                // Show statics
                System.out.println("========================");
                System.out.println("ESTADÍSTOCAS DE PROCESO");
                System.out.println("========================");
                System.out.println();
                String insertedType = ScannerData.askToStatistic();
                System.out.println("Procesos Ingresados: " + Court.arrivalsTrials(insertedType));
                System.out.println("Procesos Salientes: " + Court.closesTrials(insertedType));
                System.out.println("Procesos Activos: " + Court.activesTrials(insertedType));
                ControllerInterface.nextStep();
                break;
            case 4:
                // Show all trials
                System.out.println("==================");
                System.out.println("lISTA DE PROCESOS");
                System.out.println("==================");
                System.out.println();
                PrintData.printTrials(Court.getAllTrials());
                ControllerInterface.nextStep();
                break;
            case 5:
                // Print trials
                System.out.println("======================");
                System.out.println("IMPRESIÓN DE PROCESOS");
                System.out.println("======================");
                System.out.println();
                System.out.println("La lista de sus procesos fue guardada en el archivo trials.txt");
                PrintData.printTrialsFile(Court.getAllTrials());
                ControllerInterface.nextStep();
                break;
            case 6:
                break;
            default:
                System.out.println("NUMERO INCORRECTO");
                System.out.println("Ingrese una opción valida");
                interfaceUser();
                break;
        }
    }
}