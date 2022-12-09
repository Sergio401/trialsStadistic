package model;

public class Trial {
    private final String type;
    private final String reason;
    private final Integer idTrial;
    private final Date arrivalDate, closeDate;

    private String status;

    public Trial(Integer idTrial, String type, Date arrivalDate, Date closeDate, String reason, String status){
        this.idTrial = idTrial;
        this.type = type;
        this.arrivalDate = arrivalDate;
        this.closeDate = closeDate;
        this.reason = reason;
        this.status = status;
    }

    public String toString(){
        return
            "\nNúmero de proceso: " + idTrial
            + "\nTipo de contrato: " + type
            + "\nFecha de entrada: " + arrivalDate
            + "\nFecha de salida: " + closeDate
            + "\nRazón de salida: " + reason
            + "\nEstado: " + Status();
    }

    public int getIdTrial(){
        return idTrial;
    }

    public String getType(){
        return type;
    }
    public Date getCloseDate(){
        return closeDate;
    }
    public String Status(){
        if (arrivalDate != null && closeDate == null){
            status = "Activo";
        }else {
            status = "Archivado";
        }
        return status;
    }
}

