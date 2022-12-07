package model;

import java.util.Arrays;

public class Court {
    private static final Trial[] trials = new Trial[10];
    public static void saveTrials(Trial trial) {
        trials[0] = trial;
    }
    public static void getTrials() {
        System.out.println(Arrays.toString(trials));
    }

}
