package model;

import model.Date;

public class Trial {
    private final String name, type, reason;
    private final Date arrivalDate, closeDate;

    public Trial(String name, String type, Date arrivalDate, Date closeDate, String reason){
        this.name = name;
        this.type = type;
        this.arrivalDate = arrivalDate;
        this.closeDate = closeDate;
        this.reason = reason;
    }

    public String toString(){
        return
            "Nombre: " + name
            + "\nTipo: " + type
            + "\nFecha de Entrada: " + arrivalDate
            + "\nFecha de Salida: " + closeDate
            + "\nRazón: " + reason;
    }
}
