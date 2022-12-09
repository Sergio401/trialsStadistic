package model;

import java.util.Objects;

public class Court {
    private static final Trial[] trials = new Trial[10];

    public boolean addTrial(Trial trial) {
        boolean isInserted = false;
        boolean isExisted = existingTrial(trial.getIdTrial());
        for (int i = 0; i < trials.length && !isInserted; i++) {
            if (trials[i] == null && !isExisted) {
                trials[i] = trial;
                isInserted = true;
            } else if (isExisted) {
                System.out.println("El proceso ya exíste");
                isInserted = true;
            }
        }
        return isExisted;
    }

    public boolean existingTrial(int idTrial) {
        Trial trial = searchTrial(idTrial);
        boolean isExistingTrial;

        isExistingTrial = trial != null;
        return isExistingTrial;
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
            if (trials[i] == null) {
                isTheTrial = true;
            } else if (trials[i].getIdTrial() == idTrial) {
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


