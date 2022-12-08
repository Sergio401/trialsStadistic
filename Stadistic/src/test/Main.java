package test;

import model.Court;
import model.Trial;
import model.TypeTrial;
import utils.ControllerInterface;
import utils.ScannerData;
import utils.PrintData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int EXIT_OPTION = 4;
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
        TypeTrial.optionType(); // Interface to ask for type
        System.out.println(" ");
        System.out.println("Por favor ingrese la opción que quiere usar: ");
        System.out.println(" - Para ingresar proceso - marque 1");
        System.out.println(" - Para mostrar todos los procesos - marque 2");
        System.out.println(" - Para imprimir procesos - marque 3");
        System.out.println(" - Para salir del programa - marque 4");
        System.out.println(" ");
        System.out.print("INGRESE NÚMERO: ");

        return scanner.nextInt();
    }

    public static void menuOption(int option) {
        switch (option) {
            case 1:
                Trial trial = ScannerData.askForData();
                Court.addTrial(trial);
                ControllerInterface.cleanInterface();
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
                break;
            default:
                System.out.println("NUMERO INCORRECTO");
                System.out.println("Ingrese una opción valida");
                interfaceUser();
                break;
        }
    }
}