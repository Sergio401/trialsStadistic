package model;

import java.util.Arrays;

public class Court {
    private static final Trial[] trials = new Trial[10];

    public static void addTrial(Trial trial) {
        boolean inserted = false;
        for(int i=0; i<trials.length && !inserted; i++) {
            if(trials[i] == null) {
                trials[i] = trial;
                inserted = true;
            }
        }
    }

    public static void getLastTrial(Trial trial) {
        boolean inserted = false;
        for(int i=0; i<trials.length && !inserted; i++) {
            if(trials[i] == null) {
                inserted = true;
            }
        }
    }

    public static void getAllTrials() {
        System.out.println(Arrays.toString(trials));
    }

}
