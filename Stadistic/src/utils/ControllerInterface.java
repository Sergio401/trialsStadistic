package utils;

import java.util.Objects;
import java.util.Scanner;

public class ControllerInterface {
    public static void cleanInterface() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void nextStep() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSi desea continuar presione Si(s)/No(n): ");
        String userInput = scanner.nextLine();

        if(Objects.equals(userInput, "s")) {
            return;
        }
        else if (Objects.equals(userInput, "n")) {
            System.exit(0);
        }
    }

}
