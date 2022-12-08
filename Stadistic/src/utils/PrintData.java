package utils;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Trial;
public class PrintData {
    public static void printTrialsFile(Trial[] trials){
        String txtFile = "trials.txt";

        try (FileWriter writer = new FileWriter(txtFile);
             PrintWriter pw = new PrintWriter(writer)) {
            for (Trial trial : trials) {
                if (trial != null) {
                    pw.println(trial);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTrials(Trial[] trials) {
        // int i=0; i<trials.length; i++
        for (Trial trial : trials) {
            if (trial != null) {
                System.out.println(trial);
            }
        }
    }

}
