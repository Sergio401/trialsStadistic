package model;

import java.util.Arrays;
import java.util.Objects;

public class Court {
    int max = 10;
    private final Trial[] trials = new Trial[max];
    private final Trial[] trialsByMonth = new Trial[max];
    private final Trial[] trialsByStatus = new Trial[max];

    public void addTrial(Trial trial) {
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
    }

    public boolean existingTrial(int idTrial) {
        Trial trial = searchTrial(idTrial);
        boolean isExistingTrial;

        isExistingTrial = trial != null;
        return isExistingTrial;
    }

    public Trial[] addActiveTrials() {
        Trial[] actives = new Trial [max];
        for (Trial trial : trials) {
            if (Objects.equals(trial.getStatus(), "Activo")) {
                boolean isInserted = false;
                for (int a = 0; a < actives.length && !isInserted; a++) {
                    if (actives[a] == null) {
                        actives[a] = trial;
                        isInserted = true;
                    }
                }
            }
        }
        return actives;
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

    public Trial[] getAllTrials() {
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
            if (trial != null && trial.getType().equals(type))
            {
                numberArrivals++;
            }
        }
        return numberArrivals;
    }

    public int closesTrials(String type) {
        int numberCloses = 0;
        for (Trial trial : trials) {
            if (trial != null && trial.getStatus().equals("Archivado") && trial.getType().equals(type))
            {
                numberCloses++;
            }
        }
        return numberCloses;
    }

    public int activesTrials(String type) {
        int numberActives = 0;
        for (Trial trial : trials) {
            if (trial != null && Objects.equals(trial.getStatus(), "Activo") && Objects.equals(trial.getType(), type))
            {
                numberActives++;
            }
        }
        return numberActives;
    }

    public Trial[] getTrialsByMonth(int month) {
        boolean isComplete = false;
        for (int i = 0; i < trials.length && !isComplete; i++) {
            if(trials[i] != null){
                String[] stringDate = trials[i].getStartDate().toString().split("/");
                int monthToCompare = Integer.parseInt(stringDate[1]);
                if(monthToCompare == month){
                    trialsByMonth[i] = trials[i];
                }
            } else {
                isComplete = true;
            }
        }
        return trialsByMonth;
    }

   public Trial[] getTrialsByStatus(String status) {
        boolean isComplete = false;
        for (int i = 0; i < trials.length && !isComplete; i++) {
            if(trials[i] != null){
                if(trials[i].getStatus().equals(status)){
                    trialsByStatus[i] = trials[i];
                }
            } else {
                isComplete = true;
            }
        }
        return trialsByStatus;
    }


    public void deleteTrialsByMonth(){
        Arrays.fill(trialsByMonth, null);
    }

    public void deleteTrialsByStatus(){
        Arrays.fill(trialsByStatus, null);
    }
}


