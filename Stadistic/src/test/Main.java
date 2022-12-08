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
        System.out.println(" - Para mostrar todos los procesos - marque 2");
        System.out.println(" - Para imprimir procesos - marque 3");
        System.out.println(" - Para buscar un proceso - marque 4");
        System.out.println(" - Para buscar las estadísticas de un tipo de proceso - marque 5");
        System.out.println(" - Para salir - marque 6");
        System.out.println(" ");
        System.out.print("INGRESE NÚMERO: ");

        return scanner.nextInt();
    }

    public static void menuOption(int option) {
        switch (option) {
            case 1:
                ControllerInterface.cleanInterface();
                Trial trial = ScannerData.askForData();
                Court.addTrial(trial);
                System.out.println(Court.getLastTrial());
                ControllerInterface.nextStep();
                break;
            case 2:
                ControllerInterface.cleanInterface();
                PrintData.printTrials(Court.getAllTrials());
                ControllerInterface.nextStep();
                break;
            case 3:
                ControllerInterface.cleanInterface();
                PrintData.printTrialsFile(Court.getAllTrials());
                ControllerInterface.nextStep();
                break;
            case 4:
                ControllerInterface.cleanInterface();
                int idTrial = ScannerData.askToSearch();
                System.out.println(Court.searchTrial(idTrial));
                ControllerInterface.nextStep();
                break;
            case 5:
                String insertedType = ScannerData.askToStadistic();
                System.out.println("Entradas: " + Court.arrivalsTrials(insertedType));
                System.out.println("Salidas: " + Court.closesTrials(insertedType));
                System.out.println("Activos: " + Court.activesTrials(insertedType));
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