package model;

import java.util.Objects;

public class Court {
    private static final Trial[] trials = new Trial[10];

    public static void addTrial(Trial trial) {
        boolean isInserted = false;
        for (int i = 0; i < trials.length && !isInserted; i++) {
            if (trials[i] == null) {
                trials[i] = trial;
                isInserted = true;
            }
        }
    }

    public static Trial getLastTrial() {
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

    public static boolean existingTrial(int idTrial) {
        Trial trial = searchTrial(idTrial);
        boolean isExistingTrial;

        isExistingTrial = trial != null;
        return isExistingTrial;
    }

    public static Trial searchTrial(int idTrial) {
        Trial foundTrial = null;
        boolean isTheTrial = false;
        for (int i = 0; i < trials.length && !isTheTrial; i++) {
            if (trials[i] == null) {
                isTheTrial = true;
            } else if (trials[i].getIdTrial() == idTrial) {
                foundTrial = trials[i];
                isTheTrial = true;
            }
        }
        return foundTrial;
    }

    public static int arrivalsTrials(String type) {
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

    public static int closesTrials(String type) {
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
    public static int activesTrials(String type) {
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

    public static int averageTrials(){
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

