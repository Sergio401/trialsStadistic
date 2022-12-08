package model;

public class Court {
    private static final Trial[] trials = new Trial[10];

    public static void addTrial(Trial trial) {
        boolean isInserted = false;
        for(int i=0; i<trials.length && !isInserted; i++) {
            if(trials[i] == null) {
                trials[i] = trial;
                isInserted = true;
            }
        }
    }

    public static Trial getLastTrial() {
        Trial theLastTrial = null;
        boolean isLastTrial = false;
        for(int i=0; i<trials.length && !isLastTrial; i++) {
            if (trials[i] == null) {
                int lastPosition = i - 1;
                isLastTrial = true;
                theLastTrial = trials[lastPosition];
            }
        }
        return theLastTrial;
    }

    public static Trial[] getAllTrials() {
        return trials;
    }

}
