package model;

public class Trial {
    private final String type;
    private String reason;
    private final int idTrial;
    private final Date arrivalDate;
    private Date closeDate;
    private String status;

    public Trial(int idTrial, String type, Date arrivalDate){
        this.idTrial = idTrial;
        this.type = type;
        this.arrivalDate = arrivalDate;
    }

    public void setCloseDate(Date closeDate){
        this.closeDate = closeDate;
    }

    public void setReason(String reason){
        this.reason = reason;
    }

    public String toString(){
        return
            "\nNúmero de proceso: " + idTrial
            + "\nTipo de contrato: " + type
            + "\nFecha de entrada: " + arrivalDate
            + "\nFecha de salida: " + closeDate
            + "\nRazón de salida: " + reason
            + "\nStatus: " + Status() ;
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

