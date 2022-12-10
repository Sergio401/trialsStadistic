package model;

public class Trial {
    private final String type;
    private String reason;
    private final int idTrial;
    private final Date arrivalDate;
    private Date closeDate;
    private String status;

    public Trial(int idTrial, String type, Date arrivalDate) {
        this.idTrial = idTrial;
        this.type = type;
        this.arrivalDate = arrivalDate;
        this.status = "Activo";
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String toString() {
        String printTrial;
        if (status.equals("Activo")) {
            printTrial =
                "\nNúmero de proceso: " + idTrial
                + "\nTipo de contrato: " + type
                + "\nFecha de entrada: " + arrivalDate
                + "\nStatus: " + status;
        } else {
            printTrial =
                "\nNúmero de proceso: " + idTrial
                + "\nTipo de contrato: " + type
                + "\nFecha de entrada: " + arrivalDate
                + "\nFecha de salida: " + closeDate
                + "\nRazón de salida: " + reason
                + "\nStatus: " + status;
        }
        return printTrial;
    }

    public int getIdTrial(){
        return idTrial;
    }
    public String getStatus(){
        return status;
    }
    public String getType(){
        return type;
    }
    public Date getCloseDate(){
        return closeDate;
    }
    public Date getStartDate(){
        return arrivalDate;
    }
    public void setStatus(String status){
        this.status = status;
    }
}


