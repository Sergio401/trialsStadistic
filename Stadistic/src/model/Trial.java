package model;

import model.Date;

public class Trial {
    private String name, type, reason;
    private Date arrivalDate, closeDate;

    public Trial(String name, String type, Date arrivalDate, Date closeDate, String reason){
        this.name = name;
        this.type = type;
        this.arrivalDate = arrivalDate;
        this.closeDate = closeDate;
        this.reason = reason;
    }

    public String toString(){
        return name + " " + type + " " + arrivalDate + " " + closeDate + " " + reason;
    }
}
