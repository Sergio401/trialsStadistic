package model;

public class Trial {
    private String type;
    private String reason;
    private Integer idTrial;
    private Date arrivalDate, closeDate;

    public Trial(Integer idTrial, String type, Date arrivalDate, Date closeDate, String reason){
        this.idTrial = idTrial;
        this.type = type;
        this.arrivalDate = arrivalDate;
        this.closeDate = closeDate;
        this.reason = reason;
    }

    public String toString(){
        return
            "\nNombre: " + idTrial
            + "\nTipo de contrato: " + type
            + "\nFecha de entrada: " + arrivalDate
            + "\nFecha de salida: " + closeDate
            + "\nRazón de salida: " + reason;
    }

    public int getIdTrial(){
        return idTrial;
    }
}

