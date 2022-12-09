package model;

import java.util.Objects;

public class Court {
    private static final Trial[] trials = new Trial[10];

    public void addTrial(Trial trial) {
        boolean isInserted = false;
        for (int i = 0; i < trials.length && !isInserted; i++) {
            if (trials[i] == null) {
                trials[i] = trial;
                isInserted = true;
            }
        }
    }

    public Trial getLastTrial() {
        Trial theLastTrial = null;
        boolean isLastTrial = false;
        for (int i = 0; i < trials.length && !isLastTrial; i++) {
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

    public Trial searchTrial(int idTrial) {
        Trial foundTrial = null;
        boolean isTheTrial = false;
        for (int i = 0; i < trials.length && !isTheTrial; i++) {
            if (trials[i].getIdTrial() == idTrial) {
                foundTrial = trials[i];
                isTheTrial = true;
            }
        }
        return foundTrial;
    }

    public int arrivalsTrials(String type) {
        int numberArrivals = 0;
        for (Trial trial : trials) {
            if (trial != null &&
                Objects.equals(trial.getType(), type))
            {
                numberArrivals++;
            }
        }
        return numberArrivals;
    }

    public int closesTrials(String type) {
        int numberCloses = 0;
        for (Trial trial : trials) {
            if (trial != null &&
                Objects.equals(trial.getType(), type) &&
                trial.getCloseDate() != null)
            {
                numberCloses++;
            }
        }
        return numberCloses;
    }
    public int activesTrials(String type) {
        int numberActives = 0;
        for (Trial trial : trials) {
            if (trial != null &&
                Objects.equals(trial.getType(), type) &&
                trial.getCloseDate() == null)
            {
                numberActives++;
            }
        }
        return numberActives;
    }

    public int averageTrials(){
        int cont = 0;
        int average = 0;
        for (Trial trial : trials) {
            if (trial != null){
            cont++;
            }
            average = cont / 3;
        }
        return average;
    }
}

/*
for (int i = 0; i < trials.length; i++) {
    if (trials[i] != null && trials[i].getType() == type && trials[i].getCloseDate() == null) {
        numberActives++;
    }
}
 */

