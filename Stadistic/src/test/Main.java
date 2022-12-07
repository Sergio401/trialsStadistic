package test;

import model.Court;
import model.Trial;
import utils.ScannerData;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO A SU SISTEMA DE ESTADISTICAS DEL JUZGADO");
        System.out.println("Por favor ingrese la opción que quiere usar: ");
        System.out.println("Para ingresar proceso marque 1");
        System.out.println("Para mostrar todos los procesos marque 2");
        System.out.print("Ingrese número: ");

        int inputUser = scanner.nextInt();

        if (inputUser == 1) {
            Trial trial = ScannerData.askForData();
            Court.saveTrials(trial);
            Court.getTrials();
        } else if (inputUser == 2) {
            Court.getTrials();
        } else {
            System.out.println("Número incorrecto");
            System.exit(0);
        }
    }
}