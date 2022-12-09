package model;

import java.util.Objects;

public class Trial {
    private static String type;
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

        public static String assignType(int option) {
            switch (option) {
                case 1:
                    type = "ORDINARIOS - CONTROVERSIAS DE SEGURIDAD SOCIAL - ÚNICA INSTANCIA";
                    break;
                case 2:
                    type = "ORDINARIOS - CONTROVERSIAS CONTRATOS DE TRABAJO - ÚNICA INSTANCIA";
                    break;
                case 3:
                    type = "ORDINARIOS - RECONOCIMIENTO DE HONORARIOS - ÚNICA INSTANCIA";
                    break;
                case 4:
                    type = "ORDINARIOS - OTROS";
                    break;
                case 5:
                    type = "EJECUTIVOS - SEGURIDAD SOCIAL";
                    break;
                case 6:
                    type = "EJECUTIVOS - OBLIGACIONES DERIVADAS DEL CONTRATO DE TRABAJO";
                    break;
                case 7:
                    type = "EJECUTIVOS - COBRO DE APORTES PARAFISCALES";
                    break;
                case 8:
                    type = "EJECUTIVOS - OTROS";
                    break;
                case 9:
                    type = "CONCILIACIÓN EXTRAJUDICIAL";
                    break;
                case 10:
                    type = "OTROS";
                    break;
                case 11:
                    type = "FUERO SINDICAL";
                    break;
            }
            return type;
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


        public int getIdTrial() {
            return idTrial;
        }

        public String getStatus() {
            return status;
        }

        public String getType() {
            return type;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

