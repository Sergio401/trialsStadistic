package utils;

import java.util.Objects;
import java.util.Scanner;

public class ControllerInterface {
    public void cleanInterface() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public void nextStep() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSi desea continuar presione Si(s)/No(n): ");
        String userInput = scanner.nextLine();

        if(Objects.equals(userInput, "s")) {
            cleanInterface();
        }
        else if (Objects.equals(userInput, "n")) {
            System.exit(0);
        }
    }
    public boolean askingClose(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSi desea ingresar la fecha y razón de la salida marque Si(s)/No(n): ");
        String userInput = scanner.nextLine();

        return Objects.equals(userInput, "s");
    }

    public void printOptionsType() {
        System.out.println("Para el tipo de proceso marque la opción correspondiente: "
                + "\n1 → ORDINARIOS - CONTROVERSIAS DE SEGURIDAD SOCIAL - ÚNICA INSTANCIA"
                + "\n2 → ORDINARIOS - CONTROVERSIAS CONTRATOS DE TRABAJO - ÚNICA INSTANCIA"
                + "\n3 → ORDINARIOS - RECONOCIMIENTO DE HONORARIOS - ÚNICA INSTANCIA"
                + "\n4 → ORDINARIOS - OTROS"
                + "\n5 → EJECUTIVOS - SEGURIDAD SOCIAL"
                + "\n6 → EJECUTIVOS - OBLIGACIONES DERIVADAS DEL CONTRATO DE TRABAJO"
                + "\n7 → EJECUTIVOS - COBRO DE APORTES PARAFISCALES"
                + "\n8 → EJECUTIVOS - OTROS"
                + "\n9 → CONCILIACIÓN EXTRAJUDICIAL"
                + "\n10 → OTROS"
                + "\n11 → FUERO SINDICAL"
                + "\n");
    }
}
